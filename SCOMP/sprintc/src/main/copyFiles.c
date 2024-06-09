#include "Config.h"
#include "CircularBuffer.h"
#include "utils.h"
#include <semaphore.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <dirent.h>
#include <unistd.h>

/**
 * @file copyFiles.c
 * @brief This file contains the function to copy files for a given candidate based on their candidate ID.
 */

/**
 * @brief Copies files for a given candidate based on their candidate ID.
 *
 * This function waits for the sem_startWorkers semaphore, then reads the candidate ID from the shared memory.
 * It then constructs the path to the candidate's data file and reads the first line to get the job offer ID.
 * If the job offer ID is valid, it creates a new directory for the job offer (if it doesn't already exist)
 * and copies the candidate's files into it. It then lists all the files in the new directory and adds
 * their names to the shared memory. Finally, send a post in the sem_startReport
 * semaphore to indicate that it's done.
 *
 * @param config The configuration settings, which include the input and output directory paths.
 * @param sharedMemory The shared circular buffer for inter-process communication.
 * @param sem_startWorkers The semaphore for synchronizing worker processes.
 * @param sem_startReport The semaphore for indicating completion of file reporting.
 * @param sem_sharedmemory_mutex The semaphore for synchronizing access to the shared memory.
 */
void copyFiles(Config *config, CircularBuffer *sharedMemory, sem_t *sem_startWorkers, sem_t *sem_startReport, sem_t *sem_sharedmemory_mutex)
{
    int candidateID, status;
    char buffer[300];
    CandidateInfo files;
    char *jobOffer;

    while (1)
    {
        sem_wait(sem_startWorkers);       // Start Working
        sem_wait(sem_sharedmemory_mutex); // shared memory mutex
        files = readFromBuffer(sharedMemory);
        sem_post(sem_sharedmemory_mutex);

        candidateID = files.candidateID;
        printf("-> Candidate ID: %d PID:%d\n", candidateID, getpid()); // Working with the candidateID

        sprintf(buffer, "%s%d-candidate-data.txt", config->inputPath, candidateID);

        if (isFileOrDirectory(buffer) != 1 || (jobOffer = readFirstLine(buffer, candidateID)) == NULL)
        {

            sprintf(buffer, "Failed to read the job Opening ID from Candidate:%d\n", candidateID);
            errorMessages(buffer);
            files.candidateID = -1;
        }
        else
        {
            strcpy(files.jobOffer_dir, jobOffer);
            files.jobOffer_dir[strlen(files.jobOffer_dir) - 1] = '\0';

            sprintf(buffer, "%s%s/%d", config->outputPath, files.jobOffer_dir, candidateID);
            replaceChar(buffer, "\r", "");

            if (createChildProcess() == 0)
            {
                char command[1024];
                snprintf(command, sizeof(command), "mkdir -p %s && /bin/cp -u %s%d-* %s", buffer, config->inputPath, candidateID, buffer);
                execlp("/bin/sh", "sh", "-c", command, NULL);
                exit(EXIT_FAILURE);
            }

            wait(&status);

            if (WIFEXITED(status))
            {
                if (WEXITSTATUS(status) == EXIT_FAILURE)
                {
                    errorMessages("Failed to copy files");
                    exit(EXIT_FAILURE);
                }
            }
            DIR *dir;
            struct dirent *entry;

            if (!(dir = opendir(buffer)))
            {
                errorMessages("Failed to open directory\n");
                exit(EXIT_FAILURE);
            }
            while ((entry = readdir(dir)) != NULL)
            {
                if (entry->d_type == DT_REG)
                {
                    strcpy(files.files[files.numFiles], entry->d_name);
                    files.numFiles++;
                }
            }
        }
        sem_wait(sem_sharedmemory_mutex);
        files.isDone = 1;
        addInfo(sharedMemory, files);
        sem_post(sem_sharedmemory_mutex);

        sem_post(sem_startReport);
    }
}

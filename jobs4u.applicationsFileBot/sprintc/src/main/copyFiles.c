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
 * @brief Copy all files from new Candidates to the output directory.
 *
 * @param fd The file descriptor for the pipe.
 * @param config The configuration struct.
 */
void copyFiles(Config *config, CircularBuffer *sharedMemory, sem_t *sem_startWorkers, sem_t *sem_isDone, sem_t *sem_files, sem_t *sem_reportFile)
{
    int candidateID, status;
    char buffer[300];
    CandidateInfo files;
    char *jobOffer;
    while (1)
    {
        sem_wait(sem_startWorkers); // acess shared memory
        files = readFromBuffer(sharedMemory);

        if (files.candidateID == -1)
            continue;
        sem_post(sem_startWorkers); // release shared memory
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
        sem_wait(sem_isDone); // protect the shared memory
        files.isDone = 1;
        sem_post(sem_isDone); // release the shared memory
        sem_wait(sem_files);  // protect the shared memory
        addInfo(sharedMemory, files);
        sem_post(sem_files); // release the shared memory
        sem_post(sem_reportFile);
    }
}

// standard libraries
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
// directory libraries
#include <dirent.h>
// signal libraries
#include <signal.h>
// info about this project
#include "info.h"
#include <sys/types.h>
#include <sys/wait.h>
#include "utils.h"

/**
 * @brief Copy all files from new Candidates to the output directory.
 *
 * @param fd The file descriptor for the pipe.
 * @param config The configuration struct.
 */
void copyFiles(Config *config, CircularBuffer *shared_data, sem_t *sem_shared_memory, sem_t *sem_barrier, sem_t *sem_barrier_mutex)
{
    int candidateID;
    Files files;

    while (1)
    {
        sem_wait(sem_shared_memory); // acess shared memory
        if (isEmpty(shared_data))
            continue;

        files = readFromBuffer(shared_data);
        sem_post(sem_shared_memory); // release shared memory

        candidateID = files.candidateID;
        printf("-> Candidate ID: %d PID:%d\n", candidateID, getpid());

        pid_t pid;
        int status;
        char buffer[300];
        sprintf(buffer, "%s%d-candidate-data.txt", config->inputPath, candidateID);
        if (isFileOrDirectory(buffer) != 1)
        {
            sprintf(buffer, "Candidate ID: %d has an invalid format\n", candidateID);
            errorMessages(buffer);
        }
        else
        {
            files.candidateID = candidateID;
            files.numFiles = 0;
            char *job;
            if ((job = readFirstLine(buffer, candidateID)) != NULL)
            {
                strcpy(files.jobOffer_dir, job);
                files.jobOffer_dir[strlen(files.jobOffer_dir) - 1] = '\0';
                pid = createChildProcess();
                if (pid == 0)
                {
                    // create new directory and copy the files
                    sprintf(buffer, "%s%s/%d", config->outputPath, files.jobOffer_dir, candidateID);
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
                    }
                }
                // list all files in the directory
                sprintf(buffer, "%s%s/%d", config->outputPath, files.jobOffer_dir, candidateID);
                DIR *dir;
                struct dirent *entry;

                if (!(dir = opendir(buffer)))
                {
                    errorMessages("Failed to open directory\n");
                    return; // or exit(1), depending on your program structure
                }
                while ((entry = readdir(dir)) != NULL)
                {
                    if (entry->d_type == DT_REG)
                    {
                        strcpy(files.files[files.numFiles], entry->d_name);
                        files.numFiles++;
                    }
                }
                closedir(dir);
            }
        }
        sem_wait(sem_barrier_mutex); // protect the barrier counter
        addToBuffer(shared_data, files);
        shared_data->barrierCounter--;
        sem_post(sem_barrier_mutex); // release the barrier counter
        if (shared_data->barrierCounter == 0)
        {
            printf("\n-> All files have been copied\n");
            sem_post(sem_barrier);
        }
    }
}

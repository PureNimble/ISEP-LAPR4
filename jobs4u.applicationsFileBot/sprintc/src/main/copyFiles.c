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
void copyFiles(int *send_work_fd, int *recive_work_fd, Config *config)
{
    int candidateID;

    while (1)
    {
        // TODO: semaphore mutex
        read(send_work_fd[0], &candidateID, sizeof(candidateID));
        printf("-> Candidate ID: %d PID:%d\n", candidateID, getpid());
        Files files;

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
        // barrier semaphores
        write(recive_work_fd[1], &files, sizeof(files));
    }
}

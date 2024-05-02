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
#include "utils.h"
#include <sys/types.h>

/**
 * @brief Check if there are new files in the directory and send a signal to the
 *        parent process if there are new files.
 *
 * This function continuously checks for new files in the specified directory
 *  and sends a signal to the parent process if any new files are found.
 *  It uses the given configuration to determine the input path and the
 *  frequency at which to check for new files.
 *
 * @param config A pointer to the configuration struct that contains the input
 *             path and the frequency of checking for new files.
 */
void newFileChecker(Config *config)
{
    int exec_fd[2], lastFileTime = 0;
    pid_t pid;
    createPipe(exec_fd);

    while (1)
    {
        pid = createChildProcess();

        if (pid == 0)
        {
            close(exec_fd[0]);
            if (dup2(exec_fd[1], STDOUT_FILENO) == -1)
            {
                errorMessages("dup2");
                exit(EXIT_FAILURE);
            }
            close(exec_fd[1]);
            char command[100];
            int ret = snprintf(command, sizeof(command), "stat -c '%%Y' %s/* 2>&1 | sort -n", config->inputPath);
            if (ret < 0 || ret >= (int)sizeof(command))
            {
                errorMessages("snprintf");
                exit(EXIT_FAILURE);
            }
            execlp("/bin/sh", "sh", "-c", command, NULL);
            perror("execlp");
            exit(EXIT_FAILURE);
        }
        char buffer[1024];
        ssize_t numRead;
        unsigned int counter = 0;
        int *files_birth;
        numRead = read(exec_fd[0], buffer, sizeof(buffer) - 1);
        buffer[numRead] = '\0';
        char *token = strtok(buffer, "\n");

        if (token[0] >= '0' && token[0] <= '9')
        {
            createMalloc((void **)&files_birth, 0);
            while (token != NULL)
            {
                counter++;
                files_birth = createRealloc(files_birth, counter * sizeof(files_birth));
                files_birth[counter - 1] = atoi(token);
                token = strtok(NULL, "\n");
            }
            if (files_birth[counter - 1] > lastFileTime)
            {
                kill(getppid(), SIGUSR1);
            }
            lastFileTime = files_birth[counter - 1];

            free(files_birth);
        }
        else
        {
            printf("No files found\n");
        }

        sleep(config->verifyNewFilesFrequency);
        unsigned time = config->verifyNewFilesFrequency;
        sleep(time);
    }
}

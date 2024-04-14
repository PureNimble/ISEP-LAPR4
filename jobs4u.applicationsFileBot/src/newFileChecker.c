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
 * @brief Check if there are new files in the directory( send a signal to the
 *  parent process if there are new files)
 * @param lastFiletime The last time a file was created in the directory.
 * @param father_fd The file descriptor of the father process.
 */
void newFileChecker(unsigned int lastFiletime, int *father_fd)
{
    // pipe responsible to send the output of the command "stat"
    int exec_fd[2];
    createPipe(exec_fd);

    pid_t pid = createChildProcess();

    if (pid == 0) // Child process
    {
        // close(exec_fd[0]); // Close unused read end
        //   Redirect stdout to the write end of the pipe

        if (dup2(exec_fd[1], STDOUT_FILENO) == -1)
        {
            perror("dup2");
            exit(EXIT_FAILURE);
        }
        close(exec_fd[1]);

        char command[256];
        // command to get the birth time of the files in the directory
        int ret = snprintf(command, sizeof(command), "stat -c '%%W' %s/* 2>&1 | sort -n", INPUT_PATH);
        if (ret < 0 || ret >= sizeof(command))
        {
            fprintf(stderr, "snprintf");
            exit(EXIT_FAILURE);
        }
        execlp("/bin/sh", "sh", "-c", command, NULL);
        perror("execlp");
        exit(EXIT_FAILURE);
    }
    else // Parent process
    {
        char buffer[1024];
        ssize_t numRead;
        close(exec_fd[1]); // Close unused write end
        //   Read from the pipe and print to stdout
        while ((numRead = read(exec_fd[0], buffer, sizeof(buffer) - 1)) > 0)
        {
            buffer[numRead] = '\0';
            char *token = strtok(buffer, "\n");
            int counter = 0;
            int *files_birth;

            if (token[0] == 's')
            {
                perror("stat error -> Invalid input path");
                exit(EXIT_FAILURE);
            }

            if ((files_birth = malloc(0)) == NULL)
            {
                perror("malloc error -> files_birth");
                exit(EXIT_FAILURE);
            }
            while (token != NULL)
            {
                counter++;
                files_birth = realloc(files_birth, (counter) * sizeof(int));
                files_birth[counter - 1] = atoi(token);
                token = strtok(NULL, "\n");
            }
            write(father_fd[1], &files_birth[counter - 1], sizeof(int));

            if (files_birth[counter - 1] > lastFiletime)
                kill(getppid(), SIGUSR1);

            free(files_birth);
        }

        // close(exec_fd[0]); // Close read end of the pipe
    }
}
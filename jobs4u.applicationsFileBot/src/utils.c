// standard libraries
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
// process libraries
#include <sys/wait.h>
/**
 *
 * @brief Function to reduce the code duplication of creating a pipe and children
 */

void createPipe(int *fd)
{
    if (pipe(fd) == -1)
    {
        perror("Pipe failed.");
        exit(EXIT_FAILURE);
    }
}

pid_t createChildProcess()
{
    pid_t pid;
    pid = fork();
    if (pid == -1)
    {
        perror("fork");
        exit(EXIT_FAILURE);
    }
    return pid;
}

void waitChildProcess()
{
    int status;
    wait(&status);
    if (WIFEXITED(status) && WEXITSTATUS(status) != EXIT_SUCCESS)
    {
        exit(EXIT_FAILURE);
    }
}
// standard libraries
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
// process libraries
#include <sys/wait.h>
// info about this project
#include "info.h"
#include "utils.h"
/**
 *
 * @brief Main function, responsible for creating the children processes and to
 * handle the parent process.
 */

int main()
{
    pid_t pid;
    unsigned int lastFileTime = 0;
    int father_fd[2];
    setUpSignal();
    createPipe(father_fd);

    while (1)
    {
        pid = createChildProcess();
        if (pid == 0) // child process
        {
            newFileChecker(lastFileTime, father_fd);
            exit(0);
        }
        // parent process
        waitChildProcess();
        read(father_fd[0], &lastFileTime, sizeof(int));
        sleep(VERIFY_NEW_FILES_FREQUENCY);
    }
    return 0;
}
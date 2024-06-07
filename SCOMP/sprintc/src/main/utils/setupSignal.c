#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <stdlib.h>
#include <signal.h>
#include "info.h"
#include "utils.h"
#include <sys/types.h>
#include <sys/wait.h>
#include <dirent.h>
#include <ctype.h>
/**
 * @brief Change the comportment of a set of signals.
 *
 * This function sets up the signal handlers for SIGUSR1, SIGUSR2, SIGINT, and SIGRTMIN.
 * It assigns the same signal handler function, handle_signal, to all these signals.
 * It also sets the SA_RESTART flag for SIGUSR1, SIGUSR2, and SIGINT to ensure that system calls are automatically restarted if interrupted by these signals.
 */
extern pid_t pids[21];
extern int pidsCounter;
void setUpSignal()
{
    struct sigaction act;
    memset(&act, 0, sizeof(struct sigaction));
    act.sa_handler = handle_signal;
    act.sa_flags = SA_RESTART;
    if (sigaction(SIGINT, &act, NULL) == -1)
    {
        errorMessages("Error setting up SIGINT handler");
        exit(EXIT_FAILURE);
    }
    if (sigaction(SIGCHLD, &act, NULL) == -1)
    {
        errorMessages("Error setting up SIGCHLD handler");
        exit(EXIT_FAILURE);
    }
}

/**
 * @brief Handle the signals.
 *
 * This function is the signal handler for SIGUSR1, SIGUSR2, SIGINT, and SIGRTMIN.
 * It performs different actions based on the received signal.
 * - For SIGUSR1, it writes a message indicating that new files were found.
 * - For SIGINT, it writes a message indicating that SIGINT was received and terminates all child processes.
 * - For any other signal, it increments the received_signals counter.
 *
 * @param signal The signal number.
 */
void handle_signal(int signal)
{
    switch (signal)
    {
    case SIGINT:
        char msg[100];
        sprintf(msg, "SIGINT received by process %d. Terminating all child processes...\n", getpid());
        write(1, msg, strlen(msg)); // Kill all processes in the same process group
        for (int i = 0; i < pidsCounter + 1; i++)
        {
            kill(pids[i], SIGTERM);
        }
        // Wait for all child processes to finish
        for (int i = 0; i < pidsCounter + 1; i++)
        {
            int status;
            waitpid(pids[i], &status, 0);
            if (WIFEXITED(status))
                status = WEXITSTATUS(status);

            sprintf(msg, "Child process %d terminated with status %d\n", pids[i], WEXITSTATUS(status));
            write(1, msg, strlen(msg));
        }
        removeShmFiles();
        exit(0);
    case SIGCHLD:
        int status;
        // check if any child died, but don't wait
        waitpid(-1, &status, WNOHANG);
        if (WIFEXITED(status) && WEXITSTATUS(status) == 1)
        {
            write(1, "Child process was killed. Terminating all child processes...\n", 62);
            removeShmFiles();
            kill(0, SIGTERM);
        }
        break;
    default:
        break;
    }
}

/**
 * @brief Removes the shared memory files and semaphores used by the application.
 *
 * This function removes the shared memory file and all the semaphores used by the application.
 * The shared memory file and semaphores are identified by their respective names.
 *
 * @note This function assumes that the shared memory file and semaphores have already been created.
 *
 * @param None
 * @return None
 */
void removeShmFiles()
{
    removeSharedMemory(SHARED_MEMORY);
    removeSemaphore(SEM_NEW_FILE_CHECKER);
    removeSemaphore(SEM_START_WORKERS);
    removeSemaphore(SEM_REPORT_FILE);
    removeSemaphore(SEM_ADD_TO_BUFFER);
    removeSemaphore(SEM_NUMBER_OF_CANDIDATES);
    removeSemaphore(SEM_IS_DONE);
    removeSemaphore(SEM_FILES);
}
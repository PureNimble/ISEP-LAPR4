#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <stdlib.h>
#include <signal.h>
#include "info.h"
#include "utils.h"
#include <sys/types.h>
#include <dirent.h>
#include <ctype.h>
/**
 * @brief Change the comportment of a set of signals.
 * 
 * This function sets up the signal handlers for SIGUSR1, SIGUSR2, SIGINT, and SIGRTMIN.
 * It assigns the same signal handler function, handle_signal, to all these signals.
 * It also sets the SA_RESTART flag for SIGUSR1, SIGUSR2, and SIGINT to ensure that system calls are automatically restarted if interrupted by these signals.
 */
void setUpSignal()
{
    struct sigaction act;
    memset(&act, 0, sizeof(struct sigaction));
    act.sa_handler = handle_signal;
    act.sa_flags = SA_RESTART;
    sigaction(SIGUSR1, &act, NULL);
    sigaction(SIGUSR2, &act, NULL);
    sigaction(SIGINT, &act, NULL);
    //act.sa_handler = handler;
    act.sa_flags = 0;
    sigemptyset(&act.sa_mask);
    sigaction(SIGRTMIN, &act, NULL);
}

/**
 * @brief Handle the signals.
 * 
 * This function is the signal handler for SIGUSR1, SIGUSR2, SIGINT, and SIGRTMIN.
 * It performs different actions based on the received signal.
 * - For SIGUSR1, it writes a message indicating that new files were found.
 * - For SIGINT, it writes a message indicating that SIGINT was received and terminates all child processes.
 * - For SIGUSR2, it writes a message indicating that a child process ended.
 * - For any other signal, it increments the received_signals counter.
 * 
 * @param signal The signal number.
 */
void handle_signal(int signal)
{
    switch (signal)
    {
    case SIGUSR1:
        write(1, "New Files were found.\n", 23);
        break;
    case SIGINT:
        write(1, "SIGINT received. Terminating all child processes...\n", 52);
        // Kill all child processes
        kill(0, SIGTERM);
        exit(0);
    case SIGUSR2:
        write(1, "Child process ended.\n", 22);
        received_signals++;
        break;
    default:
        received_signals++;
        break;
    }
}
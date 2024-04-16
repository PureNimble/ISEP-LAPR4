// standard libraries
#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <stdlib.h>
// signal libraries
#include <signal.h>
#include "info.h"
#include "utils.h"
#include <sys/types.h>

/**
 * @brief Change the comportment of a set of signals.
 */
void setUpSignal()
{
    struct sigaction act;
    memset(&act, 0, sizeof(struct sigaction));
    act.sa_handler = handle_signal;
    act.sa_flags = SA_RESTART;
    sigaction(SIGUSR1, &act, NULL);
    sigaction(SIGINT, &act, NULL);
}

/**
 *
 * @brief Handle the signals
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
    default:
        break;
    }
}
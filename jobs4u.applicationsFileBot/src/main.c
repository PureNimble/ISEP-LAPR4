#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <string.h>
#include "info.h"
#include "utils.h"

/**
 * @file main.c
 * @brief Main function responsible for creating child processes and handling
 *        the parent process.
 */

volatile sig_atomic_t received_signals = 0;
// pipes check
// format project
// read project
int main() {
    Config config;
    readConfigFile(&config); 
    printConfig(&config); 

    int fd[2],i, numberOfCandidates;
    pid_t pid[config.numberOfChildren];
    memset(pid, 0, sizeof(pid));
    setUpSignal(); 
    
    if (createChildProcess() == 0)
        newFileChecker(&config); 

    createPipe(fd);
    for (i = 0; i < config.numberOfChildren; i++) {
        pid[i] = createChildProcess();
        if (pid[i] == 0) copyFiles(fd,&config);  
    }

    while (1){  
        pause(); 
        numberOfCandidates = listCandidatesID(fd,&config);
        printf("Number of Candidates: %d\n", numberOfCandidates);
        while(numberOfCandidates != received_signals);
        received_signals = 0;
        printf("All files have been copied\n");
        reportFile(&config);
        printf("Report file has been generated\n");
    }

    return 0;
}

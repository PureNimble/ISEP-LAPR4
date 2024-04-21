// standard libraries
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
// process libraries
#include <sys/wait.h>
#include <string.h>
// info about this project
#include "info.h"
#include "utils.h"
/**
 *
 * @brief Main function, responsible for creating the children processes and to
 * handle the parent process.
 */

volatile sig_atomic_t received_signals = 0;

int main() {
    Config config;
    readConfigFile(&config); // read the config file
    printConfig(&config); // print the config file to the user

    int fd[2],i, numberOfCandidates;
    pid_t pid[config.numberOfChildren];
    memset(pid, 0, sizeof(pid));
    setUpSignal(); // set up the signal handler
    
    if (createChildProcess() == 0)
        newFileChecker(&config);  // first child process

    createPipe(fd); // create the pipe
    for (i = 0; i < config.numberOfChildren; i++) {
        pid[i] = createChildProcess();
        if (pid[i] == 0) copyFiles(fd,&config);  // set the children to copy files
    }

    //close(fd[0]); // close the read end of the pipe
    
    while (1){  // Parent Code
        pause(); // wait for new files
        numberOfCandidates = listCandidatesID(fd,&config); // list new Candidates
        printf("Number of Candidates: %d\n", numberOfCandidates);
        while(numberOfCandidates != received_signals); // wait for all children to finish
        received_signals = 0; // reset the number of signals
        printf("All files have been copied\n");
        reportFile(&config); // generate the report file
        printf("Report file has been generated\n");
    }

    return 0;
}  
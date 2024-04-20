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
    int fd[2],i, numberOfCandidates;
    pid_t pid[NUMBER_OF_CHILDREN];
    memset(pid, 0, sizeof(pid));
    setUpSignal();

    if (createChildProcess() == 0)
        newFileChecker();  // first child process

    createPipe(fd);
    for (i = 0; i < NUMBER_OF_CHILDREN; i++) {
        pid[i] = createChildProcess();
        if (pid[i] == 0) copyFiles(fd);  // create children processes
    }

    //close(fd[0]); // close the read end of the pipe
    
    while (1){  // Parent Code
        pause(); // wait for new files
        numberOfCandidates = listCandidatesID(fd); // list new Candidates
        while(numberOfCandidates != received_signals); // wait for all children to finish
        received_signals = 0; // reset the number of signals
        printf("All files have been copied\n");
        //reportFile(numberOfCandidates, received_signals); // generate the report file
    }

    return 0;
}
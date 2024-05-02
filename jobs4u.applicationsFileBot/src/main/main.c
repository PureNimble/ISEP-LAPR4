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

int main()
{
    Config config;
    readConfigFile(&config);
    printConfig(&config);

    int send_work_fd[2], recive_work[2]; // child/parent pipe
    unsigned int i, numberOfCandidates;
    pid_t pid;
    setUpSignal();

    if (createChildProcess() == 0)
        newFileChecker(&config);

    createPipe(send_work_fd);
    createPipe(recive_work);
    for (i = 0; i < config.numberOfChildren; i++)
    {
        pid = createChildProcess();
        if (pid == 0)
            copyFiles(send_work_fd, recive_work, &config);
    }

    while (1)
    {
        pause();
        numberOfCandidates = listCandidatesID(send_work_fd, &config);
        printf("Number of Candidates: %d\n", numberOfCandidates);
        Files *files;
        createMalloc((void **)&files, sizeof(Files) * numberOfCandidates);
        for (i = 0; i < numberOfCandidates; i++)
        {
            Files file;
            read(recive_work[0], &file, sizeof(Files));
            files[i] = file;
        }
        printf("All files have been copied\n");
        reportFile(&config, files, numberOfCandidates);
    }

    return 0;
}

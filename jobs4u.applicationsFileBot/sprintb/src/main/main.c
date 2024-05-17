#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#include <string.h>
#include "info.h"
#include "utils.h"

/**
 * Main function of the program.
 * Reads the configuration file, creates child processes, sets up pipes,
 * creates worker processes, and handles candidates.
 * @return 0 on successful execution.
 */
int main()
{
    Config config;
    readConfigFile(&config);
    printConfig(&config);

    int send_work_fd[2], recive_work[2]; // child/parent pipe
    setUpSignal();

    if (createChildProcess() == 0)
        newFileChecker(&config);

    createPipe(send_work_fd);
    createPipe(recive_work);

    createWorkers(&config, send_work_fd, recive_work);
    handleCandidates(&config, send_work_fd, recive_work);

    return 0;
}

/**
 * Creates worker processes based on the number of children specified in the configuration.
 * Each worker process copies files using the send_work_fd and recive_work pipes.
 * @param config Pointer to the configuration struct.
 * @param send_work_fd Pointer to the send_work_fd pipe.
 * @param recive_work Pointer to the recive_work pipe.
 */
void createWorkers(Config *config, int *send_work_fd, int *recive_work)
{
    pid_t pid;
    unsigned int i;
    for (i = 0; i < config->numberOfChildren; i++)
    {
        pid = createChildProcess();
        if (pid == 0)
            copyFiles(send_work_fd, recive_work, config);
    }
}

/**
 * Handles the candidates by continuously pausing and reading candidate files from the recive_work pipe.
 * Reports the copied files using the reportFile function.
 * @param config Pointer to the configuration struct.
 * @param send_work_fd Pointer to the send_work_fd pipe.
 * @param recive_work Pointer to the recive_work pipe.
 */
void handleCandidates(Config *config, int *send_work_fd, int *recive_work)
{
    unsigned int i, numberOfCandidates;
    while (1)
    {
        pause();
        numberOfCandidates = listCandidatesID(send_work_fd, config);
        printf("Number of Candidates: %d\n", numberOfCandidates);
        Files *files;
        createMalloc((void **)&files, sizeof(Files) * numberOfCandidates);
        for (i = 0; i < numberOfCandidates; i++)
        {
            Files file;
            read(recive_work[0], &file, sizeof(Files));
            files[i] = file;
        }
        printf("-> All files have been copied\n");
        reportFile(config, files, numberOfCandidates);
    }
}
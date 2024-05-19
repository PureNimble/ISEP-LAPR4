#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>
#include <fcntl.h>
#include <string.h>
#include "utils.h"
#include <semaphore.h>
int main()
{
    Config config;
    sem_t *sem_newFile, *sem_shared_memory, *sem_barrier, *sem_barrier_mutex;
    CircularBuffer *sharedMemory;
    int fd;

    readConfigFile(&config);
    printConfig(&config);
    setUpSignal();
    sem_newFile = createSemaphore(SEM_NEW_FILE_CHECKER, 0);

    if (createChildProcess() == 0)
        newFileChecker(&config, sem_newFile);

    sharedMemory = createSharedMemory(SHARED_MEMORY, &fd);     // Comunication between workers and main process
    sem_shared_memory = createSemaphore(SEM_SHARED_MEMORY, 0); // for shared memory acess
    sem_barrier_mutex = createSemaphore(SEM_BARRIER_MUTEX, 1); // To protect the barrier counter
    sem_barrier = createSemaphore(SEM_BARRIER, 0);             // To wait for all workers to finish

    createWorkers(&config, sharedMemory, sem_shared_memory, sem_barrier, sem_barrier_mutex);
    while (1)
    {
        sem_wait(sem_newFile);
        printf("New file detected\n");
        listCandidatesID(&config, sharedMemory, sem_shared_memory);
        sem_wait(sem_barrier);
        reportFile(&config, sharedMemory);
    }

    return 0;
}

/**
 * Creates worker processes based on the number of children specified in the configuration.
 * Each worker process copies files using the send_work_fd and recive_work pipes.
 * @param config Pointer to the configuration struct.
 * @param send_work_fd Pointer to the send_work_fd pipe.
 * @param recive_work Pointer to the recive_work pipe.
 */
void createWorkers(Config *config, CircularBuffer *shared_data, sem_t *sem_shared_memory, sem_t *sem_barrier, sem_t *sem_barrier_mutex)
{
    unsigned int i;
    for (i = 0; i < config->numberOfChildren; i++)
    {
        if (createChildProcess() == 0)
            copyFiles(config, shared_data, sem_shared_memory, sem_barrier, sem_barrier_mutex);
    }
}

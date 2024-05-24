#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>
#include <fcntl.h>
#include <string.h>
#include "utils.h"
#include <semaphore.h>
/**
 * @brief The main function of the application.
 *
 * This function initializes the necessary variables and resources, reads the configuration file,
 * creates semaphores and shared memory, creates child processes, and performs the parent and worker tasks.
 *
 * @return 0 on successful execution.
 */
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
    parentWork(&config, sharedMemory, sem_shared_memory, sem_newFile, sem_barrier);

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

/**
 * Performs the work of the parent process.
 *
 * This function continuously waits for a new file signal, then lists the candidates' IDs
 * and generates a report file based on the configuration.
 *
 * @param config The configuration object.
 * @param sharedMemory The shared memory object.
 * @param sem_shared_memory The semaphore for shared memory synchronization.
 * @param sem_newFile The semaphore for signaling a new file.
 */
void parentWork(Config *config, CircularBuffer *sharedMemory, sem_t *sem_shared_memory, sem_t *sem_newFile, sem_t *sem_barrier)
{
    while (1)
    {
        sem_wait(sem_newFile);
        listCandidatesID(config, sharedMemory, sem_shared_memory);
        sem_wait(sem_barrier);
        reportFile(config, sharedMemory);
    }
}

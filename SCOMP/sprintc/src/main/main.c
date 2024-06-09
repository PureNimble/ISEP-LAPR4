#include <stdlib.h>
#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>
#include <fcntl.h>
#include <string.h>
#include "utils.h"
#include <semaphore.h>

/**
 * @brief The main function of the program.
 *
 * This function initializes the necessary variables and resources, reads the configuration file,
 * creates semaphores and shared memory, and spawns child processes and worker threads.
 * It then coordinates the execution of the program by calling various functions.
 */
pid_t pids[21];
int pidsCounter = 0;
int main()
{

    Config config;
    CircularBuffer *sharedMemory;
    int fd;

    readConfigFile(&config);
    printConfig(&config);

    setUpSignal();

    sem_t *sem_newFile = createSemaphore(SEM_NEW_FILE_CHECKER, 0);

    if ((pids[pidsCounter] = createChildProcess()) == 0)
        newFileChecker(&config, sem_newFile);

    sharedMemory = createSharedMemory(SHARED_MEMORY, &fd, &config);
    sem_t *sem_startWorkers = createSemaphore(SEM_START_WORKERS, 0);             // send work to workers
    sem_t *sem_startReport = createSemaphore(SEM_REPORT_FILE, 0);                // send data to report file
    sem_t *sem_bufferSize = createSemaphore(SEM_BUFFER_SIZE, config.bufferSize); // buffer size
    sem_t *sem_numberOfCandidates = createSemaphore(SEM_NUMBER_OF_CANDIDATES, 0);
    sem_t *sem_sharedmemory_mutex = createSemaphore(SEM_SHARED_MEMORY_MUTEX, 1); // mutex for shared memory

    createWorkers(&config, sharedMemory, sem_startWorkers, sem_startReport, sem_sharedmemory_mutex, pids);
    parentWork(&config, sharedMemory, sem_newFile, sem_bufferSize, sem_numberOfCandidates, sem_startWorkers, sem_startReport, sem_sharedmemory_mutex);

    return 0;
}

/**
 * Creates worker processes to copy files based on the provided configuration.
 *
 * @param config The configuration settings for the worker processes.
 * @param shared_data The circular buffer for sharing data between processes.
 * @param sem_startWorkers The semaphore for synchronizing the start of worker processes.
 * @param sem_reportFile The semaphore for synchronizing file reporting.
 * @param sem_isDone_mutex The mutex semaphore for synchronizing the isDone flag.
 * @param sem_files_mutex The mutex semaphore for synchronizing access to the files.
 */
void createWorkers(Config *config, CircularBuffer *sharedMemory, sem_t *sem_startWorkers, sem_t *sem_startReport, sem_t *sem_sharedmemory_mutex, pid_t *pids)
{
    for (unsigned int i = 0; i < config->numberOfChildren; i++)
    {
        pidsCounter++;
        if ((pids[pidsCounter] = createChildProcess()) == 0)
            copyFiles(config, sharedMemory, sem_startWorkers, sem_startReport, sem_sharedmemory_mutex);
    }
}

/**
 * Executes the parent work in a loop.
 *
 * @param config The configuration object.
 * @param sharedMemory The shared circular buffer.
 * @param sem_startWorkers The semaphore for starting workers.
 * @param sem_newFile The semaphore for new file.
 * @param sem_reportFile The semaphore for reporting file.
 * @param sem_addToBuffer_mutex The mutex semaphore for adding to buffer.
 * @param sem_isDone_mutex The mutex semaphore for checking if work is done.
 * @param sem_numberOfCandidates The semaphore for number of candidates.
 */

void parentWork(Config *config, CircularBuffer *sharedMemory, sem_t *sem_newFile, sem_t *sem_bufferSize, sem_t *sem_numberOfCandidates, sem_t *sem_startWorkers, sem_t *sem_startReport, sem_t *sem_sharedmemory_mutex)
{
    HashSet *candidateList;
    int i, numberOfCandidates;

    while (1)
    {
        sem_wait(sem_newFile);

        candidateList = listCandidatesID(config, sharedMemory);
        numberOfCandidates = size(candidateList);
        printf("-> Number of Candidates: %d\n", numberOfCandidates);
        for (i = 0; i < numberOfCandidates - 1; i++)
            sem_post(sem_numberOfCandidates);

        while (1)
        {
            if (!isSetEmpty(candidateList))
            {
                while (sem_trywait(sem_bufferSize) == 0)
                    sendWork(candidateList, sharedMemory, sem_sharedmemory_mutex, sem_startWorkers);
            }

            sem_wait(sem_startReport);
            reportFile(config, sharedMemory, sem_sharedmemory_mutex, sem_bufferSize);
            if (sem_trywait(sem_numberOfCandidates) == -1)
                break;
        }

        printf("-> All Work is Done!\n");
        freeHashSet(candidateList);
    }
}

/**
 * Sends work to the workers by adding candidate IDs to a shared memory circular buffer.
 *
 * @param candidateList The hash set containing the candidate IDs.
 * @param sharedMemory The circular buffer for storing the candidate IDs.
 * @param sem_addToBuffer The semaphore for synchronizing access to the circular buffer.
 * @param sem_isDone The semaphore for indicating when a worker is done processing a candidate.
 * @param sem_startWorkers The semaphore for signaling the workers to start processing.
 * @return Returns 0 if the buffer is not full after sending all the candidates, 1 otherwise.
 */
void sendWork(HashSet *candidateList, CircularBuffer *sharedMemory, sem_t *sem_sharedmemory_mutex, sem_t *sem_startWorkers)
{
    sem_wait(sem_sharedmemory_mutex);
    addToBuffer(sharedMemory, getValue(candidateList));
    sem_post(sem_sharedmemory_mutex);
    sem_post(sem_startWorkers);
}
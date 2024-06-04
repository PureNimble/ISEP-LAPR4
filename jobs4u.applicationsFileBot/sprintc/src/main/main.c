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
    sem_t *sem_newFile, *sem_startWorkers, *sem_reportFile,
        *sem_addToBuffer_mutex, *sem_numberOfCandidates_mutex,
        *sem_isDone_mutex, *sem_files_mutex;
    int fd;

    readConfigFile(&config);
    printConfig(&config);

    setUpSignal();

    sem_newFile = createSemaphore(SEM_NEW_FILE_CHECKER, 0);

    if ((pids[pidsCounter] = createChildProcess()) == 0)
        newFileChecker(&config, sem_newFile);

    sharedMemory = createSharedMemory(SHARED_MEMORY, &fd, &config);
    sem_startWorkers = createSemaphore(SEM_START_WORKERS, 0);
    sem_reportFile = createSemaphore(SEM_REPORT_FILE, 0);
    sem_addToBuffer_mutex = createSemaphore(SEM_ADD_TO_BUFFER, 1);
    sem_numberOfCandidates_mutex = createSemaphore(SEM_NUMBER_OF_CANDIDATES, 1);
    sem_isDone_mutex = createSemaphore(SEM_IS_DONE, 1);
    sem_files_mutex = createSemaphore(SEM_FILES, 1);

    createWorkers(&config, sharedMemory, sem_startWorkers, sem_reportFile, sem_isDone_mutex, sem_files_mutex, pids);
    parentWork(&config, sharedMemory, sem_startWorkers, sem_newFile, sem_reportFile, sem_addToBuffer_mutex, sem_isDone_mutex, sem_numberOfCandidates_mutex);

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
void createWorkers(Config *config, CircularBuffer *shared_data, sem_t *sem_startWorkers, sem_t *sem_reportFile, sem_t *sem_isDone_mutex, sem_t *sem_files_mutex, pid_t *pids)
{
    for (unsigned int i = 0; i < config->numberOfChildren; i++)
    {
        pidsCounter++;
        if ((pids[pidsCounter] = createChildProcess()) == 0)
            copyFiles(config, shared_data, sem_startWorkers, sem_isDone_mutex, sem_files_mutex, sem_reportFile);
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
void parentWork(Config *config, CircularBuffer *sharedMemory, sem_t *sem_startWorkers, sem_t *sem_newFile, sem_t *sem_reportFile, sem_t *sem_addToBuffer_mutex, sem_t *sem_isDone_mutex, sem_t *sem_numberOfCandidates)
{
    HashSet *candidateList;
    int isThereCandidatesToSend;

    while (1)
    {
        isThereCandidatesToSend = 1;
        sem_wait(sem_newFile);

        candidateList = listCandidatesID(config, sharedMemory);

        while (1)
        {
            if (isThereCandidatesToSend)
                isThereCandidatesToSend = sendWork(candidateList, sharedMemory, sem_addToBuffer_mutex, sem_isDone_mutex, sem_startWorkers);

            sem_wait(sem_reportFile);
            reportFile(config, sharedMemory, sem_addToBuffer_mutex, sem_numberOfCandidates);

            if (sharedMemory->numberOfCandidates == 0)
                break;
        }

        printf("-> All Work is Done!\n");
        fflush(stdout);
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
int sendWork(HashSet *candidateList, CircularBuffer *sharedMemory, sem_t *sem_addToBuffer, sem_t *sem_isDone, sem_t *sem_startWorkers)
{
    int isBufferFull = 0;
    int candidateID;

    while (!isBufferFull)
    {
        if ((candidateID = getValue(candidateList)) == -1)
            break;

        isBufferFull = addToBuffer(sharedMemory, candidateID, sem_isDone, sem_addToBuffer);

        if (isBufferFull)
            add(candidateList, candidateID);
    }

    sem_post(sem_startWorkers);
    printf("-> Sent data to the Workers\n");

    return isBufferFull;
}
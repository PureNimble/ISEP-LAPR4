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
    CircularBuffer *sharedMemory;
    sem_t *sem_newFile, *sem_startWorkers, *sem_reportFile,
        *sem_addToBuffer_mutex, *sem_numberOfCandidates_mutex,
        *sem_isDone_mutex, *sem_files_mutex;
    int fd;
    readConfigFile(&config);
    printConfig(&config);
    setUpSignal();

    sem_newFile = createSemaphore(SEM_NEW_FILE_CHECKER, 0);

    if (createChildProcess() == 0)
        newFileChecker(&config, sem_newFile);

    sharedMemory = createSharedMemory(SHARED_MEMORY, &fd, &config); // Comunication between workers and main process
    sem_startWorkers = createSemaphore(SEM_START_WORKERS, 0);       // Know when to start the workers
    sem_reportFile = createSemaphore(SEM_REPORT_FILE, 0);           // Know when to generate the report file for each candidate
    // Write On shared memory
    sem_addToBuffer_mutex = createSemaphore(SEM_ADD_TO_BUFFER, 1);               // Write On Buffer:Head; CandidateInfo:candidateID
    sem_numberOfCandidates_mutex = createSemaphore(SEM_NUMBER_OF_CANDIDATES, 1); // Write On Buffer:numberOfCandidates
    sem_isDone_mutex = createSemaphore(SEM_IS_DONE, 1);                          // Write On Buffer:isDone
    sem_files_mutex = createSemaphore(SEM_FILES, 1);                             // Write On CandidateInfo:files,numFiles

    createWorkers(&config, sharedMemory, sem_startWorkers, sem_reportFile, sem_isDone_mutex, sem_files_mutex);
    parentWork(&config, sharedMemory, sem_startWorkers, sem_newFile, sem_reportFile, sem_addToBuffer_mutex, sem_isDone_mutex, sem_numberOfCandidates_mutex);

    return 0;
}

/**
 * Creates worker processes based on the number of children specified in the configuration.
 * Each worker process copies files using the send_work_fd and recive_work pipes.
 * @param config Pointer to the configuration struct.
 * @param send_work_fd Pointer to the send_work_fd pipe.
 * @param recive_work Pointer to the recive_work pipe.
 */
void createWorkers(Config *config, CircularBuffer *shared_data, sem_t *sem_startWorkers, sem_t *sem_reportFile, sem_t *sem_isDone_mutex, sem_t *sem_files_mutex)
{
    unsigned int i;
    for (i = 0; i < config->numberOfChildren; i++)
    {
        if (createChildProcess() == 0)
            copyFiles(config, shared_data, sem_startWorkers, sem_isDone_mutex, sem_files_mutex, sem_reportFile);
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
 * @param sem_startWorkers The semaphore for shared memory synchronization.
 * @param sem_newFile The semaphore for signaling a new file.
 */
void parentWork(Config *config, CircularBuffer *sharedMemory, sem_t *sem_startWorkers, sem_t *sem_newFile, sem_t *sem_reportFile, sem_t *sem_addToBuffer_mutex, sem_t *sem_isDone_mutex, sem_t *sem_numberOfCandidates)
{
    HashSet *candidateList;
    int isThereCandidatesToSend;
    while (1)
    {
        isThereCandidatesToSend = 1; // flag to check if there are candidates to send
        sem_wait(sem_newFile);
        // loop
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
#include "config.h"
#include "info.h"
#include "test.h"
#include <stdio.h>
#include <stddef.h>
#include <stdlib.h>
#include <string.h>
#include "utils.h"
#include <sys/stat.h>
#include <unistd.h>
#include <signal.h>
#include <sys/types.h>
#include <errno.h>
int sendWork(HashSet *candidateList, CircularBuffer *sharedMemory, sem_t *sem_sharedMemory_mutex, sem_t *sem_startWorkers);
int main()
{
    create_directory(SHARED_FOLDER);
    create_directory(TEST_INPUT);
    create_directory(TEST_OUTPUT);

    Config config;
    strcpy(config.inputPath, TEST_INPUT);
    strcpy(config.outputPath, TEST_OUTPUT);
    config.verifyNewFilesFrequency = TEST_FREQUENCY;
    config.numberOfChildren = TEST_CHILDREN;
    config.bufferSize = TEST_BUFFER_SIZE;
    setUpSignal();

    newFileChecker_test(config);
    int fd;
    // Shared memory and semaphores
    CircularBuffer *shared_data = createSharedMemory(SHARED_MEMORY, &fd, &config);
    sem_t *sem_startWorkers = createSemaphore(SEM_SHARED_MEMORY, 0);
    sem_t *sem_sharedMemory_mutex = createSemaphore(SEM_BARRIER, 0);
    sem_t *sem_reportFile = createSemaphore(SEM_BARRIER_MUTEX, 1);

    copyFiles_test(config, shared_data, sem_startWorkers, sem_sharedMemory_mutex, sem_reportFile);
    sem_wait(sem_reportFile);
    reportFile_test(config, shared_data, sem_sharedMemory_mutex);

    // delete folder
    printf("-> Deleting test folders in 5 seconds\n");
    sleep(DELETE_FOLDER_TIME);
    delete_directory(TEST_INPUT);
    delete_directory(TEST_OUTPUT);
    removeSemaphore(SEM_NEW_FILE_CHECKER);
    removeSemaphore(SEM_SHARED_MEMORY);
    removeSemaphore(SEM_BARRIER);
    removeSemaphore(SEM_BARRIER_MUTEX);
    removeSharedMemory(SHARED_MEMORY);

    return 0;
}

void newFileChecker_test(Config config)
{
    pid_t pid;
    sem_t *sem_new_file_checker = createSemaphore(SEM_NEW_FILE_CHECKER, 0);
    printf("-> Testing newFileChecker\n");
    if ((pid = createChildProcess()) == 0)
        newFileChecker(&config, sem_new_file_checker);

    // create new file in input folder
    char *file_path = malloc(FILE_PATH_SIZE);
    strcpy(file_path, TEST_INPUT);
    strcat(file_path, "1-candidate-data.txt");
    FILE *file = fopen(file_path, "w");
    if (file == NULL)
    {
        errorMessages("Failed to create file.\n\n");
        exit(EXIT_FAILURE);
    }
    fprintf(file, "FNAC1-1\njohndoe@email.com\nJohn Doe\n961234567\n");
    sem_wait(sem_new_file_checker);
    kill(pid, SIGTERM);
    fclose(file);

    printf("-> newFileChecker test passed\n\n\n");
}

void copyFiles_test(Config config, CircularBuffer *shared_data, sem_t *sem_startWorkers, sem_t *sem_sharedMemory_mutex, sem_t *sem_reportFile)
{
    printf("-> Testing copyFiles\n");
    pid_t pid;

    if ((pid = createChildProcess()) == 0)
        copyFiles(&config, shared_data, sem_startWorkers, sem_sharedMemory_mutex, sem_reportFile);

    HashSet *candidates = listCandidatesID(&config, shared_data);
    sendWork(candidates, shared_data, sem_sharedMemory_mutex, sem_startWorkers);
    sem_wait(sem_reportFile);

    printf("-> copyFiles test passed\n\n\n");
}

void reportFile_test(Config config, CircularBuffer *shared_data, sem_t *sem)
{
    printf("-> Testing reportFile\n");

    reportFile(&config, shared_data, sem);

    printf("-> reportFile test passed\n");
}

int sendWork(HashSet *candidateList, CircularBuffer *sharedMemory, sem_t *sem_sharedMemory_mutex, sem_t *sem_startWorkers)
{
    int isBufferFull = 0;
    int candidateID;
    while (!isBufferFull)
    {
        if ((candidateID = getValue(candidateList)) == -1)
            break;
        sem_wait(sem_sharedMemory_mutex);
        isBufferFull = addToBuffer(sharedMemory, candidateID);
        if (isBufferFull)
            add(candidateList, candidateID);
        sem_post(sem_sharedMemory_mutex);
    }

    sem_post(sem_startWorkers);
    printf("-> Sent data to the Workers\n");
    return isBufferFull;
}
#include "config.h"
#include "info.h"
#include "test.h"
#include "utils.h"
#include <stdio.h>
#include <stddef.h>
#include <stdlib.h>
#include <string.h>
#include <sys/stat.h>
#include <unistd.h>
#include <signal.h>
#include <sys/types.h>
#include <errno.h>
pid_t pids[2];
int pidsCounter = 0;
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
    CircularBuffer *sharedMemory = createSharedMemory(SHARED_MEMORY, &fd, &config);
    sem_t *sem_startWorkers = createSemaphore(SEM_START_WORKERS, 0);             // send work to workers
    sem_t *sem_startReport = createSemaphore(SEM_REPORT_FILE, 0);                // send data to report file
    sem_t *sem_bufferSize = createSemaphore(SEM_BUFFER_SIZE, config.bufferSize); // buffer size
    sem_t *sem_sharedmemory_mutex = createSemaphore(SEM_SHARED_MEMORY_MUTEX, 1); // mutex for shared memory
    sem_t *sem_numberOfCandidates = createSemaphore(SEM_NUMBER_OF_CANDIDATES, 0);

    sem_post(sem_numberOfCandidates);

    copyFiles_test(config, sharedMemory, sem_startWorkers, sem_startReport, sem_sharedmemory_mutex);
    reportFile_test(config, sharedMemory, sem_startReport, sem_sharedmemory_mutex, sem_bufferSize);

    printf("-> Deleting test folders in 5 seconds\n");
    sleep(DELETE_FOLDER_TIME);
    delete_directory(TEST_INPUT);
    delete_directory(TEST_OUTPUT);

    removeSemaphore(SEM_NEW_FILE_CHECKER);
    removeSemaphore(SEM_START_WORKERS);
    removeSemaphore(SEM_REPORT_FILE);
    removeSemaphore(SEM_BUFFER_SIZE);
    removeSemaphore(SEM_NUMBER_OF_CANDIDATES);
    removeSemaphore(SEM_SHARED_MEMORY_MUTEX);

    removeSharedMemory(SHARED_MEMORY);

    return 0;
}

void newFileChecker_test(Config config)
{
    pid_t pid;
    sem_t *sem_new_file_checker = createSemaphore(SEM_NEW_FILE_CHECKER, 0);

    printf("-> Testing newFileChecker\n");

    if ((pid = createChildProcess()) == 0)
    {
        newFileChecker(&config, sem_new_file_checker);
    }

    char *file_path = malloc(FILE_PATH_SIZE);
    snprintf(file_path, FILE_PATH_SIZE, "%s1-candidate-data.txt", TEST_INPUT);

    FILE *file = fopen(file_path, "w");
    if (file == NULL)
    {
        perror("Failed to create file");
        exit(EXIT_FAILURE);
    }

    fprintf(file, "FNAC1-1\njohndoe@email.com\nJohn Doe\n961234567\n");
    fclose(file);

    sem_wait(sem_new_file_checker);
    kill(pid, SIGTERM);

    printf("-> newFileChecker test passed\n\n\n");

    free(file_path);
}

void copyFiles_test(Config config, CircularBuffer *sharedMemory, sem_t *sem_startWorkers, sem_t *sem_startReport, sem_t *sem_sharedmemory_mutex)
{
    printf("-> Testing copyFiles\n");
    pid_t pid;

    if ((pid = createChildProcess()) == 0)
        copyFiles(&config, sharedMemory, sem_startWorkers, sem_startReport, sem_sharedmemory_mutex);

    HashSet *candidateList = listCandidatesID(&config, sharedMemory);
    sendWork(candidateList, sharedMemory, sem_sharedmemory_mutex, sem_startWorkers);
    sem_wait(sem_startReport);
    kill(pid, SIGTERM);

    printf("-> copyFiles test passed\n\n\n");
}

void reportFile_test(Config config, CircularBuffer *sharedMemory, sem_t *sem_startReport, sem_t *sem_sharedmemory_mutex, sem_t *sem_bufferSize)
{
    printf("-> Testing reportFile\n");
    reportFile(&config, sharedMemory, sem_sharedmemory_mutex, sem_bufferSize);
    printf("-> reportFile test passed\n");
}

void sendWork(HashSet *candidateList, CircularBuffer *sharedMemory, sem_t *sem_sharedmemory_mutex, sem_t *sem_startWorkers)
{
    sem_wait(sem_sharedmemory_mutex);
    addToBuffer(sharedMemory, getValue(candidateList));
    sem_post(sem_sharedmemory_mutex);
    sem_post(sem_startWorkers);
}
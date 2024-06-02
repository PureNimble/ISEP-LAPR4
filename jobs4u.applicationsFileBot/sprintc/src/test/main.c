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

int sendWork(HashSet *candidateList, CircularBuffer *sharedMemory, sem_t *sem_addToBuffer, sem_t *sem_isDone, sem_t *sem_startWorkers);

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
    CircularBuffer *shared_data = createSharedMemory(SHARED_MEMORY, &fd, &config);
    sem_t *sem_startWorkers = createSemaphore(SEM_START_WORKERS, 0);
    sem_t *sem_reportFile = createSemaphore(SEM_REPORT_FILE, 0);
    sem_t *sem_addToBuffer_mutex = createSemaphore(SEM_ADD_TO_BUFFER, 1);
    sem_t *sem_numberOfCandidates_mutex = createSemaphore(SEM_NUMBER_OF_CANDIDATES, 1);
    sem_t *sem_isDone_mutex = createSemaphore(SEM_IS_DONE, 1);
    sem_t *sem_files_mutex = createSemaphore(SEM_FILES, 1);

    copyFiles_test(config, shared_data, sem_startWorkers, sem_reportFile, sem_isDone_mutex, sem_files_mutex, sem_addToBuffer_mutex);
    reportFile_test(config, shared_data, sem_addToBuffer_mutex, sem_numberOfCandidates_mutex);

    printf("-> Deleting test folders in 5 seconds\n");
    sleep(DELETE_FOLDER_TIME);
    delete_directory(TEST_INPUT);
    delete_directory(TEST_OUTPUT);

    removeSemaphore(SEM_NEW_FILE_CHECKER);
    removeSemaphore(SEM_START_WORKERS);
    removeSemaphore(SEM_REPORT_FILE);
    removeSemaphore(SEM_ADD_TO_BUFFER);
    removeSemaphore(SEM_NUMBER_OF_CANDIDATES);
    removeSemaphore(SEM_IS_DONE);
    removeSemaphore(SEM_FILES);

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

void copyFiles_test(Config config, CircularBuffer *shared_data, sem_t *sem_startWorkers, sem_t *sem_reportFile, sem_t *sem_isDone_mutex, sem_t *sem_files_mutex, sem_t *sem_addToBuffer_mutex)
{
    printf("-> Testing copyFiles\n");
    pid_t pid;

    if ((pid = createChildProcess()) == 0)
        copyFiles(&config, shared_data, sem_startWorkers, sem_isDone_mutex, sem_files_mutex, sem_reportFile);

    HashSet *candidates = listCandidatesID(&config, shared_data);
    sendWork(candidates, shared_data, sem_addToBuffer_mutex, sem_isDone_mutex, sem_startWorkers);
    sem_wait(sem_reportFile);

    printf("-> copyFiles test passed\n\n\n");
}

void reportFile_test(Config config, CircularBuffer *shared_data, sem_t *sem_addToBuffer_mutex, sem_t *sem_numberOfCandidates)
{
    printf("-> Testing reportFile\n");
    reportFile(&config, shared_data, sem_addToBuffer_mutex, sem_numberOfCandidates);
    printf("-> reportFile test passed\n");
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
#ifndef INFO_H
#define INFO_H

#define MAX_CHILDREN 100
#define SHARED_MEMORY "/shared_memory"
#define SEM_SHARED_MEMORY "/sem_shared_memory"
#define SEM_NEW_FILE_CHECKER "/sem_new_file_checker"
#define SEM_BARRIER "/sem_barrier"
#define SEM_BARRIER_MUTEX "/sem_barrier_mutex"

#include "config.h"
#include <semaphore.h>
#include "circularBuffer.h"
#include "candidateInfo.h"
#include "hashSet.h"

// -----------------------------
// Signal handling functions
// -----------------------------
void handle_signal(int signal);
void setUpSignal();
void removeShmFiles();
// -----------------------------
// File checking functions
// -----------------------------
void newFileChecker(Config *config, sem_t *sem);
// -----------------------------
// Parent process functions
// -----------------------------
int checkIfCandidateFilesExist(CandidateInfo *files, int numberOfCandidates, char *buffer);
void reportFile(Config *config, CircularBuffer *sharedMemory);
void parentWork(Config *config, CircularBuffer *sharedMemory, sem_t *sem_shared_memory, sem_t *sem_newFile, sem_t *sem_barrier);
void listCandidatesID(Config *config, CircularBuffer *sharedData, sem_t *sem_shared_memory);
void createWorkers(Config *config, CircularBuffer *shared_data, sem_t *sem_shared_memory, sem_t *sem_barrier, sem_t *sem_barrier_mutex);
// -----------------------------
// Child process functions
// -----------------------------
void copyFiles(Config *config, CircularBuffer *shared_data, sem_t *sem_shared_memory, sem_t *sem_barrier, sem_t *sem_barrier_mutex, int isTest);
// -----------------------------
// Utility functions
// -----------------------------
char *readFirstLine(char *file_path, int candidateID);

#endif // INFO_H
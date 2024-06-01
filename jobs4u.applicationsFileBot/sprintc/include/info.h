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
int checkIfCandidateFileExists(CandidateInfo candidate, char *buffer);
void reportFile(Config *config, CircularBuffer *shared_memory, sem_t *sem_sharedMemory_mutex);
void parentWork(Config *config, CircularBuffer *sharedMemory, sem_t *sem_shared_memory, sem_t *sem_newFile, sem_t *sem_reportFile, sem_t *sem_sharedMemory_mutex);
HashSet *listCandidatesID(Config *config);
void createWorkers(Config *config, CircularBuffer *shared_data, sem_t *sem_shared_memory, sem_t *sem_barrier, sem_t *sem_barrier_mutex);
int sendWork(HashSet *candidateList, CircularBuffer *sharedMemory, sem_t *sem_sharedMemory_mutex, sem_t *sem_shared_memory);
// -----------------------------
// Child process functions
// -----------------------------
void copyFiles(Config *config, CircularBuffer *shared_data, sem_t *sem_shared_memory, sem_t *sem_barrier, sem_t *sem_barrier_mutex);

#endif // INFO_H
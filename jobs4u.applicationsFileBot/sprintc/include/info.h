#ifndef INFO_H
#define INFO_H
#define MAX_CHILDREN 100
#include "config.h"
#include <semaphore.h>
#include "circularBuffer.h"
#include "candidateInfo.h"
#include "hashSet.h"

#define SHARED_MEMORY "/shared_memory"
#define SEM_SHARED_MEMORY "/sem_shared_memory"
#define SEM_NEW_FILE_CHECKER "/sem_new_file_checker"
#define SEM_BARRIER "/sem_barrier"
#define SEM_BARRIER_MUTEX "/sem_barrier_mutex"

// main.c

// Singal setup (setupSignal.c)
void handle_signal(int signal);
void setUpSignal();

// Child Code (newFileChecker.c)
void newFileChecker(Config *config, sem_t *sem);

// Parent Code (listCandidatesID.c and reportFile.c)
void reportFile(Config *config, CircularBuffer *sharedMemory);
void listCandidatesID(Config *config, CircularBuffer *sharedData,
                      sem_t *sem_shared_memory);
void createWorkers(Config *config, CircularBuffer *shared_data,
                   sem_t *sem_shared_memory,
                   sem_t *sem_barrier,
                   sem_t *sem_barrier_mutex);

// Children Code (copyFiles.c)
void copyFiles(Config *config, CircularBuffer *shared_data,
               sem_t *sem_shared_memory,
               sem_t *sem_barrier,
               sem_t *sem_barrier_mutex);

char *readFirstLine(char *file_path, int candidateID);

#endif // INFO_H
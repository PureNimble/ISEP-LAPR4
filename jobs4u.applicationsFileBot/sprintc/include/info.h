#ifndef INFO_H
#define INFO_H

#define MAX_CHILDREN 100
#define SHARED_MEMORY "/shared_memory"
// communication between processes
#define SEM_NEW_FILE_CHECKER "/sem_new_file_checker"
#define SEM_START_WORKERS "/sem_start_workers"
#define SEM_REPORT_FILE "/sem_report_file"
// semaphores for the shared memory
#define SEM_BUFFER_SIZE "/sem_buffer_size"
#define SEM_NUMBER_OF_CANDIDATES "/sem_number_of_candidates"
#define SEM_SHARED_MEMORY_MUTEX "/sem_sharedmemory_mutex"

#include "config.h"
#include <semaphore.h>
#include <stddef.h>
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
void createWorkers(Config *config, CircularBuffer *shared_data, sem_t *sem_startWorkers, sem_t *sem_reportFile, sem_t *sem_sharedmemory_mutex, pid_t *pids);
void parentWork(Config *config, CircularBuffer *sharedMemory, sem_t *sem_newFile, sem_t *sem_bufferSize, sem_t *sem_numberOfCandidates, sem_t *sem_startWorkers, sem_t *sem_startReport, sem_t *sem_sharedmemory_mutex);
HashSet *listCandidatesID(Config *config, CircularBuffer *sharedMemory);
void sendWork(HashSet *candidateList, CircularBuffer *sharedMemory, sem_t *sem_addToBuffer, sem_t *sem_startWorkers);
void reportFile(Config *config, CircularBuffer *shared_memory, sem_t *sem_numberOfCandidates, sem_t *buffer_size);
int checkIfCandidateFileExists(CandidateInfo candidate, char *buffer);
// -----------------------------
// Worker(s) function
// -----------------------------
void copyFiles(Config *config, CircularBuffer *sharedMemory, sem_t *sem_startWorkers, sem_t *sem_startReport, sem_t *sem_sharedmemory_mutex);

#endif // INFO_H
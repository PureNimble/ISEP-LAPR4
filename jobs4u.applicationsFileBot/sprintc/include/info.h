#ifndef INFO_H
#define INFO_H

#define MAX_CHILDREN 100
#define SHARED_MEMORY "/shared_memory"
// communication between processes
#define SEM_NEW_FILE_CHECKER "/sem_new_file_checker"
#define SEM_START_WORKERS "/sem_start_workers"
#define SEM_REPORT_FILE "/sem_report_file"
// semaphores for the shared memory
#define SEM_ADD_TO_BUFFER "/sem_add_to_buffer"
#define SEM_NUMBER_OF_CANDIDATES "/sem_number_of_candidates"
#define SEM_IS_DONE "/sem_is_done"
#define SEM_FILES "/sem_files"

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
void reportFile(Config *config, CircularBuffer *shared_memory, sem_t *sem_numberOfCandidates, sem_t *sem_files);
void parentWork(Config *config, CircularBuffer *sharedMemory, sem_t *sem_startWorkers, sem_t *sem_newFile, sem_t *sem_reportFile, sem_t *sem_addToBuffer_mutex, sem_t *sem_isDone_mutex, sem_t *sem_numberOfCandidates);
HashSet *listCandidatesID(Config *config, CircularBuffer *sharedMemory);
void createWorkers(Config *config, CircularBuffer *shared_data, sem_t *sem_startWorkers, sem_t *sem_reportFile, sem_t *sem_isDone_mutex, sem_t *sem_files_mutex);
int sendWork(HashSet *candidateList, CircularBuffer *sharedMemory, sem_t *sem_addToBuffer, sem_t *sem_isDone, sem_t *sem_startWorkers);
// -----------------------------
// Worker(s) function
// -----------------------------
void copyFiles(Config *config, CircularBuffer *sharedMemory, sem_t *sem_startWorkers, sem_t *sem_isDone, sem_t *sem_files, sem_t *sem_reportFile);

#endif // INFO_H
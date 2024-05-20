#ifndef UTILS_H
#define UTILS_H
#define HASH_SET_SIZE 20
#define PERMISSIONS 0777
#include <semaphore.h>
#include "info.h"

// -----------------------------
// Semaphore related functions
// -----------------------------
sem_t *createSemaphore(char *name, unsigned value);
void removeSemaphore(char *name);
// -----------------------------
// Shared memory related functions
// -----------------------------
CircularBuffer *createSharedMemory(char *name, int *fd);
void removeSharedMemory(char *name);
void close_shared_memory(int fd, CircularBuffer *shm);
// ----------------------------------
// Process and pipe related functions
// ----------------------------------
pid_t createChildProcess();
void createPipe(int *fd);
// -----------------------------------
// Memory allocation related functions
// -----------------------------------
void createMalloc(void **array, size_t size);
void *createRealloc(void *array, size_t size);
void createMallocString(char **str, char *value);
// ------------------------------------
// File and directory related functions
// ------------------------------------
int isFileOrDirectory(char *path);
char *readFirstLine(char *file_path, int candidateID);
void create_directory(const char *dir);
void delete_directory(const char *dir);
// -----------------------------
// Utility functions
// -----------------------------
int isInteger(char *str);
void errorMessages(char *message);
// -----------------------------
// CandidateInfo struct related functions
// -----------------------------
void printFiles(CandidateInfo file);
CandidateInfo createFiles(int candidateID);

#endif // UTILS_H
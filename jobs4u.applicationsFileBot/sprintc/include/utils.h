#ifndef UTILS_H
#define UTILS_H
#define HASH_SET_SIZE 20
#define PERMISSIONS 0777
#include <semaphore.h>
#include "hashSet.h"

int isInteger(char *str);
// Utils functions
// Semaphore
sem_t *createSemaphore(char *name, unsigned value);
void removeSemaphore(char *name);
// Shared Memory
HashSet *createSharedMemory(char *name, int *fd);
void removeSharedMemory(char *name);

void createPipe(int *fd);
int createChildProcess();

// Malloc
void createMalloc(void **ptr, size_t size);
void *createRealloc(void *ptr, size_t size);

// Error Messages
void errorMessages(char *message);

// File/Directory
int isFileOrDirectory(char *path);
void create_directory(const char *dir);
void delete_directory(const char *dir);

#endif // UTILS_H
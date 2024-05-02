#ifndef UTILS_H
#define UTILS_H
#define HASH_SET_SIZE 20  
#include <ctype.h>

int isInteger(char* str);
// Utils functions
void createPipe(int*fd);
int createChildProcess();
void createMalloc(void** ptr, size_t size);
void* createRealloc(void* ptr, size_t size);

int isFileOrDirectory(char *path);
void errorMessages(char *message);

#endif // UTILS_H
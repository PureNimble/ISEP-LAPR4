#ifndef UTILS_H
#define UTILS_H
#define HASH_SET_SIZE 20  
#include <ctype.h>

int isInteger(char* str);
// Utils functions
void createPipe(int*fd);
int createChildProcess();
void waitChildProcess();
void stdOutToPipe(int* fd);
void createMalloc(void* ptr);
void* createRealloc(void* ptr, size_t size);

void printFilesRecursively(char *basePath, FILE *file);


#endif // UTILS_H
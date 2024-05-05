#ifndef UTILS_H
#define UTILS_H
#define HASH_SET_SIZE 20
#define PERMISSIONS 0777
#include <ctype.h>

int isInteger(char *str);
// Utils functions
void createPipe(int *fd);
int createChildProcess();
void createMalloc(void **ptr, size_t size);
void *createRealloc(void *ptr, size_t size);

int isFileOrDirectory(char *path);
void errorMessages(char *message);

void create_directory(const char *dir);
void delete_directory(const char *dir);

#endif // UTILS_H
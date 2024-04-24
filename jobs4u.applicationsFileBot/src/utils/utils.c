// standard libraries
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
// process libraries
#include <sys/wait.h>
#include <sys/stat.h>
#include <string.h>
#include "utils.h"
#include "hashSet.h"
#include "config.h"
#include <stdbool.h>
/**
 * Creates a pipe using the pipe system call.
 * 
 * @param fd An integer array to store the file descriptors of the pipe.
 */
void createPipe(int *fd)
{
    if (pipe(fd) == -1)
    {
        perror("Pipe failed.");
        exit(EXIT_FAILURE);
    }
}

/**
 * Creates a child process using the fork system call.
 * 
 * @return The process ID of the child process.
 */
pid_t createChildProcess()
{
    pid_t pid;
    pid = fork();
    if (pid == -1)
    {
        perror("fork");
        kill(0, SIGTERM);
    }
    return pid;
}

/**
 * Allocates memory using the malloc function.
 * 
 * @param array A pointer to the memory block to be allocated.
 */
void createMalloc(void *array)
{
    array = malloc(0);
    if (array == NULL)
    {
        printf("Memory allocation failed\n");
        exit(EXIT_FAILURE);
    }
}

/**
 * Reallocates memory using the realloc function.
 * 
 * @param array A pointer to the memory block to be reallocated.
 * @param size The new size of the memory block.
 * @return A pointer to the reallocated memory block.
 */
void *createRealloc(void *array, size_t size)
{
    void *newArray = realloc(array, size);
    if (newArray == NULL)
    {
        printf("Memory allocation failed\n");
        return NULL;
    }
    return newArray;
}

/**
 * Checks if a given path is a file or a directory.
 * 
 * @param path The path to be checked.
 * @return 1 if the path is a file, 2 if the path is a directory, 0 otherwise.
 */
int isFileOrDirectory(char *path)
{
    struct stat path_stat;
    stat(path, &path_stat);
    if (S_ISREG(path_stat.st_mode))
    {
        return 1; // file
    }
    else if (S_ISDIR(path_stat.st_mode))
    {
        return 2; // directory
    }
    return 0; // not a file or directory
}

/**
 * Checks if a given string represents an integer.
 * 
 * @param str The string to be checked.
 * @return 1 if the string represents an integer, 0 otherwise.
 */
int isInteger(char* str)
{
    if (*str == '-' || *str == '+') {
        ++str;
    }

    while (*str) {
        if (!isdigit(*str)) {
            return 0;
        }
        ++str;
    }

    return 1;
}

/**
 * Prints an error message to the standard error stream.
 * 
 * @param message The error message to be printed.
 */
void errorMessages(char *message)
{
    fprintf(stderr, "[ERROR] An error occurred: %s\n", message);
}

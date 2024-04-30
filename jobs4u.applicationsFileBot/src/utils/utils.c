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
        exit(EXIT_FAILURE);
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


/**
 * @brief Create a malloc string.
 * 
 * @param str The string to be created.
 * @param value The value to be assigned to the string.
 */
void createMallocString(char** str, char* value) {
    *str = malloc(strlen(value) + 1);
    if (*str == NULL) {
        errorMessages("Failed to allocate memory for the string\n");
        return;
    }
    strcpy(*str, value);
}


/**
 * @brief Read the first line of a file.
 * 
 * @param file_path The path to the file.
 * @return char* The first line of the file, or NULL if an error occurred.
 */
char* readFirstLine(char* file_path, int candidateID) {
    FILE* file = fopen(file_path, "r"); // Open the file for reading
    char buffer[300];
    if (file == NULL) {
        sprintf(buffer,"Failed to open file at %s\n", file_path);
        errorMessages(buffer);
        return NULL;
    }

    char* line = malloc(256 * sizeof(char)); // Allocate memory for the line
    if (line == NULL) {
        errorMessages("Failed to allocate memory for the line\n");
        fclose(file);
        return NULL;
    }

    if (fgets(line, 256, file) == NULL) { // Read the first line
        sprintf(buffer,"Failed to read the job Opening ID from Candidate:%d\n",candidateID);
        errorMessages(buffer);
        free(line);
        line = NULL;
    }

    fclose(file); // Close the file
    return line;
}
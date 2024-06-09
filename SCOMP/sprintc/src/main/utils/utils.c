#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <sys/mman.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <errno.h>
#include <ctype.h>
#include <semaphore.h>
#include "utils.h"
#include "circularBuffer.h"

/**
 * Creates a semaphore with the specified name and initial value.
 *
 * @param name The name of the semaphore.
 * @param value The initial value of the semaphore.
 * @return A pointer to the created semaphore, or exits the program with a status of 4 if semaphore creation fails.
 */
sem_t *createSemaphore(char *name, unsigned value)
{
    sem_t *sem;
    if ((sem = sem_open(name, O_CREAT, 0644, value)) == SEM_FAILED)
    {
        perror("sem_open");
        exit(4);
    }
    return sem;
}

/**
 * Removes a named semaphore.
 *
 * @param name The name of the semaphore to be removed.
 */
void removeSemaphore(char *name)
{
    if (sem_unlink(name) == -1)
    {
        perror("sem_unlink");
        exit(5);
    }
}

/**
 * Creates a shared memory segment and returns a pointer to it.
 *
 * @param name The name of the shared memory segment.
 * @param fd A pointer to an integer that will hold the file descriptor of the shared memory segment.
 * @param config A pointer to a Config struct containing configuration information.
 * @return A pointer to the CircularBuffer struct representing the shared memory segment, or exits the program with a status of 1, 2, or 3 if shared memory creation fails.
 */
CircularBuffer *createSharedMemory(char *name, int *fd, Config *config)
{
    CircularBuffer *shm;

    if ((*fd = shm_open(name, O_CREAT | O_RDWR, 0644)) == -1)
    {
        perror("shm_open");
        exit(1);
    }

    // Truncate the shared memory to the size of the struct
    if (ftruncate(*fd, sizeof(CircularBuffer)) == -1)
    {
        perror("ftruncate");
        exit(2);
    }
    // Map the shared memory to the address space of the process
    if ((shm = mmap(NULL, sizeof(CircularBuffer), PROT_READ | PROT_WRITE, MAP_SHARED, *fd, 0)) == MAP_FAILED)
    {
        perror("mmap");
        exit(3);
    }
    initBuffer(shm, config);
    return shm;
}

/**
 * Removes the shared memory with the given name.
 *
 * @param name The name of the shared memory to remove.
 */
void removeSharedMemory(char *name)
{
    if (shm_unlink(name) == -1)
    {
        perror("shm_unlink");
        exit(5);
    }
}

/**
 * Closes the shared memory and file descriptor.
 *
 * @param fd The file descriptor to close.
 * @param shm Pointer to the shared memory region.
 */
void close_shared_memory(int fd, CircularBuffer *shm)
{
    if (munmap(shm, sizeof(CircularBuffer)) < 0)
    {
        perror("munmap");
        exit(4);
    }
    if (close(fd) < 0)
    {
        perror("close");
        exit(6);
    }
}

/**
 * Creates a child process using the fork system call.
 *
 * @return The process ID (PID) of the child process.
 */
pid_t createChildProcess()
{
    pid_t pid;
    pid = fork();
    if (pid == 0)
        setpgid(0, 0);

    if (pid == -1)
    {
        errorMessages("Fork failed.");
        exit(EXIT_FAILURE);
    }
    return pid;
}

/**
 * Creates a pipe using the pipe system call.
 *
 * @param fd An integer array to store the file descriptors of the pipe.
 */
void createPipe(int *fd)
{
    if (pipe(fd) == -1)
    {
        perror("pipe");
        exit(1);
    }
}

/**
 * Allocates memory for an array of a given size using malloc.
 *
 * @param array Pointer to the array pointer that will store the allocated memory.
 * @param size  The size of the array to be allocated.
 *
 * @note This function will exit the program with failure if memory allocation fails.
 */
void createMalloc(void **array, size_t size)
{
    *array = malloc(size);
    if (*array == NULL)
    {
        errorMessages("Memory allocation failed\n");
        exit(EXIT_FAILURE);
    }
}

/**
 * Reallocates memory for an array with the specified size.
 *
 * @param array The pointer to the array to be reallocated.
 * @param size The new size of the array.
 * @return The pointer to the newly reallocated array, or NULL if memory allocation failed.
 */
void *createRealloc(void *array, size_t size)
{
    void *newArray = realloc(array, size);
    if (newArray == NULL)
    {
        errorMessages("Memory allocation failed\n");
        return NULL;
    }
    return newArray;
}

/**
 * @brief Creates a dynamically allocated string and assigns it to the given pointer.
 *
 * This function allocates memory for a string with the same length as the given value,
 * plus one additional byte for the null terminator. It then copies the value into the
 * allocated memory and assigns the pointer to the newly created string.
 *
 * @param str Pointer to a pointer that will store the newly created string.
 * @param value The string value to be copied.
 */
void createMallocString(char **str, char *value)
{
    *str = malloc(strlen(value) + 1);
    if (*str == NULL)
    {
        errorMessages("Failed to allocate memory for the string\n");
        return;
    }
    strcpy(*str, value);
}

/**
 * Checks if a given string represents an integer.
 *
 * @param str The string to be checked.
 * @return 1 if the string represents an integer, 0 otherwise.
 */
int isInteger(char *str)
{
    if (*str == '-' || *str == '+')
    {
        ++str;
    }

    while (*str)
    {
        if (!isdigit(*str))
        {
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
 * Checks whether the given path is a file or a directory.
 *
 * @param path The path to check.
 * @return 1 if the path is a file, 2 if it is a directory, 0 if it is neither.
 */
int isFileOrDirectory(char *path)
{
    struct stat path_stat;
    stat(path, &path_stat);
    if (S_ISREG(path_stat.st_mode))
    {
        return 1;
    }
    else if (S_ISDIR(path_stat.st_mode))
    {
        return 2;
    }
    return 0;
}

/**
 * Reads the first line of a file and returns it as a dynamically allocated string.
 *
 * @param file_path The path of the file to read.
 * @param candidateID The ID of the candidate.
 * @return A pointer to the first line of the file, or NULL if the file cannot be opened or the first line is empty.
 */
char *readFirstLine(char *file_path, int candidateID)
{
    FILE *file = fopen(file_path, "r"); // Open the file for reading
    char buffer[300];
    if (file == NULL)
    {
        sprintf(buffer, "Failed to open file at %s\n", file_path);
        errorMessages(buffer);
        return NULL;
    }

    char *line;
    createMalloc((void **)&line, 256 * sizeof(char));

    if (fgets(line, 256, file) == NULL)
    { // Read the first line
        free(line);
        line = NULL;
    }

    fclose(file); // Close the file
    return line;
}

/**
 * Creates a directory with the specified name.
 *
 * @param dir The name of the directory to create.
 */
void create_directory(const char *dir)
{
    if ((mkdir(dir, PERMISSIONS) == -1) && (errno != EEXIST))
    {
        errorMessages("Failed to create directory.\n");
        exit(EXIT_FAILURE);
    }
}

/**
 * Deletes a directory and all its contents.
 *
 * @param dir The path of the directory to be deleted.
 */
void delete_directory(const char *dir)
{
    char command[1024];
    snprintf(command, sizeof(command), "rm -r %s", dir);
    if (system(command) != 0)
    {
        errorMessages("Failed to delete directory.\n");
        exit(EXIT_FAILURE);
    }
}

/**
 * Prints the information of a CandidateInfo struct.
 *
 * @param file The CandidateInfo struct to print.
 */
void printFiles(CandidateInfo file)
{
    printf("Candidate ID: %d\n", file.candidateID);
    printf("Job Offer Directory: %s\n", file.jobOffer_dir);
    printf("Number of files: %d\n", file.numFiles);
    printf("Is Done: %d\n", file.isDone);
    printf("Index: %d\n", file.index);
    for (int i = 0; i < file.numFiles; i++)
    {
        printf("File %d: %s\n", i + 1, file.files[i]);
    }
}

/**
 * Creates a CandidateInfo object with the given candidate ID.
 *
 * @param candidateID The ID of the candidate.
 * @return The created CandidateInfo object.
 */
CandidateInfo createFiles(int candidateID)
{
    CandidateInfo file;
    file.candidateID = candidateID;
    return file;
}

/**
 * Replaces all occurrences of a substring in a given string with another substring.
 *
 * @param str The string in which the replacement will be performed.
 * @param find The substring to be replaced.
 * @param replace The substring to replace the occurrences of `find`.
 */
void replaceChar(char *str, char *find, char *replace)
{
    char *pos = str;
    while ((pos = strstr(pos, find)) != NULL)
    {
        memmove(pos + strlen(replace), pos + strlen(find), strlen(pos + strlen(find)) + 1);
        memcpy(pos, replace, strlen(replace));
        pos += strlen(replace);
    }
}
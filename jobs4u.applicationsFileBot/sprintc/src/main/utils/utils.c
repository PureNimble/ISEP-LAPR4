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
 * Creates a semaphore with the given name and initial value.
 *
 * @param name The name of the semaphore.
 * @param value The initial value of the semaphore.
 * @return A pointer to the created semaphore.
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
 * Creates a shared memory region and returns a pointer to it.
 *
 * @param name The name of the shared memory region.
 * @param fd A pointer to an integer that will hold the file descriptor of the shared memory region.
 * @return A pointer to the created shared memory region.
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
 * Removes a named semaphore.
 *
 * @param name The name of the semaphore to remove.
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
 * @param shm The shared memory to unmap.
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
 * @return The process ID of the child process.
 */
pid_t createChildProcess()
{
    pid_t pid;
    pid = fork();
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
 * @return None.
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
 * Allocates memory using the malloc function.
 *
 * @param array A pointer to the memory block to be allocated.
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
        errorMessages("Memory allocation failed\n");
        return NULL;
    }
    return newArray;
}
/**
 * @brief Create a malloc string.
 *
 * @param str The string to be created.
 * @param value The value to be assigned to the string.
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
 * @brief Read the first line of a file.
 *
 * @param file_path The path to the file.
 * @return char* The first line of the file, or NULL if an error occurred.
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
 * Deletes a directory with the specified name.
 *
 * @param dir The name of the directory to delete.
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
 * Prints the details of a CandidateInfo object.
 *
 * This function prints the candidate ID, job offer directory, and the list of files
 * associated with the CandidateInfo object.
 *
 * @param file The CandidateInfo object to be printed.
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
 * Creates a CandidateInfo struct with the given candidate ID and initializes its fields.
 *
 * @param candidateID The ID of the candidate.
 * @return The created CandidateInfo struct.
 */
CandidateInfo createFiles(int candidateID)
{
    CandidateInfo file;
    file.candidateID = candidateID;
    return file;
}

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
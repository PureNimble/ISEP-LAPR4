#include <stddef.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <dirent.h>
#include <unistd.h>
#include "hashSet.h"
#include "config.h"
#include "utils.h"
/**
 * @brief Lists the IDs of the candidates found in the specified directory.
 *
 * This function opens the specified directory and reads the names of the files in it.
 * It extracts the candidate IDs from the file names and adds them to a hash set.
 * Finally, it writes the candidate IDs to a file descriptor and returns the number of candidate IDs found.
 *
 * @param fd The file descriptor to write the candidate IDs to.
 * @param config The configuration settings for the application.
 * @return The number of candidate IDs found.
 */
void listCandidatesID(Config *config, HashSet *sharedData, sem_t *sem_barrier_mutex, int fd)
{
    DIR *d;
    struct dirent *dir;
    d = opendir(config->inputPath);
    int *files = NULL;

    HashSet *set = createHashSet();
    if (d == NULL)
    {
        errorMessages("Error opening directory\n");
        exit(EXIT_FAILURE);
    }
    createMalloc((void **)&files, 0);

    while ((dir = readdir(d)) != NULL)
    {
        if (strcmp(dir->d_name, ".") == 0 || strcmp(dir->d_name, "..") == 0)
            continue;
        char buffer[100];
        strcpy(buffer, dir->d_name);

        char *token = strtok(buffer, "-");
        if (token != NULL && isInteger(token))
        {
            add(set, atoi(token));
        }
    }
    closedir(d);
    free(files);

    int size = getArray(set, &files);

    printf("Number of candidates: %d\n", size);
    for (int i = 0; i < size; i++)
    {
        printf("Candidate ID: %d\n", files[i]);
    }

    pause();
}
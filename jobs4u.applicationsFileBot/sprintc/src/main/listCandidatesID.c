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
void listCandidatesID(Config *config, CircularBuffer *sharedData, sem_t *sem_shared_memory)
{
    struct dirent *dir;
    DIR *d = opendir(config->inputPath);
    if (d == NULL)
    {
        errorMessages("Error opening directory\n");
        exit(EXIT_FAILURE);
    }
    HashSet *set = createHashSet();

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
    int array[20];
    int size = getArray(set, array);
    freeHashSet(set);

    sharedData->barrierCounter = size;
    printf("Number of candidates: %d\n", size);
    for (int i = 0; i < size; i++)
    {
        CandidateInfo file = createFiles(array[i]);
        addToBuffer(sharedData, file);
    }
    sem_post(sem_shared_memory);
}
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
 * Lists the IDs of the candidates found in the specified directory.
 *
 * @param config The configuration settings.
 * @param sharedMemory The shared memory buffer.
 * @return A HashSet containing the IDs of the candidates.
 */
HashSet *listCandidatesID(Config *config, CircularBuffer *sharedMemory)
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
    return set;
}
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
 * @file listCandidatesID.c
 * @brief This file contains the function to list the IDs of the candidates found in a specified directory.
 */

/**
 * @brief Lists the IDs of the candidates found in the specified directory.
 *
 * This function opens the directory specified in the configuration settings, reads each file in the directory,
 * extracts the candidate ID from the file name, and adds the ID to a hash set. The function ignores files
 * whose names do not start with an integer (the candidate ID).
 *
 * @param config The configuration settings, which include the path of the directory.
 * @param sharedMemory The shared memory buffer. This parameter is not used in the function.
 * @return A pointer to a HashSet containing the IDs of the candidates. The caller is responsible for freeing this memory.
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
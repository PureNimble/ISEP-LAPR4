#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <stdlib.h>
#include <signal.h>
#include "info.h"
#include "utils.h"
#include <sys/types.h>
#include <dirent.h>
#include <ctype.h>
#include <time.h>
#include <dirent.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <unistd.h>

/**
 * @brief Generates a report file containing the names of all files in a given directory.
 * The report file is named with a timestamp and saved in the specified output path.
 *
 * @param config A pointer to the Config struct containing the configuration settings.
 */
void reportFile(Config *config, CircularBuffer *shared_memory)
{
    CandidateInfo *files = NULL;
    int numberOfCandidates = 0;
    while (!isEmpty(shared_memory))
    {
        CandidateInfo file = readFromBuffer(shared_memory);
        files = createRealloc(files, (numberOfCandidates + 1) * sizeof(CandidateInfo));
        files[numberOfCandidates] = file;
        numberOfCandidates++;
    }

    char buffer[3000];
    sprintf(buffer, "%sreport.txt", config->outputPath);

    files = checkIfCandidateFilesExist(files, &numberOfCandidates, buffer);

    FILE *file = fopen(buffer, "a");
    if (file == NULL)
    {
        errorMessages("Failed to create file.\n");
        exit(EXIT_FAILURE);
    }
    for (int i = 0; i < numberOfCandidates; i++)
    {
        if (files[i].numFiles == 0)
            continue;

        fprintf(file, "Candidate ID: %d\n", files[i].candidateID);
        fprintf(file, "Job Offer: %s\n", files[i].jobOffer_dir);
        fprintf(file, "\tFiles:\n");
        for (int j = 0; j < files[i].numFiles; j++)
        {
            fprintf(file, "\t\t%s\n", files[i].files[j]);
        }
        fprintf(file, "\n");
    }
    fclose(file);
    free(files);
    printf("-> Report file has been generated\n\n");
}

CandidateInfo *checkIfCandidateFilesExist(CandidateInfo *files, int *numberOfCandidates, char *buffer)
{
    FILE *file = fopen(buffer, "r");
    if (file == NULL)
    {
        CandidateInfo *newFiles = malloc(*numberOfCandidates * sizeof(CandidateInfo));
        memcpy(newFiles, files, *numberOfCandidates * sizeof(CandidateInfo));
        free(files);
        return newFiles;
    }

    int validIndex = 0;
    int id;
    char jobOffer[256];
    CandidateInfo *newFiles = malloc(*numberOfCandidates * sizeof(CandidateInfo));

    for (int i = 0; i < *numberOfCandidates; i++)
    {
        rewind(file); // Go back to the start of the file for each candidate
        int found = 0;
        while (fscanf(file, "Candidate ID: %d\nJob Offer: %s\n", &id, jobOffer) == 2)
        {
            if (files[i].candidateID == id && strcmp(files[i].jobOffer_dir, jobOffer) == 0)
            {
                found = 1;
                break;
            }
        }

        if (found) // If no match was found in the file
        {
            newFiles[validIndex++] = files[i];
        }
    }
    fclose(file);

    free(files);                                                      // Free the old files array
    newFiles = realloc(newFiles, validIndex * sizeof(CandidateInfo)); // Resize the newFiles array
    *numberOfCandidates = validIndex;

    return newFiles;
}
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
int checkIfCandidateFilesExist(Files *files, int numberOfCandidates, char *buffer);
void reportFile(Config *config, CircularBuffer *sharedMemory)
{
    int numberOfCandidates = 0;
    Files *files = NULL; // Initialize files to NULL
    while (!isEmpty(sharedMemory))
    {
        files = createRealloc(files, sizeof(Files) * (numberOfCandidates + 1));
        files[numberOfCandidates] = readFromBuffer(sharedMemory);
        numberOfCandidates++;
    }

    char buffer[300];
    sprintf(buffer, "%sreport.txt", config->outputPath);

    int temp;
    if ((temp = checkIfCandidateFilesExist(files, numberOfCandidates, buffer)) != -1)
        numberOfCandidates = temp;

    FILE *reportFile = fopen(buffer, "a");
    if (reportFile == NULL)
    {
        errorMessages("Failed to create file.\n");
        exit(EXIT_FAILURE);
    }
    for (int i = 0; i < numberOfCandidates; i++)
    {
        if (files[i].numFiles == 0)
            continue;

        fprintf(reportFile, "Candidate ID: %d\n", files[i].candidateID);
        fprintf(reportFile, "Job Offer: %s\n", files[i].jobOffer_dir);
        fprintf(reportFile, "\tFiles:\n");
        for (int j = 0; j < files[i].numFiles; j++)
        {
            fprintf(reportFile, "\t\t%s\n", files[i].files[j]);
        }
        fprintf(reportFile, "\n");
    }
    fclose(reportFile);
    free(files);
    printf("-> Report file has been generated\n\n");
}

int checkIfCandidateFilesExist(Files *files, int numberOfCandidates, char *buffer)
{
    FILE *file = fopen(buffer, "r");
    if (file == NULL)
        return -1;
    int validIndex = 0;
    for (int i = 0; i < numberOfCandidates; i++)
    {
        if (fscanf(file, "Candidate ID: %d\nJob Offer: %s\n", &files[i].candidateID, files[i].jobOffer_dir) == 2)
        {
            if (i != validIndex)
            {
                files[validIndex] = files[i];
            }
            validIndex++;
        }
    }
    fclose(file);
    files = createRealloc(files, validIndex * sizeof(Files));
    return validIndex;
}

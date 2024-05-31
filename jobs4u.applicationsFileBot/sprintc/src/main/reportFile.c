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
void reportFile(Config *config, CircularBuffer *shared_memory, sem_t *sem_sharedMemory_mutex)
{
    sem_wait(sem_sharedMemory_mutex); // acess shared memory
    CandidateInfo candidateInfo = checkFinishedFiles(shared_memory);
    shared_memory->numberOfCandidates--;
    sem_post(sem_sharedMemory_mutex); // release shared memory

    if (candidateInfo.candidateID == -1)
    {
        return;
    }
    char buffer[3000];
    sprintf(buffer, "%sreport.txt", config->outputPath);

    if (checkIfCandidateFileExists(candidateInfo, buffer))
        return;

    FILE *file = fopen(buffer, "a");
    if (file == NULL)
    {
        errorMessages("Failed to create file.\n");
        exit(EXIT_FAILURE);
    }
    // Print Info
    fprintf(file, "Candidate ID: %d\n", candidateInfo.candidateID);
    fprintf(file, "Job Offer: %s\n", candidateInfo.jobOffer_dir);
    fprintf(file, "\tFiles:\n");
    for (int j = 0; j < candidateInfo.numFiles; j++)
    {
        fprintf(file, "\t\t%s\n", candidateInfo.files[j]);
    }
    fprintf(file, "\n");

    fclose(file);
    printf("-> Report file has been generated for candidate:%d\n\n", candidateInfo.candidateID);
}

int checkIfCandidateFileExists(CandidateInfo candidate, char *buffer)
{
    FILE *file = fopen(buffer, "r");
    if (file == NULL)
        return 0;

    int id;
    char line[500];

    while (fgets(line, sizeof(line), file) != NULL)
    {
        if (sscanf(line, "Candidate ID: %d", &id) == 1)
        {
            if (candidate.candidateID == id)
            {
                printf("-> Candidate id:%d already exists in the report file.\n", id);
                return 1;
            }
        }
    }

    fclose(file);
    return 0;
}
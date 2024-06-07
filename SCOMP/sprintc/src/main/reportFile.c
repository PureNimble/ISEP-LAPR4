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
 * Generates a report file for a candidate.
 *
 * This function generates a report file for a candidate based on the provided configuration,
 * shared memory, and candidate information. The report file contains details such as the
 * candidate ID, job offer directory, and a list of files associated with the candidate.
 *
 * @param config The configuration settings.
 * @param shared_memory The shared memory buffer.
 * @param sem_numberOfCandidates The semaphore for the number of candidates.
 * @param sem_files The semaphore for accessing shared memory.
 */
void reportFile(Config *config, CircularBuffer *shared_memory, sem_t *sem_numberOfCandidates, sem_t *sem_files)
{
    sem_wait(sem_files); // access shared memory
    CandidateInfo candidateInfo = checkFinishedFiles(shared_memory);
    sem_post(sem_files); // release shared memory
    sem_wait(sem_numberOfCandidates);
    shared_memory->numberOfCandidates--;
    sem_post(sem_numberOfCandidates);
    if (candidateInfo.candidateID == -1)
        return;

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
    printf("-> Report file has been generated for candidate:%d\n", candidateInfo.candidateID);
}

/**
 * Checks if a candidate file exists in the report file.
 *
 * @param candidate The candidate information.
 * @param buffer The file path of the report file.
 * @return Returns 1 if the candidate ID already exists in the report file, 0 otherwise.
 */
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
                printf("-> Candidate ID: %d already exists in the report file.\n", id);
                return 1;
            }
        }
    }

    fclose(file);
    return 0;
}
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
void reportFile(Config *config,Files * files ,int numberOfCandidates)
{
    //get timestamp
    time_t t = time(NULL);
    if (t == ((time_t)-1))
    {
        fprintf(stderr, "Failure to obtain the current time.\n");
        exit(EXIT_FAILURE);
    }
    char buffer[3000];
    sprintf(buffer, "%sreport_%d.txt", config->outputPath,(int) t);    
    FILE *file = fopen(buffer, "w");
    if (file == NULL)
    {
        fprintf(stderr, "Failed to create file.\n");
        exit(EXIT_FAILURE);
    }
    for (int i = 0; i < numberOfCandidates; i++)
    {
        if (files[i].numFiles == 0) continue;

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
}

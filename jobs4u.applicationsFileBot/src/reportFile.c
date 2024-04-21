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
 *
 * @brief Handle the signals
 */
void reportFile(Config *config)
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
    //write the name of the directory inside output path and all files inside
    printFilesRecursively(config->outputPath,file);
    fclose(file);
    
}

void printFilesRecursively(char *basePath, FILE *file)
{
    char path[1000];
    struct dirent *dp;
    DIR *dir = opendir(basePath);

    // Unable to open directory stream
    if (!dir)
        return;

    while ((dp = readdir(dir)) != NULL)
    {
        // first character is a integer
        
        if (strcmp(dp->d_name, ".") != 0 && strcmp(dp->d_name, "..") != 0 )
        {
            // Construct new path from our base path
            strcpy(path, basePath);
            strcat(path, "/");
            strcat(path, dp->d_name);

            struct stat pathStat;
            stat(path, &pathStat);
            if(isdigit(dp->d_name[0])){
                if (S_ISDIR(pathStat.st_mode))
                    fprintf(file, "Directory: %s\n", dp->d_name);
                else
                    fprintf(file, "    File: %s\n", dp->d_name);
            }
            printFilesRecursively(path,file);
        }
    }

    closedir(dir);
}
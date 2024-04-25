// standard libraries
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
// directory libraries
#include <dirent.h>
// signal libraries
#include <signal.h>
// info about this project
#include "info.h"
#include <sys/types.h>
#include <sys/wait.h>
#include "utils.h"

/**
 * @brief Copy all files from new Candidates to the output directory.
 * 
 * @param fd The file descriptor for the pipe.
 * @param config The configuration struct.
 */
void copyFiles(int* fd, Config* config)
{
    close(fd[1]); // close the write end of the pipe
    int candidateID;

    while (1)
    {
        read(fd[0], &candidateID, sizeof(candidateID));
        printf("Candidate ID: %d PID:%d\n", candidateID,getpid());

        pid_t pid;
        int status;
        char buffer[300];
        sprintf(buffer, "%s%d-candidate-data.txt",config->inputPath, candidateID);

        if(isFileOrDirectory(buffer)!= 1){
            sprintf(buffer, "Candidate ID: %d has an invalid format\n", candidateID);
            errorMessages(buffer);
        }
        else{
            char * job = readFirstLine(buffer, candidateID);
            if(job != NULL){
                job[strlen(job) - 1] = '\0';
                pid = createChildProcess();

                if (pid == 0){
                    // create new directory and copy the files  
                    sprintf(buffer, "%s%s/%d", config->outputPath, job, candidateID);
                    char command[1024];
                    snprintf(command, sizeof(command), "mkdir -p %s && /bin/cp -u %s%d-* %s", buffer, config->inputPath, candidateID, buffer);                
                    execlp("/bin/sh", "sh", "-c", command, NULL);
                    exit(EXIT_FAILURE);   
                }

                wait(&status);
                
                if(WIFEXITED(status)){
                    if(WEXITSTATUS(status) == EXIT_FAILURE){
                        errorMessages("Failed to copy files");
                    }
                }
                free(job);
            }
        }
        kill(getppid(), SIGRTMIN); // send signal to parent
    }
}

/**
 * @brief Read the first line of a file.
 * 
 * @param file_path The path to the file.
 * @return char* The first line of the file, or NULL if an error occurred.
 */
char* readFirstLine(char* file_path, int candidateID) {
    FILE* file = fopen(file_path, "r"); // Open the file for reading
    char buffer[300];
    if (file == NULL) {
        sprintf(buffer,"Failed to open file at %s\n", file_path);
        errorMessages(buffer);
        return NULL;
    }

    char* line = malloc(256 * sizeof(char)); // Allocate memory for the line
    if (line == NULL) {
        errorMessages("Failed to allocate memory for the line\n");
        fclose(file);
        return NULL;
    }

    if (fgets(line, 256, file) == NULL) { // Read the first line
        sprintf(buffer,"Failed to read the job Opening ID from Candidate:%d\n",candidateID);
        errorMessages(buffer);
        free(line);
        line = NULL;
    }

    fclose(file); // Close the file
    return line;
}

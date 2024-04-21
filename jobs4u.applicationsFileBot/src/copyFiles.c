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
#include "utils.h"
#include <sys/types.h>

/**
 * @brief Check if there are new files in the directory( send a signal to the
 *  parent process if there are new files)
 */
void copyFiles(int* fd, Config* config)
{
    close(fd[1]); // close the write end of the pipe
    int candidateID;

    while (1)
    {
        read(fd[0], &candidateID, sizeof(candidateID));
        //TODO: copy the file
        printf("Candidate ID: %d PID:%d\n", candidateID,getpid());
        pid_t pid;
        char buffer[300];
        sprintf(buffer, "%s%d-candidate-data.txt",config->inputPath, candidateID);
        char * job = read_first_line(buffer);
        job[strlen(job) - 1] = '\0';
        pid = createChildProcess();
        if (pid == 0){
            // create new directory and copy the files  
            sprintf(buffer, "%s%s/%d", config->outputPath, job, candidateID);
            char command[1024];
            snprintf(command, sizeof(command), "mkdir -p %s && /bin/cp %s%d* %s", buffer, config->inputPath, candidateID, buffer);                
            execlp("/bin/sh", "sh", "-c", command, NULL);
            exit(EXIT_FAILURE);   
        }
        kill(getppid(), SIGUSR2); // send signal to parent
    }
}





char* read_first_line(char* file_path) {
    FILE* file = fopen(file_path, "r"); // Open the file for reading
    if (file == NULL) {
        printf("Failed to open file at %s\n", file_path);
        return NULL;
    }

    char* line = malloc(256 * sizeof(char)); // Allocate memory for the line
    if (line == NULL) {
        printf("Failed to allocate memory for the line\n");
        fclose(file);
        return NULL;
    }

    if (fgets(line, 256, file) == NULL) { // Read the first line
        printf("Failed to read the first line from %s\n", file_path);
        free(line);
        line = NULL;
    }

    fclose(file); // Close the file
    return line;
}

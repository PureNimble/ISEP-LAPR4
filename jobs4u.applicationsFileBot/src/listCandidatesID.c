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
#include "hashSet.h"
#include <sys/types.h>

int listCandidatesID(int* fd, Config* config) {
    DIR* d;
    struct dirent* dir;
    d = opendir(config->inputPath);
    int* files = NULL;
    if (d == NULL) {
        printf("Error opening directory\n");
        exit(EXIT_FAILURE);
    }
    createMalloc(files);

    HashSet* set = createHashSet();

    //create a Set
    while ((dir = readdir(d)) != NULL)
    {
        if (strcmp(dir->d_name, ".") == 0 || strcmp(dir->d_name, "..") == 0) continue;
        char buffer[100];
        strcpy(buffer, dir->d_name);  // Copy the file name into the buffer

        char* token = strtok(buffer, "-");
        if (token != NULL && isInteger(token))
        {
            add(set, atoi(token));
        }
    }
    closedir(d);
    free(files);
    int array[20];
    
    int b = getArray(set,array);
    for(int i = 0; i < b; i++){
        int n = array[i];
        write(fd[1], &n, sizeof(int));
    }

    return b;

}
#ifndef INFO_H
#define INFO_H
#define MAX_CHILDREN 100
#define MAX_FILES 20
#include "config.h"

typedef struct Files
{
    char jobOffer_dir[100];
    int candidateID;
    int numFiles;
    char files[MAX_FILES][100];

} Files;
// Singal setup (setupSignal.c)
void handle_signal(int signal);
void setUpSignal();

// Child Code (newFileChecker.c)
void newFileChecker(Config *config);

// Parent Code (listCandidatesID.c and reportFile.c)
int listCandidatesID(int *fd, Config *config);
void reportFile(Config *config, Files *files, int numberOfCandidates);

// Children Code (copyFiles.c)
void copyFiles(int *send_work_fd, int *recive_work_fd, Config *config);
char *readFirstLine(char *file_path, int candidateID);

#endif // INFO_H
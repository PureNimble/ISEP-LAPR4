#ifndef INFO_H
#define INFO_H
#define MAX_CHILDREN 100
#define MAX_FILES 20
#include "config.h"
#include "utils.h"
#include <semaphore.h>

#define SHARED_MEMORY "/shared_memory"
#define SEM_NEW_FILE_CHECKER "/sem_new_file_checker"
#define SEM_BARRIER "/sem_barrier"
#define SEM_BARRIER_MUTEX "/sem_barrier_mutex"

typedef struct Files
{
    char jobOffer_dir[100];
    int candidateID;
    int numFiles;
    char files[MAX_FILES][100];

} Files;

// main.c

// Singal setup (setupSignal.c)
void handle_signal(int signal);
void setUpSignal();

// Child Code (newFileChecker.c)
void newFileChecker(Config *config, sem_t *sem);

// Parent Code (listCandidatesID.c and reportFile.c)
void listCandidatesID(Config *config, HashSet *sharedData, sem_t *sem_barrier_mutex);
void reportFile(Config *config, Files *files, int numberOfCandidates);
void createWorkers(Config *config, HashSet *shared_data, sem_t *sem_barrier, sem_t *sem_barrier_mutex);

// Children Code (copyFiles.c)
void copyFiles(Config *config, HashSet *shared_data, sem_t *sem_barrier, sem_t *sem_barrier_mutex);
char *readFirstLine(char *file_path, int candidateID);

#endif // INFO_H
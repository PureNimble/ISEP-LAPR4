#ifndef INFO_H
#define INFO_H
#define MAX_CHILDREN 100
#include "config.h"
// Singal counter
extern volatile sig_atomic_t received_signals;

// Singal setup (setupSignal.c)
void handle_signal(int signal);
void setUpSignal();

// Child Code (newFileChecker.c)
void newFileChecker(Config *config);

// Parent Code (listCandidatesID.c and reportFile.c)
int listCandidatesID(int *fd, Config *config);
void reportFile(Config *config);
char* read_first_line(char* file_path);

// Children Code (copyFiles.c)
void copyFiles(int* fd, Config* config);


#endif // INFO_H
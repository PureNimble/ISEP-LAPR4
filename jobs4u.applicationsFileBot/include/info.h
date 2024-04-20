#ifndef INFO_H
#define INPUT_PATH "./resources/input/"
#define OUTPUT_PATH "./resources/output/"
#define NUMBER_OF_CHILDREN 5
#define VERIFY_NEW_FILES_FREQUENCY 5
#define MAX_CHILDREN 100
#include <stdbool.h>

void handle_signal(int signal);
void newFileChecker();
void setUpSignal();
int listCandidatesID();
bool isInteger(char* str);
void copyFiles(int* fd);
void reportFile();
extern volatile sig_atomic_t received_signals;

char* read_first_line(char* file_path);


#endif // INFO_H
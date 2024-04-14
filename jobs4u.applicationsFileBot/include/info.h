#ifndef INFO_H
#define INFO_H
#define INPUT_PATH "./resources/input/"
#define OUTPUT_PATH "./resources/output/"
#define NUMBER_OF_CHILDREN 5
#define VERIFY_NEW_FILES_FREQUENCY 5
#define MAX_CHILDREN 100

void handle_signal(int signal);
void newFileChecker(unsigned int lastFileTime, int *father_fd);
void setUpSignal();

#endif // INFO_H
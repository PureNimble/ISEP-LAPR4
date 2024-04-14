#ifndef UTILS_H
#define UTILS_H

void createPipe(int *fd);
int createChildProcess();
void waitChildProcess();
void stdOutToPipe(int *fd);

#endif // UTILS_H
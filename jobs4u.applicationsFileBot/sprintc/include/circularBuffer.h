#ifndef CIRCULAR_BUFFER_H
#define CIRCULAR_BUFFER_H
#define BUFFER_SIZE 20
#include "candidateInfo.h"
#include "config.h"
#include <semaphore.h>
typedef struct
{
    CandidateInfo buffer[BUFFER_SIZE];
    unsigned int head;
    unsigned int tail;
    unsigned int size;

} CircularBuffer;

void initBuffer(CircularBuffer *buf, Config *config);
int addToBuffer(CircularBuffer *buf, int candidateID);
CandidateInfo readFromBuffer(CircularBuffer *buf);
void printBuffer(CircularBuffer *buf);
void addInfo(CircularBuffer *candidates, CandidateInfo data);
CandidateInfo checkFinishedFiles(CircularBuffer *candidates);
void removeFromBuffer(CircularBuffer *candidates, int index);
#endif // CIRCULAR_BUFFER_H
#ifndef CIRCULAR_BUFFER_H
#define CIRCULAR_BUFFER_H
#define BUFFER_SIZE 10
#include "candidateInfo.h"
typedef struct
{
    CandidateInfo buffer[BUFFER_SIZE];
    int head;
    int tail;
    int count;
    int count2;
    int barrierCounter;
} CircularBuffer;

void initBuffer(CircularBuffer *buf);
void addToBuffer(CircularBuffer *buf, CandidateInfo data);
void addToBuffer2(CircularBuffer *buf, CandidateInfo data);
CandidateInfo readFromBuffer(CircularBuffer *buf);
int isEmpty(CircularBuffer *buf);
void printBuffer(CircularBuffer *buf);

#endif // CIRCULAR_BUFFER_H
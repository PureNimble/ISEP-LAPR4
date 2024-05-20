#ifndef CIRCULAR_BUFFER_H
#define CIRCULAR_BUFFER_H
#define BUFFER_SIZE 10
#include "candidateInfo.h"
typedef struct
{
    Files buffer[BUFFER_SIZE];
    int head;
    int tail;
    int count;
    int barrierCounter;
} CircularBuffer;

void initBuffer(CircularBuffer *buf);
void addToBuffer(CircularBuffer *buf, Files data);
Files readFromBuffer(CircularBuffer *buf);
int isEmpty(CircularBuffer *buf);

#endif // CIRCULAR_BUFFER_H
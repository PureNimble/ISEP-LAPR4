#include <stdio.h>
#include "circularBuffer.h"

// Initialize buffer
void initBuffer(CircularBuffer *buf)
{
    buf->head = 0;
    buf->tail = 0;
    buf->count = 0;

    for (int i = 0; i < BUFFER_SIZE; i++)
    {
        CandidateInfo file;
        file.candidateID = -1;
        file.jobOffer_dir[0] = '\0';
        file.numFiles = 0;
        buf->buffer[i] = file;
    }
}

// Add to buffer
void addToBuffer(CircularBuffer *buf, CandidateInfo data)
{
    buf->buffer[buf->head] = data;
    buf->head = (buf->head + 1) % BUFFER_SIZE;
    if (buf->count == BUFFER_SIZE)
        buf->tail = (buf->tail + 1) % BUFFER_SIZE;
    else
        ++buf->count;
}

// Remove from buffer
CandidateInfo readFromBuffer(CircularBuffer *buf)
{
    CandidateInfo item = buf->buffer[buf->tail];
    buf->tail = (buf->tail + 1) % BUFFER_SIZE;
    --buf->count;
    return item;
}

int isEmpty(CircularBuffer *buf)
{
    return buf->count == 0;
}

void printBuffer(CircularBuffer *buf)
{
    printf("Buffer: ");
    for (int i = 0; i < BUFFER_SIZE; i++)
    {
        printf("%d ", buf->buffer[i].candidateID);
    }
    printf("\n");
}
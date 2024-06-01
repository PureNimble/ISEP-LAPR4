#include <stdio.h>
#include "circularBuffer.h"

// Initialize buffer
void initBuffer(CircularBuffer *buf, Config *config)
{
    buf->head = 0;
    buf->tail = 0;
    buf->size = config->bufferSize;
    for (int i = 0; i < buf->size; i++)
    {
        CandidateInfo file;
        file.index = i;
        file.candidateID = -1;
        file.jobOffer_dir[0] = '\0';
        file.isDone = 0;
        file.numFiles = 0;
        buf->buffer[i] = file;
    }
}

// Add to buffer
int addToBuffer(CircularBuffer *buf, int candidateID)
{
    if (isFull(buf) || buf->buffer[buf->head].isDone)
    {
        printf("Buffer is full.\n");
        return 1;
    }
    buf->buffer[buf->head].candidateID = candidateID;
    buf->head = (buf->head + 1) % buf->size;
    return 0;
}

CandidateInfo readFromBuffer(CircularBuffer *buf)
{
    if (isEmpty(buf))
    {
        printf("Buffer is empty.\n");
        CandidateInfo empty;
        empty.candidateID = -1;
        return empty;
    }

    CandidateInfo item = buf->buffer[buf->tail];
    buf->tail = (buf->tail + 1) % buf->size;
    return item;
}

int isFull(CircularBuffer *buf)
{
    return (buf->head + 1) % buf->size == buf->tail;
}

int isEmpty(CircularBuffer *buf)
{
    return buf->head == buf->tail;
}

void printBuffer(CircularBuffer *buf)
{
    printf("Buffer: ");
    for (int i = 0; i < buf->size; i++)
    {
        printf("%d,", buf->buffer[i].candidateID);
        printf("%d\n ", buf->buffer[i].index);
    }
    printf("\n");
}

CandidateInfo checkFinishedFiles(CircularBuffer *buf)
{
    for (int i = 0; i < buf->size; i++)
    {
        if (buf->buffer[i].isDone)
        {
            buf->buffer[i].isDone = 0;
            return buf->buffer[i];
        }
    }
    CandidateInfo empty;
    empty.candidateID = -1;
    return empty;
}
void addInfo(CircularBuffer *candidates, CandidateInfo data)
{
    candidates->buffer[data.index] = data;
}
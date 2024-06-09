#include <stdio.h>
#include "circularBuffer.h"
#include <string.h>

/**
 * Initializes the circular buffer with the given configuration.
 *
 * @param buf The circular buffer to initialize.
 * @param config The configuration containing the buffer size.
 */
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
        file.isDone = 2;
        file.numFiles = 0;
        buf->buffer[i] = file;
    }
}
/**
 * Adds a candidate ID to the circular buffer.
 *
 * @param buf The circular buffer to add the candidate ID to.
 * @param candidateID The ID of the candidate to add.
 * @param sem_isDone_mutex The mutex for the isDone variable.
 * @param sem_addToBuffer_mutex The mutex for the buffer.
 * @return 0 if the candidate ID was successfully added, 1 if the buffer is full or the previous candidate is not done.
 */
int addToBuffer(CircularBuffer *buf, int candidateID)
{
    buf->buffer[buf->head].candidateID = candidateID;
    buf->head = (buf->head + 1) % buf->size;
    return 1;
}

/**
 * Reads an item from the circular buffer.
 *
 * @param buf The circular buffer to read from.
 * @return The item read from the buffer.
 */
CandidateInfo readFromBuffer(CircularBuffer *buf)
{
    CandidateInfo item = buf->buffer[buf->tail];
    buf->tail = (buf->tail + 1) % buf->size;
    return item;
}

/**
 * Prints the contents of a CircularBuffer.
 *
 * @param buf The CircularBuffer to be printed.
 */
void printBuffer(CircularBuffer *buf)
{
    printf("Buffer: \n");
    printf("Head=%d, Tail=%d\n\n", buf->head, buf->tail);

    for (int i = 0; i < buf->size; i++)
    {
        printf("value=%d,", buf->buffer[i].candidateID);
        printf("index=%d,", buf->buffer[i].index);
        printf("isDone=%d\n", buf->buffer[i].isDone);
    }
    printf("\n");
}

/**
 * Checks for finished files in the circular buffer and returns the information of the first finished file.
 * If a finished file is found, its status is updated and its file information is cleared.
 *
 * @param buf The circular buffer to check for finished files.
 * @return The information of the first finished file, or a candidate ID of -1 if no finished files are found.
 */
CandidateInfo checkFinishedFiles(CircularBuffer *buf)
{
    CandidateInfo temp;
    for (int i = 0; i < buf->size; i++)
    {
        if (buf->buffer[i].isDone == 1)
        {
            temp = buf->buffer[i];
            buf->buffer[i].isDone = 2;
            buf->buffer[i].numFiles = 0;
            memset(buf->buffer[i].files, 0, sizeof(buf->buffer[i].files));
            return temp;
        }
    }
    temp.candidateID = -1;
    return temp;
}
/**
 * Adds the given CandidateInfo data to the CircularBuffer.
 *
 * @param candidates The CircularBuffer to add the data to.
 * @param data The CandidateInfo data to be added.
 */
void addInfo(CircularBuffer *candidates, CandidateInfo data)
{
    candidates->buffer[data.index] = data;
}
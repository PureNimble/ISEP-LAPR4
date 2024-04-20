// standard libraries
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
// process libraries
#include <sys/wait.h>
#include <string.h>
#include "utils.h"
/**
 * @brief Function to reduce the code duplication of creating a pipe and children
 */

void createPipe(int *fd)
{
    if (pipe(fd) == -1)
    {
        perror("Pipe failed.");
        exit(EXIT_FAILURE);
    }
}

pid_t createChildProcess()
{
    pid_t pid;
    pid = fork();
    if (pid == -1)
    {
        perror("fork");
        exit(EXIT_FAILURE);
    }
    return pid;
}

int hash(int key)
{
    unsigned int hash = key;
    return hash % HASH_SET_SIZE;
}

HashSet *createHashSet()
{
    HashSet *set = malloc(sizeof(HashSet));
    if (set == NULL)
    {
        perror("Memory allocation failed\n");
        exit(EXIT_FAILURE);
    }
    memset(set, 0, sizeof(HashSet));
    return set;
}

void add(HashSet *set, int key)
{
    if (set == NULL)
    {
        printf("HashSet is NULL\n");
        return;
    }
    unsigned int index = hash(key);
    Node *node = set->buckets[index];
    while (node)
    {
        if (node->key == key)
        {
            return; // Key already exists
        }
        node = node->next;
    }
    node = malloc(sizeof(Node));
    if (node == NULL)
    {
        printf("Memory allocation failed\n");
        return;
    }
    node->key = key;
    node->next = set->buckets[index];
    set->buckets[index] = node;
}
int contains(HashSet *set, int key)
{
    unsigned int index = hash(key);
    Node *node = set->buckets[index];
    while (node)
    {
        if (node->key == key)
        {
            return 1; // Key found
        }
        node = node->next;
    }
    return 0; // Key not found
}

void createMalloc(void *array)
{
    array = malloc(0);
    if (array == NULL)
    {
        printf("Memory allocation failed\n");
        exit(EXIT_FAILURE);
    }
}

void *createRealloc(void *array, size_t size)
{
    void *newArray = realloc(array, size);
    if (newArray == NULL)
    {
        printf("Memory allocation failed\n");
        return NULL;
    }
    return newArray;
}

int getArray(HashSet *set,int *array){
    int counter= 0;
    for (int i = 0; i < HASH_SET_SIZE; i++)
    {
        Node *node = set->buckets[i];
        while (node)
        {
            array[counter] = node->key;
            node = node->next;
            counter++;
        }
    }
    return counter;
}

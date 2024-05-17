#ifndef HASH_SET_H
#define HASH_SET_H
#define HASH_SET_SIZE 20
#include <stdbool.h>

// HashSet struct
typedef struct
{
    int key;
    bool isOccupied;
} Node;

typedef struct HashSet
{
    Node buckets[HASH_SET_SIZE];
    // for barrier synchronization
    unsigned int barrierCount;
    unsigned int barrierSize;
} HashSet;

// HashSet functions
bool add(HashSet *set, int key);
bool contains(HashSet *set, int key);
int removeValue(HashSet *set);
int size(HashSet *set);
void printHashSet(HashSet *set);

#endif // HASH_SET_H
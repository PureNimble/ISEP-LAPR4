#ifndef HASH_SET_H
#define HASH_SET_H

#define HASH_SET_SIZE 20

typedef struct Node
{
    int key;
    struct Node *next;
} Node;

typedef struct HashSet
{
    Node *buckets[HASH_SET_SIZE];
} HashSet;

int hash(int key);
HashSet *createHashSet();
void freeHashSet(HashSet *set);
void add(HashSet *set, int key);
int contains(HashSet *set, int key);
int getArray(HashSet *set, int *array);
int getValue(HashSet *set);
int isSetEmpty(HashSet *set);
int size(HashSet *set);

#endif // HASH_SET_H
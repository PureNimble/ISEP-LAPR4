#ifndef HASH_SET_H
#define HASH_SET_H
#define HASH_SET_SIZE 20

// Node struct for linked list
typedef struct Node
{
    int key;
    struct Node *next;
} Node;

// HashSet struct
typedef struct HashSet
{
    Node *buckets[HASH_SET_SIZE];
} HashSet;

// Hash function
int hash(int key);

// HashSet creation and deletion
HashSet *createHashSet();
void freeHashSet(HashSet *set);

// HashSet operations
void add(HashSet *set, int key);
int contains(HashSet *set, int key);
int getArray(HashSet *set, int *array);

#endif // HASH_SET_H
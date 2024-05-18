#include "hashSet.h"
#include <stdlib.h>
#include <stddef.h>
#include <string.h>
#include <stdio.h>
#include "utils.h"

/**
 * Calculates the hash value for a given key.
 *
 * @param key The key to calculate the hash value for.
 * @return The hash value.
 */
int hash(int key)
{
    unsigned int hash = key;
    return hash % HASH_SET_SIZE;
}

/**
 * Creates a new HashSet.
 *
 * @return A pointer to the newly created HashSet.
 */
HashSet *createHashSet()
{
    HashSet *set;
    createMalloc((void**)&set,sizeof(HashSet));
    memset(set, 0, sizeof(HashSet));
    return set;
}

/**
 * Adds a key to the HashSet.
 *
 * @param set The HashSet to add the key to.
 * @param key The key to add.
 */
void add(HashSet *set, int key)
{
    if (set == NULL)
    {
        errorMessages("HashSet is NULL\n");
        exit(EXIT_FAILURE);
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
    createMalloc((void**)&node,sizeof(Node));
    if (node == NULL)
    {
        errorMessages("Memory allocation failed\n");
        exit(EXIT_FAILURE);
    }
    node->key = key;
    node->next = set->buckets[index];
    set->buckets[index] = node;
}

/**
 * Retrieves all the keys in the HashSet and stores them in an array.
 *
 * @param set The HashSet to retrieve the keys from.
 * @param array The array to store the keys in.
 * @return The number of keys stored in the array.
 */
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

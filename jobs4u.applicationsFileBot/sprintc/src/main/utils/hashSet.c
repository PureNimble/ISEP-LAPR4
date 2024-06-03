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
    createMalloc((void **)&set, sizeof(HashSet));
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
    createMalloc((void **)&node, sizeof(Node));
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
 * Retrieves and removes the value from the HashSet.
 *
 * @param set The HashSet from which to retrieve the value.
 * @return The value retrieved from the HashSet, or -1 if the HashSet is empty.
 */
int getValue(HashSet *set)
{
    for (unsigned int index = 0; index < HASH_SET_SIZE; index++)
    {
        Node *node = set->buckets[index];
        if (node != NULL)
        {
            // Get the value of the node
            int value = node->key;

            // Remove the node from the bucket
            set->buckets[index] = node->next;

            // Free the memory of the node
            free(node);

            return value;
        }
    }

    // If the HashSet is empty
    return -1;
}

/**
 * Returns the number of elements in the HashSet.
 *
 * @param set The HashSet to get the size of.
 * @return The number of elements in the HashSet.
 */
int size(HashSet *set)
{
    int counter = 0;
    for (int i = 0; i < HASH_SET_SIZE; i++)
    {
        Node *node = set->buckets[i];
        while (node)
        {
            node = node->next;
            counter++;
        }
    }
    return counter;
}

/**
 * Frees the memory allocated for a HashSet and its elements.
 *
 * @param set The HashSet to be freed.
 */
void freeHashSet(HashSet *set)
{
    for (int i = 0; i < HASH_SET_SIZE; i++)
    {
        Node *node = set->buckets[i];
        while (node)
        {
            Node *temp = node;
            node = node->next;
            free(temp);
        }
    }
    free(set);
}

/**
 * Checks if a HashSet is empty.
 *
 * @param set The HashSet to check.
 * @return 1 if the HashSet is empty, 0 otherwise.
 */
int isSetEmpty(HashSet *set)
{
    for (int i = 0; i < HASH_SET_SIZE; i++)
    {
        if (set->buckets[i] != NULL)
        {
            return 0;
        }
    }
    return 1;
}
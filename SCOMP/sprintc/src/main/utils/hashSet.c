#include "hashSet.h"
#include <stdlib.h>
#include <stddef.h>
#include <string.h>
#include <stdio.h>
#include "utils.h"

/**
 * @file hashSet.c
 * @brief This file contains the implementation of a hash set data structure.
 */

/**
 * @brief Calculates the hash value for a given key.
 *
 * This function uses a simple hash function that calculates the remainder of the key divided by the size of the hash set.
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
 * @brief Creates a new HashSet.
 *
 * This function allocates memory for a new HashSet and initializes all its buckets to NULL.
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
 * @brief Adds a key to the HashSet.
 *
 * This function calculates the hash value for the key and adds a new node with the key to the corresponding bucket in the HashSet.
 * If the key already exists in the HashSet, the function does nothing.
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
 * @brief Retrieves and removes a value from the HashSet.
 *
 * This function iterates over the buckets of the HashSet until it finds a non-empty bucket.
 * It then removes the first node from the bucket and returns its key.
 * If the HashSet is empty, the function returns -1.
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
 * @brief Returns the number of elements in the HashSet.
 *
 * This function iterates over all the buckets in the HashSet and counts the number of nodes in each bucket.
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
 * @brief Frees the memory allocated for a HashSet and its elements.
 *
 * This function iterates over all the buckets in the HashSet and frees the memory for each node.
 * It then frees the memory for the HashSet itself.
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
 * @brief Checks if a HashSet is empty.
 *
 * This function iterates over all the buckets in the HashSet.
 * If it finds a non-empty bucket, it returns 0.
 * If all the buckets are empty, it returns 1.
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
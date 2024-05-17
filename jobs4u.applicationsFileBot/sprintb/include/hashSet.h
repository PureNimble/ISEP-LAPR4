#ifndef HASH_SET_H
#define HASH_SET_H
#define HASH_SET_SIZE 20  

//HashSet struct
typedef struct Node {
    int key;
    struct Node* next;
} Node;

typedef struct HashSet {
    Node* buckets[HASH_SET_SIZE];
} HashSet;

//HashSet functions
int hash(int key);
HashSet* createHashSet();
void add(HashSet* set, int key);
int contains(HashSet* set, int key);
int getArray(HashSet* set,int*array);



#endif // HASH_SET_H
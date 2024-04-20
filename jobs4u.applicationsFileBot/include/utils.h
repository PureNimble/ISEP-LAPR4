#ifndef UTILS_H
#define UTILS_H
#define HASH_SET_SIZE 20  

void createPipe(int*fd);
int createChildProcess();
void waitChildProcess();
void stdOutToPipe(int* fd);
void createMalloc(void* ptr);
void* createRealloc(void* ptr, size_t size);

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


#endif // UTILS_H
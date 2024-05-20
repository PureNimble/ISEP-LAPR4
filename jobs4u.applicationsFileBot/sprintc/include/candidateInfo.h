#ifndef CANDIDATE_INFO_H
#define CANDIDATE_INFO_H
#define MAX_FILES 20
typedef struct
{
    char jobOffer_dir[100];
    int candidateID;
    int numFiles;
    char files[MAX_FILES][100];

} CandidateInfo;

#endif // CANDIDATE_INFO_H
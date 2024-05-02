#ifndef TEST_H
#define TEST_H
#define TEST_INPUT "./resources/test_folder/input/"
#define TEST_OUTPUT "./resources/test_folder/output/"
#define SHARED_FOLDER "./resources/test_folder/"
#define TEST_CHILDREN 5
#define TEST_FREQUENCY 5
#define DELETE_FOLDER_TIME 5
#include "config.h"
char *newFileChecker_test(Config config);
Files copyFiles_test(Config config);
int reportFile_test(Config config, Files file);

#endif // TEST_H
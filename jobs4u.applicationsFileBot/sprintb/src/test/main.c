#include "config.h"
#include "info.h"
#include "test.h"
#include <stdio.h>
#include <stddef.h>
#include <stdlib.h>
#include <string.h>
#include "utils.h"
#include <sys/stat.h>
#include <unistd.h>
#include <signal.h>
#include <sys/types.h>
#include <errno.h>

int main()
{
    setUpSignal();

    create_directory(SHARED_FOLDER);
    create_directory(TEST_INPUT);
    create_directory(TEST_OUTPUT);

    Config config;
    strcpy(config.inputPath, TEST_INPUT);
    strcpy(config.outputPath, TEST_OUTPUT);
    config.verifyNewFilesFrequency = TEST_FREQUENCY;
    config.numberOfChildren = TEST_CHILDREN;

    char *file_path = newFileChecker_test(config);
    Files file = copyFiles_test(config);
    reportFile_test(config, file);

    // delete folder
    printf("-> Deleting test folders in 5 seconds\n");
    sleep(DELETE_FOLDER_TIME);
    delete_directory(TEST_INPUT);
    delete_directory(TEST_OUTPUT);

    free(file_path);

    return 0;
}

char *newFileChecker_test(Config config)
{
    pid_t pid;
    printf("-> Testing newFileChecker\n");
    if ((pid = createChildProcess()) == 0)
        newFileChecker(&config);

    // create new file in input folder
    char *file_path = malloc(FILE_PATH_SIZE);
    strcpy(file_path, TEST_INPUT);
    strcat(file_path, "1-candidate-data.txt");
    FILE *file = fopen(file_path, "w");
    if (file == NULL)
    {
        errorMessages("Failed to create file.\n\n");
        exit(EXIT_FAILURE);
    }
    fprintf(file, "FNAC1-1\njohndoe@email.com\nJohn Doe\n961234567\n");
    pause();
    kill(pid, SIGTERM);
    fclose(file);

    printf("-> newFileChecker test passed\n\n\n");

    return file_path;
}

Files copyFiles_test(Config config)
{
    printf("-> Testing copyFiles\n");
    pid_t pid;
    int send_work_fd[2], recive_work_fd[2];
    createPipe(send_work_fd);
    createPipe(recive_work_fd);
    if ((pid = createChildProcess()) == 0)
        copyFiles(send_work_fd, recive_work_fd, &config);

    listCandidatesID(send_work_fd, &config);

    Files file;
    read(recive_work_fd[0], &file, sizeof(Files));
    printf("All files have been copied\n");

    printf("-> copyFiles test passed\n\n\n");
    return file;
}

int reportFile_test(Config config, Files file)
{
    printf("-> Testing reportFile\n");
    Files *files;
    createMalloc((void **)&files, sizeof(Files));
    files[0] = file;

    reportFile(&config, files, 1);

    printf("-> reportFile test passed\n");
}
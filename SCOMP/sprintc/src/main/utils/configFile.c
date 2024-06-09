#include "config.h"
#include <stdio.h>
#include <stddef.h>
#include <stdlib.h>
#include "utils.h"

/**
 * Reads the configuration file and populates the Config structure.
 *
 * @param config A pointer to the Config structure to be populated.
 */
void readConfigFile(Config *config)
{
    // Open the configuration file for reading
    FILE *file = fopen(CONFIG_FILE, "r");
    if (file == NULL)
    {
        errorMessages("Error opening file!\n");
        exit(EXIT_FAILURE);
    }
    // Read and validate the INPUT_PATH
    if (fscanf(file, "INPUT_PATH=%s\n", config->inputPath) == -1 || isFileOrDirectory(config->inputPath) != 2)
    {
        errorMessages("Invalid format for INPUT_PATH (The Folder need to be created)\n");
        exit(EXIT_FAILURE);
    }
    // Read and validate the OUTPUT_PATH
    if (fscanf(file, "OUTPUT_PATH=%s\n", config->outputPath) == -1 || isFileOrDirectory(config->outputPath) != 2)
    {
        errorMessages("Invalid format for OUTPUT_PATH (The Folder need to be created)\n");
        exit(EXIT_FAILURE);
    }
    // Read and validate the NUMBER_OF_CHILDREN
    if (fscanf(file, "NUMBER_OF_CHILDREN=%d\n", &(config->numberOfChildren)) == -1 || (config->numberOfChildren == 0 || config->numberOfChildren > 20))
    {
        errorMessages("Invalid format for NUMBER_OF_CHILDREN\n");
        exit(EXIT_FAILURE);
    }
    // Read and validate the VERIFY_NEW_FILES_FREQUENCY
    if (fscanf(file, "VERIFY_NEW_FILES_FREQUENCY=%d\n", &(config->verifyNewFilesFrequency)) == -1 || config->verifyNewFilesFrequency <= 0)
    {
        errorMessages("Invalid format for VERIFY_NEW_FILES_FREQUENCY\n");
        exit(EXIT_FAILURE);
    }
    // Read and validate the VERIFY_NEW_FILES_FREQUENCY
    if (fscanf(file, "CIRCULAR_BUFFER_SIZE=%d\n", &(config->bufferSize)) == -1 || (config->bufferSize > 20 || config->bufferSize <= 0))

    {
        errorMessages("Invalid format for CIRCULAR_BUFFER_SIZE (MAX VALUE= 20)\n");
        exit(EXIT_FAILURE);
    }
    // Close the configuration file
    fclose(file);
}

/**
 * Prints the configuration details of the application.
 *
 * @param config A pointer to the Config struct containing the configuration details.
 */
void printConfig(Config *config)
{
    printf("\n========================\n");
    printf("= Application File Bot =\n");
    printf("========================\n\n");
    printf("\033[1;36mConfiguration Details:\033[0m\n");
    printf("\033[1;36m--------------------------------\033[0m\n");
    printf("\033[1;32mInput Path:\033[0m %s\n", config->inputPath);
    printf("\033[1;32mOutput Path:\033[0m %s\n", config->outputPath);
    printf("\033[1;32mNumber of Children(Max=20):\033[0m %d\n", config->numberOfChildren);
    printf("\033[1;32mVerify New Files Frequency:\033[0m %d\n", config->verifyNewFilesFrequency);
    printf("\033[1;32mCircular Buffer Size(Max=20):\033[0m %d\n", config->bufferSize);
    printf("\033[1;36m--------------------------------\033[0m\n");

    printf("\n\033[1;33mWarning:\033[0m \033[1;31mIf you want to change the program\n\t settings, you must change the config\n\t file located in the resources folder\033[0m\n");
    printf("\nPress enter to continue...\n");
    scanf("%*c");
}
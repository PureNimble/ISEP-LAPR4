#ifndef CONFIG_H
#define CONFIG_H
#define CONFIG_FILE "resources/config.txt"
typedef struct Config
{
    unsigned int verifyNewFilesFrequency;
    unsigned int numberOfChildren;
    unsigned int bufferSize;
    char inputPath[100];
    char outputPath[100];
} Config;

void readConfigFile(Config *config);
void printConfig(Config *config);
int checkIfDirectoryExists(char *path);

#endif // CONFIG_H
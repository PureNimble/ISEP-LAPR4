#ifndef CONFIG_H
#define CONFIG_H
#define CONFIG_FILE "resources/config.txt"
typedef struct Config {
    int verifyNewFilesFrequency;
    int numberOfChildren;
    char inputPath[100];
    char outputPath[100];
} Config;

void readConfigFile(Config* config);
void printConfig(Config* config);
int checkIfDirectoryExists(char* path);


#endif // CONFIG_H
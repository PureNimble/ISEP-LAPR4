<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764"/>

# SCOMP Application File Bot / Top 20 Words

## Table of Contents

- [Introduction](#1-introduction)
- [Application File Bot](#2-application-file-bot)
- [Top 20 Words](#3-top-20-words)
 

## 1. Introduction

This document describes the SCOMP part of the project, focusing on two main functionalities: the Applications Email Bot and the Top 20 words feature.

The Applications Email Bot, as per User Story 2001b, is designed to continuously process files produced by the bot. These files can then be imported into the system at the operator's initiative. The bot is developed in C and utilizes processes, shared memory, and semaphore primitives to manage tasks and avoid busy waiting.

The Top 20 words feature, as per User Story 4000, is a functionality expected by the Customer Manager. When displaying candidate data, the system presents a list of the 20 most frequently referenced words from files uploaded by a candidate. Additionally, a comprehensive list of the files in which these words appear is provided. This feature is developed in Java, utilizing threads and synchronization mechanisms outlined in SCOMP.

Both functionalities prioritize the elimination of busy waiting and the efficient use of processes and threads. They also emphasize the importance of unit and integration tests for ensuring the quality and reliability of the system.

## 2. Application File Bot

- The Application File Bot is implemented in C, utilizing processes, shared memory, and semaphore primitives to manage tasks and avoid busy waiting. The bot is designed to continuously process files produced by the bot. These files can then be imported into the system at the operator's initiative.

- The bot is developed in C and is located in the `sprintc` project. The main source code is located in the [main.c](../../../SCOMP/sprintc/src/main/main.c) file. The test code is located in the [main.c](../../../SCOMP/sprintc/src/test/main.c) file. The documentation for the bot is located in the [us_2001b](./sprintc/us_2001b/readme.md) folder.



## 3. Top 20 Words

- The Top 20 Words feature is implemented in Java, utilizing threads and synchronization mechanisms outlined in SCOMP. The feature is designed to display the 20 most frequently referenced words from files uploaded by a candidate. Additionally, a comprehensive list of the files in which these words appear is provided.

- Since the feature is developed in Java, using the Jobs4u Application, the code is located in the `jobs4u` project and it is located in the [ListCandidatesDataUI](../../../jobs4u.app.backoffice.console\src\main\java\lapr4\jobs4u\app\backoffice\console\presentation\authz\ListCandidatesDataUI.java).But all the major functionalities related to Threads and Synchronization are located in the following directorys:
  - [Application](../../../jobs4u.core\src\main\java\lapr4\jobs4u\applicationmanagement\domain\Application.java) 
    - This class is responsible for the Application object, which is the main object that contains the files uploaded by the candidate.It implements the `Runnable` interface, which allows the object to be executed as a thread.
  - [FilePartition](../../../jobs4u.core\src\main\java\lapr4\jobs4u\applicationmanagement\domain\FilePartition.java)
    - This class is responsible for the FilePartition object, which is a partition of a file that contains a list of words. It implements the `Runnable` interface, which allows the object to be executed as a thread.
  - [File](../../../jobs4u.core\src\main\java\lapr4\jobs4u\applicationmanagement\domain\File.java)
    - This class is responsible for the File object, which contains the file name and a list of FilePartitions. It implements the `Runnable` interface, which allows the object to be executed as a thread.





<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764&section=footer"/>
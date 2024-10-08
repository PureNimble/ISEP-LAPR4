<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764"/>

# Project Jobs4U

```
      _         _           _  _    _    _ 
     | |       | |         | || |  | |  | |
     | |  ___  | |__   ___ | || |_ | |  | |
 _   | | / _ \ | '_ \ / __||__   _|| |  | |
| |__| || (_) || |_) |\__ \   | |  | |__| |
 \____/  \___/ |_.__/ |___/   |_|   \____/ 
```

_Jobs4U logo created with [kammerl ascii signature](https://www.kammerl.de/ascii/AsciiSignature.php) using font "big" and kerning_

## 1. Description of the Project

As part of the LEI ([Licenciatura Engenharia Informática](https://www.isep.ipp.pt/Course/Course/26)) degree's integrative project at ISEP ([Instituto Superior de Engenharia do Porto](https://www.isep.ipp.pt)) for the 2023/2024 academic year, we are embarking on a project to develop a Minimum Viable Product (MVP) for Jobs4U aimed at automating their talent acquisition process. Our objective is to enhance the efficiency of how Jobs4U connects companies with top candidates. Within the next 3 months, we will collaborate to design, code, and deploy a system that optimizes the recruitment workflow, from identifying potential candidates to compiling a prioritized list of candidates for job offers. This repository serves as our central workspace, containing initial source code, project management tools, and comprehensive documentation to support us through the software development lifecycle.

## 2. Planning and Technical Documentation

[_`Planning and Technical Documentation`_](docs/readme.md)

## 3. How to Build

> ⚠️ _Before building, ensure that you have a JDK installed and confirm that the JAVA_HOME environment variable is set to the JDK installation directory._

### For linux/unix/macos
> ⚠️ _Before building on linux/unix/macos, ensure that you have the following prerequisites:_
> - _Make (If not installed, you can install it by running `sudo apt install build-essential`)_
> - _GCC (If not installed, you can install it by running `sudo apt install valgrind`)_
```
./bin/build-all.sh
```

##### Quick build

```
./bin/quickbuild.sh
```

### For windows
```
.\bin\build-all.bat
```

##### Quick build

```
.\bin\quickbuild.bat
```

## 4. How to Execute Tests

> 💡 _Building with maven will automatically run all unit tests in the projects. To trigger this, follow the instructions described in [**3. How to Build**](#3-how-to-build)._

You can also execute the tests using the following commands:

### For linux/unix/macos
```
./bin/test-all.sh
```
### For windows
```
.\bin\test-all.bat
```

## 5. How to Run

### To run Bootstrap

> ⚠️ _Only run the bootstrap if you are connecting to a newly created database!_

#### For linux/unix/macos
```
./bin/run-bootstrap.sh
```
#### For windows
```
.\bin\run-bootstrap.bat
```

#### You can add one of the following arguments to the script to run a specific module:

* To run the Demo Data: `-bootstrap:demo`

* To run the Basic Scenario: `-smoke:basic`

### To run Backoffice App

#### For linux/unix/macos
```
./bin/run-backoffice.sh
```
#### For windows
```
.\bin\run-backoffice.bat
```

### To run Customer App

#### For linux/unix/macos
```
./bin/run-customer.sh 
```
#### For windows
```
.\bin\run-customer.bat
```

### To run Candidate App

#### For linux/unix/macos
```
./bin/run-candidate.sh 
```
#### For windows
```
.\bin\run-candidate.bat
```

## 6. How to Install/Deploy into Another Machine (or Virtual Machine)

> ⚠️ _To run this script is necessary to have the docker installed, since we are creating a docker image and a docker container._

### For linux/unix/macos
```
./bin/deploy-docker.sh
```
### For windows
```
.\bin\deploy-docker.bat
```
## 7. How to Generate PlantUML Diagrams

To generate plantuml diagrams for documentation execute the script:

#### For linux/unix/macos
```
./bin/generate-plantuml-diagrams.sh
```

#### For windows
```
.\bin\generate-plantuml-diagrams.bat
```

<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764&section=footer"/>

<img width=100% src="https://capsule-render.vercel.app/api?type=waving&height=120&color=4E1764"/>

# Project Jobs4U

## 1. Description of the Project

As part of the [LEI](https://www.isep.ipp.pt/Course/Course/26) degree's integrative project at [ISEP](https://www.isep.ipp.pt) for the 2023/2024 academic year, we are embarking on a project to develop a Minimum Viable Product (MVP) for Jobs4U aimed at automating their talent acquisition process. Our objective is to enhance the efficiency of how Jobs4U connects companies with top candidates. Within the next 3 months, we will collaborate to design, code, and deploy a system that optimizes the recruitment workflow, from identifying potential candidates to compiling a prioritized list of candidates for job offers. This repository serves as our central workspace, containing initial source code, project management tools, and comprehensive documentation to support us through the software development lifecycle.

## 2. Planning and Technical Documentation

[_`Planning and Technical Documentation`_](docs/readme.md)

## 3. How to Build

### For linux/unix/macos
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

```
mvn test
```

## 5. How to Run

*To Do*

## 6. How to Install/Deploy into Another Machine (or Virtual Machine)

<table>
<tr>

<td>
<img width=50px height=35px src="https://media2.giphy.com/media/v1.Y2lkPTc5MGI3NjExN3kzdDBieGd6eDc4czJuaHgxeGZ2aWwxN3BtazdmanNnNDNkYjZybCZlcD12MV9pbnRlcm5hbF9naWZfYnlfaWQmY3Q9cw/Ve5vfhwsox2G3bJ44O/giphy.gif"/>
</td>
<td>

_`To run this script is necessary to have the docker installed, since we are creating a docker image and a docker container.`_
</td>

</tr>
</table>

### For linux/unix/macos
```
./bin/dockerRun.sh
```
### For windows
```
.\bin\dockerRun.bat
```

## 7. How to execute (.JAR)

### Execute jobs4u.app1

```
java -jar jobs4u.app1-0.1.0.jar
```

### Execute jobs4u.app2

```
java -jar jobs4u.app2-0.1.0.jar
```

## 8. How to Generate PlantUML Diagrams

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
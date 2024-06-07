#!/usr/bin/env bash
echo OFF
echo make sure JAVA_HOME is set to JDK folder
echo make sure maven is on the system PATH
./bin/mvnw $1 package dependency:copy-dependencies -Daggregate=true checkstyle:checkstyle-aggregate surefire-report:report
make $1 test -C ./SCOMP/sprintc
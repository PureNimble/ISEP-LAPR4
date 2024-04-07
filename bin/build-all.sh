#!/usr/bin/env bash
ECHO OFF
ECHO make sure JAVA_HOME is set to JDK folder
ECHO make sure maven is on the system PATH
./bin/mvnw $1 package dependency:copy-dependencies surefire-report:report -Daggregate=true checkstyle:checkstyle-aggregate 
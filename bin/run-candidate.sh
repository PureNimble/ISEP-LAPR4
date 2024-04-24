#!/usr/bin/env bash

#REM set the class path,
#REM assumes the build was executed with maven copy-dependencies
export jobs4u_CP=jobs4u.app.candidate.console/target/jobs4u.app.candidate.console-0.1.0.jar:jobs4u.app.candidate.console/target/dependency/*;

#REM call the java VM, e.g,
java -cp $jobs4u_CP lapr4.jobs4u.app.candidate.console.CandidateApp

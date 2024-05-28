@echo off
REM set the class path,
REM assumes the build was executed with maven copy-dependencies
set jobs4u_CP=jobs4u.applicationProtocol\target\jobs4u.applicationProtocol-0.1.0.jar;jobs4u.applicationProtocol\target\dependency\*;

REM call the java VM, e.g,
java -cp %jobs4u_CP% lapr4.jobs4u.ServerApp
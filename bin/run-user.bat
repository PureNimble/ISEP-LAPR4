REM set the class path,
REM assumes the build was executed with maven copy-dependencies
SET jobs4u_CP=jobs4u.app.user.console\target\jobs4u.app.user.console-0.1.0.jar;jobs4u.app.user.console\target\dependency\*;

REM call the java VM, e.g, 
java -cp %jobs4u_CP% lapr4.jobs4u.app.user.console.BaseUserApp

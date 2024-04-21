@ECHO OFF
.\bin\mvnw.cmd test checkstyle:checkstyle-aggregate surefire-report:report
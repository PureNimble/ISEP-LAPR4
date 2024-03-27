ECHO OFF
.\bin\mvnw.cmd -B %1 clean dependency:copy-dependencies verify -D maven.javadoc.skip=true
ECHO OFF
ECHO make sure JAVA_HOME is set to JDK folder
ECHO make sure maven is on the system PATH
.\bin\mvnw.cmd %1 dependency:copy-dependencies package
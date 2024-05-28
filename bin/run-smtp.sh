#!/usr/bin/env bash
WORKDIR=/root/sem4pi-23-24-2di2/libs
PIDFILE=$WORKDIR/smtp.pid
cd $WORKDIR

# Start the Java application in the background
java -jar ./fake-smtp-server-2.2.1.jar -Dspring.config.location=./application.yaml &

# Get the PID of the last command executed in the background
JAVA_PID=$!

# Write the PID to the PID file
echo $JAVA_PID > $PIDFILE

# Detach from the terminal to ensure the script does not block
disown
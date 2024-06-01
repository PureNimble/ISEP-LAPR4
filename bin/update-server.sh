#!/bin/bash

# Define the log file
logfile="/root/logFile.log"

# Navigate to the root directory of your project
cd /root/sem4pi-23-24-2di2
echo "Cron job executed at $(date)" >> $logfile

# Perform a git pull and capture the output
pull=$(git pull)
# Check if the output contains "Already up-to-date."
if [[ $pull != *"Already up to date."* ]]; then
    chmod +x /root/sem4pi-23-24-2di2/bin/*
    echo "-> Stopping the server" >> $logfile
    systemctl stop jobs4u 
    systemctl stop smtp 
    # Build the project
    echo "-> Building the project ..." >> $logfile
    ./bin/quickbuild.sh 
    # Check the exit status of the previous command
    if [ $? -eq 0 ]; then
        echo "-> Maven command succeeded" >> $logfile
        # Restart the server
        echo "-> Restarting the server" >> $logfile
        systemctl start jobs4u 
        systemctl start smtp 
    else
        echo "-> Maven command failed" >> $logfile
    fi
fi
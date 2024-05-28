#!/bin/bash

# Navigate to the root directory of your project
cd ~/sem4pi-23-24-2di2

# Perform a git pull and capture the output
pull=$(git pull)

echo "Cron job executed at $(date)"

# Check if the output contains "Already up-to-date."
if [[ $pull != *"Already up-to-date."* ]]; then
    chmod +x /root/sem4pi-23-24-2di2/bin/*
    systemctl stop jobs4u
    systemctl stop smtp
    # Build the project
    ./bin/quickbuild.sh
    # Check the exit status of the previous command
    if [ $? -eq 0 ]; then
        echo "->Maven command succeeded"
        # Restart the server
        systemctl start jobs4u
        systemctl start smtp
    else
        echo "->Maven command failed"
    fi
fi
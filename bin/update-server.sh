#!/bin/bash

# Navigate to the root directory of your project
cd ~/sem4pi-23-24-2di2

# Perform a git pull and capture the output
pull=$(git pull)

echo "Cron job executed at $(date)"

# Check if the output contains "Already up-to-date."
if [[ $pull != *"Already up-to-date."* ]]; then
    # Build the project
    ./bin/quickbuild.sh
    # Restart the server
    systemctl restart isep
    fi
fi
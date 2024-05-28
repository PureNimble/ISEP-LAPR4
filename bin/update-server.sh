#!/bin/bash

# Navigate to the root directory of your project
cd ~/sem4pi-23-24-2di2

# Perform a git pull and capture the output
pull=$(git pull)

# Check if the output contains "Already up-to-date."
if [[ $pull != *"Already up-to-date."* ]]; then
    # If there are changes, check if any of them are in the specific path
    if [[ $(git diff --name-only HEAD HEAD~1 | grep jobs4u.applicationProtocol) ]]; then
        # If there are changes in the specific path, run the other script
        ./bin/quickbuild.sh

        systemctl restart isep

    fi
fi
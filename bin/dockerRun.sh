#!/bin/sh

# Define the image name
IMAGE_NAME="jobs4u"
CONTAINER_NAME="jobs4u-container"
FOLDER="./.docker"
ROOT="./"

# Build the Docker image
docker build -t $IMAGE_NAME -f $FOLDER/Dockerfile $ROOT

# Run the Docker container
docker run -d --name $CONTAINER_NAME $IMAGE_NAME

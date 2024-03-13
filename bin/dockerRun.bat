REM Define the image name
set "IMAGE_NAME=jobs4u"
set "CONTAINER_NAME=jobs4u-container"
set "FOLDER=./.docker"
set "ROOT=./"

REM Build the Docker image
docker build -t %IMAGE_NAME% -f %FOLDER%/Dockerfile %ROOT%

REM Run the Docker container
docker run -d --name %CONTAINER_NAME% %IMAGE_NAME%
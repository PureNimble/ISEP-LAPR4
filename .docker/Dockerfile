# Use an Alpine base image with OpenJDK JRE
FROM adoptopenjdk:11-jdk-hotspot-bionic

# Set the working directory in the Docker image
WORKDIR /app

# Copy the project files into the Docker image
COPY . .

# Install dos2unix
RUN apt-get update && apt-get install -y dos2unix

# Convert line endings to Unix-style
RUN find ./bin -name '*' -exec dos2unix {} \; && chmod +x ./bin/*

# Run the script
CMD ["./bin/build-all.sh"]
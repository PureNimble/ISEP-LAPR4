#!/usr/bin/env bash
./bin/mvnw -B $1 dependency:copy-dependencies verify -D maven.javadoc.skip=true
make build -C ./jobs4u.applicationsFileBot
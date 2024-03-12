#!/usr/bin/env bash
./bin/mvnw -B $1 clean dependency:copy-dependencies verify -D maven.javadoc.skip=true
#!/usr/bin/env bash
mvnw -B $1 dependency:copy-dependencies verify -D maven.javadoc.skip=true
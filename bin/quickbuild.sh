#!/usr/bin/env bash
mvn -B $1 dependency:copy-dependencies verify -D maven.javadoc.skip=true
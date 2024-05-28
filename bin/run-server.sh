#!/usr/bin/env bash

# Set the class path, assumes the build was executed with maven copy-dependencies
jobs4u_CP=/root/sem4pi-23-24-2di2/jobs4u.applicationProtocol/target/jobs4u.applicationProtocol-0.1.0.jar:/root/sem4pi-23-24-2di2/jobs4u.applicationProtocol/target/dependency/*
WORKDIR=/root/sem4pi-23-24-2di2
cd $WORKDIR

# Call the Java VM
java -cp $jobs4u_CP lapr4.jobs4u.ServerApp &
echo $! > $WORKDIR/serverapp.pid

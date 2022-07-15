#!/usr/bin/env bash

echo 'Testing Maven Build To Docker Image'

set -x
mvn package docker:build
set +x

echo 'Finished'
#!/bin/bash

docker rm -fv $(docker ps -qa)
docker volume rm $(docker volume ls -qf dangling=true)
export BUILD_NAME="testing"
mvn clean generate-sources package docker:build
docker-compose -f docker-infrastructure/infra-dev.yml up --remove-orphans

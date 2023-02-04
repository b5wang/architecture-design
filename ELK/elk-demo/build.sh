#!/bin/bash

docker-compose down -v
rm -rf ./zookeeper-0/data
rm -rf ./kafka-0/data
mkdir -p ./zookeeper-0/data
mkdir -p ./kafka-0/data
docker-compose build
docker-compose up -d
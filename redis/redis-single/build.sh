#!/bin/bash

docker-compose down -v

rm -rf ./data
mkdir -p ./data

docker-compose build
docker-compose up -d
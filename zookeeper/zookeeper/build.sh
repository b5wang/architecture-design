#!/bin/bash

docker-compose down -v
rm -rf ./mysql-single/data
mkdir -p ./mysql-single/data
docker-compose build
docker-compose up -d
#!/bin/bash
docker-compose down -v

rm -rf ./data
mkdir -p ./data/redis-1
mkdir -p ./data/redis-2
mkdir -p ./data/redis-3

docker-compose build
docker-compose up -d
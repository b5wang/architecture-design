#!/bin/bash

docker-compose down -v

rm -rf ./logstash/data
rm -rf ./logstash/logs
rm -rf ./elasticsearch/data
rm -rf ./elasticsearch/plugins

mkdir -p ./logstash/data
mkdir -p ./logstash/logs
mkdir -p ./elasticsearch/data
mkdir -p ./elasticsearch/plugins

docker-compose build
docker-compose up -d
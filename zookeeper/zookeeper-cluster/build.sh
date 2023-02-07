#!/bin/bash

docker-compose down -v

rm -rf ./zoo1/data
rm -rf ./zoo2/data
rm -rf ./zoo3/data
rm -rf ./zoo1/datalog
rm -rf ./zoo2/datalog
rm -rf ./zoo3/datalog

mkdir -p ./zoo1/data
mkdir -p ./zoo2/data
mkdir -p ./zoo3/data
mkdir -p ./zoo1/datalog
mkdir -p ./zoo2/datalog
mkdir -p ./zoo3/datalog

docker-compose build
docker-compose up -d
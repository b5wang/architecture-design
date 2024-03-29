#!/bin/bash
APP_BASE=/opt/zk-cluster

cp -rf zk-1/conf/zoo.cfg $APP_BASE/zk-1/conf/zoo.cfg
cp -rf zk-2/conf/zoo.cfg $APP_BASE/zk-2/conf/zoo.cfg
cp -rf zk-3/conf/zoo.cfg $APP_BASE/zk-3/conf/zoo.cfg

mkdir -p $APP_BASE/zk-1/data/
mkdir -p $APP_BASE/zk-2/data/
mkdir -p $APP_BASE/zk-3/data/

cp -rf zk-1/data/myid $APP_BASE/zk-1/data/myid
cp -rf zk-2/data/myid $APP_BASE/zk-2/data/myid
cp -rf zk-3/data/myid $APP_BASE/zk-3/data/myid

cp -rf start.sh $APP_BASE/
cp -rf stop.sh  $APP_BASE/

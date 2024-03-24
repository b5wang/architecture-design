#!/bin/bash
APP_BASE=$(pwd)
CODE_BASE=/mnt/d/Projects/GitHub/b5wang/architecture-design/zookeeper/zk-cluster

cp -rf $CODE_BASE/zk-1/conf/zoo.cfg $APP_BASE/zk-1/conf/zoo.cfg
cp -rf $CODE_BASE/zk-2/conf/zoo.cfg $APP_BASE/zk-2/conf/zoo.cfg
cp -rf $CODE_BASE/zk-3/conf/zoo.cfg $APP_BASE/zk-3/conf/zoo.cfg

mkdir -p $APP_BASE/zk-1/data/
mkdir -p $APP_BASE/zk-2/data/
mkdir -p $APP_BASE/zk-3/data/

cp -rf $CODE_BASE/zk-1/data/myid $APP_BASE/zk-1/data/myid
cp -rf $CODE_BASE/zk-2/data/myid $APP_BASE/zk-2/data/myid
cp -rf $CODE_BASE/zk-3/data/myid $APP_BASE/zk-3/data/myid

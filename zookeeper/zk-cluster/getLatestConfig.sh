#!/bin/bash
APP_BASE=/Users/wangbo584/Workspace/applications/zk-cluster
CODE_BASE=/Users/wangbo584/Workspace/projects/GitHub/b5wang/architecture-design/zookeeper/zk-cluster

cp -rf $CODE_BASE/zk-1/conf/zoo.cfg $APP_BASE/zk-1/conf/zoo.cfg
cp -rf $CODE_BASE/zk-2/conf/zoo.cfg $APP_BASE/zk-2/conf/zoo.cfg
cp -rf $CODE_BASE/zk-3/conf/zoo.cfg $APP_BASE/zk-3/conf/zoo.cfg

mkdir $APP_BASE/zk-1/data/
mkdir $APP_BASE/zk-2/data/
mkdir $APP_BASE/zk-3/data/

cp -rf $CODE_BASE/zk-1/data/myid $APP_BASE/zk-1/data/myid
cp -rf $CODE_BASE/zk-2/data/myid $APP_BASE/zk-2/data/myid
cp -rf $CODE_BASE/zk-3/data/myid $APP_BASE/zk-3/data/myid

#!/bin/bash
APP_BASE=/Users/wangbo584/Workspace/applications/zk-cluster

$APP_BASE/zk-1/bin/zkServer.sh stop
$APP_BASE/zk-2/bin/zkServer.sh stop
$APP_BASE/zk-3/bin/zkServer.sh stop

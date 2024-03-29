#!/bin/bash
APP_BASE=/opt/zk-cluster

$APP_BASE/zk-1/bin/zkServer.sh start
$APP_BASE/zk-2/bin/zkServer.sh start
$APP_BASE/zk-3/bin/zkServer.sh start

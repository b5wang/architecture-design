#!/bin/bash
APP_BASE=/Users/wangbo584/Workspace/projects/GitHub/b5wang/architecture-design/redis/redis-linux/redis-sentinel

$APP_BASE/node6379/redis-startup.sh
$APP_BASE/node7379/redis-startup.sh
$APP_BASE/node8379/redis-startup.sh

$APP_BASE/node6379/redis-sentinel-startup.sh
$APP_BASE/node7379/redis-sentinel-startup.sh
$APP_BASE/node8379/redis-sentinel-startup.sh

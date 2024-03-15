#!/bin/bash
redis_pid=$(cat /Users/wangbo584/Workspace/applications/redis-sentinel/node8379/data/redis-sentinel.pid)
echo "Redis pid: $redis_pid"
kill -9 $redis_pid
#!/bin/bash
redis_pid=$(cat /Users/wangbo584/Workspace/applications/redis-sentinel/node8379/data/redis_8379.pid)
echo "Redis pid: $redis_pid"
kill -9 $redis_pid
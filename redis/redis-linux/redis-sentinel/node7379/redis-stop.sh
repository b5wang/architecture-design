#!/bin/bash
redis_pid=$(cat /Users/wangbo584/Workspace/applications/redis-sentinel/node7379/data/redis_7379.pid)
echo "Redis pid: $redis_pid"
kill -9 $redis_pid
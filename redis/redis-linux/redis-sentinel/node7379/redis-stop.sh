#!/bin/bash
redis_pid=$(cat /opt/redis/redis-sentinel/node7379/data/redis_7379.pid)
echo "Redis pid: $redis_pid"
kill -9 $redis_pid
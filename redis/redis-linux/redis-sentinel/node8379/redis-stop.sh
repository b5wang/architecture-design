#!/bin/bash
redis_pid=$(cat /opt/redis/redis-sentinel/node8379/data/redis_8379.pid)
echo "Redis pid: $redis_pid"
kill -9 $redis_pid
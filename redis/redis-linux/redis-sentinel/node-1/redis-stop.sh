#!/bin/bash
redis_pid=$(cat /opt/redis/redis-single/data/redis_6379.pid)
echo "Redis pid: $redis_pid"
kill -9 $redis_pid
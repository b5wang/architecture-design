#!/bin/bash

pid=$(cat /redis-stack-server-6.2.6/data/redis_6379.pid)
kill -9 $pid
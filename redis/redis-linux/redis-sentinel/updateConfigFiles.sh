#!/bin/bash
APP_BASE=/Users/wangbo584/Workspace/applications/redis-sentinel
CODE_BASE=/Users/wangbo584/Workspace/projects/GitHub/b5wang/architecture-design/redis/redis-linux/redis-sentinel

cp -r $APP_BASE/node6379/*.conf $CODE_BASE/node6379
cp -r $APP_BASE/node7379/*.conf $CODE_BASE/node7379
cp -r $APP_BASE/node8379/*.conf $CODE_BASE/node8379

sed -i "s/\/opt\/redis\/redis-sentinel/${APP_BASE}/g" '$APP_BASE/node6379/redis.conf'
sed -i "s/\/opt\/redis\/redis-sentinel/${APP_BASE}/g" "$APP_BASE/node6379/redis-sentinel.conf"




sed -i "" "s#\/opt\/redis\/redis-sentinel#${APP_BASE}#g" node6379/redis.conf
sed -i "" "s#/opt/redis/redis-sentinel#${APP_BASE}#g" node6379/redis-sentinel.conf
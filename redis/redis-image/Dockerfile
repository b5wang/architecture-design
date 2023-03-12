FROM redis:6.2
COPY redis.conf /etc/redis/redis.conf
COPY sentinel.conf /etc/redis/sentinel.conf
CMD [ "redis-server", "/etc/redis/redis.conf" ]
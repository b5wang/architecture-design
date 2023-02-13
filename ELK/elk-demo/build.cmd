docker-compose down -v

rmdir logstash\data
rmdir logstash\logs
rmdir elasticsearch\data
rmdir elasticsearch\plugins

mkdir logstash\data
mkdir logstash\logs
mkdir elasticsearch\data
mkdir elasticsearch\plugins

docker-compose build
docker-compose up -d
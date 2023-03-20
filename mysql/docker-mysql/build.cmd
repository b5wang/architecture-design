# windows cmd

docker-compose down -v
rmdir mysql-single\data /s /q
mkdir mysql-single\data
docker-compose build --no-cache
docker-compose up -d
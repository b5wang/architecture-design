# windows cmd
docker-compose down -v
rmdir mysql-single\data
mkdir mysql-single\data
docker-compose build
docker-compose up -d
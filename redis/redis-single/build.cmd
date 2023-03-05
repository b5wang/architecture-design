#windows cmd
docker-compose down -v
rmdir data
mkdir data
docker-compose build
docker-compose up -d
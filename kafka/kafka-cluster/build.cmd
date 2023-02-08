#windows cmd

docker-compose down -v

rmdir kafka1\data
rmdir kafka2\data
rmdir kafka3\data

mkdir kafka1\data
mkdir kafka2\data
mkdir kafka3\data

docker-compose build
docker-compose up -d
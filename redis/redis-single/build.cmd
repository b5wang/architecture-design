#windows cmd

docker-compose down -v

rmdir zoo1\data
rmdir zoo2\data
rmdir zoo3\data
rmdir zoo1\datalog
rmdir zoo2\datalog
rmdir zoo3\datalog

mkdir zoo1\data
mkdir zoo2\data
mkdir zoo3\data
mkdir zoo1\datalog
mkdir zoo2\datalog
mkdir zoo3\datalog

docker-compose build
docker-compose up -d
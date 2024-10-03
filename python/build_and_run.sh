echo "Going to remove docker image"
docker rmi -f fbcrapper

echo "Going to build docker image"
docker build -t fbcrapper:latest .

echo "Going to run fb scrapper server"
docker run -d -p 5001:5001 fbcrapper

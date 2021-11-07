# rest-user-store
Technical Test


# Setup MySQL on Docker
- docker pull mysql
- docker run -p 3306:3306 --name mysql -e MYSQL_ROOT_PASSWORD=12345678 -e MYSQL_DATABASE=user_store -e MYSQL_PASSWORD=12345678 -d mysql:5.6

# Build Application Jar
- ./gradlew bootJar


# Setup Spring Application on Docker
- docker build . -t rest-user-store
- docker run -p 8080:8080 --name rest-user-store --link mysql:mysql rest-user-store

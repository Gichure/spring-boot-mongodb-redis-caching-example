# Spring Boot + MongoDB + Redis Caching Example
## Setting up
-  Ensure MongoDB Is running. You can run a docker image
-  Ensure Redis is running. You can run a docker image
- Clone this repository
- cd to the root folder for the project
- Run the command mvn clean spring-boot:run

```

docker run -d --name mongo-on-docker -p 27017:27017 mongo
docker run -d --name redis-on-docker -p 6379:6379 redis
cd working_directory
git clone https://gitlab.com/pgichure/spring-boot-mongodb-redis-caching-example.git
cd spring-boot-mongodb-redis-caching-example
mvn clean spring-boot:run
```

omeone may choose to fork your project or volunteer to step in as a maintainer or owner, allowing your project to keep going. You can also make an explicit request for maintainers.

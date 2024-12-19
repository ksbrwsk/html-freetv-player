# html-freetv-player
#### simple html5 german free tv player

![Java CI with Maven](https://github.com/ksbrwsk/html-freetv-player/workflows/Java%20CI%20with%20Maven/badge.svg)

**Prerequisites:**
* [Java 21](https://openjdk.net/)
* [Apache Maven](https:http://maven.apache.org/)

> ⚠️ **Currently only working on Apple Safari, no Chrome or Edge support yet!**

**Themes:**
* Spring MVC
* Thymeleaf
* Bootstrap

#### How to build and run
Type
```bash
mvn package
mvn spring-boot:run
```
to build and run the application on your local environment.

Point your browser to
```bash
http://localhost:8080
```
to try out the player.

docker build -t html-freetv-player .
docker run -d --name html-freetv-player -p 9070:8080 html-freetv-player

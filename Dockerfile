FROM eclipse-temurin:21-alpine
MAINTAINER kai.saborowski@googlemail.com

EXPOSE 8080
RUN mkdir -p /app/
RUN mkdir -p /app/logs/
ADD target/html-freetv-player-1.0.0-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java","-Xms768M","-Dspring.profiles.active=ssl", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/app.jar"]
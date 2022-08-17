FROM amazoncorretto:18.0.2-alpine

LABEL maintainer="Ivan Andreev"

EXPOSE 8080

WORKDIR /usr/local/bin/

COPY ./target/fleetman-0.0.1-SNAPSHOT.jar webapp.jar

CMD ["java", "-Dspring.profiles.active=docker-demo", "-jar", "webapp.jar"]
FROM openjdk:8-jre-alpine
ENV WEB_PORT=9090 DB_HOST=localhost DB_USER=root DB_PASSWORD=123456
VOLUME /tmp
ADD hotelmanagement-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
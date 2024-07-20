# Dockerfile for FirstApplication
FROM openjdk:17
WORKDIR /app
COPY target/myfirstservice.jar /app/myfirstservice.jar
ENTRYPOINT ["java", "-jar", "myfirstservice.jar"]
EXPOSE 8080

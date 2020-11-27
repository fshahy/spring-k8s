FROM openjdk:11-slim

LABEL maintainer="Farid Shahy <fshahy@gmail.com>"

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
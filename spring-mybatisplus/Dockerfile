FROM openjdk:8-jdk-alpine
EXPOSE 8080

ADD target/${JAR_FILE} /docker/projects/app.jar

ENTRYPOINT ["java", "-jar", "/docker/projects/app.jar"]
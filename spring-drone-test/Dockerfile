FROM openjdk:8-jdk-alpine
WORKDIR /app
EXPOSE 8088
COPY /app/target/*.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
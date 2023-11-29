FROM maven:3.9.4-jdk-8 as builder 
COPY . /app
WORKDIR /app
RUN mvn clean package dockerfile:build

FROM openjdk:8-jdk-alpine
COPY --from=builder /app/target/*.jar /app/app.jar
EXPOSE 8282
ENTRYPOINT ["java","-jar","/app/app.jar"]

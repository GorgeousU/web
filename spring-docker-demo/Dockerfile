FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8282
ARG JAR_FILE
ADD target/${JAR_FILE} /docker/projects/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/docker/projects/app.jar"]

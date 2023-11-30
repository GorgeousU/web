FROM registry.cn-shenzhen.aliyuncs.com/mogu-zh/jdk:8-mogu-alpine
EXPOSE 8088
COPY *.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
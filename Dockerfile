FROM openjdk:10-jre-slim
COPY ./target/*.jar /tmp/app.jar
WORKDIR /tmp/
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "app.jar"]
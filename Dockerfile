FROM eclipse-temurin:21.0.5_11-jre
MAINTAINER "Abhishek M"
COPY target/tms-service-configuration.jar  /app/app.jar
WORKDIR /app
ENTRYPOINT ["java", "-jar", "app.jar"]

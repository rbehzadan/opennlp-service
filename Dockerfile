FROM openjdk:8-jre-alpine

EXPOSE 6003

COPY target/libs /app/libs
COPY models /app/models
COPY target/opennlp-service-1.0.jar /app
WORKDIR /app

CMD ["java", "-jar", "opennlp-service-1.0.jar"]

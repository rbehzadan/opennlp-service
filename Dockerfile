FROM openjdk:13-alpine

WORKDIR /app

COPY . /app

RUN apk add --no-cache maven wget \
 && mkdir /app/models && cd /app/models && wget -i ../models.url \
 && cd /app && mvn clean package \
 && apk del maven wget \
 && rm -rf /var/cache/apk/*

EXPOSE 80

CMD ["java", "-jar", "target/opennlp-service-1.0.jar"]

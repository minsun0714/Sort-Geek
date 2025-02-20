FROM openjdk:17-jdk-slim

RUN apt-get update && apt-get install -y \
    iputils-ping \
    netcat \
    default-mysql-client \
    && rm -rf /var/lib/apt/lists/*

WORKDIR /app
COPY build/libs/sort-geek-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9090
CMD ["java", "-jar", "app.jar", "--server.port=9090"]

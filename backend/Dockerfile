FROM openjdk:17
WORKDIR /app
COPY build/libs/sort-geek-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9090
CMD ["java", "-jar", "app.jar", "--server.port=9090"]

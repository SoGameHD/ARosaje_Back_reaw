FROM maven:3.6.1-jdk-8-slim AS build
WORKDIR /app
COPY . .
RUN mvn -f pom.xml clean package

FROM openjdk:11-jre-slim
WORKDIR /app
COPY --from=build /app/target/my-app.jar ./app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]

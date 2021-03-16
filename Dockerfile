FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD
MAINTAINER farouq
COPY . /interview-test-casino/

WORKDIR /interview-test-casino/
RUN mvn clean install
FROM openjdk:8-jre-alpine

EXPOSE 8080:8080
WORKDIR /app/
COPY --from=MAVEN_BUILD /interview-test-casino/target/casino-0.0.1-SNAPSHOT.jar /app/
ENTRYPOINT ["java", "-jar", "casino-0.0.1-SNAPSHOT.jar"]
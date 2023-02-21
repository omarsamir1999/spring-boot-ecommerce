
FROM maven:3.8.2-jdk-18 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:18

LABEL maintainer="javaguides.net"

ADD target/spring-boot-ecommerce-0.0.1-SNAPSHOT.jar spring-boot-ecommerce.jar
ENTRYPOINT ["java" , "-jar" , "spring-boot-ecommerce.jar"]
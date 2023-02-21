FROM openjdk:18

LABEL maintainer="javaguides.net"

ADD target/spring-boot-ecommerce-0.0.1-SNAPSHOT.jar spring-boot-ecommerce.jar
EXPOSE 8081
ENTRYPOINT ["java" , "-jar" , "spring-boot-ecommerce.jar"]
FROM openjdk:18

LABEL maintainer="javaguides.net"

COPY --from=build target/spring-boot-ecommerce-0.0.1-SNAPSHOT.jar spring-boot-ecommerce.jar

ENTRYPOINT ["java" , "-jar" , "spring-boot-ecommerce.jar"]
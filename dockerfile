FROM openjdk:8
EXPOSE 9000
ADD target/demohsbcapp-0.0.1-SNAPSHOT.jar demohsbcapp-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/demohsbcapp-0.0.1-SNAPSHOT.jar"]

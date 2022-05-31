FROM openjdk:8-jdk

COPY /target/urna-0.0.1-SNAPSHOT.jar /urna.jar

EXPOSE 8080

CMD ["java", "-jar", "/urna.jar"]


FROM openjdk:8
ADD target/logica-rh.jar logica-rh.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "logica-rh.jar"]

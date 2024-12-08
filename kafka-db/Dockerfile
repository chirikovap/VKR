FROM docker.io/eclipse-temurin:17.0.7_7-jre

WORKDIR /app
COPY target/demo-0.0.1-SNAPSHOT.jar /app/demo-0.0.1-SNAPSHOT.jar
EXPOSE 8182/tcp
CMD ["java", "-XX:+UseG1GC", "-jar", "demo-0.0.1-SNAPSHOT.jar"]
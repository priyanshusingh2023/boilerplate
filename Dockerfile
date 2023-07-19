FROM openjdk:11

ADD ./target/HealthMonitoring-server-0.0.1-SNAPSHOT.jar /usr/src/HealthMonitoring-server-0.0.1-SNAPSHOT.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "HealthMonitoring-server-0.0.1-SNAPSHOT.jar"]


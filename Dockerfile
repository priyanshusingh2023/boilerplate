FROM openjdk:11

ADD ./target/boilerplate.jar /usr/src/boilerplate.jar

WORKDIR usr/src

ENTRYPOINT ["java","-jar", "boilerplate.jar"]


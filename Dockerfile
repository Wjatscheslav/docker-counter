FROM maven:3.6.1-jdk-8

WORKDIR '/app'
COPY ./pom.xml .
COPY ./src ./src

CMD mvn spring-boot:run
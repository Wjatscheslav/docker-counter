FROM maven:3.6.1-jdk-8

WORKDIR /app
COPY ./pom.xml .
RUN mvn dependency:go-offline -B

COPY ./src ./src
RUN mvn package

CMD java -jar -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005 target/docker-demo-0.0.1-SNAPSHOT.jar
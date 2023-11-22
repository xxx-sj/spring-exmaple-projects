FROM openjdk:11-jdk
COPY ./build/libs/docker-example-0.0.1-SNAPSHOT.jar /build/libs/docker-example-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "/build/libs/docker-example-0.0.1-SNAPSHOT.jar"]
#WORKDIR /app

#ARG PATH=./build/libs

#COPY ${PATH}/docker-example-0.0.1-SNAPSHOT.jar ${PATH}/docker-example-0.0.1-SNAPSHOT.jar
#CMD ["java", "-jar", "./build/libs/docker-example-0.0.1-SNAPSHOT.jar"]
#WORKDIR /app
#ARG JAR_FILE=build/libs/docker-0.0.1-SNAPSHOT.jar
#ADD ${JAR_FILE} docker-springboot.jar

#ENTRYPOINT ["java", "-Djava.securiy"]

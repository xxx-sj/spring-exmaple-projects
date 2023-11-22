FROM openjdk:11-jdk
ARG PATH=./build/libs
WORKDIR /app
COPY ${PATH}/docker-example-0.0.1-SNAPSHOT.jar ${PATH}/docker-example-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "./build/libs/docker-example-0.0.1-SNAPSHOT.jar"]


#COPY ${PATH}/docker-example-0.0.1-SNAPSHOT.jar ${PATH}/docker-example-0.0.1-SNAPSHOT.jar
#CMD ["java", "-jar", "./build/libs/docker-example-0.0.1-SNAPSHOT.jar"]
#ADD ${JAR_FILE} docker-springboot.jar
#ENTRYPOINT ["java", "-Djava.securiy"]

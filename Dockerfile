FROM eclipse-temurin:17
WORKDIR /app
COPY build/libs/semestralka-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9000
ENTRYPOINT [ "java" , "-jar" , "app.jar" ]
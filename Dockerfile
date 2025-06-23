FROM gradle:8.10.2-jdk21 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon


FROM openjdk:21
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/logoutput.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/logoutput.jar"]

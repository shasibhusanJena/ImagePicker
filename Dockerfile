# define base docker image
FROM openjdk:17
EXPOSE 8080
ADD target/ImagePicker-1.0.0-SNAPSHOT.jar ImagePicker-1.0.0-SNAPSHOT.jar
ENTRYPOINT [ "java", "-jar","/ImagePicker-1.0.0-SNAPSHOT.jar" ]
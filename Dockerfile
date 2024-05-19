# define base docker image
FROM openjdk:17
EXPOSE 8080
ADD target/imagepicker.jar imagepicker.jar
ENTRYPOINT [ "java", "-jar","/imagepicker.jar" ]
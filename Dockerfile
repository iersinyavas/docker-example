FROM openjdk:8-jdk-alpine
ADD target/*.jar app.jar
#ARG DEPENDENCY=target/dependency
#COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY ${DEPENDENCY}/META-INF /app/META-INF
#COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["sh","-c","java -jar /app.jar"]
#ENTRYPOINT ["sh","-c","app:app/lib/*","com.artsoft.examapp.appsdk.AppSdkApplication"]



FROM openjdk:8-jdk-alpine
ADD target/*.jar app.jar
#ARG DEPENDENCY=target/dependency
#COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
#COPY ${DEPENDENCY}/META-INF /app/META-INF
#COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["sh","-c","java -jar /app.jar"]
#ENTRYPOINT ["sh","-c","app:app/lib/*","com.artsoft.examapp.appsdk.AppSdkApplication"]



#docker container run -p 7070:9090 --link=mysqldb -e RDS_HOSTNAME=mysqldb --name examapp iersinyavas/examapp:0.0.1
#yukarıdaki komut sayesinde mysqldb containeri ayağa kalktı --link=mysqldb -e RDS_HOSTNAME=mysqldb

#docker run -d -e MYSQL_ROOT_PASSWORD=iersinyavas -e MYSQL_DATABASE=mysqldb -e MYSQL_USER=iersinyavas -e MYSQL_PASSWORD=iersinyavas -p 3306:3306 --network=network1 --volume=mysqldb-volume:/var/lib/mysql --name mysqldb mysql
#volume ve network eklendi. Böylece--link=mysqldb ye gerek kalmadı

#docker container run -p 7070:9090 --network=network1 -e RDS_HOSTNAME=mysqldb  --name examapp iersinyavas/examapp:1
#network ekleyince linke gerek kalmıyor.
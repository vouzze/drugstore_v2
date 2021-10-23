FROM openjdk:11
EXPOSE 8080
ADD target/drugstore_v2-0.0.1-SNAPSHOT.jar drugstore_v2-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/drugstore_v2-0.0.1-SNAPSHOT.jar"]
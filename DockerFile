FROM openjdk:8
ADD build/libs/rest-user-store-0.0.1-SNAPSHOT.jar rest-user-store.jar
ENTRYPOINT ["java","-jar","rest-user-store.jar"]
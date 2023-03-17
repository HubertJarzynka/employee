FROM openjdk:17
COPY target/*.jar /Users/hubert/Downloads/employee/target/employee-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/Users/hubert/Downloads/employee/target/employee-0.0.1-SNAPSHOT.jar"]
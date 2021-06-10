**EMPLOYEE DATA - SPRING BOOT APPLICATION**

Description : This project demonstrates CRUD (Create, Read, Update, Delete) operations using spring boot and H2 in-memory database. In this app we are using Spring Data JPA for built-in methods to do CRUD operations.

**Prerequisites:**
  Java - 9 & above
  Spring Boot
  Maven
  H2 Database
  Lombok (For getting rid of boiler plate)
  Hexagonal Architecture (https://alistair.cockburn.us/hexagonal-architecture/)

**Running the application in local:**
(in the project folder go to) ~/absolute-path-to-directory/employee-detail-service

and try below command in terminal
mvn spring-boot:run it will run application as spring boot application

or

mvn clean install it will build application and create jar file under target directory

Run jar file from below path with given command

java -jar ~/<employee-detail-service-path>/target/employee-detail-service-0.0.1-SNAPSHOT.jar

Or

run main method from EmployeeDetailApplication.java as spring boot application.

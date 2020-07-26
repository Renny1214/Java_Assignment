## Rest API's for Employee Management

####``Requirements``

1. JDK 1.8
2. Maven 3

####``Running the application ``

To run the application execute the run.bat file in package folder.



####``Dependencies used``


1.  log4j-core
2.  log4j-api
3.  spring-boot-starter-data-jdbc
4.  spring-boot-starter-data-jpa
5.  spring-boot-starter-web
6.  spring-boot-starter-test
7.  mysql-connector-java
8.  hibernate-core
9.  springfox-swagger2
10. springfox-swagger-ui



####``Features``
These services can perform,

   1. Employee CRUD operations.
   
     > GET Method 
       Api -  /employee
       Discription - returns the employee of the provided designation
      
     > POST Method
       Api - /employee
       Discription - enters the employee into the table
       Demo json - [
                       {
                           "date_of_joining": "2020-07-26T06:25:38.225Z",
                           "designation": "trainee",
                           "email": "abc@gmail.com",
                           "name": "abc",
                           "phone": "9876543210",
                           "reporting_manager": "xyz",
                           "team": "operations",
                       }
                   ] 
                   
      > GET Method
        Api - /employee/
        Discription - returns the list of all employees
        
      > DELETE Method
        Api - /employee/{id}
        Description - deletes the employee with the given id
      
      > GET Method
        Api - /employee/{id}
        Description - returns the employee of the given id
        
      > PUT Method
        Api - /employee/{id}
        Description - update the employee with the given id
        Demo json - [
                          {
                               "date_of_joining": "2020-07-26T06:25:38.225Z",
                               "designation": "trainee",
                               "email": "abc@gmail.com",
                               "name": "abc",
                               "phone": "9876543210",
                               "reporting_manager": "xyz",
                               "team": "operations",
                          }
                     ] 
      
   




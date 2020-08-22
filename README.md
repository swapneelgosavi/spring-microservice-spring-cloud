## spring-microservice-spring-cloud
#### Dependencies Used : Spring Boot, Spring REST, Spring JPA, Spring Actuator, H2 Database, Spring-Cloud-Config-Server, Neflix Eureka Server & Client, Spring Openfeign, Neflix Ribbon, Netflix Zuul, Spring Sleuth, Spring Zipkin and RabbitMQ, Netflix Hystrix  

Microservice project comprising different components of Spring Cloud. This is microservice cloud ready project.
It has features like :
  1. Inter-communication between microservices using **Spring Openfeign REST client**
  2. Microservice Configuration with Centralized **Spring Cloud Config Server**
  3. Exchange messages about Configuration updates from Spring Cloud config server using **Spring Cloud Bus**
  5. Client side load balancing with **Ribbon**
  6. Dynamic scaling using **Eureka Naming Server and Ribbon**
  7. API Gateway with **Netflix Zuul**
  8. Distributed tracing with **Spring Cloud Sleuth and (Zipkin : TODO)**
  9. Fault Tolerance with **netflix Hystrix**


 #### Project Description :
  1. security-details-service : Service return's list of security. But it returns all securities between the min and max value of security turnover. Min and Max value 
  of turnover limit is stored in property file which is managed by spring-cloud-config-server.
 
  2. spring-cloud-config-server : Stores the configuration of security-details-service.
        
        ```
          security-details-service.minturnover=200
          security-details-service.maxturnover=250
        ```
   3. turnover-cal-service : This service is dependent on  security-details-service. turnover-cal-service get list of securities from  security-details-service and returns total sum of turnover's of all securities returned by security-details-service.      
 
   4. netflix-eureka-naming-server: Naming registry server
   5. netflix-zuul-api-gateway-server : Requests from turnover-cal-service for security-details-service are routed thru API gateway server.
 

 Following are the components/applications in the project (Order of starting application's should be as follow ):
 
 | Application Names                     | Ports Used     |  URLS                                              |URL via API Gateway                          |
 | ------------------------------------- | -------------- | -------------------------------------------------- |---------------------------------------------
 |Zipkin Server (TODO)                   |(TODO)          |                                                    |   |
 |netflix-eureka-naming-server           |8761            |http://localhost:8761/                              ||
 |netflix-zuul-api-gateway-server        |8765            |                                                    ||
 |spring-cloud-config-server             |8888            |http://localhost:8888/security-details-service/turnover-range  ||
 |security-details-service               |(8080,8081,..)  |http://localhost:8080/getsecurity/                  |http://**localhost:8765**/security-details-service/getsecurity/|
 |turnover-cal-service                   |(8000,8001,..)  |http://localhost:8000/get-turnover                  |http://**localhost:8765**/turnover-cal-service/get-turnover/|
 

 #### Project HLD1 :
 
 ![alt text](https://github.com/swapneelgosavi/spring-microservice-spring-cloud/blob/master/readme_images/HLD.JPG)
 
 #### Project HLD2 :
 
 ![alt text](https://github.com/swapneelgosavi/spring-microservice-spring-cloud/blob/master/readme_images/HLD2.JPG)

 #### Project HLD3 (client side load balancing):
 
 ![alt text](https://github.com/swapneelgosavi/spring-microservice-spring-cloud/blob/master/readme_images/HLD3.JPG)


 #### Sample Output :
  1. security-details-service : 
     ```
       0	
        id	4
        scriptName	"RBS"
        securityFullName	"RBS FULL"
        turnover	200
        faceValue	15
        port	8080
      1	
        id	5
        scriptName	"NFS"
        securityFullName	"NFS FULL"
        turnover	250
        faceValue	16
        port	8080
     ``` 
 
  2. turnover-cal-service :
  
      ```
        totalTurnover	450
        maxTurnover	250
        maxTurnoverScriptName	"NFS"
        minTurnover	200
        minTurnoverScriptName	"RBS"
        port	8080
      ```
  
  
    
     ```
     ```
 



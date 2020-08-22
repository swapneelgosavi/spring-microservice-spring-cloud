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

 Following are the components/applications in the project (Order of starting applicatio should be as follow ):
 
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


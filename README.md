## spring-microservice-spring-cloud
#### Dependencies Used : Spring Boot, Spring REST, Spring JPA, Spring Actuator, H2 Database, Spring-Cloud-Config-Server, Neflix Eureka Server & Client, Spring Openfeign, Neflix Ribbon, Netflix Zuul, Spring Sleuth, Spring Zipkin and RabbitMQ, Netflix Hystrix  

Microservice project comprising differnet components of Spring Cloud. This is microservice cloud ready project.
It has features like :
  1. Inter-communication between microservices using **Spring Openfeign REST client**
  2. Microservice Configuration with Centralized **Spring Cloud Config Server**
  3. Exchange messages about Configuration updates from Spring Cloud config server using **Spring Cloud Bus**
  5. Client side load balancing with **Ribbon**
  6. Dynamic scaling using **Eureka Naming Server and Ribbon**
  7. API Gateway with **Netflix Zuul**
  8. Distributed tracing with **Spring Cloud Sleuth and Zipkin** (TODO)
  9. Fault Tolerance with **netflix Hystrix**

 Following are the components/applications in the project (Order of starting applicatio should be as follow ):
 
 | Application Names                     | Ports Used     |  URLS                                              |
 | ------------------------------------- | -------------- | -------------------------------------------------- |
 |Ziplin Server (TODO)                   |(TODO)          |                                                    |   
 |netflix-eureka-naming-server           |8761            |                                                    |
 |netflix-zuul-api-gateway-server        |8765            |                                                    |
 |spring-cloud-config-server             |8888            |                                                    |
 |security-details-service               |(8080,8081,..)  |                                                    |
 |turnover-cal-service                   |(8001,8002,..)  |                                                    |
 

 Project HLD :
 
 

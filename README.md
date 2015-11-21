# SpringCloudGettingStarted:

##Paths:
RestController(RestTemplate, endpoint /gateway/messages)->Ribbon->Histrix->Eureka->BackEnd<br />
Feign(BlogInterface, endpoint /gateway/posts)->Ribbon->Histrix->Eureka->BackEnd<br />
Zuul(service name as endpoint)->Ribbon->Histrix->Eureka->BackEnd<br />

##StartUp:
1. config-client (port 9000)<br />
    spring-boot:run
2. eureka-server (ports 9001 server1 and 9002 server2)<br />
    spring-boot:run -Dspring.profiles.active=default,server1<br />
    spring-boot:run -Dspring.profiles.active=default,server2<br />
3. back-end (restful-blog) (ports 9003, 9004, 9005)<br />
    spring-boot:run -Dspring.profiles.active=default,server1<br />
    spring-boot:run -Dspring.profiles.active=default,server2<br />
    spring-boot:run -Dspring.profiles.active=default,server3<br />
4. front-end (blog-client) (port 9010)<br />
    spring-boot:run<br />
5. hystix-dashboard (port 9011)<br />
    spring-boot:run<br />
    

##config server wiki:<br />
eureka wiki: https://github.com/Netflix/eureka/wiki<br />
histrix wiki: https://github.com/Netflix/Hystrix/wiki<br />
zuul wiki: https://github.com/Netflix/zuul/wiki<br />
ribbon wiki: https://github.com/Netflix/ribbon<br />
feign wiki: https://github.com/Netflix/feign<br />

##Useful links: 
http://cloud.spring.io/spring-cloud-config/spring-cloud-config.html   
http://cloud.spring.io/spring-cloud-netflix/spring-cloud-netflix.html

<!--- ![alt tag]() ---> 
Issue Creation Service
===================================

[![Quality Gate](https://dp-myplant-build-sonar1.dev.power.ge.com/sonar/api/badges/gate?key=myplant-issue-creation-rules-service)](https://dp-myplant-build-sonar1.dev.power.ge.com/sonar/dashboard/index/myplant-issue-creation-rules-service)  

The Issue Creation Service is a myPlant micro-service. It allows to manage issue rules. These rules are used to 
define whether an Issue should be automatically created. The rules are related to certain assets and analytic items.



### API documentation
The API documentation can be found under [http://domain:port/swagger-ui.html](http://domain:port/swagger-ui.html)

### Start the application
`java -jar issue-creation-rules.jar -Dspring.profiles.active=dev`

### Configuration
The configuration depends on the environment variable `spring.profiles.active=dev`. Supported values are dev, staging 
and production. Based in the value of the environment variable, the corresponding properties file gets picked up. The 
technical and common configuration settings are in `application.properties`. Environment specific settings are stored in 
the related application-(dev|staging|production).properties file. 


# Spring Boot Api to calculate profit of an casino

# Usage 
### Run Spring Boot application
* build the project
```
mvn clean install 
```
* Run it on local 
```
mvn spring-boot:run
```

### Run the project on docker 
```
docker build -t casino .
```

```
docker container run --name casino   -p 8080:8080 casino
```

## Call the endpoint and get the result 
* Endpoint : `localhost:8080/api/v1/casino/profit`
* Send the file as `file` in the body
* Response sample :
![Alt text](api_response.png?raw=true "API response")

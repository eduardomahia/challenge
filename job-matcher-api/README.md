# JOB MATCHER API

## Requirements
* Maven 3.6
* Java 11

## TO START IT
Execute the following command in the root folder:
```
mvn clean install
spring-boot:run
```

## TO TEST THE API

### POSTMAN COLLECTION
Postman collection attached to project's resource folder (<root>/src/main/resources/postman)

### ACCESS
* USER: swipejobs
* PASSWORD: candidates

### EXAMPLE REQUESTS
#### GET WORKERS
```
curl --location --request GET 'http://localhost:8080/job-matcher/api/v1/workers' \
--header 'Authorization: Basic c3dpcGVqb2JzOmNhbmRpZGF0ZXM=' 
```
#### GET JOBS
```
curl --location --request GET 'http://localhost:8080/job-matcher/api/v1/jobs' \
--header 'Authorization: Basic c3dpcGVqb2JzOmNhbmRpZGF0ZXM='
```
#### GET WORKER JOBS
```
curl --location --request GET 'http://localhost:8080/job-matcher/api/v1/workers/10/jobs' \
--header 'Authorization: Basic c3dpcGVqb2JzOmNhbmRpZGF0ZXM='
```

## EXERCISE
To understand more about the API requirements and functionality, read the following exercise:
```
App is all about matching Jobs to Workers. With that in mind, our challenge is for you to develop a simple matching engine that presents Workers with appropriate Jobs. We will provide a REST API for this task – /workers, which provides the list of all available Workers and /jobs which provides a list of all available Jobs. Your task is to produce your own REST API matches that will take a workerId and return no more than three appropriate jobs for that Worker.
You may use any technology stack that you’d like to solve this problem. We are most interested in the quality of the matching, as well as the readability of your code.

https://test.swipejobs.com/api/workers

https://test.swipejobs.com/api/jobs
```

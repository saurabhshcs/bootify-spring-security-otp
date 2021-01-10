# bootify-spring-security-otp

This application is discarded as I leveraged my existing application for JWT token based authentication. I have added an email api into that send successfully send that jwt token to the mentioned email and it works perfectly.

So please refer my another repo i.e. bootifyjpajwt

However I keep this repo for OTP generator API reference.

Many thanks

# How to run this application

## Machine Prerequisite
- Java 8 or later
- Docker
- Docker compose

Both docker and docker compose come with an installation of Docker Desktop. 


To clone this repository AND all submodules execute the following:
```
git clone https://github.com/saurabhshcs/bootify-aws.git
```

## Local environment

In order to run the Integration tests a Postgres database is required.

In order to run this service locally, an ActiveMQ service is required. 

Create Postgres database and ActiveMQ service with docker-compose:
 
```
docker-compose up -d
```

This will install and setup Postgres database with correct database name, username and password,
likewise for ActiveMQ.

### Running service for the first time
In order to force the download of dependencies outside of IntelliJ:

`./gradlew build --refresh-dependencies`

### Run any service

`./gradlew bootRun`

### Test and build

#### Run tests (also runs big tests)
`./gradlew clean test`

#### Run big tests only
`./gradlew clean bigTest`

#### Build conditionally on tests
`./gradlew clean build`  


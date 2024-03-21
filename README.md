# CS544-EA project

## Get Started

### Install

1. Install [https://github.com/vytaux/common-base-module](https://github.com/vytaux/common-base-module).
2. Run these commands from the project root:
   
```
$ docker compose up -d
```

## Run

```
$ mvn spring-boot:run
```

## Authenticating Requests

Security is implemented with Spring OAuth. Here are the steps how to authenticate with the api:
1. Navigate to the API with the browser - you will be asked to login.
2. After logging in, get the JSESSIONID cookie. To do this in developer tools, go to Application->Cookies.
3. On Postman, in headers section, add Cookie containing "JSESSIONID=$cookieFromDeveloperTools".

## Developer Notes
Add this to your JVM options. This prevents orika mapper errors.

```
$ --add-opens java.base/java.lang=ALL-UNNAMED
```

### Running tests

Run the unit tests:

```
$ mvn clean test 
```

Run the integration tests:

```
$ mvn clean verify
```

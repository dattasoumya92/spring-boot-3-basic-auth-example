# Basic Authentication Example using Spring Boot 3.2.2 and Spring Security 6.2.1
 
## Description
- This application demonstrates securing RESTFUL apis with basic authentication. Here, four RESTful APIs are secured 
with basic auth. This app also demonstrates that basic auth can be bypassed on some URLs by using SecurtiyFilterChain, 
as done in `BasicAuthConfigurer` class.

- The basic auth username & password are configurable in the application.properties file.
- The password has been generated using an online Bcrypt [encoder](https://bcrypt-generator.com/). 

## Build
- Execute `.\mvnw.cmd clean package` to build the code.

## Run
- Execute `.\mvnw.cmd spring-boot:run` to run the app.

## Tests
- Use POSTMAN or any other API testing tool to test the following:
    - GET `/app/<name>`
        - Returns: Welcome `<name>`
    - POST `/app/`
        - Body: { "name": `<name>` }
        - Returns: OK
        - Prints `<name>` on console.
    - PUT `/app/`
        - Body: { "name": `<name>` }
        - Returns: OK
        - Prints `<name>` on console.
    - DELETE `/app/`
        - Body: { "name": `<name>` }
        - Returns: OK
        - Prints `<name>` on console.
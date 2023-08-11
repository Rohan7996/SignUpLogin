
# Login and Signup REST API

This project provides a backend implementation for a login and signup REST API with security and web tokens. It is built on Spring Boot and uses an H2 database for data storage.

## API Reference

#### Signup

```http
  POST api/v1/employee/hello
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `employeeid` | `string` | **AutoGenerated** |
| `employeename` | `string` | **Required** |
| `email` | `string` | **Required** |
| `password` | `string` | **Required** |


#### Login

```http
  POST api/v1/employee/login
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `email`      | `string` | **Required**. email of item to fetch |
| `password`      | `string` | **Required**.|




## Configurations

The application can be configured through the application properties file located in the src/main/resources directory. The following properties can be modified:

`spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=user
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true`
## Database

The H2 in-memory database is used for this project. You can access the H2 console by navigating to http://localhost:8080/h2-console. The default JDBC URL is jdbc:h2:mem:testdb, and the username is `user` with an empty `password`.
## Security
The project uses JSON Web Tokens (JWT) for authentication

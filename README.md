# User Service

This application provides template for CRUD operations of a User service in Java
and Spring Boot.

## Instructions to start the application

```sh
gradle bootRun
```

## Instructions to access and test the API endpoints

### Create a User

```sh
curl --verbose --request POST http://localhost:8080/api/users \
--header 'Content-Type: application/json' \
--data '{"name":"John Doe","age":34, "city": "Berlin"}' \
| json_pp | pygmentize -l json
```

### Get a User by Id

Replace /users/uuid with newly generated uuid on user creation

```sh
curl --verbose --request GET \
http://localhost:8080/api/users/cb646756-ae61-4c6d-abe5-f7f13d7f8f85 | json_pp \
| pygmentize -l json
```

### Get all Users

```sh
curl --verbose --request GET 'http://localhost:8080/api/users' \
| json_pp | pygmentize -l json
```

### Update a User

```sh
curl --verbose --request PUT 'http://localhost:8080/api/users/1' \
--header 'Content-Type: application/json' \
--data '{"name":"User number 36","age":24, "city": "Rourkela"}' \
| json_pp | pygmentize -l json
```

### Delete a User

```sh
curl --verbose --request DELETE 'http://localhost:8080/api/users/1' \
| json_pp | pygmentize -l json
```

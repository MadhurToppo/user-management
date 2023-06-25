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
curl -X POST \
http://localhost:8080/api/users \
-H 'Cache-Control: no-cache' \
-H 'Content-Type: application/json' \
-d '{"name":"User number 1","age":34, "city": "Mumbai"}' | json_pp
```

### Get a User by Id

```sh
curl -X GET \
http://localhost:8080/api/users/1 \
| json_pp | pygmentize -l json
```

# b_challenge_backend
## Description
##### Project for register user and history for posts.


### Swagger Directory
```url
http://localhost:8080/support/v1.0/swagger-ui/index.html
```

1.- Verify that new lines of code have unit tests.

2.- Build and run test, spotbugs.

```bash
mvn clean install
```

3.- VM options

```enviroment
 -Dspring.profiles.active=dev
```

4.- Environment
```Environment
MYSQL_HOST=localhost;MYSQL_PASSWORD=@P4ssw0rD;MYSQL_PORT=3306;MYSQL_USER=root
```

5.- User and pass authorization Basic:
```Environment
    user: admin
    password: admin
```

#### CURLS Example
1.-Get User
```curl
    curl --location 'http://localhost:8080/support/v1.0/bancom/users' \
    --header 'Cookie: JSESSIONID=D15CE6136FC958C70595A95F4E9064F3'
```
2.- Patch Post
```curl
    curl --location --request PATCH 'http://localhost:8080/support/v1.0/bancom/posts' \
    --header 'user-code: 1' \
    --header 'request-id: 550e8400-e29b-41d4-a716-446655440000' \
    --header 'request-date: 2023-11-05T01:30:00.000-05:00' \
    --header 'Content-Type: application/json' \
    --header 'Authorization: Basic YWRtaW46YWRtaW4=' \
    --header 'Cookie: JSESSIONID=E098692B2927C6CC1E60E72A619A2EC6' \
    --data '{
      "id": 5,
      "userId": 1,
      "text": "prueba 3"
    }'
```

### Docker
1.- Initializer database
```bash
    docker-compose up mysql
```
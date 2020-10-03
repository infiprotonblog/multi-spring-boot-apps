# multi-spring-docker
Deploying Multi Spring Apps in Docker using docker compose

## Spring App 1

Created a sample spring boot app, that has 1 API that takes a param and prints the input param.

```
http://localhost:8080/hello?msg=world
```
This API will just print the msg `Hello world`

## Spring App 2

Created another sample spring app, which uses Spring's rest template to invoke app1's endpoint

```
http://localhost:8090/invokeApp1
```
This api will invoke app 1 and get the message and prints it in spring app 2

## Docker compose

Created a docker-compose file that will build the images for both spring apps, and runs them together.

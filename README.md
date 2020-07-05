# Getting Started

### Introduction
eProduct service expose APIs (HATEOAS) for read/save resources such as Product, Category. Swagger-ui is rendered at runtime to make it easier to call APIs.


### Guides
Building jar file by maven
```sh
$ mvn clean install
```
Starting eOrder instance with "dev" profile with initialization of sample data.
```sh
$ cd target
...
$ java -jar ecom-product-{version}.jar --spring.profiles.active=dev
```
Access eDiscovery by http://localhost:8888/swagger-ui.html

### Noted CURL
-Get All Products
```sh
curl -X GET "http://localhost:8888/api/product" -H "accept: application/json"
```
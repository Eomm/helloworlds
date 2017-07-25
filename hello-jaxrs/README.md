# JAX-RS
**JAX-RS** (Java API for RESTful Web Services), is a set if APIs to developer REST service. JAX-RS is part of the Java EE6 (from version 1.1), and make developers to develop REST web application easily.

There main versions are:

|Version|Date|Main Changes|
|---|---|---|
|1.0|2008|RESTFul API|
|1.1|02/2011|[Become part of the JEE6](https://jcp.org/aboutJava/communityprocess/maintenance/jsr311/311changelog.1.1.html)|
|2.0|05/2013|Add client API, asynchronous response, HATEOAS, Bean Validation|
|2.1|Q1 2017|SSE (Server-Sent Events) Introduction|

The Java specification of this APIs are defined in the `javax.ws.rs` package, and the developing is simplified by annotations.

Popular JAX-RS implementations are:
+ Jersey 
+ RESTEasy

### Demo
In this project there are some services for common tasks aiming to coverage all the features of JAX-RS.

For testing the service simply run `mvn test`

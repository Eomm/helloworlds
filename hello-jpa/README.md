# JPA 2.1
**JPA** (Java Persistence Api) is a specification for provide an object/relational mapping (ORM) facility using Java domain model to manage a relational database.

The specification 2.1 was released in 22/05/2013, and it can be found here: [oracle.com](http://download.oracle.com/otndocs/jcp/persistence-2_1-fr-eval-spec/index.html)

This document describe all the functionality of JPA:
- Entity: lightweight persistent domain object and their relations and mapping;
- Entity operations: how manage all the entity instance lifecycle;
- Query language: define portable static or dynamic queries, independent of the database schema;
- Metamodel API: provides a set of interfaces for accessing managed class;
- Criteria API: construction of object-base query rather than Query Language;
- Persistence Contexts: fundamentals of the persistence logic;
- XML/Annotation for define the application domain model contract; 

The main reasons for use JPA is:
1. Productivity: the API provide fast CRUD (create, read, update, delete) operations, concurrency management;
2. Database independent;
3. Security over SQL-Injection;
4. Perfomance: cache, avoid unnecessary queries, clean code; 

The most famous implementations of JPA 2.1 are (alphabetical order):
- DataNucleus
- EclipseLink
- Hibernate
- OpenJPA 

### Demo
In this project are shown almost all the feature that JPA offer, without worrying about the database or the implementation of the spec used.
It is a `maven` project, and you can run with this instruction:

`mvn test`

If you have some suggest, comment or send me a message on GitHub, I will appreciate any feedback.
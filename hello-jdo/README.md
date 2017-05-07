# JDO
**JDO** (Java Data Objects) is a Java standard since 2001 developed by [Java Community Process](https://www.jcp.org/en/home/index) first, and Apache JDO open-source project after.
You can use JDO technology to store Java domain model instances into the persistent store. With JDO you can use persist the object in:
- direct file I/O
- serialization
- JDBC
- Enterprise JavaBeans (EJB)
- Bean-Managed Persistence (BMP)
- Container-Managed Persistence (CMP) entity beans
- Java Persistence API

The specs can be found on this [link](https://www.jcp.org/en/jsr/detail?id=243).

From the official documentation we can view the benefits of JDO:
- **Ease of use**: Application programmers can focus on their domain object model and leave the details of persistence (field-by-field storage of objects) to the JDO implementation. 
- **Portability**: Applications written with the JDO API can be run on multiple implementations without recompiling or changing source code. Metadata, which describes persistence behavior external to the Java source code including most commonly used features of O/R mapping, is highly portable. 
- **Database independence**: Applications written with the JDO API are independent of the underlying database. JDO implementations support many different kinds of transactional data stores, including relational and object databases, XML, flat files, and others. 
- **High performance**: Application programmers delegate the details of persistence to the JDO implementation, which can optimize data access patterns for optimal performance. 
- **Integration with EJB**: Applications can take advantage of EJB features such as remote message processing, automatic distributed transaction coordination, and security, using the same domain object models throughout the enterprise.

An implementation of JDO must pass all the TCK (Technology Compatibility Kit) tests, maintained by Apache JDO community.

A list of implementations are on the [Apache's site](https://db.apache.org/jdo/impls.html).

In this project are shown some base concepts of JDO, without worrying about the persistence.
                It is a `maven` project, and you can run with this instruction:

`mvn test`

If you have some suggest, comment or send me a message on GitHub, I will appreciate any feedback.
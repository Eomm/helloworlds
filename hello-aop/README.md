#AOP
**AOP** (Aspect Oriented Programming) want to reduce the duplication code and develop a 
solution for cross cutting concerns, common functionalities. 
This is an Aspect, that can to apply to the classes.

Some famous examples are:
 - logging
 - transactions
 - configuration
 - security
 - triggers

The main concept in the AOP-architecture is the **weaving**.
The weaving is the process of applying aspects to the objects, creating proxy objects. 
This operation can be done in different times:
1. Compile time: when you have the source code for an application, ajc will compile from source and produce woven class files as output;
2. Post Compile time: when you have to apply aspect on existing code;
3. Load-time weaving (LTW): is simply binary weaving defered until the point that a class loader loads a class file and defines the class to the JVM;

More details can be found on the [official documentation](http://www.eclipse.org/aspectj/doc/next/devguide/ltw.html)

For describe the concepts to keep in mind about aspect definition are:
 1. JoinPoint: are all the piece of code where the aspect can be applied to. 
 We can assume that JoinPoint is a synonymous of method. The join points are:
    - method call
    - method execution
    - constructor call
    - constructor execution
    - field get/set
    - initialization and pre-initialization
    - static initialization
    - handler
    - advice execution
 2. Advice: is an action taken by an aspect at a particular join point. Different types are:
    - around: run the aspect method's before and after the target join point;
    - before: run the aspect method's before the target join point;
    - after: run the aspect method's after the target join point regardless the exit status;
    - after Returning: run the aspect method's after the target join point if an exception isn't throws;
    - after Throwing: run the aspect method's after the target join point if an exception is throws;
 3. PointCut: a predicate that describe the pattern that matches join points;
 
 In the JoinPoint you can access the target method's and all his parameters.

###Demo
In this example we will use LTW for apply our demo aspect.
It is a `maven` project, and you can run with this instruction:

`mvn test`

The target isn't testing the AOP, but notice the functionalities and define a basic HOW-TO. 
For test an aspect you can refer to [this stackoverflow post](http://stackoverflow.com/questions/41389015/junit-tests-for-aspectj).

If you have some suggest, comment or send me a message on GitHub, I will appreciate any feedback.

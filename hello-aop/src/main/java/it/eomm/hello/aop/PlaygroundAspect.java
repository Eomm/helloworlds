package it.eomm.hello.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by Manuel Spigolon on 09/03/2017.
 */
@Aspect
public class PlaygroundAspect {

    // execute when run the this exact method signature
    @Before("execution(void it.eomm.hello.aop.apackage.DemoClass.doSomething())")
    public void logExactlyJoinpoint(JoinPoint joinPoint) {
        System.out.println("** Before *** logExactlyJoinpoint : " + joinPoint.getSignature().getName());
    }

    // execute with all DemoClass with method signature that start with `doSomething` and has one `String` parameter
    @Before("execution(* it.eomm.hello.aop.*.DemoClass.doSomething*(String))")
    public void logJoinpointWithOneParameter(JoinPoint joinPoint) {
        System.out.println("** Before *** logJoinpointWithOneParameter : " + joinPoint.getSignature().getName());
    }

    // execute for all methods with start with `doSomething` no matter the visibility and from 0 to n parameters
    @After("execution(* doSomething*(..))")
    public void logAllJoinpointStartWith(JoinPoint joinPoint) {
        System.out.println("** After *** logAllJoinpointStartWith : " + joinPoint.getSignature().getName() + '\n');
    }

    // execute for any package or subpackage `..`
    @Before("execution(* it.eomm.hello.aop.anotherpackage..*())")
    public void logAllAnotherPackage(JoinPoint joinPoint) {
        System.out.println("** Before *** logAllAnotherPackage : " + joinPoint.getSignature().getName());
    }

    // TODO @AfterThrowing

    // TODO @Pointcut("whitin(classname)")

    // TODO @Pointcut("args()")

    // TODO @Before("getAll() && gatName()")

}

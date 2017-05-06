package it.eomm.hello.aop.test;

import it.eomm.hello.aop.anotherpackage.AnotherClass;
import it.eomm.hello.aop.apackage.DemoClass;
import org.junit.Test;

/**
 * Created by Manuel Spigolon on 04/03/2017.
 */
public class TestAop {


    private DemoClass oneLogic = new DemoClass();

    private AnotherClass other = new AnotherClass();

    /**
     * <pre>
     * * Before *** logExactlyJoinpoint : doSomething
     * it.eomm.hello.aop.apackage.DemoClass doSomething
     * * After *** logAllJoinpointStartWith : doSomething
     *
     * it.eomm.hello.aop.apackage.DemoClass doSomethingPrivate
     * * After *** logAllJoinpointStartWith : doSomethingPrivate
     *
     * * Before *** logJoinpointWithOneParameter : doSomethingWithParameter
     * it.eomm.hello.aop.apackage.DemoClass doSomethingWithParameter(I am a parameter!)
     * * After *** logAllJoinpointStartWith : doSomethingWithParameter
     * </pre>
     */
    @Test
    public void testSimpleLogAspect() {
        DemoClass logic = new DemoClass();
        logic.doSomething();

        // also private methods can have some aspect
        logic.callPrivate();

        logic.doSomethingWithParameter("I am a parameter!");
    }

    /**
     * <pre>
     * * Before *** logExactlyJoinpoint : doSomething
     * it.eomm.hello.aop.apackage.DemoClass doSomething
     * * After *** logAllJoinpointStartWith : doSomething
     *
     * * Before *** logAllAnotherPackage : doSomething
     * it.eomm.hello.aop.anotherpackage.AnotherClass doSomething()
     * * After *** logAllJoinpointStartWith : doSomething</pre>
     */
    @Test
    public void testPackageAspcet() {
        oneLogic.doSomething();
        other.doSomething();
    }


}

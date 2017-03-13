package it.eomm.hello.aop.anotherpackage;

import it.eomm.hello.aop.util.SomeUtil;

/**
 * Created by Manuel Spigolon on 09/03/2017.
 */
public class AnotherClass {


    public void doSomething() {
        // this method do some stuff
        SomeUtil.log(this.getClass(), "doSomething()");
    }

    private void doSomethingPrivate() {
        // this is an hidden method
        SomeUtil.log(this.getClass(), "doSomethingPrivate()");
    }

    public void interceptParameter(String theParameter) {
        // this method accept a parameter
        SomeUtil.log(this.getClass(), "interceptParameter(" + theParameter + ")");
    }

}

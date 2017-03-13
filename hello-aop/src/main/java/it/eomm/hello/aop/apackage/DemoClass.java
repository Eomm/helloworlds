package it.eomm.hello.aop.apackage;

import it.eomm.hello.aop.util.SomeUtil;

/**
 * Created by Manuel Spigolon on 09/03/2017.
 */
public class DemoClass {


    public void doSomething() {
        // this method do some stuff
        SomeUtil.log(this.getClass(), "doSomething");
    }

    public void callPrivate() {
        doSomethingPrivate();
    }

    private void doSomethingPrivate() {
        // this is an hidden method
        SomeUtil.log(this.getClass(), "doSomethingPrivate");
    }

    public void doSomethingWithParameter(String theParameter) {
        // this method accept a parameter
        SomeUtil.log(this.getClass(), "doSomethingWithParameter(" + theParameter + ")");
    }

    public void doSomethingWithError() {
        SomeUtil.log(null, "doSomethingWithError");
    }

}

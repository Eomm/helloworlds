package it.eomm.hello.aop.util;

/**
 * Created by Manuel Spigolon on 09/03/2017.
 */
public class SomeUtil {

    private SomeUtil() {

    }

    public static void log(Class clazz, String message) {
        // easy work
        System.out.println(clazz.getName() + ' ' + message);
    }

}

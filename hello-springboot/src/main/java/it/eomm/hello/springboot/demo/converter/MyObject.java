package it.eomm.hello.springboot.demo.converter;

/**
 * Created by Manuel Spigolon on 10/10/2017.
 */
public class MyObject {

    private String myString;

    public MyObject() {
    }

    public MyObject(String myString) {
        this.myString = myString;
    }

    public String getMyString() {
        return myString;
    }

    public void setMyString(String myString) {
        this.myString = myString;
    }
}

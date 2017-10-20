package it.eomm.hello.springboot.demo.exception;

/**
 * Created by Manuel Spigolon on 20/10/2017.
 * I don't want extend Exception
 */
public class ApplicationException {

    private String message;
    private String applicationErrorField;

    public ApplicationException(String message, String applicationErrorField) {
        this.message = message;
        this.applicationErrorField = applicationErrorField;
    }

    public String getApplicationErrorField() {
        return applicationErrorField;
    }

    public void setApplicationErrorField(String applicationErrorField) {
        this.applicationErrorField = applicationErrorField;
    }
}

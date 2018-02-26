package it.eomm.hello.springboot.demo;

import org.springframework.boot.ExitCodeGenerator;

/**
 * Created by Manuel Spigolon on 30/07/2017.
 */
public class ExitException extends Exception implements ExitCodeGenerator {
    @Override
    public int getExitCode() {
        return -42;
    }
}

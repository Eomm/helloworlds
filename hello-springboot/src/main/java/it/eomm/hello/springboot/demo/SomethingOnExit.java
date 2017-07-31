package it.eomm.hello.springboot.demo;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * Created by Manuel Spigolon on 30/07/2017.
 */
@Component
public class SomethingOnExit {

    @PreDestroy
    public void onShoutdown() {
        System.out.println("The application is shouting down...");



    }

}

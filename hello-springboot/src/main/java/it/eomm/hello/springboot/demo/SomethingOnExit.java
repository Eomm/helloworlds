package it.eomm.hello.springboot.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

/**
 * Created by Manuel Spigolon on 30/07/2017.
 */
@Component
public class SomethingOnExit {

    private final static Logger log = LogManager.getLogger(SomethingOnExit.class);

    @PreDestroy
    public void onShoutdown() {
        log.warn("The application is shouting down...");


    }

}

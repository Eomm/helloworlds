package it.eomm.hello.springboot.demo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * Created by Manuel Spigolon on 09/11/2017.
 */
@Service
public class HeavyService {

    private final static Logger log = LogManager.getLogger(HeavyService.class);

    @Async
    protected CompletableFuture<String> heavyOperation() {
        try {
            log.info("Starting heavyOperation");
            Thread.sleep(5000);
            log.info("Ended heavyOperation");
            return CompletableFuture.completedFuture("done");
        } catch (InterruptedException e) {
            // wooo :(
            return CompletableFuture.completedFuture("error");
        }
    }
}

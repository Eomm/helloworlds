package it.eomm.hello.springboot.demo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by Manuel Spigolon on 20/10/2017.
 */
@RestController
@RequestMapping("/async")
public class AsyncController {

    private final static Logger log = LogManager.getLogger(AsyncController.class);

    @Autowired
    public HeavyService heavyService;

    @GetMapping("/no-wait")
    String noWait() throws ExecutionException, InterruptedException {
        CompletableFuture<String> result = heavyService.heavyOperation();
        // this will not wait the operation to complete
        log.info("Called heavyOperation method: " + result.getNow("absent"));
        return "heavyOperation started!!";
    }

    @GetMapping("/wait")
    String waiting() throws ExecutionException, InterruptedException {
        CompletableFuture<String> result = heavyService.heavyOperation();
        // calling result.get() will wait the operation to complete
        log.info("Wait heavyOperation method: " + result.get());
        return "heavyOperation started!!";
    }

    @GetMapping("/read")
    String read() throws ExecutionException, InterruptedException {
        CompletableFuture<String> result = heavyService.heavyOperation();

        // read the response
        result.handle((res, error) -> {
            log.info("Get the result: " + res);
            return res;
        });

        log.info("Called heavyOperation method: " + result.getNow("absent"));
        return "heavyOperation started!!";
    }

}

package it.eomm.hello.springboot.demo.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Manuel Spigolon on 20/10/2017.
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    private final static Logger log = LogManager.getLogger(ApiController.class);

    // routing like servlet mapping
    @GetMapping("/hello-world")
    String home() {
        log.info("Called home");
        return "Hello World!";
    }

    @GetMapping("/error")
    String error() throws NullPointerException {
        throw new NullPointerException("Ops, this is an error");
    }

}

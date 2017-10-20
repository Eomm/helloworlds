package it.eomm.hello.springboot.demo.controller;

import it.eomm.hello.springboot.demo.exception.ApplicationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Null;

/**
 * Created by Manuel Spigolon on 20/10/2017.
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    private final static Logger log = LogManager.getLogger(ApiController.class);

    // routing like servlet mapping
    @RequestMapping("/hello-world")
    String home() {
        log.info("Called home");
        return "Hello World!";
    }

    @RequestMapping("/error")
    String error() throws NullPointerException {
        throw new NullPointerException("Ops, this is an error");
    }

}

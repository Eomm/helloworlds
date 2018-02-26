package it.eomm.hello.springboot.demo.controller;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by Manuel Spigolon on 21/10/2017.
 */
@Component
@Path("/jax-rs")
public class JerseyController {

    @GET
    public String message() {
        return "Hello from JAX-RS";
    }

}

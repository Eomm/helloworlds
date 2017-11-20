package it.eomm.hello.springboot.demo.configuration;

import org.springframework.stereotype.Component;

/**
 * This class is only for documentation:
 * If you want to implement standard JAX-RS and Jersey REST endpoints you have to:
 * # add the spring-boot-starter-jersey to pom.xml
 * # uncomment the class below
 * This will demand all the implementation of REST endpoint to this class
 * Created by Manuel Spigolon on 21/10/2017.
 */
@Component
public class JerseyConfig {

}
// public class JerseyConfig extends ResourceConfig {
//
//    public JerseyConfig() {
//        register(JerseyController.class);
//    }
// }

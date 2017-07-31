package it.eomm.hello.springboot.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by Manuel Spigolon on 30/07/2017.
 */
@Component
@Order(value = 1)
public class CommandLine implements CommandLineRunner{


    @Override
    public void run(String... strings) throws Exception {
        System.out.println("CommandLine after SpringApplication has started!");
    }
}

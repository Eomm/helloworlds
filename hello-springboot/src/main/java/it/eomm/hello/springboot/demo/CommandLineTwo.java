package it.eomm.hello.springboot.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by Manuel Spigolon on 30/07/2017.
 */
@Component
@Order(value = 2)
public class CommandLineTwo implements CommandLineRunner {


    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Second CommandLine after SpringApplication has started, I'll kill it!");

        //throw new ExitException();
    }
}

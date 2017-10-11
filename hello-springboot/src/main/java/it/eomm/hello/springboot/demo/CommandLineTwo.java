package it.eomm.hello.springboot.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by Manuel Spigolon on 30/07/2017.
 */
@Component
@Order(value = 2)
public class CommandLineTwo implements CommandLineRunner {

    private final static Logger log = LogManager.getLogger(CommandLineTwo.class);

    @Override
    public void run(String... strings) throws Exception {
        log.fatal("Second CommandLine after SpringApplication has started, I'll kill it!");

        //throw new ExitException();
    }
}

package it.eomm.hello.springboot.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

/**
 * Created by Manuel Spigolon on 30/07/2017.
 */
@Component
public class ReadCmdLineArgs {

    @Autowired
    public ReadCmdLineArgs(ApplicationArguments args) {
        System.out.println("ARGs:");
        for (String arg : args.getSourceArgs()) {
            System.out.println(" ---> " + arg);
        }
    }

}

package it.eomm.hello.springboot.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

/**
 * Created by Manuel Spigolon on 30/07/2017.
 */
@Component
public class ReadCmdLineArgs {

    private final static Logger log = LogManager.getLogger(ReadCmdLineArgs.class);

    @Autowired
    public ReadCmdLineArgs(ApplicationArguments args) {
        log.info("ARGs:");
        for (String arg : args.getSourceArgs()) {
            log.debug(" ---> " + arg);
        }
    }

}

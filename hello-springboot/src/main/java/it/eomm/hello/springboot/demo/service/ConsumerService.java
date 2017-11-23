package it.eomm.hello.springboot.demo.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Created by Manuel Spigolon on 23/11/2017.
 */
@Service
public class ConsumerService {

    private final static Logger log = LogManager.getLogger(ConsumerService.class);

    @Autowired
    private DemoService demoService;

    @EventListener
    public void onApplicationEvent(ApplicationReadyEvent event) {
        // This is the right way when do connection and call Retryable method
        try {
            demoService.retryService("-- DemoService on event: " + event.toString());
        } catch (Exception ex) {
            log.error("Error onApplicationEvent");
        }
        log.debug("End");
    }

}

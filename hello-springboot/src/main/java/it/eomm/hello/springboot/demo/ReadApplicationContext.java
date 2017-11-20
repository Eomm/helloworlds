package it.eomm.hello.springboot.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by Manuel Spigolon on 31/07/2017.
 */
@Component
public class ReadApplicationContext implements ApplicationContextAware {

    private final static Logger log = LogManager.getLogger(ReadApplicationContext.class);

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;

        log.info("Stored the application context: " + context);
    }
}

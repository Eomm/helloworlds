package it.eomm.hello.springboot.demo;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by Manuel Spigolon on 31/07/2017.
 */
@Component
public class ReadApplicationContext implements ApplicationContextAware {

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;

        System.out.println("Stored the application context: " + context);
    }
}

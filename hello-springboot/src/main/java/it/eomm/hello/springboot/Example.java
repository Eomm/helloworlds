package it.eomm.hello.springboot;

import it.eomm.hello.springboot.demo.converter.MyObject;
import it.eomm.hello.springboot.demo.lang.LangRequester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by Manuel Spigolon on 28/07/2017.
 */
// stereotype annotation
@RestController

//@SpringBootApplication = Configuration + EnableAutoConfiguration + ComponentScan

@ComponentScan

// understand how you will want to configure String based on jar dependancies.
// Auto-configuration is designed to work well with “Starters” dependancies.
@EnableAutoConfiguration

// Enables support for handling components marked with AspectJ's @Aspect annotation.
// It let you use the proxyMode for request scoped beans.
@EnableAspectJAutoProxy
public class Example {

    @Autowired
    private LangRequester langRequester;

    public static void main(String[] args) throws Exception {
//        SpringApplication.run(Example.class, args);

        SpringApplication app = new SpringApplication(Example.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.addListeners(new ApplicationListener<ApplicationEvent>() {
            @Override
            public void onApplicationEvent(ApplicationEvent applicationEvent) {
                System.out.println("An event occurred: " + applicationEvent.getClass());
            }
        });
        app.run(args);

    }

    // routing like servlet mapping
    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }


    @RequestMapping("/lang")
    String lang() {
        return langRequester.getMessage("hello") + ' ' + langRequester.getMessage("only");
    }

    @RequestMapping(value = "/converter", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    MyObject convert() {
        return new MyObject("hello");
    }

}
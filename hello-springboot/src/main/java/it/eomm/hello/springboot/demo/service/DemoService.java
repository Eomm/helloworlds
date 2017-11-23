package it.eomm.hello.springboot.demo.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by Manuel Spigolon on 23/11/2017.
 */
@Service
public class DemoService {

    private final static Logger log = LogManager.getLogger(DemoService.class);

    private int retryCount;

    @PostConstruct
    public void init() {
        log.info("This is post construct");
        retryCount = 0;

        try {
            this.retryService("DemoService");
        } catch (Exception ex) {
            // @Retryable is implemented using Spring AOP.
            // Only external calls to retryable methods go
            // through the proxy (which invokes the method
            // within a RetryTemplate); internal calls within
            // the class bypass the proxy and therefore are not retried.

            // NEVER do connection on @PostConstruct
            log.error("Error retrying into demo service");
        }
    }

    /**
     * If @Retryable is used without any attributes:
     * maxAttempts = 3
     * delay = one second.
     */
    @Retryable(maxAttempts = 4,
            backoff = @Backoff(delay = 2000))
    public void retryService(String caller) throws NullPointerException {
        retryCount++;
        log.warn("This is a retry " + retryCount + " by " + caller);
        throw new NullPointerException();
    }

}

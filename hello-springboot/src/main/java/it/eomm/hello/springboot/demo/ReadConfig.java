package it.eomm.hello.springboot.demo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Load priorities are described here:
 * https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#boot-features-external-config
 * Created by Manuel Spigolon on 30/07/2017.
 */
@Component
public class ReadConfig {

    private final static Logger log = LogManager.getLogger(ReadConfig.class);

    // Usage: Add the JVM property at mvn spring:run
    // -Dspring-boot.run.jvmArguments=-Dread.from.jvm.args=hello
    @Value("${read.from.jvm.args}")
    private String fromJvm;

    // Usage: Add a application{-profile}.properties file in the class path
    @Value("${read.from.properties}")
    private String fromFileProps;

    @Value("${read.random.number}")
    private Integer random;

    // @Autowired // field injection is a BAD practice
    private ConfigClass properties;

    @Autowired
    public ReadConfig(ConfigClass properties) {
        this.properties = properties;
    }

    @PostConstruct
    public void checkConfig() {
        log.info("Read a bean from the app's context: \n" +
                "JVM: " + this.getFromJvm() + '\n' +
                "File prop: " + this.getFromFileProps() + '\n' +
                "Random: " + this.getRandom() + '\n' +
                "ConfigurationProperties: " + this.properties.getStringProp() + '\n' +
                "ConfigurationProperties SubTag: " + this.properties.getSubTag().getAnotherString() + '\n' +
                "ConfigurationProperties List: " + this.properties.getStringList().size());
    }

    public String getFromJvm() {
        return fromJvm;
    }

    public void setFromJvm(String fromJvm) {
        this.fromJvm = fromJvm;
    }

    public String getFromFileProps() {
        return fromFileProps;
    }

    public void setFromFileProps(String fromFileProps) {
        this.fromFileProps = fromFileProps;
    }

    public Integer getRandom() {
        return random;
    }

    public void setRandom(Integer random) {
        this.random = random;
    }
}

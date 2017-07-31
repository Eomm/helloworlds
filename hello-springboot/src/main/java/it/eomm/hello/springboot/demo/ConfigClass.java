package it.eomm.hello.springboot.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * This bean will named with: demo-it.eomm.hello.springboot.demo.ConfigClass
 * Created by Manuel Spigolon on 31/07/2017.
 */
@Component

// The prefix value for the annotation must be in kebab-case
@ConfigurationProperties(prefix = "demo")
@Validated
public class ConfigClass {

    // Ensure that a compliant JSR-303 implementation is on your classpath
    @NotNull
    private String stringProp;

    private Integer numberProp;

    private List<String> stringList;

    @Valid // for nested class
    private final SubTag subTag = new SubTag();

    public static class SubTag {
        private String anotherString;

        public String getAnotherString() {
            return anotherString;
        }

        public void setAnotherString(String anotherString) {
            this.anotherString = anotherString;
        }
    }

    public String getStringProp() {
        return stringProp;
    }

    public void setStringProp(String stringProp) {
        this.stringProp = stringProp;
    }

    public Integer getNumberProp() {
        return numberProp;
    }

    public void setNumberProp(Integer numberProp) {
        this.numberProp = numberProp;
    }

    public SubTag getSubTag() {
        return subTag;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }
}

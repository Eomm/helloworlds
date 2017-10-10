package it.eomm.hello.springboot.demo.lang;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * Created by Manuel Spigolon on 09/10/2017.
 */
@Component
public class LangResource {

    @Value("${default.lang}")
    private String defaultAppLang;

    @Value("${lang.path}")
    private String langPath;

    @Bean
    @Scope("singleton")
    public MessageSource langSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.addBasenames(langPath);
        return messageSource;
    }

    @Bean
    @Scope("singleton")
    public Locale defaultLocale() {
        return new Locale(defaultAppLang);
    }

}

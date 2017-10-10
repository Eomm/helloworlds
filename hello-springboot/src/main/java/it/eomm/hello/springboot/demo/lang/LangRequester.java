package it.eomm.hello.springboot.demo.lang;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import javax.servlet.http.HttpServletRequest;
import java.util.Locale;

/**
 * Created by Manuel Spigolon on 09/10/2017.
 */
@Component
@RequestScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class LangRequester {

    @Autowired
    private MessageSource langSource;

    @Autowired
    private Locale defaultLocale;

    @Autowired
    private HttpServletRequest currentRequest;

    public String getMessage(String messageKey, Object... params) {
        Locale locale = currentRequest.getLocales().nextElement();
        if (locale.getDisplayCountry().isEmpty()) {
            locale = defaultLocale;
        } else {
            locale = new Locale(currentRequest.getLocales().nextElement().getLanguage());
        }
        return langSource.getMessage(messageKey, params, locale);
    }

}

package it.eomm.hello.springboot.demo.error.viewresolver;

import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * For more complex mappings: this will override the Whitelabel error page from the BasicErrorController
 * Created by Manuel Spigolon on 21/10/2017.
 */
@Component
public class CustomViewResolver implements ErrorViewResolver {

    @Override
    public ModelAndView resolveErrorView(HttpServletRequest request, HttpStatus status, Map<String, Object> model) {
        // Use the request or status to optionally return a ModelAndView
        if (request.getQueryString().startsWith("customViewResolver")) {
            return new ModelAndView("error-custom-view-resolver/custom-error", model);
        } else {
            return null; // will view the apache tomcat default error page
        }
    }
}

package it.eomm.hello.springboot.demo.configuration;

import it.eomm.hello.springboot.demo.controller.ApiController;
import it.eomm.hello.springboot.demo.exception.ApplicationException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Manuel Spigolon on 20/10/2017.
 */
@ControllerAdvice(basePackageClasses = ApiController.class)
public class MyControllerAdvice extends ResponseEntityExceptionHandler {

    private final static Logger log = LogManager.getLogger(MyControllerAdvice.class);

    @ExceptionHandler(NullPointerException.class)
    @ResponseBody
    ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable ex) {
        log.info("Intercepted NullPointer for ApiController.. converting to ApplicationException");
        HttpStatus status = getStatus(request);
        return new ResponseEntity<>(new ApplicationException(String.valueOf(status.value()), ex.getMessage()), status);
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }

}

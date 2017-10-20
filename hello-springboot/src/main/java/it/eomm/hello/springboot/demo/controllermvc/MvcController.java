package it.eomm.hello.springboot.demo.controllermvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by Manuel Spigolon on 20/10/2017.
 */
@Controller
public class MvcController {

    /**
     * Use a path configured on MvcConfig.addViewControllers and add some model variable
     *
     * @param model
     */
    @GetMapping("/home")
    String home(Map<String, Object> model) {
        model.put("name", "John Doe");
        return "home"; // return the name of the VIEW to show
    }

    @GetMapping("/error-mvc")
    String error(Map<String, Object> model) {
        // This error is not catch by the MyControllerAdvice thanks the different package configured
        throw new NullPointerException("Ops, this is an error");
    }

}

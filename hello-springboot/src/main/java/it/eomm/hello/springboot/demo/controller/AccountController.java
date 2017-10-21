package it.eomm.hello.springboot.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Manuel Spigolon on 21/10/2017.
 */
@RestController
public class AccountController {

    @RequestMapping(value = "/public/{accountNumber}")
    public String getPublicAccount(@PathVariable final int accountNumber) {
        return "Account public " + accountNumber;
    }

    @RequestMapping(value = "/private/{accountNumber}")
    public String getPrivateAccount(@PathVariable final int accountNumber) {
        return "Account private " + accountNumber;
    }
}

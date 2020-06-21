package com.gautam.rest.basic.auth;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class BasicAutheticationController {


    @GetMapping(path = "/basicauth")
    public AuthenticationBean HelloWorldBean() {
        return new AuthenticationBean("You are Authenticated");
    }

}

package com.gautam.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class HelloWorld {

    @GetMapping(path = "/hello")
    public String Hello() {
        return "Hello World";
    }

    @GetMapping(path = "/hello-bean")
    public HelloWorldBean HelloBean() {
        return new HelloWorldBean("Hello World Bean");
    }

    @GetMapping(path = "/hello-bean/pathvar/{name}")
    public HelloWorldBean HelloBeanPathVar(@PathVariable String name) {
        System.out.println(name);
        //throw new RuntimeException("Error message while getting request");
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }

}

package com.portfolioprojects.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/basicauth")
    public String basicAuthCheck() {
        return "Success";
    }

    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello World V2";
    }

    @GetMapping(path = "/hello-world/path-variable/{username}")
    public String helloWorldPathVariable(@PathVariable String username) {
        return "Hello World, " + username;
    }


}

package com.mazlumabul.restfullwebservices.controller;

import com.mazlumabul.restfullwebservices.model.HelloWorldBean;
import com.mazlumabul.restfullwebservices.model.User;
import com.mazlumabul.restfullwebservices.service.UserDaoService;
import com.mazlumabul.restfullwebservices.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloWorldController {
/*
    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

 */
    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello Mazlum";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello Mazlum");
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello Ferhat, %s", name));
    }


}

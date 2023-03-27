package com.mazlumabul.restfullwebservices.controller;

import com.mazlumabul.restfullwebservices.model.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;


import java.util.Locale;

@RestController
public class HelloWorldController {
    @Autowired
    private MessageSource messageSource;

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

    @GetMapping(path = "/hello-worldInternationalization")
    public String helloWorldInternationalization(@RequestHeader(name = "Accept-Language",required = false)Locale locale){
        // en = helloWorld
        // nl = Goede Morgen
        // fr = Bonjour
        return messageSource.getMessage("good.morning.message",null,"default Message",locale);
    }
}

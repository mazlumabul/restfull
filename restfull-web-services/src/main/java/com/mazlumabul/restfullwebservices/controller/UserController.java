package com.mazlumabul.restfullwebservices.controller;

import com.mazlumabul.restfullwebservices.exception.UserNotFoundException;
import com.mazlumabul.restfullwebservices.model.User;
import com.mazlumabul.restfullwebservices.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public  class UserController {
    //retrieveAllUsers
    //retrieveUser{id}
    @Autowired
    private UserDaoService userService;

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public EntityModel retrieveUser(@PathVariable int id){
        User user = userService.findUser(id);
        if (user == null){
            throw new UserNotFoundException("id :"+ id);
        }
        EntityModel<User> model = EntityModel.of(user);

        WebMvcLinkBuilder linkToUsers =WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());
        model.add(linkToUsers.withRel("all-users"));
        return model;
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userService.saveUser(user);
    }
}

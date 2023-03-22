package com.mazlumabul.restfullwebservices.service;

import com.mazlumabul.restfullwebservices.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();
    private static int usersCount=6;

    static {
        users.add(new User(1,"Mazlum", new Date()));
        users.add(new User(2,"Ferhat", new Date()));
        users.add(new User(3,"Alice", new Date()));
        users.add(new User(4,"John", new Date()));
        users.add(new User(5,"Leyla", new Date()));
        users.add(new User(6,"Mecnun", new Date()));
    }


    public List<User> findAll(){
        return users;
    }

    public User saveUser(User user){
       if (user.getId() == null){
           user.setId(++usersCount);
       }
       users.add(user);
       return user;
    }

    public User findUser(Integer id){
        for (User user : users){
            if (user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }
}

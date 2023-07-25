package com.sharad.ridersspot.controller;

import com.sharad.ridersspot.collection.User;
import com.sharad.ridersspot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    public String createUser(User user) {
        return userService.create(user);
    }
}

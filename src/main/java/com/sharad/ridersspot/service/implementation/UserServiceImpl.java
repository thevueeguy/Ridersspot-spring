package com.sharad.ridersspot.service.implementation;

import com.sharad.ridersspot.collection.User;
import com.sharad.ridersspot.repository.UserRepository;
import com.sharad.ridersspot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public String create(User user) {
        return null;
    }
}

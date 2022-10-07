package com.group1.userservice.service;

import com.group1.userservice.model.User;

public interface UserService {
    void save(User user);

    User findByEmail(String email);
}

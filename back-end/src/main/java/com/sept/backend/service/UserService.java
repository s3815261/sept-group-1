package com.sept.backend.service;

import com.sept.backend.model.User;

public interface UserService {
    void save(User user);

    User findByEmail(String email);
}

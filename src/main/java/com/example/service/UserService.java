package com.example.service;

import com.example.domain.User;

public interface UserService {

    void save(User user);

    User findById(Long id);

    User findByUsername(String username);

//    User findByUsername(String username);

//    User findBySso(String sso);

}

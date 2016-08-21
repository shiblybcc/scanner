package com.example.dao;


import com.example.domain.User;

public interface UserDao {

    User findByUserName(String username);

//    User findBySSO(String sso);

}

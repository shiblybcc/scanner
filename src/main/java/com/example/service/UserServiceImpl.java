//package com.example.service;
//
//import com.example.dao.UserDao;
//import com.example.domain.User;
//import org.hibernate.Criteria;
//import org.hibernate.criterion.Restrictions;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//@Service("userService")
//@Transactional
//public class UserServiceImpl implements UserService{
//
//    @Autowired
//    private UserDao dao;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//
//    public void save(User user){
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        dao.save(user);
//    }
//
//    public User findById(Long id) {
//        return dao.findById(id);
//    }
//
//    public User findByUsername(String username){
//        return dao.findByUsername(username);
//    }
//
////    public User findByUsername(String username){
////        return dao.findByUsername(username);
////    }
//
////    public User findBySso(String sso) {
////        return dao.findBySSO(sso);
////    }
//
//}

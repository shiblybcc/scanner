package com.example.dao;

import com.example.domain.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;


@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public User findByUserName(String username) {

        List<User> users = new ArrayList<User>();

        users = sessionFactory.getCurrentSession().createQuery("from User where username=:username")
//                .setParameter(0, username)
                .setString( "username", username )
                .list();

//        List users = sessionFactory.getCurrentSession()
//                .createQuery( "from User where username = :username" )
//                .setString( "username", username )
//                .list();

        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }

    }

}

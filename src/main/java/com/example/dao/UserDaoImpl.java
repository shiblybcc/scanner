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
public class UserDaoImpl extends AbstractDao<Long, User> implements UserDao {

//    @Autowired
//    private SessionFactory mySessionFactory;

    public void save(User user) {
        persist(user);
    }

    public User findById(Long id) {
        return getByKey(id);
    }

    public User findByUsername(String username){
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("username", username));
        return (User) criteria.uniqueResult();
    }

//    public User findByUsername(String username){
//
//
//
//        List<User> users = new ArrayList<User>();
//
//        users = mySessionFactory.getCurrentSession().createQuery("from User where username=?").setParameter(0, username)
//                .list();
//
//        if (users.size() > 0) {
//            return users.get(0);
//        } else {
//            return null;
//        }
//    }

//    public User findBySSO(String sso) {
//        Criteria crit = createEntityCriteria();
//        crit.add(Restrictions.eq("ssoId", sso));
//        return (User) crit.uniqueResult();
//    }

}

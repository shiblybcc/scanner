package com.example.dao;

import java.io.Serializable;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

import com.example.domain.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao<PK extends Serializable, T> {

    private final Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public AbstractDao(){
        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
    public T getByKey(PK key) {
        return (T) getSession().get(persistentClass, key);
    }

//    public T getByUserName(PK username){
//        List<User> users = new ArrayList<User>();
//
//        users = getSession().createQuery("from User where username=?").setParameter(0, username)
//                .list();
//
//        if (users.size() > 0) {
//            return T;
//        } else {
//            return null;
//        }
//    }

    public void persist(T entity) {
        getSession().persist(entity);
    }

    public void delete(T entity) {
        getSession().delete(entity);
    }

    protected Criteria createEntityCriteria(){
        return getSession().createCriteria(persistentClass);
    }


}

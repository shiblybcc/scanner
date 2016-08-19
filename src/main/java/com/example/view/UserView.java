package com.example.view;

import com.example.domain.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "user")
@ViewScoped
public class UserView extends User{
    public UserView(){}
}

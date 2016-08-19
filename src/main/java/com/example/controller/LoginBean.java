//package com.example.controller;
//
//import com.example.domain.User;
//import com.example.repository.UserRepository;
//
//import javax.faces.application.FacesMessage;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.ManagedProperty;
//import javax.faces.bean.SessionScoped;
//import javax.faces.context.ExternalContext;
//import javax.faces.context.FacesContext;
//import java.io.IOException;
//
//@ManagedBean
//@SessionScoped
//public class LoginBean {
//
//    private String password;
//    private String username;
//
//    @ManagedProperty(value = "#{userRepository}")
//    UserRepository userRepository;
//
//    public String userLogin() throws IOException {
//        User currentUser = userRepository.findByUsername(username);
//        FacesContext context = FacesContext.getCurrentInstance();
//
//        if (currentUser == null) {
//            context.addMessage(null, new FacesMessage("username and password doesn't match, try again"));
//            return null;
//        } else {
//            context.getExternalContext().getSessionMap().put("currentUser", currentUser);
////            context.getExternalContext().getSessionMap().put("testSession", "session working!!!");
//            return "index.xhtml?faces-redirect=true";
//        }
//    }
//
//    public String logout() {
//        FacesContext context = FacesContext.getCurrentInstance();
//        context.getExternalContext().invalidateSession();
//        return "login.xhtml?faces-redirect=true";
//    }
//
////
////    public String getPwd() {
////        return pwd;
////    }
////
////    public void setPwd(String pwd) {
////        this.pwd = pwd;
////    }
//
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public UserRepository getUserRepository() {
//        return userRepository;
//    }
//
//    public void setUserRepository(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//
//
//}

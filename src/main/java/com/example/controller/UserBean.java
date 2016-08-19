package com.example.controller;

import com.example.domain.ScannedFile;
import com.example.domain.User;
import com.example.repository.ScannedFileRepository;
import com.example.repository.UserRepository;
import com.example.view.ScannedFileView;
import com.example.view.UserView;
import org.apache.commons.codec.DecoderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.validation.Valid;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class UserBean {

    @ManagedProperty(value = "#{user}")
    private UserView user;

    @ManagedProperty(value = "#{userRepository}")
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

//    @Autowired
//    UserService userService;

    public String register(){
        User created = new User();
        created.setId(this.user.getId());
        created.setFirstName(this.user.getFirstName());
        created.setLastName(this.user.getLastName());
        created.setUsername(this.user.getUsername());
        created.setPassword((this.user.getPassword()));
//        created.setPassword(passwordEncoder.encode(this.user.getPassword()));
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User newUser = this.userRepository.save(created);
        return "login.xhtml";
    }

//    public String register(@Valid User user,
//                           BindingResult result, ModelMap model){
//
//        userService.save(user);
//
//        return "login.xhtml";
//    }

//    public void findFileById() throws GeneralSecurityException, DecoderException, IOException {
//        User found = userRepository.findOne(this.user.getId());
//        this.user.setId(found.getId());
//        this.user.setUsername(found.getUsername());
//        this.user.setFirstName(found.getFirstName());
//        this.user.setLastName(found.getLastName());
//    }
//
//    public List<UserView> findAllUsers() {
//        List<UserView> users = new ArrayList<>();
//        for (User entity : this.userRepository.findAll()) {
//            UserView view = new UserView();
//            view.setId(entity.getId());
//            view.setUsername(entity.getUsername());
//            view.setFirstName(entity.getFirstName());
//            view.setLastName(entity.getLastName());
//            users.add(view);
//        }
//        return users;
//    }


    public void validatePassword(ComponentSystemEvent event) {

        FacesContext fc = FacesContext.getCurrentInstance();

        UIComponent components = event.getComponent();

        // get password
        UIInput uiInputPassword = (UIInput) components
                .findComponent("password");

        String password = uiInputPassword.getLocalValue() == null ? ""
                : uiInputPassword.getLocalValue().toString();

        String passwordId = uiInputPassword.getClientId();

        // get confirm password
        UIInput uiInputConfirmPassword = (UIInput) components
                .findComponent("confirmPassword");
        String confirmPassword = uiInputConfirmPassword.getLocalValue() == null ? ""
                : uiInputConfirmPassword.getLocalValue().toString();

        // Let required="true" do its job.
        if (password.isEmpty() || confirmPassword.isEmpty()) {
            return;
        }

        if (!password.equals(confirmPassword)) {

            FacesMessage msg = new FacesMessage(
                    "Password must match confirm password");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            fc.addMessage(passwordId, msg);
            fc.renderResponse();
        }

    }


    public UserView getUser() {
        return user;
    }

    public void setUser(UserView user) {
        this.user = user;
    }

//    public UserService getUserService() {
//        return userService;
//    }
//
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }

        public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}

package com.example.service;

import java.util.ArrayList;
import java.util.List;

import com.example.dao.UserDao;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.faces.bean.ManagedProperty;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private UserDao userDao;

    @Transactional(readOnly=true)
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        com.example.domain.User user = userDao.findByUserName(username);
        if (user == null) {
            return null;
        }
        List<GrantedAuthority> auth = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String password = user.getPassword();
        return new org.springframework.security.core.userdetails.User(username, password, true, true, true, true,
                auth);
    }



//    @Transactional(readOnly=true)
//    @Override
//    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
//
//        User user = userService.findByUsername(username);
//        List<GrantedAuthority> authorities = buildUserAuthority();
//
//
//
//
//
//
//        return buildUserForAuthentication(com.example.domain.User user, authorities);
//
//    }
//
//    // Converts com.mkyong.users.model.User user to
//    // org.springframework.security.core.userdetails.User
//    private User buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
//        return new User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
//    }
//
//    private List<GrantedAuthority> buildUserAuthority() {
//
//        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
//
//        setAuths.add(new SimpleGrantedAuthority("USER"));
//
//
//        List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);
//
//        return Result;
//    }



//    @Transactional(readOnly=true)
//    public UserDetails loadUserByUsername(String ssoId)
//            throws UsernameNotFoundException {
//        User user = userService.findBySso(ssoId);
//        System.out.println("User : "+user);
//        if(user==null){
//            System.out.println("User not found");
//            throw new UsernameNotFoundException("Username not found");
//        }
//        return new org.springframework.security.core.userdetails.User(user.getSsoId(), user.getPassword(),
//                user.getState().equals("Active"), true, true, true, getGrantedAuthorities(user));
//    }
//
//
//    private List<GrantedAuthority> getGrantedAuthorities(User user){
//        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//
//        for(UserProfile userProfile : user.getUserProfiles()){
//            System.out.println("UserProfile : "+userProfile);
//            authorities.add(new SimpleGrantedAuthority("ROLE_"+userProfile.getType()));
//        }
//        System.out.print("authorities :"+authorities);
//        return authorities;
//    }



}

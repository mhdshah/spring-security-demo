package com.example.springspecdemo.service;

import com.example.springspecdemo.dao.UserRepo;
import com.example.springspecdemo.model.User;
import com.example.springspecdemo.model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user =  repo.findByUsername(username);

        if(user == null) {
            System.out.println("User 404");
            throw new UsernameNotFoundException("User 404");
        }


        return new UserPrincipal(user);
    }
}



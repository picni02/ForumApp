package com.example.web_250.services;

import com.example.web_250.models.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.web_250.repositories.UserRepository;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired

    private UserRepository _UserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final User user = _UserRepository.findByEmail(username);
        if (user == null) throw new UsernameNotFoundException(username);
        if (user.getIsBanned() == 1) throw new IllegalStateException("Banovan korisnik.");
        else {
            UserDetails newUser;
            if(user.getRoleId() == 0) newUser = org.springframework.security.core.userdetails.User.withUsername(user.getEmail()).password(user.getPassword()).authorities("USER").build();
            else newUser = org.springframework.security.core.userdetails.User.withUsername(user.getEmail()).password(user.getPassword()).authorities("ADMIN").build();
            return newUser;
        }
    }
}

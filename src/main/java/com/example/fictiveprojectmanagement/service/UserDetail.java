package com.example.fictiveprojectmanagement.service;

import java.util.*;
import java.util.stream.Collectors;

import com.example.fictiveprojectmanagement.entity.User;
import com.example.fictiveprojectmanagement.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetail implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetail(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsernameOrEmail(username, username);

        if(user.isEmpty()){
            throw new UsernameNotFoundException("User not exists by Username");
        }

        Set<GrantedAuthority> authorities = user.get().getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(username,user.get().getPassword(),authorities);
    }
}
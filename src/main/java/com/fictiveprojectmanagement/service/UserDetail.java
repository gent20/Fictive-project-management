package com.fictiveprojectmanagement.service;

import java.util.*;
import java.util.stream.Collectors;

import com.fictiveprojectmanagement.entity.Role;
import com.fictiveprojectmanagement.entity.User;
import com.fictiveprojectmanagement.repository.UserRepository;
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

    public void assignRoleToUser(User user, Role role) {
        user.getRoles().add(role);
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsernameOrEmail(username, username);

        if(user.isEmpty()){
            throw new UsernameNotFoundException("User not found!");
        }

        Set<GrantedAuthority> authorities = user.get().getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());

        return new org.springframework.security.core.userdetails.User(username,user.get().getPassword(),authorities);
    }
}
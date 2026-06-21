package com.stuti.interview_platform.service;

import com.stuti.interview_platform.entity.User;
import com.stuti.interview_platform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
public UserDetails loadUserByUsername(String username)
        throws UsernameNotFoundException {

    System.out.println("CALLED: " + username);

    User user =
repository
.findByUsername(username)
.orElseThrow(
        () -> new RuntimeException(
                "User not found"
        )
);

    System.out.println("USER = " + user);

    if (user == null) {
        throw new UsernameNotFoundException("User not found");
    }

    return new org.springframework.security.core.userdetails.User(
            user.getUsername(),
            user.getPassword(),
            Collections.singletonList(
                    new SimpleGrantedAuthority("ROLE_USER"))
    );
}
}
    
package com.techsharezone.bootifyspringsecurityotp.service;

/*
 * @created 24/11/2020 -23:41
 * @project bootify-spring-security-otp
 * @author  saurabhshcs
 */

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class BootifyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User("admin", "nimda", Collections.emptyList());
    }
}

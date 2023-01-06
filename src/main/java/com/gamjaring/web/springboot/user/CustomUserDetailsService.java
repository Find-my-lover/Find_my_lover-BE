package com.gamjaring.web.springboot.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.servlet.http.HttpSession;

public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    private final HttpSession session;

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{
        Member user=userRepository.findByEmail(email).orElseThrow(()->
        new UsernameNotFoundException("해당 사용자가 존재하지 않습니다.:"+email)));
        session.setAttribute("user", new UserSessionDto(user));

        return new CustomUserDetails(user);
    }

}

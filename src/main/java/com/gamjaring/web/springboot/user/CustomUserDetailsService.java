package com.gamjaring.web.springboot.user;

import com.gamjaring.web.springboot.domain.Member;
import com.gamjaring.web.springboot.domain.UserRepository;
import com.gamjaring.web.springboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Component
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    private final UserService userService;
    private final HttpSession session;


    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException{

        Member user=userRepository.findByEmail(email);
                /*.orElseThrow(()->
        new UsernameNotFoundException("해당 사용자가 존재하지 않습니다.:"+email));
        session.setAttribute("user", new UserSessionDto(user));
*/
        return new CustomUserDetails(user);
    }

}

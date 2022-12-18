package com.gamjaring.web.springboot.user;

import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
    Member createUser(Member user);

    boolean validationLogin(String name, String password);

    void validateDuplicateUser(Member user);
    public List<Member> findUsers();
}

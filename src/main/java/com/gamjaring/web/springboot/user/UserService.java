package com.gamjaring.web.springboot.user;

public interface UserService {
    void createUser(User user);

    boolean validationLogin(String email, String password);

}

package com.gamjaring.web.springboot.user;

import java.util.List;

public interface UserService {
    void createUser(User user);

    boolean validationLogin(String email, String password);

    void validateDuplicateUser(User user);
    public List<User> findUsers();
}

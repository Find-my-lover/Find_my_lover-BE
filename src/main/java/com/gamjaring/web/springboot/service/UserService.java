package com.gamjaring.web.springboot.service;

import java.util.List;

import com.gamjaring.web.springboot.enumpack.Gender;
import com.gamjaring.web.springboot.domain.Member;

public interface UserService {
    Member createUser(Member user);

    boolean validationLogin(String name, String password);

    void validateDuplicateUser(Member user);
    List<Member> getUsers();
    Member getUser(String email);
    void updateGender(String email, Gender gender);
}
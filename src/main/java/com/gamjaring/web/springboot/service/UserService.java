package com.gamjaring.web.springboot.service;

import java.util.List;

import com.gamjaring.web.springboot.domain.Gender;
import com.gamjaring.web.springboot.domain.Member;

public interface UserService {
    Member createUser(Member user);

    boolean validationLogin(String name, String password);

    void validateDuplicateUser(Member user);
    public List<Member> getUsers();
    public Member getUser(String email);
    public void updateGender(String email, Gender gender);
}
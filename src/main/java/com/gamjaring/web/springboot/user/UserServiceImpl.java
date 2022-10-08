//User가 null일경우 에러가 떠버릴 수도 있다.

package com.gamjaring.web.springboot.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void createUser(User user){
        String encodedPassword=passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }

    @Override
    public boolean validationLogin(String email, String password){
        User loginUser=userRepository.findByEmail(email);

        if(loginUser==null){
            System.out.println("해당 이메일로 등록된 유저는 없습니다.");
            return false;

        }

        if(!passwordEncoder.matches(password, loginUser.getPassword())){
            System.out.println("비밀번호가 일치하지 않습니다.");
            return false;
        }
        return true;
    }


}

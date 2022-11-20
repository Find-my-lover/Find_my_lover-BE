//User가 null일경우 에러가 떠버릴 수도 있다.

package com.gamjaring.web.springboot.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void createUser(User user){
        String encodedPassword=passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }

    @Override
    public boolean validationLogin(String name, String password){
        User loginUser=userRepository.findByName(name);

        if(loginUser==null){
            System.out.println("해당 이메일로 등록된 유저는 없습니다.");
            return false;

        }

        ////고민해볼 파트////
        if(!passwordEncoder.matches(password, loginUser.getPassword())){
            System.out.println("비밀번호가 일치하지 않습니다.");
            return false;
         }

        return true;
    }



    //private이어야 할지 고민해보기
    public void validateDuplicateUser(User user){
        if(userRepository.findByName(user.getName())!=null){
            System.out.println("이미 가입이 된 아이디입니다.");
        }

    }

    public List<User> findUsers(){
        return userRepository.findAll();
    }


    public User findOne(String userMail){
        return userRepository.findByName(userMail);
    }


}

//User가 null일경우 에러가 떠버릴 수도 있다.

package com.gamjaring.web.springboot.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional//로직을 처리하다가 에러가 발생하면 변경된 데이터를 로직을 수행하기 이전 상태로 롤백해줘야 된다.
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member user=userRepository.findByEmail(email);

        if(user==null){
            throw new UsernameNotFoundException(email);
        }
        return User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .build();
    }

    @Override
    public Member createUser(Member user){
        validateDuplicateUser(user);
        return userRepository.save(user);
    }

    @Override
    public boolean validationLogin(String name, String password){
        Member loginUser=userRepository.findByEmail(name);

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
    //중복 이메일로 회원가입 시도하면 예외 발생
    public void validateDuplicateUser(Member user){
        if(userRepository.findByEmail(user.getEmail())!=null){
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }

    }

    public List<Member> findUsers(){
        return userRepository.findAll();
    }


/*    public User findOne(String userMail){
        return userRepository.findByEmail(userMail);
    }
*/

}
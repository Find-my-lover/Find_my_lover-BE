package com.gamjaring.web.springboot.controller;


import com.gamjaring.web.springboot.user.User;
import com.gamjaring.web.springboot.user.UserForm;
import com.gamjaring.web.springboot.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

//@Tag(name="signup", description="회원가입 API")
//@RequestMapping("/api/signup")
@Api(tags={"User"})
@RequestMapping(value="/users")//공통적인 URL
@RestController
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder){
        this.userService=userService;
        this.passwordEncoder=passwordEncoder;


    }

    //임시적으로 local host 8080에서 바로 로그인으로 가게 만들어둠.
//    @GetMapping
//    public String root(){
//        return "redirect:/login";
//
//    }


    @ApiOperation(value="회원가입 폼")
    @GetMapping("/resister")
    public String create(Model model){
        model.addAttribute("userForm", new UserForm());
        return "user/userForm";
    }

    @ApiOperation(value="회원가입")
    @PostMapping
    public String userForm(UserForm userForm){
        User user=User.createUser(userForm, passwordEncoder);
        userService.createUser(user);

        return "redirect:/";//회원가입 완료
    }
    @ApiOperation(value="로그인 폼")
    @PostMapping("/login")
    public String loginForm(){

        return "/login";
    }
/*    @ApiOperation(value="회원가입 정보 폼")
    @PostMapping("/resister")
    public String createForm(){
        return "/resister";
    }*/




    //userService
    @ApiOperation("마이 페이지 조회")
    @GetMapping("/users")
    public String list(Model model){
        List<User> users=userService.findUsers();
        model.addAttribute("users", users);
        return "users/userList";
    }



}

package com.gamjaring.web.springboot.controller;


import com.gamjaring.web.springboot.domain.Member;
import com.gamjaring.web.springboot.user.UserForm;
import com.gamjaring.web.springboot.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.validation.Valid;
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
    public String create(Model model){//뷰에 UserForm 데이터 형태 넘기기
        model.addAttribute("userForm", new UserForm());
        return "users/userForm";
    }

    @ApiOperation(value="회원가입")
    @PostMapping
    public String userForm(UserForm userForm){
        Member user= Member.createUser(userForm, passwordEncoder);
        userService.createUser(user);

        return "redirect:/";//회원가입 완료
    }

    @ApiOperation(value="회원가입 정보 검증")
    @PostMapping(value="/register")
    public String newUser(@Valid UserForm userForm,
                          BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "users/userForm";
        }
        try{
            Member user= Member.createUser(userForm, passwordEncoder);
            userService.createUser(user);
        }catch (IllegalStateException e){
            model.addAttribute("errorMessage", e.getMessage());
            return "users/userForm";
        }
        return "redirect:/";
    }

    @ApiOperation(value="로그인 폼")
    @GetMapping("/login")
    public String loginForm(){

        return "/users/loginForm";
    }

    @GetMapping(value="/login/error")
    public String loginError(Model model){
        model.addAttribute("loginErrorMsg", "아이디 또는 비밀번호를 확인해주세요.");
        return "/users/loginForm";

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
        List<Member> users=userService.getUsers();
        model.addAttribute("users", users);
        return "users/userList";
    }



}
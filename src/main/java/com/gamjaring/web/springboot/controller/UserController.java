package com.gamjaring.web.springboot.controller;


<<<<<<< HEAD
import com.gamjaring.web.springboot.user.Member;
import com.gamjaring.web.springboot.user.UserForm;
=======
import com.gamjaring.web.springboot.user.User;
>>>>>>> 89e27bc07d4e3c0b2e44f3f244730f7924b12121
import com.gamjaring.web.springboot.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
<<<<<<< HEAD
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
=======
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
>>>>>>> 89e27bc07d4e3c0b2e44f3f244730f7924b12121


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

    @ApiOperation(value="초기화면-성별선택 및 이미지 넣기")
    @PostMapping("/main/select")
    public String initialSelect(@RequestBody UserForm userForm) {
        User user = new User(userForm.getName());
        user.setGender(userForm.isGender());
        user.setImage(userForm.getImage());
        userService.createUser(user);
        return "redirect:/main/loading";
    }

    @ApiOperation(value="로딩(뒤에서 인공지능 돌아가므로 임의로 넣어둠)")
    @PostMapping("/main/loading")
    public String loading(UserForm form) {
        User user = new User(form.getName());
        user.setGender(form.isGender());
        user.setImage(form.getImage());
        userService.createUser(user);
        return "/main/loading";
    }

<<<<<<< HEAD
=======
    @ApiOperation(value="유저 회원가입 등록")
    @PostMapping("/resister")
    public String create(UserForm form){
        User user=new User(form.getName());
        //이래도 되나
        //user.setName(form.getName());
        //user.setPassword(form.getPassword());
//        user.setEmail(form.getPassword());
        //user.setGender(form.getGender());
        userService.createUser(user);
>>>>>>> 89e27bc07d4e3c0b2e44f3f244730f7924b12121


    //userService
    @ApiOperation("마이 페이지 조회")
    @GetMapping("/users")
    public String list(Model model){
        List<Member> users=userService.findUsers();
        model.addAttribute("users", users);
        return "users/userList";
    }



}

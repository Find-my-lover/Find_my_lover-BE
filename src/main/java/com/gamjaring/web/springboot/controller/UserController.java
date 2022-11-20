package com.gamjaring.web.springboot.controller;


import com.gamjaring.web.springboot.user.User;
import com.gamjaring.web.springboot.user.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Tag(name="signup", description="회원가입 API")
//@RequestMapping("/api/signup")
@Api(tags={"User"})
@RestController
public class UserController {
//    @Operation(summary = "get forms", description = "사용자의 회원가입 정보를 가져오기")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = User.class))),
//            @ApiResponse(responseCode = "400", description = "BAD REQUEST"),
//            @ApiResponse(responseCode = "404", description = "NOT FOUND"),
//            @ApiResponse(responseCode = "500", description = "INTERNAL SERVER ERROR")
//    })
//    @Parameters(
//            @Parameter(name = "password", description = "비번", example = "12345678!"),
//            @Parameter(name = "name", description = "이름", example = "감자링")
//    })

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    //임시적으로 local host 8080에서 바로 로그인으로 가게 만들어둠.
//    @GetMapping
//    public String root(){
//        return "redirect:/login";
//
//    }


    @ApiOperation(value="로그인 폼")
    @GetMapping("/login")
    public String loginForm(){
        return "/login";
    }
    @ApiOperation(value="회원가입 정보 폼")
    @GetMapping("/resister")
    public String createForm(){
        return "/resister";
    }

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

        return "redirect:/Login";
    }

    //userService
    @ApiOperation("마이 페이지 조회")
    @GetMapping("/users")
    public String list(Model model){
        List<User> users=userService.findUsers();
        model.addAttribute("users", users);
        return "users/userList";
    }



}

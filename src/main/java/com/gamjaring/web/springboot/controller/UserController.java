package com.gamjaring.web.springboot.controller;


import com.gamjaring.web.springboot.user.User;
import com.gamjaring.web.springboot.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService=userService;
    }

    @GetMapping("/resister")
    public String createForm(){
        return "/resister";
    }

    @PostMapping("/resister")
    public String create(UserForm form){
        User user=new User(form.getName(), form.getPassword());
        //이래도 되나
        //user.setName(form.getName());
        //user.setPassword(form.getPassword());
//        user.setEmail(form.getPassword());
        //user.setGender(form.getGender());
        userService.createUser(user);

        return "/Login";
    }

    @GetMapping("/users")
    public String list(Model model){
        List<User> users=userService.findUsers();
        model.addAttribute("users", users);
        return "users/userList";
    }



}

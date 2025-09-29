package com.pallidamors.memo.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/user")
@Controller
public class UserController {

    @GetMapping("/join")
    public String joinForm(){
        return "user/join";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "user/login";
    }



}

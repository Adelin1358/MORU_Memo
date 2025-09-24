package com.pallidamors.memo.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @ResponseBody
    @GetMapping("/hello")
    public String HelloWorld(){
        return "hello World!";
    }

    @GetMapping("/hello/html")
    public String helloHtml(){
        return "hello/hello";
    }
}

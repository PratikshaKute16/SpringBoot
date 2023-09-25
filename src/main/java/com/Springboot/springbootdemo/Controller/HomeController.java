package com.Springboot.springbootdemo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController
{
    @GetMapping("/")
    public String Hello()
    {
        return "Hello welcome to Springboot";
    }
}

package com.cybersoft.demospringboot03.controller;

/*
* Để định nghĩa đường dẫn thì ta có 2 cái annotation
* @Controller: dùng để định nghĩa đường dẫn khi nội dung của đường dẫn trả ra là 1 trang html
* @ResponseBody: Giúp Controller có thể trả ra kiểu String  dùng để viết API
* @RestController: dùng để viết API
* chuỗi API
* */

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("")
    public String hello(){

        return "Hello Spring Boot";
    }

    @GetMapping("/cybersoft")
    public String helloCyberSoft(){
        return "Hello CyberSoft";
    }
}

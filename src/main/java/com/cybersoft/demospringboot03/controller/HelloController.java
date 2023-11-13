package com.cybersoft.demospringboot03.controller;/*
* Để định nghĩa đường dẫn thì ta có 2 cái annotation
* @Controller: dùng để định nghĩa đường dẫn khi nội dung của đường dẫn trả ra là 1 trang html
* @ResponseBody: Giúp Controller có thể trả ra kiểu String  dùng để viết API
* @RestController: dùng để viết API
* chuỗi API
* */

import com.cybersoft.demospringboot03.Entity.Student;
import com.cybersoft.demospringboot03.payload.request.LoginRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/hello")
public class HelloController {
    // Tham số truyền trên trình duyệt: @RequestParam
    // Tham số truyền ngầm: @RequestParam
    // Tham số đóng vai tr như là 1 đường dẫn: @PathVariable
    // Tham số ngầm là đối tượng: @RequestBody

    List<Student> studentList = new ArrayList<Student>();
    @GetMapping("/student")
    public List<Student> getStudentList(){

        return studentList;
    }

    @PostMapping("/student/add")
    public List<Student> getStudentList(@RequestParam String name, @RequestParam int age){
        Student student = new Student(name,age);
        studentList.add(student);
        return studentList;
    }

    @PostMapping("/student/{name}/{age}")
    public ResponseEntity<?> getAllStudentList(@PathVariable String name, @PathVariable int age){
        try {
            Student student = new Student(name,age);
            studentList.add(student);
            return new ResponseEntity<>("Add success " + studentList ,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Error occurred while adding student.", HttpStatus.OK);
        }

    }

    @PostMapping("/student/add/v1")
    public ResponseEntity<?> getListStudent(@RequestBody Student student){
        try {
            studentList.add(student);
            return new ResponseEntity<>("Add success " + studentList, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Error occurred while adding student.", HttpStatus.OK);
        }
    }

}

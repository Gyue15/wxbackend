package cn.edu.nju.gyue.wxbackend.controller;

import cn.edu.nju.gyue.wxbackend.model.SchoolModel;
import cn.edu.nju.gyue.wxbackend.model.StudentModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/student", produces = "application/json;charset=UTF-8")
public class StudentController {

    @PostMapping("/login")
    public StudentModel login(String username, String password) {
        return null;
    }

    @PostMapping("/sign-up")
    public StudentModel signUp(String username, String password) {
        return null;
    }

    @PostMapping("/select-school")
    public StudentModel selectSchool(Long schoolId, String username) {
        return null;
    }

    @GetMapping("/schools")
    public List<SchoolModel> getSchoolList() {
        return null;
    }


}

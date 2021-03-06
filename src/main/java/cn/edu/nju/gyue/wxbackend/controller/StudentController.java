package cn.edu.nju.gyue.wxbackend.controller;

import cn.edu.nju.gyue.wxbackend.model.SchoolModel;
import cn.edu.nju.gyue.wxbackend.model.StudentModel;
import cn.edu.nju.gyue.wxbackend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/student", produces = "application/json;charset=UTF-8")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/login")
    public StudentModel login(String username, String password) {
        return studentService.login(username, password);
    }

    @PostMapping("/sign-up")
    public StudentModel signUp(String username, String password) {
        return studentService.signUp(username, password);
    }

    @PostMapping("/select-school")
    public StudentModel selectSchool(Long schoolId, Long studentId) {
//        return studentService.selectSchool("", studentId);
        return null;
    }

    @GetMapping("/schools")
    public List<SchoolModel> getSchoolList() {
        return studentService.getSchoolList();
    }

    @GetMapping("/personal-school")
    public SchoolModel getPersonalSchool(String openId){
        return null;
    }
}

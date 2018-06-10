package cn.edu.nju.gyue.wxbackend.controller;


import cn.edu.nju.gyue.wxbackend.model.SchoolModel;
import cn.edu.nju.gyue.wxbackend.service.OpenIdService;
import cn.edu.nju.gyue.wxbackend.service.SchoolService;
import cn.edu.nju.gyue.wxbackend.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/request", produces = "application/json;charset=UTF-8")
public class RequestController {

    @Autowired
    private SchoolService schoolService;
    @Autowired
    private OpenIdService openIdService;
    @Autowired
    private StudentService studentService;

    @GetMapping("/schoolList")
    public List<SchoolModel> getCanteenList() {
        return schoolService.getSchoolList();
    }

    @GetMapping("/openId")
    public String getOpenId(@RequestParam("code") String code){
        return openIdService.oauth2GetOpenid(code);
    }

    @GetMapping("/kitchen")
    public String kitchen(@RequestParam("openId") String openId){
        return studentService.getSchool(openId);
    }

    @GetMapping("/chooseKitchen")
    public void chooseKitchen(@RequestParam("openId")String openId,@RequestParam("kitchen") Long kitchen){
        studentService.selectSchool(kitchen,openId);
    }
}

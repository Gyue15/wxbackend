package cn.edu.nju.gyue.wxbackend.controller;


import cn.edu.nju.gyue.wxbackend.model.SchoolModel;
import cn.edu.nju.gyue.wxbackend.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/request", produces = "application/json;charset=UTF-8")
public class RequestController {

    @Autowired
    private SchoolService schoolService;

    @GetMapping("/schoolList")
    public List<SchoolModel> getCanteenList() {
        return schoolService.getSchoolList();
    }
}

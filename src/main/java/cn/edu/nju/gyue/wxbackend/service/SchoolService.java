package cn.edu.nju.gyue.wxbackend.service;

import cn.edu.nju.gyue.wxbackend.model.SchoolModel;

import java.util.List;

public interface SchoolService {
    //获得所有学校列表
    List<SchoolModel> getSchoolList();
}

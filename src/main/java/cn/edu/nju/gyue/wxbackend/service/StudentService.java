package cn.edu.nju.gyue.wxbackend.service;

import cn.edu.nju.gyue.wxbackend.model.SchoolModel;
import cn.edu.nju.gyue.wxbackend.model.StudentModel;

import java.util.List;

public interface StudentService {

    StudentModel login(String username, String password);

    StudentModel signUp(String username, String password);

    String selectSchool(Long schoolId, String openId);

    List<SchoolModel> getSchoolList();

    String getSchool(String openId);

}

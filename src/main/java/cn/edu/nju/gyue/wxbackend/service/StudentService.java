package cn.edu.nju.gyue.wxbackend.service;

import cn.edu.nju.gyue.wxbackend.model.SchoolModel;
import cn.edu.nju.gyue.wxbackend.model.StudentModel;

import java.util.List;

public interface StudentService {

    StudentModel login(String username, String password);

    StudentModel signUp(String username, String password);

    StudentModel selectSchool(Long schoolId, Long studentId);

    List<SchoolModel> getSchoolList();

}

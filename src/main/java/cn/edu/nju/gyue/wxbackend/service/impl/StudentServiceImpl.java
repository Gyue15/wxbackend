package cn.edu.nju.gyue.wxbackend.service.impl;

import cn.edu.nju.gyue.wxbackend.entity.OpenIdKitchen;
import cn.edu.nju.gyue.wxbackend.entity.School;
import cn.edu.nju.gyue.wxbackend.entity.Student;
import cn.edu.nju.gyue.wxbackend.exception.BadRequestException;
import cn.edu.nju.gyue.wxbackend.model.SchoolModel;
import cn.edu.nju.gyue.wxbackend.model.StudentModel;
import cn.edu.nju.gyue.wxbackend.repository.OpenIdKitchenRepository;
import cn.edu.nju.gyue.wxbackend.repository.SchoolRepository;
import cn.edu.nju.gyue.wxbackend.repository.StudentRepository;
import cn.edu.nju.gyue.wxbackend.service.StudentService;
import cn.edu.nju.gyue.wxbackend.service.component.TransferComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private TransferComponent transferComponent;

    @Autowired
    private OpenIdKitchenRepository openIdKitchenRepository;

    @Override
    public StudentModel login(String username, String password) {
        Student student = studentRepository.findByUsernameAndPassword(username, password);
        verifyStudent(student);
        return transferComponent.toModel(student);
    }

    @Override
    @Transactional
    public StudentModel signUp(String username, String password) {
        Student temp = studentRepository.findByUsername(username);
        if (temp != null) {
            throw new BadRequestException("改用户名已被注册");
        }
        Student student = new Student();
        student.setUsername(username);
        student.setPassword(password);
        student.setHasSchool(false);
        student = studentRepository.saveAndFlush(student);
        return transferComponent.toModel(student);
    }

    @Override
    public String selectSchool(Long schoolId,String openId) {
        Optional<School> schoolOptional = schoolRepository.findById(schoolId);
        if (!schoolOptional.isPresent()) {
            return "没有该学校";
        }
        OpenIdKitchen openIdKitchen = openIdKitchenRepository.findByOpenId(openId);
        if(openIdKitchen == null) {
            OpenIdKitchen openIdKitchen2 = new OpenIdKitchen();
            openIdKitchen2.setOpenId(openId);
            openIdKitchen2.setKitchen(schoolId);
            openIdKitchenRepository.save(openIdKitchen2);
            return "success";
        }
        openIdKitchen.setKitchen(schoolId);
        openIdKitchenRepository.saveAndFlush(openIdKitchen);
        return "success";
    }

    @Override
    public List<SchoolModel> getSchoolList() {
        List<School> schoolList = schoolRepository.findAll();
        return schoolList.stream().map(transferComponent::toModel).collect(Collectors.toList());
    }

    @Override
    public String getSchool(String openId) {
        OpenIdKitchen openIdKitchen = openIdKitchenRepository.findByOpenId(openId);
        if(openIdKitchen ==null){
            return "请选择学校";
        }else {
            School school = schoolRepository.findBySchoolId(openIdKitchen.getKitchen());
            return school.getSchoolName();
        }
    }

    private void verifyStudent(Student student) {
        if (student == null || student.getStudentId() == null) {
            throw new BadRequestException("用户名或密码错误");
        }
    }
}

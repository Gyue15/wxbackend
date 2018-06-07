package cn.edu.nju.gyue.wxbackend.service.impl;

import cn.edu.nju.gyue.wxbackend.entity.School;
import cn.edu.nju.gyue.wxbackend.entity.Student;
import cn.edu.nju.gyue.wxbackend.exception.BadRequestException;
import cn.edu.nju.gyue.wxbackend.model.SchoolModel;
import cn.edu.nju.gyue.wxbackend.model.StudentModel;
import cn.edu.nju.gyue.wxbackend.repository.SchoolRepository;
import cn.edu.nju.gyue.wxbackend.repository.StudentRepository;
import cn.edu.nju.gyue.wxbackend.service.StudentService;
import cn.edu.nju.gyue.wxbackend.service.component.TransferComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private TransferComponent transferComponent;

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
    public StudentModel selectSchool(Long schoolId, Long studentId) {
        Optional<School> schoolOptional = schoolRepository.findById(schoolId);
        if (!schoolOptional.isPresent()) {
            throw new BadRequestException("没有该学校");
        }
        School school = schoolOptional.get();

        Optional<Student> studentOptional = studentRepository.findById(schoolId);
        if (!studentOptional.isPresent()) {
            throw new BadRequestException("没有该学生");
        }
        Student student = studentOptional.get();

        student.setHasSchool(true);
        student.setSchool(school);
        student = studentRepository.saveAndFlush(student);

        return transferComponent.toModel(student);
    }

    @Override
    public List<SchoolModel> getSchoolList() {
        List<School> schoolList = schoolRepository.findAll();
        return schoolList.stream().map(transferComponent::toModel).collect(Collectors.toList());
    }

    private void verifyStudent(Student student) {
        if (student == null || student.getStudentId() == null) {
            throw new BadRequestException("用户名或密码错误");
        }
    }
}

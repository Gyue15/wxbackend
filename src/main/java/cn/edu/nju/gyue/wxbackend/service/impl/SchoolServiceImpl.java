package cn.edu.nju.gyue.wxbackend.service.impl;

import cn.edu.nju.gyue.wxbackend.entity.School;
import cn.edu.nju.gyue.wxbackend.model.SchoolModel;
import cn.edu.nju.gyue.wxbackend.repository.SchoolRepository;
import cn.edu.nju.gyue.wxbackend.service.SchoolService;
import cn.edu.nju.gyue.wxbackend.service.component.TransferComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolServiceImpl implements SchoolService{

    @Autowired
    private SchoolRepository schoolRepository;

    @Autowired
    private TransferComponent transferComponent;


    @Override
    public List<SchoolModel> getSchoolList() {
        List<School> schoolList = schoolRepository.findAll();
        return schoolList.stream().map(transferComponent::toModel).collect(Collectors.toList());
    }
}

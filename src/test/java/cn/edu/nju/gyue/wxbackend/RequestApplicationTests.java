package cn.edu.nju.gyue.wxbackend;

import cn.edu.nju.gyue.wxbackend.service.SchoolService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RequestApplicationTests {
    @Autowired
    SchoolService schoolService;

    @Test
    public void getSchoolList() {
        System.out.println(schoolService.getSchoolList());
    }

}

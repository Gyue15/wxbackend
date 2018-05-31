package cn.edu.nju.gyue.wxbackend.controller;

import cn.edu.nju.gyue.wxbackend.entity.Canteen;
import cn.edu.nju.gyue.wxbackend.repository.CanteenRepository;
import cn.edu.nju.gyue.wxbackend.repository.WindowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private CanteenRepository canteenRepository;

    @Autowired
    private WindowRepository windowRepository;

    @GetMapping("/")
    public String demo() {

        Canteen canteen = new Canteen();
        canteen.setCanteenName("测试");
        canteen.setPassword("123456");

        canteen = canteenRepository.save(canteen);

        return canteen.getCanteenName();
    }
}

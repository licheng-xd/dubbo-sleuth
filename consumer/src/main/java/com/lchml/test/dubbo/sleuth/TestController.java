package com.lchml.test.dubbo.sleuth;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lc on 2018/06/28.
 */
@RestController
public class TestController {

    public TestController() {
        System.out.println("init test controller");
    }

    @Reference(check = false, version = "1.0.0")
    private TestService testService;

    @RequestMapping("/")
    public String getTime() {
        return testService.getTime();
    }
}

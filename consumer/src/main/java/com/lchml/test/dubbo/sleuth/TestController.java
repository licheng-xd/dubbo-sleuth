package com.lchml.test.dubbo.sleuth;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lchml.test.dubbo.sleuth.api.TestService;
import com.lchml.test.dubbo.sleuth.api.TestService2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by lc on 2018/06/28.
 */
@RestController
public class TestController extends AbstractController {

    private LocalBean localBean;

    public TestController() {
        System.out.println("init test controller");
        localBean = new LocalBean();
    }

    @Reference(check = false, version = "1.0.0")
    private TestService testService;

    @Reference(check = false, version = "1.0.0")
    private TestService2 testService2;

    @Resource
    private TracingTest tracingTest;


    @RequestMapping("/")
    public String getTime() {
        System.out.println(localBean.test());
        return testService.getTime();
    }

    @RequestMapping("/2")
    public String getTime2() {
        return testService2.getTime2();
    }
}

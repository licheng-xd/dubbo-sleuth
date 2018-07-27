package com.lchml.test.dubbo.sleuth;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lchml.test.dubbo.sleuth.api.TestService;
import com.lchml.test.dubbo.sleuth.api.TestService2;
import com.lchml.test.dubbo.sleuth.feign.TestApiService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by lc on 2018/06/28.
 */
@RestController
public class TestController {

    @Reference(check = false, version = "1.0.0")
    private TestService testService;

    @Reference(check = false, version = "1.0.0")
    private TestService2 testService2;

    @Resource
    private TestApiService testApiService;

    @RequestMapping("/")
    public String getTime(HttpServletRequest request) {
        return testService.getTime();
    }

    @RequestMapping("/test")
    public Object test(HttpServletRequest request) {
        System.out.println(request.getHeader("X-B3-TraceId"));
        return "hello";
    }

    @RequestMapping("/feign")
    public String feign(HttpServletRequest request) {
        return testApiService.test();
    }

    @RequestMapping("/2")
    public String getTime2() {
        return testService2.getTime2();
    }
}

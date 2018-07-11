package com.lchml.test.dubbo.sleuth;

import com.alibaba.dubbo.config.annotation.Service;
import com.lchml.test.dubbo.sleuth.api.TestService2;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Created by lc on 2018/07/02.
 */
@Service(version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}")
@Component
public class TestService2Impl implements TestService2 {



    public TestService2Impl() {

    }

    @Override
    public String getTime2() {
        try {
            System.out.println("sleep 200 ms ......");
            Thread.sleep(200);
        } catch (InterruptedException e) {

        }
        return new Date().toString();
    }
}

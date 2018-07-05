package com.lchml.test.dubbo.sleuth;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.lchml.test.dubbo.sleuth.api.TestService;
import com.lchml.test.dubbo.sleuth.api.TestService2;
import org.springframework.stereotype.Component;

/**
 * Created by lc on 2018/06/27.
 */
@Service(version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}")
@Component
public class TestServiceImpl implements TestService {

    @Reference(check = false, version = "1.0.0")
    private TestService2 testService2;

    @Override
    public String getTime() {
        try {
            System.out.println("sleep 100 ms ......");
            Thread.sleep(100);
        } catch (InterruptedException e) {

        }
        return testService2.getTime2();
    }
}

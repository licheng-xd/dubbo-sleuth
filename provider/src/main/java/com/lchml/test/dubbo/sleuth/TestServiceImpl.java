package com.lchml.test.dubbo.sleuth;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by lc on 2018/06/27.
 */
@Service(version = "1.0.0",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}")
public class TestServiceImpl implements TestService {

    @Override
    public String getTime() {
        return new Date().toString();
    }
}

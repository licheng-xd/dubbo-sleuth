package com.lchml.test.hikari;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * Created by lc on 2018/07/09.
 */
@Service(version = "1.0.0")
public class TestService {
    public String test() {
        return "hello";
    }
}

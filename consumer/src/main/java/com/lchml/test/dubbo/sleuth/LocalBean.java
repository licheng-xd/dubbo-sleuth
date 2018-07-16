package com.lchml.test.dubbo.sleuth;

import org.springframework.beans.factory.InitializingBean;

/**
 * test for importSelector
 *
 * Created by lc on 2018/07/04.
 */
public class LocalBean implements InitializingBean {

    public String test() {
        return "test";
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("LocalBean afterPropertiesSet");
    }
}

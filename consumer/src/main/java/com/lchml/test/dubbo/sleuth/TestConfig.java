package com.lchml.test.dubbo.sleuth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by lc on 2018/07/04.
 */
@Configuration
public class TestConfig {

    @Bean
    public LocalBean localBean() {
        return new LocalBean();
    }
}

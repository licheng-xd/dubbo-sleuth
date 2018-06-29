package com.lchml.test.dubbo.sleuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by lc on 2018/06/27.
 */
@SpringBootApplication
public class ComsumerMain {

    public static void main(String[] args) throws InterruptedException {
        new SpringApplicationBuilder(ComsumerMain.class)
                .web(WebApplicationType.SERVLET) // 非 Web 应用
                .run(args);
    }
}

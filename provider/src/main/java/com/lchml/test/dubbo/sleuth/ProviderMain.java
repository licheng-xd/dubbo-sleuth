package com.lchml.test.dubbo.sleuth;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by lc on 2018/06/27.
 */
@SpringBootApplication
public class ProviderMain {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ProviderMain.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }
}

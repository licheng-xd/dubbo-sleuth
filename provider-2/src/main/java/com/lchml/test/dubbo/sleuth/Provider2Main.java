package com.lchml.test.dubbo.sleuth;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * Created by lc on 2018/07/02.
 */
@SpringBootApplication
public class Provider2Main {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Provider2Main.class)
                .web(WebApplicationType.NONE)
                .run(args);

    }
}

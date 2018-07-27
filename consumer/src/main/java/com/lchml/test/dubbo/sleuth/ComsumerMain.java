package com.lchml.test.dubbo.sleuth;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.sleuth.instrument.web.client.TraceWebClientAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by lc on 2018/06/27.
 */
@EnableTest
//@Import(TraceWebClientAutoConfiguration.class)
@SpringBootApplication
public class ComsumerMain implements WebMvcConfigurer {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ComsumerMain.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}

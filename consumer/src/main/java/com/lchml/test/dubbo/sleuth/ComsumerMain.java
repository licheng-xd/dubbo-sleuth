package com.lchml.test.dubbo.sleuth;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by lc on 2018/06/27.
 */
@SpringBootApplication
@EnableTest
public class ComsumerMain implements WebMvcConfigurer {

    @Bean
    public LogInterceptor logInterceptor() {
        return new LogInterceptor();
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(logInterceptor());
//    }

    public static void main(String[] args) {
        new SpringApplicationBuilder(ComsumerMain.class)
                .web(WebApplicationType.SERVLET) // 非 Web 应用
                .run(args);
    }
}

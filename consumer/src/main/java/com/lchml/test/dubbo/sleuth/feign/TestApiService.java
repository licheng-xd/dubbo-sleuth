package com.lchml.test.dubbo.sleuth.feign;

import brave.Tracing;
import brave.spring.web.TracingClientHttpRequestInterceptor;
import feign.*;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.okhttp.OkHttpClient;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by lc on 2018/07/27.
 */
@Component
public class TestApiService implements InitializingBean {

    private TestApi api;

    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient();
    }

    @Resource
    private Client okHttpClient;

    @Override
    public void afterPropertiesSet() throws Exception {
        api = Feign.builder()
                .retryer(Retryer.NEVER_RETRY)
                .client(okHttpClient)
                .options(new Request.Options(5000, 5000))
//                .encoder(new JacksonEncoder()) b
//                .decoder(new JacksonDecoder())
                .errorDecoder(new FeignErrorDecoder())
//                .requestInterceptor(TracingClientHttpRequestInterceptor.create(tracing))
                .target(TestApi.class, "http://127.0.0.1:2016");
    }

    public String test() {
        return api.test();
    }
}

package com.lchml.test.dubbo.sleuth.feign;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;

import java.io.InputStream;

/**
 *
 * Created by hzcaojiajun on 2018/6/4.
 */
public class FeignErrorDecoder implements ErrorDecoder {

    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public Exception decode(String methodKey, Response response) {
        return new Exception();
    }
}

package com.lchml.test.dubbo.sleuth.feign;

import feign.Headers;
import feign.RequestLine;

/**
 * Created by lc on 2018/07/27.
 */
@Headers({"Content-Type: application/json", /*"Accept: application/json"*/})
public interface TestApi {

    @RequestLine("POST /test")
    String test();
}

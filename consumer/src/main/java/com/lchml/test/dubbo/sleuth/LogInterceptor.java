package com.lchml.test.dubbo.sleuth;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by lc on 2018/05/23.
 */
public class LogInterceptor extends HandlerInterceptorAdapter {

    @Resource
    private TracingTest tracingTest;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String s = tracingTest.invoke();
        System.out.println(s);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
    }
}

package com.lchml.test.hikari;

import com.alibaba.boot.dubbo.context.event.WelcomeLogoApplicationListener;
import com.google.common.collect.Sets;
import com.lchml.test.hikari.dao.UserDao;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationListener;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.LinkedHashSet;

/**
 * Created by lc on 2018/07/09.
 */
@RestController
@MapperScan(basePackageClasses = UserDao.class)
@SpringBootApplication
public class HikariTest {
    @Resource
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplicationBuilder(HikariTest.class)
                .web(WebApplicationType.SERVLET).bannerMode(Banner.Mode.OFF).build();
//        app.addListeners(new TestApplicationListener());
        LinkedHashSet<ApplicationListener<?>> modifyListeners = Sets.newLinkedHashSet();
        modifyListeners.addAll(app.getListeners());
        modifyListeners.removeIf(applicationListener -> applicationListener instanceof WelcomeLogoApplicationListener);
        app.setListeners(modifyListeners);
        app.run(args);
    }

    @RequestMapping("/get/{id}")
    public Object get(@PathVariable long id) {
        System.out.println("get " + id);
        return userService.get(id);
    }

    @RequestMapping("add/{name}")
    public Object add(@PathVariable String name) {
        System.out.println("add " + name);
        return userService.insertSelective(new User(name));
    }
}

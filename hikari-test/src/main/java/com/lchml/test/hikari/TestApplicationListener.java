package com.lchml.test.hikari;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.logging.LoggingApplicationListener;
import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;

/**
 * Created by lc on 2018/07/09.
 */
@Order(LoggingApplicationListener.DEFAULT_ORDER)
public class TestApplicationListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event)
    {

        /**
         * Gets Logger After LoggingSystem configuration ready
         * @see LoggingApplicationListener
         */
        final Logger logger = LoggerFactory.getLogger(getClass());
        System.out.println("test application listener");

    }
}

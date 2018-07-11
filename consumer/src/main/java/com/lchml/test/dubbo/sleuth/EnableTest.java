package com.lchml.test.dubbo.sleuth;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by lc on 2018/07/04.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(EnableTestImportSelector.class)
public @interface EnableTest {

//    String value () default "";
}

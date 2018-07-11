package com.lchml.test.dubbo.sleuth;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

/**
 * Created by lc on 2018/07/04.
 */
//@Component
public class EnableTestImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{TestConfig.class.getName()};
    }
}

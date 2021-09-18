package com.ruoyi.client.handler.impl;

import com.ruoyi.client.annotation.column.AVueDynamic;
import com.ruoyi.client.enums.AVueAttrLevel;
import com.ruoyi.client.handler.AVueAnnotationHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.util.Map;

/**
 * 动态子表单处理
 *
 * @author liukaixiong
 * @Email liukx@elab-plus.com
 * @date 2021/8/30 - 10:41
 */
public class DynamicAnnotationHandler extends DefaultAnnotationHandler {

    @Autowired
    private AVueAnnotationHandler annotationHandler;

    @Override
    public Map<String, Object> handler(AVueAttrLevel leve, AnnotatedElement element, Annotation annotation) {
        Class<?> type = ((Field)element).getType();

        Map<String, Object> handler = super.handler(leve, element, annotation);

        Map<String, Map<String, Object>> clazzAnnotationMap = annotationHandler.parse(type);

        if (clazzAnnotationMap.size() > 0) {
            Map<String, Object> result = clazzAnnotationMap.get(AVueAttrLevel.OPTION.getKeyName());
//            result.put("type", "form");
            handler.put("children", result);
        }

        return handler;
    }

    @Override
    public boolean preHandler(AVueAttrLevel level, Annotation element) {
        return element.annotationType().equals(AVueDynamic.class);
    }
}

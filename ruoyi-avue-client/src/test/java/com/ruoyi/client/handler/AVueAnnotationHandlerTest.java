package com.ruoyi.client.handler;

//import com.alibaba.fastjson.JSON;

import com.ruoyi.client.RuoYiClientTestApplication;
import com.ruoyi.client.annotation.EnableAVue;
import com.ruoyi.client.config.props.AVueProperties;
import com.ruoyi.client.handler.impl.DefaultAnnotationHandler;
import com.ruoyi.client.model.*;
import com.ruoyi.client.processor.DicDataProcess;
import com.ruoyi.client.utils.JsonParseUtils;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RuoYiClientTestApplication.class})
@EnableAVue(basePackages = "com.ruoyi.client.model")
@EnableConfigurationProperties(AVueProperties.class)
public class AVueAnnotationHandlerTest extends TestCase {

    @Autowired
    private AVueAnnotationHandler annotationHandler;

    @Test
    public void testAVueCrudModel() {
        Map<String, Map<String, Object>> parse = annotationHandler.parse(AVueCrudModel.class);
        System.out.println(JsonParseUtils.toJson(parse));
    }

    @Test
    public void testParse() {
        Map<String, Map<String, Object>> parse = annotationHandler.parse(AVueDynamicModel.class);
        System.out.println(JsonParseUtils.toJson(parse));
    }

    @Test
    public void testAVueGroupModel() {
        Map<String, Map<String, Object>> parse = annotationHandler.parse(AVueGroupModel.class);
        System.out.println(JsonParseUtils.toJson(parse));
    }

    @Test
    public void testJson() {
        PropsModel props = new PropsModel();
        String s = JsonParseUtils.toJson(props);
        System.out.println(s);

        PropsModel parse = JsonParseUtils.parse(s, PropsModel.class);
        System.out.println(parse);
    }
}
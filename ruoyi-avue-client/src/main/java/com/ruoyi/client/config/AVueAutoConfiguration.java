package com.ruoyi.client.config;

import com.ruoyi.client.annotation.AVueGroup;
import com.ruoyi.client.annotation.column.AVueJson;
import com.ruoyi.client.config.props.AVueProperties;
import com.ruoyi.client.controller.AVueController;
import com.ruoyi.client.handler.impl.DefaultAnnotationHandler;
import com.ruoyi.client.handler.impl.DynamicAnnotationHandler;
import com.ruoyi.client.handler.impl.GroupAnnotationHandler;
import com.ruoyi.client.handler.impl.NewImportComponentsHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * AVue使用自动化配置
 *
 * @author liukaixiong
 * @Email liukx@elab-plus.com
 * @date 2021/8/18 - 16:56
 */
@EnableConfigurationProperties(AVueProperties.class)
@ComponentScan(basePackages = {"com.ruoyi.client"})
@Configuration
public class AVueAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean(value = DefaultAnnotationHandler.class)
    public DefaultAnnotationHandler defaultAnnotationHandler() {
        DefaultAnnotationHandler defaultAnnotationHandler = new DefaultAnnotationHandler();
        defaultAnnotationHandler.addExcludeAnnotationSet(AVueGroup.class);
        return defaultAnnotationHandler;
    }

    @Bean
    @ConditionalOnMissingBean(value = DynamicAnnotationHandler.class)
    public DynamicAnnotationHandler dynamicAnnotationHandler() {
        return new DynamicAnnotationHandler();
    }

    @Bean
    @ConditionalOnMissingBean(value = GroupAnnotationHandler.class)
    public GroupAnnotationHandler groupAnnotationHandler() {
        return new GroupAnnotationHandler();
    }

    @Bean
    @ConditionalOnMissingBean(value = NewImportComponentsHandler.class)
    public NewImportComponentsHandler newImportComponentsHandler() {
        // 新注册的组件处理
        NewImportComponentsHandler newImportComponentsHandler = new NewImportComponentsHandler();
        newImportComponentsHandler.addRegisterComponent(AVueJson.class);
        return newImportComponentsHandler;
    }

}

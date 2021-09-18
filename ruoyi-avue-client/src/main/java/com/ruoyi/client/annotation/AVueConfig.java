package com.ruoyi.client.annotation;

import java.lang.annotation.*;

/**
 * 描述: 评价选择器
 *
 * @author liukx
 * @date 2021/8/16 18:51
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AVueConfig {
    /**
     * 列表的服务路径
     *
     * @return
     */
    String list();
    /**
     * 保存的服务请求路径
     *
     * @return
     */
    String save() default "";

    /**
     * 修改的服务路径
     *
     * @return
     */
    String update() default "";

    /**
     * 删除的服务路径
     *
     * @return
     */
    String del() default "";

    AVueAttr[] attrExt() default {};
}

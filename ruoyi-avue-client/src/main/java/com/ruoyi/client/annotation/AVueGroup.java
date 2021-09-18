package com.ruoyi.client.annotation;

import com.ruoyi.client.annotation.AVueAttr;
import com.ruoyi.client.annotation.AVueRule;

import java.lang.annotation.*;

/**
 * 描述: dynamic属性 子表单
 *
 * @author liukx
 * @date 2021/8/16 18:51
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AVueGroup {
    /**
     * 展现类型
     *
     * @return
     */
    String type() default "group";

    /**
     * 属性名称
     *
     * @return
     */
    String prop();

    /**
     * 文本描述
     *
     * @return
     */
    String label();

    /**
     * 字段排序
     *
     * @return
     */
    int order() default 0;

    /**
     * 是否单独成行
     *
     * @return
     */
    boolean row() default false;

    /**
     * 是否可以清空选项
     *
     * @return
     */
    boolean clearable() default false;

    /**
     * 是否禁止编辑
     *
     * @return
     */
    boolean disabled() default false;

    /**
     * 文字提示
     *
     * @return
     */
    String tip() default "";

    /**
     * 标题文字提示
     *
     * @return
     */
    String labelTip() default "";

    /**
     * 辅助语: 比如'请选择','请输入'
     *
     * @return
     */
    String placeholder() default "";

    /**
     * 深结构数据绑定取值
     * <p>
     * 比如 : deep.deep.deep.value
     *
     * @return
     */
    String bind() default "";

    /**
     * 是否只读
     * 比如创建时间
     *
     * @return
     */
    boolean readonly() default false;

    /**
     * 是否可见
     *
     * @return
     */
    boolean display() default false;

    /**
     * 表格页面是否展示
     *
     * @return
     */
    boolean hide() default false;

    /* ********************************** 表单常用属性 ***************************************** */

    /**
     * 表单新增时是否禁止
     *
     * @return
     */
    boolean addDisabled() default false;

    /**
     * 表单新增时是否可见
     *
     * @return
     */
    boolean addDisplay() default true;

    /**
     * 表单新增时是否为查看模式
     *
     * @return
     */
    boolean addDetail() default false;

    /**
     * 表单编辑时是否禁止
     *
     * @return
     */
    boolean editDisabled() default false;

    /**
     * 表单编辑时是否可见
     *
     * @return
     */
    boolean editDisplay() default true;

    /**
     * 表单编辑时是否为查看模式
     *
     * @return
     */
    boolean editDetail() default false;

    /**
     * 开启排序
     *
     * @return
     */
    boolean sortable() default false;

    /* ********************************** ********** ******************************************/

    /**
     * 最小行/最小值
     *
     * @return
     */
    int minRows() default 2;

    /**
     * 最大行/最大值
     *
     * @return
     */
    int maxRows() default 4;

    /**
     * 密码是否可见
     *
     * @return
     */
    boolean showPassword() default true;

    /**
     * 是否显示输入字数统计
     *
     * @return
     */
    boolean showWordLimit() default true;

    /**
     * 输入框头部图标
     *
     * @return
     */
    String prefixIcon() default "";

    /**
     * 输入框尾部图标
     *
     * @return
     */
    String suffixIcon() default "";

    /**
     * 是否作为搜索字段
     *
     * @return
     */
    boolean search() default false;

    /**
     * 拓展字段
     *
     * @return
     */
    AVueAttr[] attrExt() default {};

    /**
     * 校验规则
     *
     * @return
     */
    AVueRule[] rules() default {};

    boolean required() default false;

}
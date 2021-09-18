package com.ruoyi.client.annotation;

import java.lang.annotation.*;

/**
 * 描述: 选项配置
 *
 * @author liukx
 * @date 2021/8/16 18:51
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AVueTableOption {

    /**
     * 页面根路径,多层级可以用.号分割
     *
     * @return
     */
    String pageRoot() default "";

    /**
     * 分页 - 页码的属性名称
     *
     * @return
     */
    String pageNumber() default "pageNumber";

    /**
     * 分页 - 每页大小的属性名称
     *
     * @return
     */
    String pageSize() default "pageSize";

    /**
     * 分页 - 页总数的名字
     *
     * @return
     */
    String pageTotal() default "total";

    /**
     * 分页 - 数据总数的名称
     *
     * @return
     */
    String pageData() default "data";

    /**
     * 表格头部表格
     *
     * @return
     */
    String title() default "";

    /**
     * 添加按钮 是否显示
     *
     * @return
     */
    boolean addBtn() default true;

    /**
     * 新增窗口文案
     *
     * @return
     */
    String addTitle() default "新增";

    /**
     * 表格行编辑时添加按钮
     *
     * @return
     */
    boolean addRowBtn() default false;

    /**
     * 表格列齐方式
     *
     * @return
     */
    String align() default "left";

    /**
     * 回车按键触发提交表单
     *
     * @return
     */
    boolean enter() default false;

    /**
     * 表格边框
     *
     * @return
     */
    boolean border() default false;

    /**
     * 表格行编辑操作按钮
     *
     * @return
     */
    boolean cellBtn() default true;

    /**
     * 表格以卡片分层模式显示，搜索部分和主体部分分层展示
     *
     * @return
     */
    boolean card() default true;

    /**
     * 日期组件按钮
     *
     * @return
     * @link https://avuejs.com/crud/crud-datetime
     */
    boolean dateBtn() default false;

    /**
     * 行内删除按钮
     *
     * @return
     */
    boolean delBtn() default true;

    /**
     * 是否默认展开所有行，"expand"为true的时候有效
     *
     * @return
     */
    boolean defaultExpandAll() default false;

    /**
     * 是否允许拖拽
     * @return
     */
    boolean dialogDrag() default false;

    /**
     * 行内编辑按钮
     *
     * @return
     */
    boolean editBtn() default true;

    /**
     * 导出Excel按钮
     *
     * @return
     */
    boolean excelBtn() default false;

    /**
     * 自定义过滤表格列按钮
     *
     * @return
     */
    boolean filterBtn() default false;

    /**
     * 是列的宽度是否自撑开属性
     *
     * @return
     */
    boolean fit() default true;

    /**
     * 是否显示序号
     *
     * @return
     */
    boolean index() default false;

    /**
     * 是否显示操作菜单栏
     *
     * @return
     */
    boolean menu() default true;

    /**
     * 是否显示操作菜单栏
     *
     * @return
     */
    boolean printBtn() default true;

    /**
     * 刷新按钮
     *
     * @return
     */
    boolean refreshBtn() default true;

    /**
     * 保存按钮
     *
     * @return
     */
    boolean saveBtn() default true;

    /**
     * 更新按钮
     *
     * @return
     */
    boolean updateBtn() default true;

    /**
     * 取消按钮
     *
     * @return
     */
    boolean cancelBtn() default true;

    /**
     * 行的主键
     *
     * @return
     */
    String rowKey() default "id";

    /**
     * 编辑窗口文案
     *
     * @return
     */
    String editTitle() default "编辑";

    /**
     * 数据为空文案
     *
     * @return
     */
    String emptyText() default "暂无数据";

    AVueAttr[] attrExt() default {};
}

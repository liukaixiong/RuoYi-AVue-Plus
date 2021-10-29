

**一款基于Java注解模版或者JSON模版就能轻松完成复杂的增删改查的页面渲染以及事件交互，让后端小伙伴不在为了查询表单而头疼。**

## 应用场景

后端人员在进行开发的时候，难免需要页面呈现来进行数据的增删改查(比如后台管理系统)。虽然说目前前端的技术框架已经非常成熟，但是仅仅为了一个模块的增删改查，在目前微服务盛行的情况下，要么搭建一个前端项目，要么耦合在后端，后续又难免又要引入一些插件，这些插件对于前端小伙伴来说很简单，但是后端同学要花非常多的时间熟悉**API**，联调调试。

有没有办法让后端不需要关注前端的各种组件的集成？直接在后端定义组件的类型和结构！直接让前端拿去渲染就行了？这样后端也不用去搭建项目或者耦合静态文件在服务中，不要写一行前端代码，就把页面的增删改查就给完成了！

由于后端对Spring的注解已经非常熟悉了，我们可以直接对页面进行实体的绑定，通过注解来渲染一个个组件。

借助`AVue`的数据驱动组件渲染的方式，后端将数据定义好，直接返回。

## 项目介绍

该项目主要是为了解放后端双手、降低页面编写的门槛以及搭建成本而成。

其基础框架模型是以[ruoyi](https://gitee.com/y_project/RuoYi-Vue) 应用为核心搭建，解决后台系统中的基础功能：用户、部门、菜单、权限、代码生成。

> 该框架体验了一下，还是非常棒的，万赞项目。基本上不用写过多代码。但是前端页面可能没有AVue灵活。

另外一个核心框架是[AVue](https://gitee.com/smallweigit/avue)，它的核心理念是数据驱动页面渲染，非常适合开发人员上手，作为组件是非常棒的，但是如果要成为一套完全通用的后台管理系统还是得花很多心思在前端。

> 另外该作者还有一个项目[avue-cli](https://gitee.com/smallweigit/avue-cli)，也是基于AVue为核心开发的，定位是后台管理系统，研究了一下发现要达到通用后台管理前后端打通还需要花费蛮多心思的，我侧重后端，但还是推荐给大家。	

而本应用是基于两款非常优秀的框架之上进行整合，打通前后端。后端通过**注解**的方式定义页面的组件、属性、接口、事件等等，本质上还是转换`AVue` 识别的 `JSON` ，但还是会基于`AVue`之上再做增强。

并且针对功能做了很多增强，基础架子搭好，更易拓展、更易开发，如果需要定制也非常简单。

如果遇到那种花里胡哨的页面，也可以通过编码方式自行完成。保留`AVue`和`RuoYi`的原始功能，自行编写代码和普通项目没啥区别，还更快速！

**本项目只能尽可能解决大部分增删改查场景，极端复杂场景可借助两个优秀项目优秀特性自行编码开发，他们提供的文档已经非常完善了。**

## 文档



为了提升阅读体验可以观看全局文档:

[全局文档点击观看](https://www.yuque.com/docs/share/912323d1-644e-44c7-8488-4bf7e1583fba)

[全局文档点击观看](https://www.yuque.com/docs/share/912323d1-644e-44c7-8488-4bf7e1583fba)

[全局文档点击观看](https://www.yuque.com/docs/share/912323d1-644e-44c7-8488-4bf7e1583fba)



使用前稍微了解下:

- [AVue的组件官网](https://avuejs.com/form/form-event.html) : 大部分注解都是基于AVue的属性设计而来。
- [ruoyi的文档地址](http://doc.ruoyi.vip/) : 针对一些部署情况，如果是后端同学只需要稍微了解nodejs的情况。
- 相对于`ruoyi`的[改动文档](./doc/ruoyi.md)

## 如何使用

[1. 环境搭建以及项目引入以及效果展示](./doc/introduction.md)

[2. 前端ruoyi-avue-ui环境搭建](./ruoyi-avue-ui/README.md)

## 代码结构

[ruoyi-avue-client 相关](./ruoyi-avue-client/README.md)

[注解相关的介绍](./doc/annotation.md)

## 展示图

### 1. 操作介绍

负责展示了各模块的关系

![image-20211029110727955](https://gitee.com/liukaixiong/drawing-bed/raw/master/image/image-20211029110727955.png)

### 2. 模版案例

```java
@AVueRouteKey(groupKey = "test-route")
@AVueTableOption(title = "这是一个测试")
@AVueConfig(list = AVueControllerTest.LIST_URL, update = AVueControllerTest.UPDATE_URL, save = AVueControllerTest.UPDATE_URL)
public class AVueCrudModel {

    @AVueInput(prop = "id", label = "主键", addDisplay = false, editDisabled = true, search = true)
    private String id;

    @AVueInput(prop = "username", label = "用户名称", search = true)
    private String username;

    @AVueSelect(prop = "checkStatus", label = "认证状态", dicData = "CheckStatusEnums", search = true)
    private String checkStatus;

    @AVueSelect(prop = "likeStar", label = "喜欢明星", dicData = "test-likeStar-map")
    private Integer likeStar;

    @AVueNumber(prop = "age", label = "年龄", labelTip = "这是选择年龄的地方")
    private Integer age;

    @AVueRadio(prop = "sex", label = "性别", border = true, dicData = "SexEnums")
    private int sex;

    @AVueDatetime(prop = "validDate", label = "有效时间")
    private Date validDate;

    @AVueTime(prop = "time", label = "时分秒选择")
    private Date time;

    @AVueTimeRange(prop = "timeRange", label = "时分秒范围")
    private Date timeRange;

    @AVueDateRange(prop = "dateRange", rangeSeparator = "-", label = "日期范围", search = true, valueFormat = "yyyy年MM月dd日", format = "yyyy-MM-dd")
    private String dateRange;

    @AVueCheckbox(prop = "interest", label = "兴趣爱好", dicData = "InterestEnums")
    private List<String> interest;

    @AVueSwitch(prop = "status", label = "状态", dicData = "StatusEnums")
    private int status;

    @AVueDynamic(prop = "simpleModel", label = "子表单测试")
    private AVueSimpleModel simpleModel;

    @AVueGroup(prop = "groupModel", label = "分组测试1")
    private AVueNodeModel groupModel;

    @AVueGroup(prop = "groupModel2", label = "分组测试2")
    private AVueNodeModel groupModel2;
    // 省略get/set .... 其实如果只作为模版的话不需要getset.
}
```

### 3. 页面展示

#### 1. 列表页效果

![](https://gitee.com/liukaixiong/drawing-bed/raw/master/image/rq10ne.png)

#### 2. 新增页面效果

![](https://gitee.com/liukaixiong/drawing-bed/raw/master/image/q8y6ja.png)

#### 3. 修改效果

![修改](https://gitee.com/liukaixiong/drawing-bed/raw/master/image/image-20210820171255314.png)


### 动态效果

![新增](ruoyi-avue-client/README.assets/6d4ftd.gif)

![新增](ruoyi-avue-client/README.assets/xyju9p.gif)

## 感谢

| 作者主页                                     | 框架     |
| -------------------------------------------- | -------- |
| [smallweigit](https://gitee.com/smallweigit) | AVue     |
| [**若依**](https://gitee.com/y_project)      | 若依系统 |
|                                              |          |

**如果你有比较好的想法或者建议请加QQ : 444368875 或者发送邮件 444368875@qq.com**

**希望大家多多支持，我会时刻关注并且加以改进。**
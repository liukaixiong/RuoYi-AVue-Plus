### 改动介绍
**1. 新增服务注解模块**

![image-20210825134956829](https://gitee.com/liukaixiong/drawing-bed/raw/master/image/image-20210825134956829.png)

这里主要是用来记录远端的服务地址

**2. 引入AVUEJS功能**

[AVUE相关文档](https://avuejs.com/views/doc.html)

> 及其复杂的页面可以考虑使用AVue编写前端代码，目前项目已经集成好了。直接拿来即用.

mock: 用来调试

**3. 新增`ruoyi-avue-client`模块：**

- 基于**AVUE**功能编写,主要负责解析**AVUE**属性的注解并进行加强适配。

## 运行环境

### 后端

- JDK
- redis
- mysql
- MAVEN

### 前端

- NodeJs

**搭建步骤可以参考: [ruoyi文档地址](http://doc.ruoyi.vip/ruoyi/)**

下载下来项目之后：

1. 执行后端脚本 :  sql目录下的脚本，先创建数据库的表环境。
   1. 找到`ruoyi-admin`项目
      1. `application.yml` 回填 Redis的地址
      2. `application-druid.yml` : 回填数据库的地址
   2. 启动类: `RuoYiApplication`  标准的SpringBoot项目。 
2. 启动前端 -> [ruoyi-avue-ui](../ruoyi-avue-ui/README.md) 

服务注册脚本:

```sql
CREATE TABLE `sys_server` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `server_name` varchar(100) DEFAULT NULL COMMENT '服务名称',
  `domain_path` varchar(255) DEFAULT NULL COMMENT '服务域名路径',
  `accept_token` varchar(32) DEFAULT NULL COMMENT '授权token',
  `status` char(1) DEFAULT '0' COMMENT '状态（1正常 -1停用）',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

INSERT INTO  `sys_menu`(`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `status`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`) VALUES (2003, '服务注册', 1, 18, '/server', 'system/server/index', 1, 0, 'C', '0', '0', 'server:index', 'server', 'admin', '2021-08-13 18:48:23', 'admin', '2021-08-13 18:49:38', '');
```

## 开始使用

### 后端引用

#### 1. 引入`ruoyi-avue-client`的maven依赖

```xml
<dependency>
    <groupId>com.ruoyi.avue</groupId>
    <artifactId>ruoyi-avue-client</artifactId>
    <version>3.6.0</version>
</dependency>
```

#### 2. 启用功能

```java
@SpringBootApplication
@EnableAVue(basePackages = {"com.ruoyi.client.model"},enumsPackages = "com.ruoyi.client.enums")
public class RuoYiClientTestApplication {
    public static void main(String[] args) {
        SpringApplication.run(RuoYiClientTestApplication.class, args);
    }
}
```

- basePackages : 属性模版存放位置
- enumsPackages: 枚举存放位置

#### 3. 定义属性模版配置

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

>  建议模版和业务分离

至此后端已经大功告成...

> 如果有字典相关的，可以往下参考详细文档内容

### 前端配置

#### 1. 注册服务地址

![image-20210825164029200](https://gitee.com/liukaixiong/drawing-bed/raw/master/image/image-20210825164029200.png)

#### 2. 新增菜单栏

![新增菜单栏](https://gitee.com/liukaixiong/drawing-bed/raw/master/image/o1vd0p.png)

- 组件路径直接写死 : `crud/server-crud`

> 路由地址 : configTest?server=1&group=test-config

- 路由地址: 必须唯一，参数
  - server : 服务注册地址的主键编号，如上图1
  - group: 后端步骤3的`@AVueRouteKey`的`groupKey`的值



组件会根据回填的server和group去查找对应的服务路径，然后获取模版。切记。。。

至此完工...

**下次如果还有接口，只需要配置后端的步骤3和前端2加个菜单栏就行了.**

> 另外对于页面交互特别复杂的场景，各个字段各种联动，交互复杂的一批的，还是考虑编码方式吧，稍微熟悉下AVue的使用特点。
>
> 该版本已经集成好了AVue，你只要把这个复杂的模版交互页面写好之后，把菜单栏的模版路径改成你写的就OK了。功能增强也非常简单。

### 效果

#### 1. 列表页效果

![](https://gitee.com/liukaixiong/drawing-bed/raw/master/image/rq10ne.png)

#### 2. 新增页面效果

![](https://gitee.com/liukaixiong/drawing-bed/raw/master/image/q8y6ja.png)

#### 3. 修改效果

![修改](https://gitee.com/liukaixiong/drawing-bed/raw/master/image/image-20210820171255314.png)


### 动态效果

![新增](../ruoyi-avue-client/README.assets/6d4ftd.gif)

![新增](../ruoyi-avue-client/README.assets/xyju9p.gif)

#### 5. 测试类

## 常见问题

1. 跨域问题

参考测试类: `com.ruoyi.client.filter.CorsFilter`

2. 部署

- 前端如果你只想用一个tomcat就为容器承载，不需要`nginx`在来一次反向代理的。请在环境配置里面加入后端请求全路径

`.env.production`

```tex
# 若依管理系统/生产环境
VUE_APP_BASE_API = 'http://localhost:8768'
```

3. Class java.lang.String not subtype of [map type; class java.util.Map, [simple type, class java.lang.String] -> [simple type, class java.lang.Object]]

这里可能出现的原因是使用了SpringBoot默认的解析器JACKSON不支持Map嵌套的复杂结构,可以尝试切换到fastjson作为序列化反序列化的工具，或者其他办法。
MVC配置继承WebMvcConfigurerAdapter后重写，

```java
@Override
public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    ParserConfig pc = new ParserConfig();
    SerializeConfig sc = new SerializeConfig();
    FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
    FastJsonConfig fastJsonConfig = new FastJsonConfig();
    fastJsonConfig.setDateFormat("yyyy-MM-dd HH:mm:ss");
    fastJsonConfig.setParserConfig(pc);
    fastJsonConfig.setSerializeConfig(sc);
    fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteDateUseDateFormat);
    fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
    converters.add(0, fastJsonHttpMessageConverter);
}
```

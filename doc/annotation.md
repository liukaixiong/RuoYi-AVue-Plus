# 注解相关类文档

## AVue的基本数据结构

```json
// 根节点
{
    option : {  // 页面渲染配置项
    	column: [
           ... // 每个字段的渲染配置项
        ]
        ... // 表格的配置项
    } 
}
```

具体的格式参考 : 

[Crud/Form属性文档](https://avuejs.com/views/doc.html)

## 特殊的注解字段描述

### 类级别注解

#### @AVueRouteKey

负责定义一个组，前端根据这个组来确定模版。

#### @AVueConfig

后端接口服务的配置路径，支持Spring的环境变量转换。

#### @AVueTableOption

表格的参数

page开头: 代表分页请求的返回结果编排。



#### @AVueFromOption

表单的参数

- `successKeyword` : 增删改的接口返回成功的标识关键字

#### @AVueEventButtons

按钮事件组，通过指定确定布局的方式，去找对应的函数执行内容。执行方法是一个个模版，通过注解传递过去的参数来触发按钮的事件。

##### @AVueClickButton

- type : [按钮类型参考](类型 参考 element-ui -> https://element.eleme.cn/#/zh-CN/component/button)
- icon : 按钮标题
- methodName: 方法名称

> 定义在ruoyi-avue-ui/src/api/crud/event/buttonEvent.js中的方法名称

- btnName: 按钮名称
- fieldNames : 按钮参数
- attrExt： 拓展属性



| 事件名称  | 事件参数        | 事件描述             |
| :-------- | --------------- | -------------------- |
| hrefClick | url : 跳转的URL | 点击跳转到特定的页面 |
| confirmClickRemoteApi | title : 确认的标题<br />url : 处理的后台地址<br />method: 接口的请求方法[post,get] 默认是post | 点击弹出确认框，确认之后出发一个后台接口调用 |
| openWindowJsonRemote | attrExt:{<br />submitUrl: "提交地址",<br />url: "弹窗内容渲染JSON,默认`/avue/crud`",<br />group: "路由的分组名称"} | 点击按钮，弹出一个弹窗，内容渲染按照递归的方式查找渲染JSON。 |

#### @AVueRule

数据校验规则

必填项等等...


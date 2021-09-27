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


## 开发

```bash
# 克隆项目
git clone https://gitee.com/liukaixiong/RuoYi-AVue-Plus.git

# 进入项目目录
cd ruoyi-avue-ui

# 安装依赖
npm install

# 建议不要直接使用 cnpm 安装依赖，会有各种诡异的 bug。可以通过如下操作解决 npm 下载速度慢的问题
npm install --registry=https://registry.npm.taobao.org

# 启动服务
npm run dev
```

浏览器访问 http://localhost:80

默认帐号密码 : amdin / admin123

## 发布

```bash
# 构建测试环境
npm run build:stage

# 构建生产环境
npm run build:prod
```

## 代码相关介绍

- src
  - api : 远程调用相关
    - crud : 涵盖了AVue调用后台逻辑的JS
  - const : 常量枚举定义  
  - mixins : AvueJS的增删改查增强的js
    - crud.js : 原生的AVueJS增强版
    - server-crud.js : 支持远端服务的AVueJs改版
  - mock : 模拟数据
  - option : AvueJS的页面渲染Json存储
  - views : 页面视图处理
    - crud : 通用的增删改查模版
      - avue-crud-test.vue  // **支持AvueJs的增删改查版本**
      - crud-test.vue  // **支持AVue的通用原生版本**
      - **server-crud.vue // 支持AVue增删改查的服务端版本**



有相关的调试内容或者增强功能，请根据需要去view的crud中找匹配版本进行调试并且增强。




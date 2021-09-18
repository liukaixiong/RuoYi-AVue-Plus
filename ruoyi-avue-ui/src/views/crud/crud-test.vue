<template>
  <div class="basic-container">
    <!--    <el-card class="basic-container__card">-->
    <h3>个人-固定的JSON参数测试</h3>
    <avue-crud :option="option"
               :page="page"
               :data="data"
               @row-update="updateBefore">
      <!-- https://avuejs.com/crud/crud-btn.html 参考 -->
      <!--
        slot取值的几种方式:
          - menu : 每一行的操作位置
          - menuForm : 新增修改右下角的位置 -> 新增->  v-if="type=='add'"  修改-> v-if="type=='edit'"
          - menuLeft: 表格左上角的新增位置
          - menuRight : 表格的右上角内容
          - searchMenu: 搜索的位置 > https://avuejs.com/crud/crud-search.html#%E6%99%AE%E9%80%9A%E7%94%A8%E6%B3%95
      -->
      <template v-if="option.tableRowButtons && option.tableRowButtons.length > 0" slot-scope="{row,index}" slot="menu">
        <span v-for="item in option.tableRowButtons">
          <el-button :type="item.type || 'primary'"
                     :icon="item.icon || 'el-icon-edit'"
                     :size="item.size || 'small'"
                     plain
                     @click="btnClick(item,row,index)">{{ item.btnName }}
          </el-button>
        </span>
      </template>

      <template v-if="option.tableTopLeftButtons && option.tableTopLeftButtons.length>0" slot-scope="{row,index}"
                slot="menuLeft">
        <span v-for="item in option.tableTopLeftButtons">
          <el-button :type="item.type || 'primary'"
                     :icon="item.icon || 'el-icon-edit'"
                     :size="item.size || 'small'"
                     @click="btnClick(item,row,index)">{{ item.btnName }}
          </el-button>
        </span>
      </template>

      <template v-if="option.tableTopRightButtons && option.tableTopRightButtons.length > 0" slot-scope="{row,index}"
                slot="menuRight">
        <span v-for="item in option.tableTopRightButtons">
          <el-button :type="item.type || 'primary'"
                     :icon="item.icon || 'el-icon-edit'"
                     :size="item.size || 'small'"
                     plain
                     @click="btnClick(item,row,index)">{{ item.btnName }}
          </el-button>
        </span>
      </template>

      <!-- 表单层 值组件展示层 -->
      <template
        slot-scope="{ column,value,size,disabled,type}" v-for="item in option.registerFieldComponents"
        :slot="getSlotName(item)">
        <el-tag>{{ column }}</el-tag>
        <!-- 引入新的组件  json  JSON.stringify(jsonStr,null,2)-->
        <span v-if="column.type === 'json'">
          <b-code-editor :name="column.prop" :value="getJsonString(value)"
                         :smart-indent="true"
                         theme="idea"
                         :indent-unit="4" :lint="true"
                         :line-wrap="false" ref="editor"
                         @on-change="onJsonChange(column.prop,value)"
                         @on-init="initJsonValue(column.prop,value)"
                         @on-blur="jsonFormat(column.prop)"
          >
          </b-code-editor>
          <p>
            <el-button @click="jsonFormat(column.prop)">手动触发格式化</el-button>
          </p>
      </span>

      </template>

    </avue-crud>
    <!--    </el-card>-->
  </div>
</template>

<script>

import * as eventMethod from "@/utils/clickEvent"
// 注册组件

const jsonData = `{
    "employees": [{
      "firstName": "Bill",
      "lastName": "Gates"
    }, {
      "firstName": "George",
      "lastName": "Bush"
    }, {
      "firstName": "Thomas",
      "lastName": "Carter"
    }]
  }`

export default {
  beforeCreate() {
    // let _self = this;
    // console.log("页面初始化");
    // let query = _self.$route.query;
    // getServerObjectApi(query.server).then((res) => {
    //   debugger;
    //   renderData(_self, _self.$route.query, res.data)
    // });
  },
  data() {
    return {
      jsonTemp: "",
      jsonStr: jsonData,
      "config": {
        "save": "/liukx/update",
        "update": "/liukx/update",
        "list": "/liukx/list",
        "domain": "http://127.0.0.1:8765"
      },
      "data": [
        {
          "id": "0",
          "username": "测试数据_0",
          "checkStatus": "BASKETBALL",
          "likeStar": "1",
          "age": 0,
          "sex": "MAN",
          "validDate": "2021-08-20T02:27:13.811+0000",
          "interest": [
            "BADMINTON",
            "BASKETBALL"
          ],
          "status": 1
          , "dataJson": JSON.stringify({
            "test": "a",
            "test1": "b",
            "test2": "c",
          })
          , "extComponents": JSON.stringify({
            "extTest": "a",
            "extTest1": "b",
            "extTest2": "c",
          })
        },
        {
          "id": "1",
          "username": "测试数据_1",
          "checkStatus": "BASKETBALL",
          "likeStar": "1",
          "age": 2,
          "sex": "MAN",
          "validDate": "2021-08-20T02:27:13.811+0000",
          "interest": [
            "BADMINTON",
            "BASKETBALL"
          ],
          "status": 1
        },
        {
          "id": "2",
          "username": "测试数据_2",
          "checkStatus": "BASKETBALL",
          "likeStar": "1",
          "age": 4,
          "sex": "MAN",
          "validDate": "2021-08-20T02:27:13.811+0000",
          "interest": [
            "BADMINTON",
            "BASKETBALL"
          ],
          "status": 1
        },
        {
          "id": "3",
          "username": "测试数据_3",
          "checkStatus": "BASKETBALL",
          "likeStar": "1",
          "age": 6,
          "sex": "MAN",
          "validDate": "2021-08-20T02:27:13.811+0000",
          "interest": [
            "BADMINTON",
            "BASKETBALL"
          ],
          "status": 1
        },
        {
          "id": "4",
          "username": "测试数据_4",
          "checkStatus": "BASKETBALL",
          "likeStar": "1",
          "age": 8,
          "sex": "MAN",
          "validDate": "2021-08-20T02:27:13.811+0000",
          "interest": [
            "BADMINTON",
            "BASKETBALL"
          ],
          "status": 1
        },
        {
          "id": "5",
          "username": "测试数据_5",
          "checkStatus": "BASKETBALL",
          "likeStar": "1",
          "age": 10,
          "sex": "MAN",
          "validDate": "2021-08-20T02:27:13.811+0000",
          "interest": [
            "BADMINTON",
            "BASKETBALL"
          ],
          "status": 1
        },
        {
          "id": "6",
          "username": "测试数据_6",
          "checkStatus": "BASKETBALL",
          "likeStar": "1",
          "age": 12,
          "sex": "MAN",
          "validDate": "2021-08-20T02:27:13.811+0000",
          "interest": [
            "BADMINTON",
            "BASKETBALL"
          ],
          "status": 1
        },
        {
          "id": "7",
          "username": "测试数据_7",
          "checkStatus": "BASKETBALL",
          "likeStar": "1",
          "age": 14,
          "sex": "MAN",
          "validDate": "2021-08-20T02:27:13.811+0000",
          "interest": [
            "BADMINTON",
            "BASKETBALL"
          ],
          "status": 1
        },
        {
          "id": "8",
          "username": "测试数据_8",
          "checkStatus": "BASKETBALL",
          "likeStar": "1",
          "age": 16,
          "sex": "MAN",
          "validDate": "2021-08-20T02:27:13.811+0000",
          "interest": [
            "BADMINTON",
            "BASKETBALL"
          ],
          "status": 1
        },
        {
          "id": "9",
          "username": "测试数据_9",
          "checkStatus": "BASKETBALL",
          "likeStar": "1",
          "age": 18,
          "sex": "MAN",
          "validDate": "2021-08-20T02:27:13.811+0000",
          "interest": [
            "BADMINTON",
            "BASKETBALL"
          ],
          "status": 1
        }
      ],
      "form": {},
      "params": {},
      "api": {},
      "loading": false,
      "page": {
        "pageSize": 10,
        "total": 100
      },
      "option": {
        "title": "这是一个测试",
        viewBtn: true,
        dialogDrag: true,
        registerFieldComponents: [
          "dataJson",
          "extJson"
        ],
        tableRowButtons: [{
          btnName: '行按钮1',
          methodName: 'testA',
          type: "success",
          icon: "el-icon-check",
          size: "mini"
        }, {
          btnName: '行按钮2',
          methodName: 'testB'
        }],
        tableTopLeftButtons: [{
          btnName: '左上角1',
          methodName: 'testA'
        }, {
          btnName: '左上角2',
          methodName: 'testB'
        }],
        tableTopRightButtons: [{
          btnName: '右上角1',
          methodName: 'testA'
        }, {
          btnName: '右上角2',
          methodName: 'testB'
        }],
        "column": [
          {
            "addDisplay": true,
            "prop": "id",
            "disabled": true,
            "label": "id",
            "type": "input"
          },
          {
            "prop": "username",
            "label": "用户名称",
            "type": "input",
            search: true,
            "rules": [{
              "type": null,
              "required": true,
              "message": "用户昵称你得填啊老哥"
            }]
            ,
            // searchRules: [{
            //   required: false,
            //   message: "请输入姓名",
            //   trigger: "blur"
            // }],
            hide: true
          },
          {
            "dicData": [
              {
                "label": "已认证",
                "value": "1"
              },
              {
                "label": "未认证",
                "value": "0"
              },
              {
                "label": "已失效",
                "value": "-99"
              },
              {
                "label": "已拒绝",
                "value": "-1"
              }
            ],
            "prop": "checkStatus",
            "label": "认证状态",
            "type": "select",
            "props": {
              "label": "label",
              "value": "value"
            }, "rules": [{
              "type": "string",
              "required": true,
              "pattern": null,
              "len": null,
              "min": null,
              "max": null,
              "message": null
            }]
          },
          {
            "dicData": [
              {
                "id": "1",
                "username": "周杰伦"
              },
              {
                "id": "2",
                "username": "林俊杰"
              },
              {
                "id": "3",
                "username": "王力宏"
              },
              {
                "id": "4",
                "username": "许嵩"
              }
            ],
            "prop": "likeStar",
            "label": "喜欢明星",
            "type": "select",
            "props": {
              "label": "username",
              "value": "id"
            }
          },
          {
            "labelTip": "这是选择年龄的地方",
            "prop": "age",
            "label": "年龄",
            "type": "number",
            "viewDisplay": false
          },
          {
            "border": true,
            "dicData": [
              {
                "label": "男",
                "value": 1
              },
              {
                "label": "女",
                "value": 0
              },
              {
                "label": "未知",
                "value": -1
              }
            ],
            "prop": "sex",
            "label": "性别",
            "type": "radio",
            "props": {
              "label": "label",
              "value": "value"
            }
          },
          {
            "prop": "validDate",
            "label": "有效时间",
            "type": "datetime"
          },
          {
            "dicData": [
              {
                "label": "篮球",
                "value": "basketball"
              },
              {
                "label": "足球",
                "value": "football"
              },
              {
                "label": "羽毛球",
                "value": "badminton"
              },
              {
                "label": "乒乓球",
                "value": "pingpong"
              },
              {
                "label": "桌球",
                "value": "billiards"
              }
            ],
            "prop": "interest",
            "label": "兴趣爱好",
            "type": "checkbox",
            "props": {
              "label": "label",
              "value": "value"
            }
          },
          {
            "prop": "status",
            "label": "状态",
            "type": "switch"
          }
          , {
            "prop": "dataJson",
            "label": "拓展参数",
            "type": "json"
          }
          , {
            "prop": "remark",
            "label": "备注",
            "type": "textarea"
          }
          // , {
          //   prop: "extJson",
          //   label: "拓展组件",
          //   labelWidth: 40,
          //   span: 24,
          //   type: "json",
          //   params: {},
          //   theme: "idea",
          //   height: 120
          // }
        ]
      }
    };
  }, methods: {
    commitUpdate(row, index, done, loading) {
      console.log("提交更新", row);
      // setTimeout(()=>{
      //   loading();
      //   this.$message.success('3秒后关闭表单')
      // },5000)
      this.$message.success('修改成功')
      // done();
    },
    eventDel(row, index) {
    },
    //列表后操作方法
    listAfter() {
    },

    //新增前操作方法
    addBefore() {
      this.form.createUser = 'small'
      debugger;
    },
    //新增后操作方法
    addAfter() {
      this.$message.success('新增成功');
    },
    //修改前操作方法
    updateBefore(form, index, done, loading) {
      this.form.updateUser = 'small';
      debugger;
      // let jsonObject = this.$refs['editor'];
      // if (jsonObject) {
      //   for (let i = 0; i < jsonObject.length; i++) {
      //     let value = jsonObject[i].getValue();
      //     let name = jsonObject[i].$attrs['name'];
      //     form[name] = value;
      //     console.log(" 获取JSON 中的值 11 " + name + " : " + value);
      //   }
      // }
    },

    //修改后操作方法
    updateAfter() {
    },

    //删除前操作方法
    delBefore() {
    },

    //删除后操作方法
    delAfter() {
    },
    // 按钮点击触发的方法
    btnClick(item, row, index) {
      eventMethod[item.methodName](this, item, row, index);
    },
    getSlotName(item) {
      return item + "Form";
    }, onJsonChange(name, value) {
      this.jsonTemp = value;

      // let jsonObject = this.$refs['editor'];
      // for (let i = 0; i < jsonObject.length; i++) {
      //   let attrName = jsonObject[i].$attrs['name'];
      //   if (name === attrName) {
      //     debugger;
      //     let newValue = jsonObject[i].getValue();
      //     jsonObject[i].value = newValue;
      //   }
      // }
      debugger;
    }, initJsonValue(name, value) {
      debugger;
      if (value) {
        this.jsonFormat(name);
      }
    }, getJsonString(value) {
      if (!value) {
        return "";
      }
      if (value instanceof Object) {
        return JSON.stringify(value);
      }
      return value;
    }, jsonFormat(name) {
      var self = this;
      let jsonObject = self.$refs['editor'];
      for (let i = 0; i < jsonObject.length; i++) {
        let attrName = jsonObject[i].$attrs['name'];
        if (name === attrName) {
          jsonObject[i].formatCode();
        }
      }
      debugger;
    }, getTestJsonValue(val) {
      if (val) {
        debugger;
      }

      return val;
    }
  }
}
;
</script>

<style lang="scss">
</style>

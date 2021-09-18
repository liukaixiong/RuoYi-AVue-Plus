/**
 * 通用的表格按钮点击方法，先在这里面定义通用的方式，然后通过传参触发
 *
 * @author liukx
 * @date  -
 */

/**
 * 通用的测试
 * @param self  vue的上下文
 * @param item  按钮的参数
 * @param row   数据行的参数
 * @param index 数据下标行的参数
 */
export function testA(self, item, row, index) {
  self.$message.success('testA --> ' + JSON.stringify(row) + '数据序号' + index);
}

export function testB(self, item, row, index) {
  self.$message.success('testB --> ' + JSON.stringify(row) + '数据序号' + index);
}

/**
 * 点击跳转到特定页面
 * @param self
 * @param item
 * @param row
 * @param index
 */
export function hrefClick(self, item, row, index) {
  debugger;
  let json = listToJson(item['attrExt']);
  if (json) {
    window.open(json.url);
  } else {
    self.message.error("没有配置跳转链接，无法跳转！")
  }
}

/**
 * 将List转化为json对象
 * @param valueList
 */
function listToJson(valueList) {

  if (valueList && Array.isArray(valueList)) {
    let result = {};
    for (let i = 0; i < valueList.length; i++) {
      let name = valueList[i].name;
      result[name] = valueList[i].value;
    }
    return result;
  }
  return undefined;

}

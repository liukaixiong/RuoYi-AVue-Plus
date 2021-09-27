/**
 * 通用的行点击事件处理
 *
 * @author liukx
 * @date  -
 */

/**
 * 通用的测试
 * @param value
 * @param column
 */
export function testA(value, column) {
  this.$message.success('testA --> ' + JSON.stringify(column) + ' 值 ' + value);
}

export function testB({value, column}) {
  this.$message.success('testB --> ' + JSON.stringify(column) + ' 值' + value);
}

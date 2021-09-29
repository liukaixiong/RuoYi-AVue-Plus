/**
 * 通用的crud的工具类方法
 * @author liukaixiong
 */

/**
 * 处理DML操作的响应处理
 * @param self
 * @param data
 */
function processDMLResponse(self, data) {
  let successField = self.config['successField'];
  let successKeyword = self.config['successKeyword'];
  let successValue = data[successField];

  if (successValue && successValue + '' === successKeyword) {
    self.$message.success('操作成功');
    return true;
  } else {
    let messageField = self.config['messageField'];
    self.$message.error(messageField);
    return false;
  }
}

/**
 * 补全请求的前缀域名
 * @param self
 * @param path
 * @returns {*}
 */
function completionDomain(self, path) {
  if (!path.startsWith("http")) {
    return self.config.domain + path;
  }
  return path;
}

export default {
  processDMLResponse,
  completionDomain
}

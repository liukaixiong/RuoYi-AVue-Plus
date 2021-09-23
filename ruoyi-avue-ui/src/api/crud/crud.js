import {post} from './remoteApi'
import page from '@/const/page.js'

/**
 * 默认的列表查询请求
 * @param _self VUE实例
 * @param data
 * @returns {Promise<unknown>}
 */
export function list(_self, data) {
  return http(_self.config, _self.config.list, data);
}

/**
 * 默认的列表新增请求
 * @returns {Promise<unknown>}
 */
export function add(_self, data) {
  return http(_self.config, _self.config.save, data);
}

/**
 * 默认的列表删除请求
 * @returns {Promise<unknown>}
 */
export function del(_self, data) {
  console.log("----------------del---------------------")
  return http(_self.config, _self.config.del, data);
}

export function update(_self, data) {
  console.log("----------------update---------------------")
  return http(_self.config, _self.config.update, data);
}

/**
 * 执行远程请求
 * @param config
 * @param path
 * @param data
 * @returns {Promise<unknown>}
 */
function http(config, path, data) {
  let domain = config.domain;
  let url = domain + path;
  return new Promise((resolve, reject) => {
    post(url, data, (res) => {
      resolve(res);
    })
  }).catch(error => {
    reject(error);
  });
}

/**
 * 渲染crud数据结构
 *
 * crud结构一共分为三层
 * - option : 页面数据
 * - data : 服务端列表数据
 * - page : 服务端分页数据
 *
 * @param self            vue对象
 * @param clientConfig       页面传输对象
 * @param pageRouteInfo   页面对象,URL请求参数
 * @param serverInfo      domain对象
 */
export function renderData(self, clientConfig, pageRouteInfo, serverInfo) {

  if (!serverInfo) {
    self.$message.error("找不到对应的服务注册编号 请检查请求路径中的: server=" + pageRouteInfo.server + " 然后去[系统管理->服务注册]中查找是否有该编号!");
    return;
  }

  let domain = serverInfo.domainPath;
  debugger;
  let params = {
    "group": pageRouteInfo.group,
    "acceptToken": serverInfo.acceptToken
  }

  let configUrl = clientConfig.configUrl || "/crud/config"

  // 拿到配置文件option
  post(domain + configUrl, params, (configObject) => {

    // 根据配置文件的信息获取数据
    let responseConfig = clientConfig.res(configObject);

    if (!checkClientConfiguration(responseConfig)) {
      return;
    }

    let config = responseConfig.config;

    let list = config.list;
    // 初始化option部分
    self.$data.option = responseConfig.option;
    self.$data.config = config;
    self.$data.config['domain'] = domain;
    postRenderData(self.$data);

    post(domain + list, {}, (res) => {
      // 初始化data部分,先确认数据的根路径
      let rootResponse = self.getRootData(res);
      requireMessage(rootResponse, "参数不能为空,否则渲染不出页面，参数可以参考@AVueTableOption的page前缀,确定数据的分页根路径")

      self.$data['data'] = rootResponse[self.getOption(page.pageData) || 'data'];

      requireMessage(self.$data['data'], page.pageData + "参数不能为空,否则渲染不出页面，参数可以参考@AVueTableOption的page前缀")

      // 初始化page部分
      let pageObject = {
        pageSize: rootResponse[self.getOption(page.pageSize) || 'pageSize'],
        pagerCount: rootResponse[self.getOption(page.pagerCount) || 'pagerCount'],
        total: rootResponse[self.getOption(page.pageTotal) || 'total']
      }

      requireMessage(pageObject.pageSize, page.pageSize + "参数不能为空,否则渲染不出页面，参数可以参考@AVueTableOption的page前缀")

      requireMessage(pageObject.total, page.pageTotal + "参数不能为空,否则渲染不出页面，参数可以参考@AVueTableOption的page前缀")

      self.$data.page = pageObject;
    })
  })
}

/**
 * 检查客户端的配置是否符合
 * @param responseConfig
 */
function checkClientConfiguration(responseConfig) {
  if (!responseConfig) {
    self.msgError("返回结果有误");
    return false;
  } else if (!responseConfig.config) {
    self.msgError("请回填@AVueConfig注解的参数");
    return false;
  } else if(!responseConfig.option){
    self.msgError("页面渲染参数option无效");
    return false;
  }
  return true;
}


function requireMessage(obj, msg) {
  if (!obj) {
    self.msgError(msg);
  }
}

/**
 * 后置处理渲染数据
 * @param aVueData
 */
function postRenderData(aVueData) {

  let columns = aVueData.option.column;

  function processColumns(columns) {
    for (let i = 0; i < columns.length; i++) {
      let column = columns[i];

      if (column.type === 'select') {
        handlerSelectColumn(aVueData, i, column);
      } else if (column.type === 'dynamic') {
        let childrenList = columns[i].children;
        if (childrenList.column) {
          processColumns(childrenList.column);
        }

      }
    }
  }

  processColumns(columns);
}

function handlerSelectColumn(aVueData, index, column) {
  let dicUrl = column.dicUrl;
  // 如果非http的url默认按照domain的前缀访问
  if (dicUrl && !dicUrl.startsWith("http")) {
    let domain = aVueData.config['domain'];
    column.dicUrl = domain + "/" + dicUrl;
  }
}

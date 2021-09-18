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
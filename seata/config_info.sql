/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : nacos_config

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 18/05/2020 01:14:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for config_info
-- ----------------------------
DROP TABLE IF EXISTS `config_info`;
CREATE TABLE `config_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `data_id` varchar(255) COLLATE utf8_bin NOT NULL COMMENT 'data_id',
  `group_id` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `content` longtext COLLATE utf8_bin NOT NULL COMMENT 'content',
  `md5` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT 'md5',
  `gmt_create` datetime NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT '2010-05-05 00:00:00' COMMENT '修改时间',
  `src_user` text COLLATE utf8_bin COMMENT 'source user',
  `src_ip` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT 'source ip',
  `app_name` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `tenant_id` varchar(128) COLLATE utf8_bin DEFAULT '' COMMENT '租户字段',
  `c_desc` varchar(256) COLLATE utf8_bin DEFAULT NULL,
  `c_use` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `effect` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `type` varchar(64) COLLATE utf8_bin DEFAULT NULL,
  `c_schema` text COLLATE utf8_bin,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_configinfo_datagrouptenant` (`data_id`,`group_id`,`tenant_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='config_info';

-- ----------------------------
-- Records of config_info
-- ----------------------------
BEGIN;
INSERT INTO `config_info` VALUES (1, 'nacos-config-client-dev.yaml', 'DEV_GROUP', 'config: \n    info: f8e7cd7d-1be4-4741-ac07-d121af35b925 , nacos-config-client-dev.yaml , DEV_GROUP , version =1 ', '76108948bfda04b275e0616a862a129c', '2020-04-18 00:38:33', '2020-04-18 00:38:33', NULL, '0:0:0:0:0:0:0:1', '', 'f8e7cd7d-1be4-4741-ac07-d121af35b925', NULL, NULL, NULL, 'yaml', NULL);
INSERT INTO `config_info` VALUES (13, 'nacos-config-client-dev.yaml', 'DEFAULT_GROUP', 'config: \n    info: from config center , nacos-config-client-dev.yaml , version = 2;\nnacos:\n  config:\n    server_addr: 127.0.0.1:8848\n    data_id: zuul-refresh-dev.json\n    group: DEFAULT_GROUP\n    namespace: ffa52718-ea89-4510-a3a9-c0085ae5ba67', '86b25d1f77126b44ac9f37cc0d12bc16', '2020-04-19 20:48:49', '2020-04-20 05:24:55', NULL, '0:0:0:0:0:0:0:1', '', '', 'null', 'null', 'null', 'yaml', 'null');
INSERT INTO `config_info` VALUES (19, 'zuul-refresh-dev.json', 'DEFAULT_GROUP', '{\n    \"refreshGatewayRoute\":true,\n    \"routeList\":[\n        {\n            \"id\":\"github_route\",\n            \"predicates\":[\n                {\n                    \"name\":\"Path\",\n                    \"args\":{\n                        \"_genkey_0\":\"/a\"\n                    }\n                }\n            ],\n            \"filters\":[\n\n            ],\n            \"uri\":\"https://github.com\",\n            \"order\":0\n        }\n    ]\n}', '33c9d01db8bbd63b2c45f9cfedefcd34', '2020-04-19 22:22:04', '2020-04-20 06:19:43', NULL, '0:0:0:0:0:0:0:1', '', 'ffa52718-ea89-4510-a3a9-c0085ae5ba67', 'null', 'null', 'null', 'json', 'null');
INSERT INTO `config_info` VALUES (20, 'cloudalibaba-sentinel-service', 'DEFAULT_GROUP', ' [\n        {\n          \"resource\": \"/rateLimit/byUrl\",\n          \"limitApp\": \"default\",\n          \"grade\": 1,\n          \"count\": 1,\n          \"strategy\": 0,\n          \"controlBehavior\": 0,\n          \"clusterMode\": false\n        }\n]', '336c83bdd516e7283158993ba6ed2bb9', '2020-05-13 06:58:15', '2020-05-13 07:10:19', NULL, '0:0:0:0:0:0:0:1', '', '', 'null', 'null', 'null', 'json', 'null');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

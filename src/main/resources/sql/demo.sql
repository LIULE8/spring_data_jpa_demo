/*
Navicat MySQL Data Transfer

Source Server         : my
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2018-10-27 12:32:02
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `demo`
-- ----------------------------
DROP TABLE IF EXISTS `demo`;
CREATE TABLE `demo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) COLLATE utf8_unicode_ci DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of demo
-- ----------------------------
INSERT INTO `demo` VALUES ('1', '小明', '10');
INSERT INTO `demo` VALUES ('2', '小红', '11');
INSERT INTO `demo` VALUES ('3', '小蓝', '22');
INSERT INTO `demo` VALUES ('4', '明白', '23');
INSERT INTO `demo` VALUES ('5', 'gg', '23');
INSERT INTO `demo` VALUES ('6', '小黑', '23');
INSERT INTO `demo` VALUES ('7', '明白', '24');
INSERT INTO `demo` VALUES ('8', 'ss', '22');

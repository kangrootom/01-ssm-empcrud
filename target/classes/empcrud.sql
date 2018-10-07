/*
Navicat MySQL Data Transfer

Source Server         : con_1
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : empcrud

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2018-10-07 13:45:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) DEFAULT NULL,
  `sex` char(2) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '范德萨', '女', '澳门', '11');
INSERT INTO `user` VALUES ('2', '张飞', '男', '上海', '55');
INSERT INTO `user` VALUES ('3', '关羽', '男', '上海', '60');
INSERT INTO `user` VALUES ('4', '赵云', '男', '北京', '20');
INSERT INTO `user` VALUES ('5', '诸葛亮', '男', '南阳', '22');
INSERT INTO `user` VALUES ('6', '芙蓉', '女', '西安', '30');
INSERT INTO `user` VALUES ('7', '司马懿', '男', '合肥', '70');
INSERT INTO `user` VALUES ('8', '周公瑾', '男', '苏州', '23');
INSERT INTO `user` VALUES ('9', '潘金莲', '女', '澳门', '21');
INSERT INTO `user` VALUES ('10', '西门庆', '男', '澳门', '22');
INSERT INTO `user` VALUES ('11', '赌王', '未知', '香港', '23');

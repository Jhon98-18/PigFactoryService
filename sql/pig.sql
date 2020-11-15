/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : pig

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2020-11-15 16:17:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for factory
-- ----------------------------
DROP TABLE IF EXISTS `factory`;
CREATE TABLE `factory` (
  `id` int(6) NOT NULL auto_increment,
  `factory_ame` varchar(6) default NULL COMMENT '猪场名字',
  `holder` varchar(6) default NULL COMMENT '猪场拥有者',
  `phone` bigint(11) default NULL COMMENT '猪场联系电话',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of factory
-- ----------------------------
INSERT INTO `factory` VALUES ('1', '小站猪场', '小张', '13001980017');
INSERT INTO `factory` VALUES ('2', '小孙猪场', '小孙', '15398247165');

-- ----------------------------
-- Table structure for pig
-- ----------------------------
DROP TABLE IF EXISTS `pig`;
CREATE TABLE `pig` (
  `id` int(6) NOT NULL auto_increment COMMENT '猪的id',
  `type` int(6) default NULL COMMENT '养殖类型',
  `variety` varchar(255) default NULL COMMENT '品种',
  `factoryId` int(6) default NULL COMMENT '所属猪场',
  `pigHouseId` int(6) default NULL COMMENT '所属猪舍',
  PRIMARY KEY  (`id`),
  KEY `pig_type` (`type`),
  KEY `pig_factoryId` (`factoryId`),
  KEY `pig_pigHouseId` (`pigHouseId`),
  CONSTRAINT `pig_factoryId` FOREIGN KEY (`factoryId`) REFERENCES `factory` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `pig_pigHouseId` FOREIGN KEY (`pigHouseId`) REFERENCES `pighouse` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `pig_type` FOREIGN KEY (`type`) REFERENCES `types` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='InnoDB free: 9216 kB; (`pigHouseId`) REFER `pig/pighouse`(`i';

-- ----------------------------
-- Records of pig
-- ----------------------------
INSERT INTO `pig` VALUES ('1', '1', '三元', '1', '1');
INSERT INTO `pig` VALUES ('2', '1', '三元', '1', '2');
INSERT INTO `pig` VALUES ('3', '1', '三元', '2', '3');
INSERT INTO `pig` VALUES ('4', '1', '三元', '2', '4');
INSERT INTO `pig` VALUES ('5', '1', '三元', '2', '1');
INSERT INTO `pig` VALUES ('7', '1', '三元', '1', '3');
INSERT INTO `pig` VALUES ('8', '1', '三元', '2', '4');
INSERT INTO `pig` VALUES ('9', '1', '三元', '1', '2');

-- ----------------------------
-- Table structure for pighouse
-- ----------------------------
DROP TABLE IF EXISTS `pighouse`;
CREATE TABLE `pighouse` (
  `id` int(6) NOT NULL auto_increment,
  `no` varchar(6) default NULL COMMENT '猪舍编号',
  `description` varchar(12) default NULL COMMENT '猪舍描述',
  `isdisinfection` char(1) NOT NULL COMMENT '是否消毒',
  `factoryId` int(6) default NULL,
  PRIMARY KEY  (`id`),
  KEY `pigHouseId_factoryId` (`factoryId`),
  CONSTRAINT `pigHouseId_factoryId` FOREIGN KEY (`factoryId`) REFERENCES `factory` (`id`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of pighouse
-- ----------------------------
INSERT INTO `pighouse` VALUES ('1', '0001', '位置位于小梨园北部', 'Y', '1');
INSERT INTO `pighouse` VALUES ('2', '0002', '位置位于小梨园北部', 'Y', '1');
INSERT INTO `pighouse` VALUES ('3', '0003', '位置位于小梨园北部', 'Y', '1');
INSERT INTO `pighouse` VALUES ('4', '0004', '位置位于小梨园北部', 'Y', '1');
INSERT INTO `pighouse` VALUES ('5', '0005', '位置位于小梨园北部', 'Y', '1');
INSERT INTO `pighouse` VALUES ('6', '0006', '位置位于小梨园北部', 'N', '1');
INSERT INTO `pighouse` VALUES ('7', '0007', '位置位于小梨园南部部', 'N', '1');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(6) NOT NULL auto_increment,
  `role` varchar(12) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'ROLE_aa');
INSERT INTO `role` VALUES ('2', '老板');
INSERT INTO `role` VALUES ('3', '员工');

-- ----------------------------
-- Table structure for types
-- ----------------------------
DROP TABLE IF EXISTS `types`;
CREATE TABLE `types` (
  `id` int(6) NOT NULL auto_increment COMMENT '类型id',
  `name` varchar(16) default NULL COMMENT '养殖类型',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of types
-- ----------------------------
INSERT INTO `types` VALUES ('1', '菜猪');
INSERT INTO `types` VALUES ('2', '母猪');
INSERT INTO `types` VALUES ('3', '公猪');
INSERT INTO `types` VALUES ('4', '其他');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(6) NOT NULL auto_increment,
  `userName` varchar(6) default NULL,
  `passWord` varchar(64) default NULL,
  `age` int(3) default NULL,
  `sex` int(2) default NULL COMMENT '0：男1：女',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '张三', '$2a$10$kDq9UrxQbFf71jQvqppsm.5.D4iJPpWptgbObwsGcBZ8yuxKVJKRC', '18', '0');
INSERT INTO `user` VALUES ('2', '李四', '$2a$10$kDq9UrxQbFf71jQvqppsm.5.D4iJPpWptgbObwsGcBZ8yuxKVJKRC', '19', '1');
INSERT INTO `user` VALUES ('3', '王五', '123456', '20', '0');
INSERT INTO `user` VALUES ('4', '赵柳', '123456', '21', '1');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(6) NOT NULL auto_increment,
  `userId` int(6) default NULL,
  `roleId` int(6) default NULL,
  PRIMARY KEY  (`id`),
  KEY `userId` (`userId`),
  KEY `roleId` (`roleId`),
  CONSTRAINT `roleId` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`),
  CONSTRAINT `userId` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1');
INSERT INTO `user_role` VALUES ('2', '2', '2');
INSERT INTO `user_role` VALUES ('3', '3', '3');

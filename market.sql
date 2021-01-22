/*
Navicat MySQL Data Transfer

Source Server         : market
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : market

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2020-05-29 20:57:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for bill
-- ----------------------------
DROP TABLE IF EXISTS `bill`;
CREATE TABLE `bill` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '销售单',
  `card_id` int(11) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `total` float DEFAULT NULL COMMENT '总价',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`),
  KEY `bill_ibfk_1` (`goods_id`),
  KEY `bill_ibfk_2` (`card_id`),
  CONSTRAINT `bill_ibfk_1` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `bill_ibfk_2` FOREIGN KEY (`card_id`) REFERENCES `card` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bill
-- ----------------------------
INSERT INTO `bill` VALUES ('14', '17', '3', '10', '128', '备注');
INSERT INTO `bill` VALUES ('15', '18', '4', '10', '211', '1');
INSERT INTO `bill` VALUES ('16', '21', '2', '2', '10', '');
INSERT INTO `bill` VALUES ('17', '17', '1', '2', '7', '张二爷常买');

-- ----------------------------
-- Table structure for card
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `total` float DEFAULT NULL,
  `total_vip` varchar(20) DEFAULT NULL,
  `date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `vip_id` int(11) DEFAULT NULL,
  `emp_id` int(11) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `card_ibfk_2` (`emp_id`),
  KEY `card_ibfk_1` (`vip_id`),
  CONSTRAINT `card_ibfk_1` FOREIGN KEY (`vip_id`) REFERENCES `vip` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `card_ibfk_2` FOREIGN KEY (`emp_id`) REFERENCES `emp` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of card
-- ----------------------------
INSERT INTO `card` VALUES ('17', '135', '101.25', '2019-04-07 14:52:40', '5', '5', null);
INSERT INTO `card` VALUES ('18', '211', '168.8', '2019-04-07 15:32:59', '4', '5', null);
INSERT INTO `card` VALUES ('21', '10', '9.5', '2020-05-29 11:49:20', '1', '1', null);

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `pass` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES ('1', 'admin', '123', '1', '1', '34', '12312341234', '管理员');
INSERT INTO `emp` VALUES ('2', '2', '2', '2', '1', '24', '12312341234', '库管');
INSERT INTO `emp` VALUES ('5', '3', '3', '3', '0', '24', '12312341234', '员工');
INSERT INTO `emp` VALUES ('7', 'ceshi', 'ceshi', '3', '1', '34', '323434343434', '434344343434');
INSERT INTO `emp` VALUES ('8', 'aaa', 'aaa', '2', '1', '22', '11111111', '22');
INSERT INTO `emp` VALUES ('10', 'bb', 'bb', '3', '1', '12', '1111111', '1111');

-- ----------------------------
-- Table structure for factory
-- ----------------------------
DROP TABLE IF EXISTS `factory`;
CREATE TABLE `factory` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '进货商',
  `name` varchar(255) DEFAULT NULL,
  `linkman` varchar(255) DEFAULT NULL COMMENT '联系人',
  `phone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of factory
-- ----------------------------
INSERT INTO `factory` VALUES ('2', '王老吉凉茶', '王', '12312341666', '北京市朝阳区朝外大街', '长期合作1');
INSERT INTO `factory` VALUES ('3', '肉食类专供', '李', '12312341234', '北京市朝阳区朝外大街', '临时合作');
INSERT INTO `factory` VALUES ('4', '蛋奶类专供', '赵', '12312341234', '北京市朝阳区朝外大街', '临时合作');
INSERT INTO `factory` VALUES ('5', '服装类专供', '周', '12312341234', '北京市朝阳区朝外大街', '临时合作');
INSERT INTO `factory` VALUES ('7', '茅台', '潘二爷', '18566342516', '贵州', '');
INSERT INTO `factory` VALUES ('8', '红富士', '红二', '15188888888', '日本', '好甜');
INSERT INTO `factory` VALUES ('10', '茅台', '潘二爷', '18566342516', '贵州', '好甜');

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `start` varchar(255) DEFAULT NULL COMMENT '生产日期',
  `keep` varchar(255) DEFAULT NULL COMMENT '保质期',
  `place` varchar(255) DEFAULT NULL COMMENT '产地',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `factory_id` int(11) DEFAULT NULL COMMENT '进货商',
  PRIMARY KEY (`id`),
  KEY `goods_ibfk_1` (`factory_id`),
  CONSTRAINT `goods_ibfk_1` FOREIGN KEY (`factory_id`) REFERENCES `factory` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '上好佳薯片', '食品', '3.5', '2015-04-01', '24', '北京', '112', '2');
INSERT INTO `goods` VALUES ('2', '王老吉凉茶', '食品', '5', '2015-04-01', '24', '广州', '备注', '2');
INSERT INTO `goods` VALUES ('3', '双汇冷鲜肉', '食品', '12.8', '2015-04-01', '6', '上海', '111', '3');
INSERT INTO `goods` VALUES ('4', '咯咯哒鸡蛋', '食品', '21.1', '2015-04-01', '6', '沈阳', '按斤计价', '4');
INSERT INTO `goods` VALUES ('5', '男士牛仔裤', '服饰', '128', '2015-04-01', '36', '杭州', '1112', '5');
INSERT INTO `goods` VALUES ('6', '雕牌洗衣粉', '日用', '7.8', '2015-04-01', '36', '天津', '2222', null);
INSERT INTO `goods` VALUES ('11', '娃哈哈', '饮料', '5', '2018-01-02', '12', '杭州', '', '7');
INSERT INTO `goods` VALUES ('13', '娃哈哈', '饮料', '5', '2018-01-02', '12', '杭州', '112', '8');

-- ----------------------------
-- Table structure for sell
-- ----------------------------
DROP TABLE IF EXISTS `sell`;
CREATE TABLE `sell` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '出货表',
  `goods_id` int(11) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL COMMENT '出货数量',
  `date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `emp_id` int(11) DEFAULT NULL COMMENT '经手人',
  `myname` varchar(2000) DEFAULT NULL,
  `mycode` varchar(2000) DEFAULT NULL,
  `mymoney` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `sell_ibfk_1` (`emp_id`),
  KEY `sell_ibfk_2` (`goods_id`),
  CONSTRAINT `sell_ibfk_1` FOREIGN KEY (`emp_id`) REFERENCES `emp` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `sell_ibfk_2` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sell
-- ----------------------------
INSERT INTO `sell` VALUES ('1', '1', '20', '2015-04-16 16:31:41', null, '2', null, null, '1');
INSERT INTO `sell` VALUES ('2', '2', '20', '2015-04-16 16:31:42', null, '2', null, null, '1');
INSERT INTO `sell` VALUES ('23', '2', '20', '2015-04-16 16:40:01', '444444444444', '1', '43434', null, '1');
INSERT INTO `sell` VALUES ('24', '2', '20', '2015-04-16 16:40:26', '测试', '1', '测试', null, '1333');
INSERT INTO `sell` VALUES ('25', '2', '1', '2015-04-16 16:41:28', '44444444', '1', '测试商品', null, '343');
INSERT INTO `sell` VALUES ('27', '2', '1', '2020-05-28 12:05:50', '666666666666666666', null, '测试商品', null, '343');
INSERT INTO `sell` VALUES ('30', '1', '1', '2019-04-07 15:34:12', '备注1', '2', null, null, null);
INSERT INTO `sell` VALUES ('31', '1', '1', '2019-04-07 15:35:52', '出库', '1', null, null, null);

-- ----------------------------
-- Table structure for stock
-- ----------------------------
DROP TABLE IF EXISTS `stock`;
CREATE TABLE `stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '进货表',
  `goods_id` int(11) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL COMMENT '数量',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `emp_id` int(11) DEFAULT NULL COMMENT '经手人',
  `date` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '进货日期',
  PRIMARY KEY (`id`),
  KEY `stock_ibfk_1` (`goods_id`),
  KEY `stock_ibfk_2` (`emp_id`),
  CONSTRAINT `stock_ibfk_1` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `stock_ibfk_2` FOREIGN KEY (`emp_id`) REFERENCES `emp` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stock
-- ----------------------------
INSERT INTO `stock` VALUES ('1', '1', '200', '', '1', '2015-04-26 22:40:20');
INSERT INTO `stock` VALUES ('2', '2', '100', '备注', '2', '2019-04-07 15:33:49');
INSERT INTO `stock` VALUES ('3', '3', '100', null, '2', '2015-04-01 09:17:38');
INSERT INTO `stock` VALUES ('4', '4', '100', '按斤计价', '2', '2015-04-02 09:41:12');
INSERT INTO `stock` VALUES ('5', '5', '100', null, '2', '2015-04-01 09:17:44');
INSERT INTO `stock` VALUES ('13', '5', '100', 'dk', '1', '2020-05-29 18:06:13');
INSERT INTO `stock` VALUES ('14', '11', '100', 'dk', '1', '2020-05-29 18:07:36');

-- ----------------------------
-- Table structure for store
-- ----------------------------
DROP TABLE IF EXISTS `store`;
CREATE TABLE `store` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '库存表',
  `goods_id` int(11) DEFAULT NULL,
  `amount` int(11) DEFAULT NULL,
  `sales` int(11) DEFAULT NULL COMMENT '销量',
  PRIMARY KEY (`id`),
  KEY `store_ibfk_1` (`goods_id`),
  CONSTRAINT `store_ibfk_1` FOREIGN KEY (`goods_id`) REFERENCES `goods` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of store
-- ----------------------------
INSERT INTO `store` VALUES ('1', '1', '235', '63');
INSERT INTO `store` VALUES ('2', '2', '246', '15');
INSERT INTO `store` VALUES ('3', '3', '80', '22');
INSERT INTO `store` VALUES ('4', '4', '80', '32');
INSERT INTO `store` VALUES ('5', '5', '192', '10');
INSERT INTO `store` VALUES ('6', '6', '92', '10');
INSERT INTO `store` VALUES ('7', '11', '100', '0');

-- ----------------------------
-- Table structure for vip
-- ----------------------------
DROP TABLE IF EXISTS `vip`;
CREATE TABLE `vip` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `grade` int(11) DEFAULT '0' COMMENT '总积分',
  `level` int(11) DEFAULT '1' COMMENT '会员级别',
  `rebate` float DEFAULT '0.95' COMMENT '折扣',
  `ident` varchar(255) DEFAULT NULL COMMENT '身份证号',
  `birthday` varchar(255) DEFAULT NULL,
  `sex` char(10) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vip
-- ----------------------------
INSERT INTO `vip` VALUES ('1', 'vip1', '12312341234', '146', '1', '0.95', '522723198802145095', '19880214', '1', '北京市海淀区中关村');
INSERT INTO `vip` VALUES ('2', 'vip2', '12312341234', '1431', '2', '0.9', '522723198802145095', '19880214', '1', '北京市海淀区中关村');
INSERT INTO `vip` VALUES ('3', 'vip3', '12312341234', '2048', '3', '0.85', '522723198802145095', '19880214', '1', '北京市海淀区中关村');
INSERT INTO `vip` VALUES ('4', 'vip4', '12312341234', '3283', '4', '0.8', '522723198802145095', '19880214', '0', '北京市海淀区中关村');
INSERT INTO `vip` VALUES ('5', 'vip5', '12312341234', '4231', '5', '0.75', '522723198802145095', '19880214', '0', '北京市海淀区中关村');

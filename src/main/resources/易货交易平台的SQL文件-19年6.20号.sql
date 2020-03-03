/*
Navicat MySQL Data Transfer

Source Server         : connect
Source Server Version : 50517
Source Host           : localhost:3306
Source Database       : bartermall

Target Server Type    : MYSQL
Target Server Version : 50517
File Encoding         : 65001

Date: 2019-06-20 18:19:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cid2` int(11) NOT NULL AUTO_INCREMENT COMMENT '类别编号',
  `cname2` varchar(255) DEFAULT NULL COMMENT '类别名称',
  PRIMARY KEY (`cid2`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '手机');
INSERT INTO `category` VALUES ('2', '电脑');
INSERT INTO `category` VALUES ('3', '影音娱乐');
INSERT INTO `category` VALUES ('4', '数码配件');
INSERT INTO `category` VALUES ('5', '运动健身');
INSERT INTO `category` VALUES ('6', '衣物鞋帽');
INSERT INTO `category` VALUES ('7', '生活娱乐');
INSERT INTO `category` VALUES ('8', '图书教材');
INSERT INTO `category` VALUES ('9', '交通出行');
INSERT INTO `category` VALUES ('10', '个人技能');
INSERT INTO `category` VALUES ('11', '其他');

-- ----------------------------
-- Table structure for `content`
-- ----------------------------
DROP TABLE IF EXISTS `content`;
CREATE TABLE `content` (
  `id` varchar(32) NOT NULL DEFAULT '',
  `title` varchar(100) DEFAULT NULL,
  `text` varchar(255) DEFAULT NULL,
  `creattime` varchar(20) DEFAULT NULL,
  `level` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of content
-- ----------------------------
INSERT INTO `content` VALUES ('1', '商品发布规则', 'F:\\JavaIO\\商品发布规则', '2019-06-13 18:59:30 ', '1');
INSERT INTO `content` VALUES ('2', '购买二手iphone注意事项', 'F:\\JavaIO\\购买二手iphone注意事项', '2019-06-13 17:02:29 ', '2');

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `pid` varchar(255) NOT NULL,
  `pname` varchar(255) DEFAULT NULL,
  `buyPrice` double(255,0) DEFAULT NULL,
  `salePrice` double(255,0) DEFAULT NULL,
  `pdesc` varchar(255) DEFAULT NULL,
  `pimage` varchar(255) DEFAULT NULL,
  `beloneto` varchar(255) DEFAULT NULL,
  `cid2` int(255) DEFAULT NULL,
  `readTimes` int(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL COMMENT '只有待售，已售，前端用来判断的',
  `isHot` varchar(255) DEFAULT NULL,
  `creatTime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('017cbaf7e9f048a8a2b97007fe76543c', '联想拯救者拯救者Y7000', '6000', '3000', '联想(Lenovo)拯救者Y7000英特尔酷睿i5 15.6英寸游戏笔记本电脑( i5-8300H 8G 512G SSD GTX1050 黑) ', '/imgs_products/d4413d6da98a42028d82945a88663032.jpg', '541513140131', '201', '37', '已售', '否', '2019-05-04 22:59:35 ');
INSERT INTO `product` VALUES ('0881dd7a47484e418b202d234c4cdf3e', 'Apple iPad Pro 12.9', '6999', '5999', 'Apple iPad Pro 12.9英寸平板电脑 2018款(64G WLAN版/全面屏/A12X/FaceID MTEL2CH/A)深空灰', '/imgs_products/91b18087c1ed439496b4a7bd99929295.png', '541513140131', '201', '4', '在售', '否', '2019-06-12 22:09:56 ');
INSERT INTO `product` VALUES ('0be2ace1b30549618aea72c5e2c92b83', '三星S9', '5999', '3999', '三星手机，手机9层新，想换其他手机，低价出', '/imgs_products/4d63e7376c7b4e7099e42f7ac09b5099.jpg', '541513140131', '101', '3', '在售', '否', '2019-06-12 21:40:16 ');
INSERT INTO `product` VALUES ('2ca3deb9f6be44caa261f99d5fdf1df1', '匡威1970', '600', '500', '此鞋子买过来尺码不合适，特价出售，喜欢大家选购。', '/imgs_products/595087ee5d7644ada8a71e181ad6218b.jpg', '541513140117', '601', '53', '在售', '否', '2019-05-25 23:23:55 ');
INSERT INTO `product` VALUES ('90edbd67ef7b4e6f83e37305692fe77b', '安徒生童话故事书套装', '488', '188', '安徒生诞辰200周年典藏之作\r\n斯洛伐克国宝画家、BIB终身荣誉获得者杜桑·凯利及妻子全书插画；\r\n历时三年，50余篇童话、500余页， 几百幅插画，创纪录童书插画规模；\r\n经典译文，赠导读手册，从7岁读到77岁；\r\n典藏品质，的艺术性与收藏价值。', '/imgs_products/bd28cd974d0f45f2b0fad5f903eda64b.jpg', '541513140101', '801', '18', '在售', '否', '2019-05-04 23:06:30 ');
INSERT INTO `product` VALUES ('90edbd67ef7b4e6f83e37305692fe7cc', '图拉斯耳机', '68', '28', '图拉斯 耳机有线入耳式耳麦游戏吃鸡电脑音乐运动手机iphone苹果vivo华为IQOO荣', 'imgs_products/bddc753dea664a86962703ec5bbc06ef.jpg', '541513140131', '301', '21', '在售', null, '2019-04-04 23:06:30 ');
INSERT INTO `product` VALUES ('a04fb8af834e441eab2f49b1b7015132', '康佳相机', '8888', '6666', '相机购买于2019年3月份，9层新，买入价格8888，现在特价6666售出，', '/imgs_products/0a6565051d8c4e0b970d27fe639dd889.png', '541513140131', '401', '27', '已售', '否', '2019-05-25 21:28:08 ');
INSERT INTO `product` VALUES ('f401b4b928414e628bcb8f8aedbaec1a', 'OPPO R17', '2999', '1200', 'OPPO R17 6+128G 霓光紫 全网通 6.4寸水滴屏 光感屏幕指纹解锁 双卡双待手机', '/imgs_products/5b57fffcc11346e78705acd64dade335.jpg', '541513140117', '101', '31', '在售', '否', '2019-05-25 20:48:46 ');
INSERT INTO `product` VALUES ('ffa35207d16f44ae96f2b5c110f056fe', '手机壳', '50', '20', 'aaaaaaaaaaaaaaaaaaa', '/imgs_products/abdc53dc30f04ff98747710edfad8f55.jpg', '541513140131', '101', '0', '在售', '否', '2019-06-13 18:59:30 ');
INSERT INTO `product` VALUES ('ffb4e8f464b6439fbbb73c091f376d0a', '华为Mate 20', '6888', '2888', '华为Mate 20 亮黑色 6GB+128GB 麒麟980芯片全面屏徕卡三摄移动联通电信4G全网通手机', '/imgs_products/e42a7ffe9c654830b9efbfe2fb8e5f2c.jpg', '541513140117', '101', '35', '在售', '否', '2019-05-25 20:46:14 ');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(255) NOT NULL,
  `email` varchar(225) DEFAULT NULL,
  `password` varchar(225) DEFAULT NULL,
  `name` varchar(225) DEFAULT NULL,
  `area` varchar(255) DEFAULT NULL,
  `college` varchar(255) DEFAULT NULL,
  `grade` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `point` int(255) DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `statephoto` varchar(255) DEFAULT NULL,
  `qq` varchar(255) DEFAULT NULL,
  `probibit` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('541513140100', 'admin', '123456', '管理员1号', '郑州轻工业大学科学校区', null, null, null, 'headphoto123.jpg', '2', '已认证', null, null, '0');
INSERT INTO `user` VALUES ('541513140101', null, '123456', '小苹果', '郑州轻工业大学科学校区', '商城幼儿园', '大四', '16895647536', 'e9a8dbcdb3ff4c199193f23f98360f0f.jpg', '2', '已认证', null, '666984563', '1');
INSERT INTO `user` VALUES ('541513140117', null, '123456', '李柯', '郑州轻工业大学科学校区', '郑州轻工业', '大四', '15696874532', 'f2c7aedf3b894b7594c2c2a3039d9562.png', '8', '已认证', null, '1159687423', '1');
INSERT INTO `user` VALUES ('541513140131', 'root', '123456', '唐涛', '郑州轻工业大学科学校区', '计算机科学与技术', '大四', '18838204960', 'bc6b9a6a958245fe8407410aa0373711.gif', '74', '已认证', null, '923972487', '1');

-- ----------------------------
-- Table structure for `wantinfo`
-- ----------------------------
DROP TABLE IF EXISTS `wantinfo`;
CREATE TABLE `wantinfo` (
  `wantid` varchar(225) NOT NULL,
  `userid` varchar(225) NOT NULL,
  `title` varchar(225) DEFAULT NULL,
  `wdesc` varchar(225) DEFAULT NULL,
  `wantprice` varchar(225) DEFAULT NULL,
  `wantdealarea` varchar(225) DEFAULT NULL,
  `creattime` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`wantid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wantinfo
-- ----------------------------
INSERT INTO `wantinfo` VALUES ('85608a318ca4489e9d7479caaa938418', '541513140102', '鞋子', '現在的撒啊殺殺殺殺殺殺殺殺殺', '200', '郑州轻工业大学', '2019-05-03 00:22:15 ');
INSERT INTO `wantinfo` VALUES ('97b4754de5ec45238df6d55a12187b20', '541513140117', '手机', '三星手机', '200', '郑州轻工业大学', '2019-05-02 23:20:39 ');
INSERT INTO `wantinfo` VALUES ('9dffaad10c084b86a12e6f4b3ffc5eb9', '541513140131', '我要买本书', 'aaaa', '200', '郑州轻工业大学', '2019-06-13 19:00:53 ');
INSERT INTO `wantinfo` VALUES ('bba70a8de7e241d6977bd2b1b88b8c76', '541513140131', '手机', '我想买个苹果x', '2000', '郑州轻工业大学', '2019-05-06 20:33:57 ');

/*
Navicat MySQL Data Transfer

Source Server         : unchenghin
Source Server Version : 80025
Source Host           : localhost:3306
Source Database       : zerohotel

Target Server Type    : MYSQL
Target Server Version : 80025
File Encoding         : 65001

Date: 2022-01-29 19:08:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `checkin`
-- ----------------------------
DROP TABLE IF EXISTS `checkin`;
CREATE TABLE `checkin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user` int NOT NULL,
  `roomRegister` int NOT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  `provideBreakfast` tinyint(1) NOT NULL,
  `provideClock` tinyint(1) NOT NULL,
  `preRoomID` int DEFAULT NULL,
  `checkInDate` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of checkin
-- ----------------------------

-- ----------------------------
-- Table structure for `checkout`
-- ----------------------------
DROP TABLE IF EXISTS `checkout`;
CREATE TABLE `checkout` (
  `id` int NOT NULL AUTO_INCREMENT,
  `checkIn` int NOT NULL,
  `days` int NOT NULL,
  `cost` int NOT NULL,
  `foodPrice` double(10,2) NOT NULL,
  `telPrice` double(10,2) NOT NULL,
  `shouldPrice` double(10,2) NOT NULL,
  `shouldDeposit` double(10,2) NOT NULL,
  `wayToPay` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `realRecived` double(10,2) NOT NULL,
  `giveChange` double(10,2) NOT NULL,
  `user` int NOT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of checkout
-- ----------------------------

-- ----------------------------
-- Table structure for `consume`
-- ----------------------------
DROP TABLE IF EXISTS `consume`;
CREATE TABLE `consume` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cid` int NOT NULL,
  `goods` int NOT NULL,
  `count` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of consume
-- ----------------------------

-- ----------------------------
-- Table structure for `cost`
-- ----------------------------
DROP TABLE IF EXISTS `cost`;
CREATE TABLE `cost` (
  `id` int NOT NULL AUTO_INCREMENT,
  `checkIn` int NOT NULL,
  `price` double(10,2) NOT NULL,
  `discount` double(10,2) NOT NULL,
  `discountPrice` double(10,2) NOT NULL,
  `totalPrice` double(10,2) NOT NULL,
  `user` int NOT NULL,
  `time` datetime NOT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of cost
-- ----------------------------

-- ----------------------------
-- Table structure for `floor`
-- ----------------------------
DROP TABLE IF EXISTS `floor`;
CREATE TABLE `floor` (
  `name` varchar(10) NOT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of floor
-- ----------------------------
INSERT INTO `floor` VALUES ('一楼', '');
INSERT INTO `floor` VALUES ('三楼', null);
INSERT INTO `floor` VALUES ('二楼', null);

-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `typeid` int NOT NULL,
  `price` double(10,2) NOT NULL,
  `unit` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', '红酒', '1', '100.00', '每瓶', null);
INSERT INTO `goods` VALUES ('2', '哇哈哈', '2', '2.50', '每瓶', null);
INSERT INTO `goods` VALUES ('3', '薯片', '3', '10.00', '每盒', null);

-- ----------------------------
-- Table structure for `goodstype`
-- ----------------------------
DROP TABLE IF EXISTS `goodstype`;
CREATE TABLE `goodstype` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(15) NOT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of goodstype
-- ----------------------------
INSERT INTO `goodstype` VALUES ('1', '酒', null);
INSERT INTO `goodstype` VALUES ('2', '饮料', null);
INSERT INTO `goodstype` VALUES ('3', '零食', null);

-- ----------------------------
-- Table structure for `guesthistory`
-- ----------------------------
DROP TABLE IF EXISTS `guesthistory`;
CREATE TABLE `guesthistory` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `guestIdType` varchar(20) NOT NULL,
  `guestId` varchar(30) NOT NULL,
  `tel` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of guesthistory
-- ----------------------------
INSERT INTO `guesthistory` VALUES ('1', 'y', '身份证', '2', '2');
INSERT INTO `guesthistory` VALUES ('2', '馬飛飛', '身份证', '12345677893', '17368231346');
INSERT INTO `guesthistory` VALUES ('3', 'timmy', '身份证', '123456', '123456');
INSERT INTO `guesthistory` VALUES ('4', 't', '身份证', '1', '1');
INSERT INTO `guesthistory` VALUES ('5', 't', '身份证', '1', '1');

-- ----------------------------
-- Table structure for `log`
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uid` int NOT NULL,
  `operation` varchar(50) NOT NULL,
  `time` datetime NOT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of log
-- ----------------------------

-- ----------------------------
-- Table structure for `member`
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(15) NOT NULL,
  `sex` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `pwd` varchar(30) NOT NULL,
  `tel` varchar(30) DEFAULT NULL,
  `addr` varchar(40) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `point` double(10,2) NOT NULL,
  `isVIP` tinyint(1) NOT NULL,
  `lastIn` datetime DEFAULT NULL,
  `lastRe` datetime DEFAULT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('1', '袁靖轩', '男', '12345', '18679872179', '澳门', 'timmy@Gmail', '0.00', '0', '2021-06-02 08:36:55', '2021-06-16 08:37:03', '袁靖轩很开心');
INSERT INTO `member` VALUES ('2', '马宁', '女', '54321', '16254895276', '广西', 'waibi@qq.com', '10000.00', '1', '2021-03-09 02:38:17', '2021-06-10 08:28:22', '宁哥很难受');

-- ----------------------------
-- Table structure for `reserve`
-- ----------------------------
DROP TABLE IF EXISTS `reserve`;
CREATE TABLE `reserve` (
  `id` int NOT NULL AUTO_INCREMENT,
  `roomRegister` int NOT NULL,
  `user` int NOT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  `status` varchar(20) NOT NULL,
  `reserveDate` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of reserve
-- ----------------------------

-- ----------------------------
-- Table structure for `room`
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `id` int NOT NULL AUTO_INCREMENT,
  `type` varchar(20) NOT NULL,
  `floor` varchar(20) NOT NULL,
  `status` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `standardPrice` double(10,2) NOT NULL,
  `discountPrice` double(10,2) NOT NULL,
  `memberPrice` double(10,2) NOT NULL,
  `vipPrice` double(10,2) NOT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES ('1', '单人间', '一楼', '空房', '100.00', '100.00', '100.00', '100.00', '');
INSERT INTO `room` VALUES ('2', '单人间', '二楼', '空房', '300.00', '300.00', '300.00', '200.00', '');
INSERT INTO `room` VALUES ('3', '双人间', '二楼', '空房', '300.00', '300.00', '300.00', '250.00', null);
INSERT INTO `room` VALUES ('4', '豪华双人间', '三楼', '空房', '1000.00', '1000.00', '1000.00', '800.00', '');

-- ----------------------------
-- Table structure for `roomregister`
-- ----------------------------
DROP TABLE IF EXISTS `roomregister`;
CREATE TABLE `roomregister` (
  `id` int NOT NULL AUTO_INCREMENT,
  `room` int NOT NULL,
  `deposit` double(10,2) NOT NULL,
  `guestName` varchar(20) NOT NULL,
  `guestIdType` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `guestId` varchar(30) NOT NULL,
  `tel` varchar(30) NOT NULL,
  `arriveTime` datetime NOT NULL,
  `leaveTime` datetime NOT NULL,
  `guestCount` int NOT NULL,
  `memberId` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of roomregister
-- ----------------------------
INSERT INTO `roomregister` VALUES ('22', '3', '100.00', 'timmy', '身份证', '1', '1', '2021-07-01 00:00:00', '2021-08-01 00:00:00', '1', '1');
INSERT INTO `roomregister` VALUES ('23', '2', '100.00', 'timmy', '身份证', '1', '1', '2021-07-01 00:00:00', '2021-07-02 00:00:00', '1', '1');
INSERT INTO `roomregister` VALUES ('25', '6', '100.00', 'timmy', '身份证', '12345678', '123456789', '2021-07-01 00:00:00', '2021-07-08 00:00:00', '2', null);
INSERT INTO `roomregister` VALUES ('27', '4', '100.00', 'timmy', '身份证', '12345', '123556', '2021-07-01 00:00:00', '2021-07-08 00:00:00', '1', '1');
INSERT INTO `roomregister` VALUES ('28', '4', '100.00', 'timmy', '身份证', '1234555', '12345', '2021-07-01 00:00:00', '2021-07-02 00:00:00', '1', '1');
INSERT INTO `roomregister` VALUES ('30', '4', '100.00', 't', '身份证', '1', '1', '2021-07-01 00:00:00', '2021-07-09 00:00:00', '1', '1');
INSERT INTO `roomregister` VALUES ('31', '4', '100.00', 't', '身份证', '2', '2', '2021-07-08 00:00:00', '2021-07-23 00:00:00', '1', '1');

-- ----------------------------
-- Table structure for `roomtype`
-- ----------------------------
DROP TABLE IF EXISTS `roomtype`;
CREATE TABLE `roomtype` (
  `name` varchar(10) NOT NULL,
  `capacity` int NOT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of roomtype
-- ----------------------------
INSERT INTO `roomtype` VALUES ('单人间', '1', null);
INSERT INTO `roomtype` VALUES ('双人间', '2', null);
INSERT INTO `roomtype` VALUES ('豪华双人间', '2', null);

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uname` varchar(20) NOT NULL,
  `pwd` varchar(40) NOT NULL,
  `power` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `remarks` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'king', '6da8jv0mhha637pll2d4sadq2giu0b40', '管理员', null);
INSERT INTO `user` VALUES ('2', 'emp', '707p1svaorbes09hl5ib858ul4o560lc', '前台人员', null);
INSERT INTO `user` VALUES ('3', 'mag', '-b0t745qi4phdvu1rv2sb47rn0uj1983f', '经理', null);

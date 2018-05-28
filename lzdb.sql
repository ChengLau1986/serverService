/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : lzdb

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-05-28 19:20:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for employees
-- ----------------------------
DROP TABLE IF EXISTS `employees`;
CREATE TABLE `employees` (
  `id` int(11) NOT NULL,
  `fname` varchar(30) DEFAULT NULL,
  `lname` varchar(30) DEFAULT NULL,
  `hired` date NOT NULL DEFAULT '1970-01-01',
  `separated` date NOT NULL DEFAULT '9999-12-31',
  `job_code` int(11) NOT NULL,
  `store_id` int(11) NOT NULL,
  KEY `ix_store_id` (`store_id`),
  KEY `ix_job_code` (`job_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
/*!50100 PARTITION BY RANGE (store_id)
(PARTITION p0 VALUES LESS THAN (6) ENGINE = InnoDB,
 PARTITION p1 VALUES LESS THAN (11) ENGINE = InnoDB,
 PARTITION p2 VALUES LESS THAN (16) ENGINE = InnoDB,
 PARTITION p3 VALUES LESS THAN (21) ENGINE = InnoDB) */;

-- ----------------------------
-- Records of employees
-- ----------------------------
INSERT INTO `employees` VALUES ('1', null, null, '1970-01-01', '9999-12-31', '1001', '1');
INSERT INTO `employees` VALUES ('2', null, null, '1970-01-01', '9999-12-31', '1002', '2');
INSERT INTO `employees` VALUES ('3', null, null, '1970-01-01', '9999-12-31', '1003', '3');
INSERT INTO `employees` VALUES ('4', null, null, '1970-01-01', '9999-12-31', '1004', '4');

-- ----------------------------
-- Table structure for employees1
-- ----------------------------
DROP TABLE IF EXISTS `employees1`;
CREATE TABLE `employees1` (
  `id` int(11) NOT NULL,
  `fname` varchar(30) DEFAULT NULL,
  `lname` varchar(30) DEFAULT NULL,
  `hired` date NOT NULL DEFAULT '1970-01-01',
  `separated` date NOT NULL DEFAULT '9999-12-31',
  `job_code` int(11) DEFAULT NULL,
  `store_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8
/*!50100 PARTITION BY RANGE ( YEAR(separated))
(PARTITION p0 VALUES LESS THAN (1991) ENGINE = InnoDB,
 PARTITION p1 VALUES LESS THAN (1996) ENGINE = InnoDB,
 PARTITION p2 VALUES LESS THAN (2001) ENGINE = InnoDB,
 PARTITION p3 VALUES LESS THAN MAXVALUE ENGINE = InnoDB) */;

-- ----------------------------
-- Records of employees1
-- ----------------------------
INSERT INTO `employees1` VALUES ('1', null, null, '1970-01-01', '1990-03-04', '1001', '1');
INSERT INTO `employees1` VALUES ('2', null, null, '1970-01-01', '1995-03-04', '1002', '2');
INSERT INTO `employees1` VALUES ('3', null, null, '1970-01-01', '1998-03-04', '1003', '3');
INSERT INTO `employees1` VALUES ('4', null, null, '1970-01-01', '2016-03-04', '1004', '4');

-- ----------------------------
-- Table structure for quarterly_report_status
-- ----------------------------
DROP TABLE IF EXISTS `quarterly_report_status`;
CREATE TABLE `quarterly_report_status` (
  `report_id` int(11) NOT NULL,
  `report_status` varchar(20) NOT NULL,
  `report_updated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8
/*!50100 PARTITION BY RANGE ( UNIX_TIMESTAMP(report_updated))
(PARTITION p0 VALUES LESS THAN (1199116800) ENGINE = InnoDB,
 PARTITION p1 VALUES LESS THAN (1206979200) ENGINE = InnoDB,
 PARTITION p2 VALUES LESS THAN (1214841600) ENGINE = InnoDB,
 PARTITION p3 VALUES LESS THAN (1222790400) ENGINE = InnoDB,
 PARTITION p4 VALUES LESS THAN (1230739200) ENGINE = InnoDB,
 PARTITION p5 VALUES LESS THAN (1238515200) ENGINE = InnoDB,
 PARTITION p6 VALUES LESS THAN (1246377600) ENGINE = InnoDB,
 PARTITION p7 VALUES LESS THAN (1254326400) ENGINE = InnoDB,
 PARTITION p8 VALUES LESS THAN (1262275200) ENGINE = InnoDB,
 PARTITION p9 VALUES LESS THAN MAXVALUE ENGINE = InnoDB) */;

-- ----------------------------
-- Records of quarterly_report_status
-- ----------------------------

-- ----------------------------
-- Table structure for td_orgtype
-- ----------------------------
DROP TABLE IF EXISTS `td_orgtype`;
CREATE TABLE `td_orgtype` (
  `TID` int(11) NOT NULL AUTO_INCREMENT,
  `OrgTypeID` varchar(255) DEFAULT NULL,
  `OrgTypeName` varchar(255) DEFAULT NULL,
  `ParentID` varchar(255) DEFAULT NULL,
  `OrgTypeLevel` int(11) DEFAULT NULL,
  PRIMARY KEY (`TID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of td_orgtype
-- ----------------------------
INSERT INTO `td_orgtype` VALUES ('1', '1', 'sdf', '0', '1');

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `birthday` datetime NOT NULL ON UPDATE CURRENT_TIMESTAMP,
  `test1` varchar(255) DEFAULT NULL,
  `test2` varchar(255) DEFAULT NULL,
  `test3` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_name` (`name`),
  KEY `idx_union` (`test1`) USING BTREE,
  KEY `idx_test2` (`test2`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of test
-- ----------------------------
INSERT INTO `test` VALUES ('4', 'kjdf', '2018-05-23 11:53:27', '1', null, null);
INSERT INTO `test` VALUES ('5', 'sss', '2018-05-23 11:56:13', '1', null, null);
INSERT INTO `test` VALUES ('6', 'asdasd', '2018-05-23 12:47:02', 'a', 'b', 'c');

-- ----------------------------
-- Table structure for ti_organization
-- ----------------------------
DROP TABLE IF EXISTS `ti_organization`;
CREATE TABLE `ti_organization` (
  `TID` int(11) NOT NULL AUTO_INCREMENT,
  `OrganizationID` varchar(255) DEFAULT NULL,
  `OrgStyle` tinyint(4) DEFAULT NULL,
  `OrgName` varchar(255) DEFAULT NULL,
  `OrgCode` varchar(255) DEFAULT NULL,
  `ParentID` varchar(255) DEFAULT NULL,
  `OrgTypeID` varchar(255) DEFAULT NULL,
  `OrgAddress` varchar(255) DEFAULT NULL,
  `OrgPhone` varchar(255) DEFAULT NULL,
  `OrgFax` varchar(255) DEFAULT NULL,
  `MainLeader` varchar(255) DEFAULT NULL,
  `OrgMark` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`TID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ti_organization
-- ----------------------------
INSERT INTO `ti_organization` VALUES ('1', '12', '1', '大圩', '1', '0', '1', '防守打法', '1212121212', '1212121', '12', '1');

-- ----------------------------
-- Table structure for ti_user
-- ----------------------------
DROP TABLE IF EXISTS `ti_user`;
CREATE TABLE `ti_user` (
  `TID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` varchar(255) NOT NULL,
  `Account` varchar(255) DEFAULT NULL,
  `UserName` varchar(255) DEFAULT NULL,
  `UserPwd` varchar(255) DEFAULT NULL,
  `OrganizationID` varchar(255) DEFAULT NULL,
  `LawNumber` varchar(255) DEFAULT NULL,
  `IDNumber` varchar(255) DEFAULT NULL,
  `LoginDeviceID` varchar(255) DEFAULT NULL,
  `PostID` varchar(255) DEFAULT NULL,
  `UserPhoto` varchar(255) DEFAULT NULL,
  `DepartmentID` varchar(255) DEFAULT NULL,
  `DeleteMark` int(11) DEFAULT NULL,
  PRIMARY KEY (`TID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ti_user
-- ----------------------------
INSERT INTO `ti_user` VALUES ('1', 'asdasd', 'lc', 'lc', '123', '12', '12', '12', '12', '12', '12', '12', '0');

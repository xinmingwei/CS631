/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : library

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 10/12/2020 20:38:20
*/
CREATE database library;
use library;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for author
-- ----------------------------
DROP TABLE IF EXISTS `author`;
CREATE TABLE `author`  (
  `isbn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Pid` int NULL DEFAULT NULL,
  INDEX `author_ibfk_1`(`isbn`) USING BTREE,
  INDEX `author_ibfk_2`(`Pid`) USING BTREE,
  CONSTRAINT `author_ibfk_1` FOREIGN KEY (`isbn`) REFERENCES `book` (`ISBN`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `author_ibfk_2` FOREIGN KEY (`Pid`) REFERENCES `person` (`Pid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of author
-- ----------------------------

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `DocId` int NOT NULL,
  `ISBN` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`DocId`) USING BTREE,
  UNIQUE INDEX `ISBN`(`ISBN`) USING BTREE,
  CONSTRAINT `book_ibfk_1` FOREIGN KEY (`DocId`) REFERENCES `document` (`DocId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (3, '26255');
INSERT INTO `book` VALUES (1, '625665');

-- ----------------------------
-- Table structure for borrows
-- ----------------------------
DROP TABLE IF EXISTS `borrows`;
CREATE TABLE `borrows`  (
  `borNumber` int NOT NULL,
  `BorDateTime` date NULL DEFAULT NULL,
  `dueDate` date NULL DEFAULT NULL,
  `fineAmount` decimal(10, 2) NULL DEFAULT NULL,
  `RetDateTime` date NULL DEFAULT NULL,
  `ReaderId` int NULL DEFAULT NULL,
  `copyNo` int NULL DEFAULT NULL,
  INDEX `ReaderId`(`ReaderId`) USING BTREE,
  INDEX `copyNo`(`copyNo`) USING BTREE,
  CONSTRAINT `borrows_ibfk_1` FOREIGN KEY (`ReaderId`) REFERENCES `reader` (`readerId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `borrows_ibfk_2` FOREIGN KEY (`copyNo`) REFERENCES `copy` (`copyNo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of borrows
-- ----------------------------
INSERT INTO `borrows` VALUES (1, '2019-09-10', '2019-09-10', 100.00, '2019-09-09', 10, 1);

-- ----------------------------
-- Table structure for branch
-- ----------------------------
DROP TABLE IF EXISTS `branch`;
CREATE TABLE `branch`  (
  `bid` int NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`bid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of branch
-- ----------------------------
INSERT INTO `branch` VALUES (1, 'branch', 'aaaa');

-- ----------------------------
-- Table structure for charirs
-- ----------------------------
DROP TABLE IF EXISTS `charirs`;
CREATE TABLE `charirs`  (
  `docid` int NOT NULL,
  `pid` int NULL DEFAULT NULL,
  PRIMARY KEY (`docid`) USING BTREE,
  INDEX `pid`(`pid`) USING BTREE,
  CONSTRAINT `charirs_ibfk_1` FOREIGN KEY (`docid`) REFERENCES `document` (`DocId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `charirs_ibfk_2` FOREIGN KEY (`pid`) REFERENCES `person` (`Pid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of charirs
-- ----------------------------

-- ----------------------------
-- Table structure for copy
-- ----------------------------
DROP TABLE IF EXISTS `copy`;
CREATE TABLE `copy`  (
  `copyNo` int NOT NULL,
  `position` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `docId` int NULL DEFAULT NULL,
  PRIMARY KEY (`copyNo`) USING BTREE,
  INDEX `docId`(`docId`) USING BTREE,
  CONSTRAINT `copy_ibfk_1` FOREIGN KEY (`docId`) REFERENCES `document` (`DocId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of copy
-- ----------------------------
INSERT INTO `copy` VALUES (1, '552666', 1);

-- ----------------------------
-- Table structure for document
-- ----------------------------
DROP TABLE IF EXISTS `document`;
CREATE TABLE `document`  (
  `DocId` int NOT NULL,
  `Title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `PDate` date NULL DEFAULT NULL,
  `PublisherId` int NULL DEFAULT NULL,
  `branchId` int NULL DEFAULT NULL,
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`DocId`) USING BTREE,
  INDEX `document_ibfk_1`(`PublisherId`) USING BTREE,
  INDEX `branchId`(`branchId`) USING BTREE,
  CONSTRAINT `document_ibfk_1` FOREIGN KEY (`PublisherId`) REFERENCES `publisher` (`PublisherId`) ON DELETE SET NULL ON UPDATE SET NULL,
  CONSTRAINT `document_ibfk_2` FOREIGN KEY (`branchId`) REFERENCES `branch` (`bid`) ON DELETE SET NULL ON UPDATE SET NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of document
-- ----------------------------
INSERT INTO `document` VALUES (1, 'update', '2018-09-09', 1, NULL, NULL);
INSERT INTO `document` VALUES (3, 'test', '2018-09-09', 1, NULL, 'testaa');
INSERT INTO `document` VALUES (11, 'rere', '2018-09-09', 1, NULL, NULL);
INSERT INTO `document` VALUES (12, '12', '2012-08-09', 1, NULL, NULL);
INSERT INTO `document` VALUES (15, 'test', '2018-09-09', 1, NULL, NULL);

-- ----------------------------
-- Table structure for gedits
-- ----------------------------
DROP TABLE IF EXISTS `gedits`;
CREATE TABLE `gedits`  (
  `Pid` int NOT NULL,
  `IssueNo` int NULL DEFAULT NULL,
  PRIMARY KEY (`Pid`) USING BTREE,
  INDEX `IssueNo`(`IssueNo`) USING BTREE,
  CONSTRAINT `gedits_ibfk_1` FOREIGN KEY (`Pid`) REFERENCES `person` (`Pid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `gedits_ibfk_2` FOREIGN KEY (`IssueNo`) REFERENCES `journal_issue` (`IssueNo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of gedits
-- ----------------------------

-- ----------------------------
-- Table structure for journal_issue
-- ----------------------------
DROP TABLE IF EXISTS `journal_issue`;
CREATE TABLE `journal_issue`  (
  `VolumnNo` int NOT NULL,
  `IssueNo` int NULL DEFAULT NULL,
  `Scope` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`VolumnNo`) USING BTREE,
  INDEX `IssueNo`(`IssueNo`) USING BTREE,
  CONSTRAINT `journal_issue_ibfk_1` FOREIGN KEY (`VolumnNo`) REFERENCES `journal_volumn` (`volumeNo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of journal_issue
-- ----------------------------
INSERT INTO `journal_issue` VALUES (10, 10, '10');

-- ----------------------------
-- Table structure for journal_volumn
-- ----------------------------
DROP TABLE IF EXISTS `journal_volumn`;
CREATE TABLE `journal_volumn`  (
  `docId` int NOT NULL,
  `volumeNo` int NULL DEFAULT NULL,
  PRIMARY KEY (`docId`) USING BTREE,
  INDEX `volumeNo`(`volumeNo`) USING BTREE,
  CONSTRAINT `journal_volumn_ibfk_1` FOREIGN KEY (`docId`) REFERENCES `document` (`DocId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of journal_volumn
-- ----------------------------
INSERT INTO `journal_volumn` VALUES (15, 10);

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager`  (
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`username`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('admin', 'admin');

-- ----------------------------
-- Table structure for person
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person`  (
  `Pid` int NOT NULL,
  `Pname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Pid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES (1, 'test author');

-- ----------------------------
-- Table structure for proceedings
-- ----------------------------
DROP TABLE IF EXISTS `proceedings`;
CREATE TABLE `proceedings`  (
  `docId` int NOT NULL,
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cDate` date NULL DEFAULT NULL,
  PRIMARY KEY (`docId`) USING BTREE,
  CONSTRAINT `proceedings_ibfk_1` FOREIGN KEY (`docId`) REFERENCES `document` (`DocId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of proceedings
-- ----------------------------
INSERT INTO `proceedings` VALUES (11, 'american', '2019-09-09');
INSERT INTO `proceedings` VALUES (12, '12652', '2018-09-09');

-- ----------------------------
-- Table structure for publisher
-- ----------------------------
DROP TABLE IF EXISTS `publisher`;
CREATE TABLE `publisher`  (
  `PublisherId` int NOT NULL,
  `PubName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `Address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`PublisherId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of publisher
-- ----------------------------
INSERT INTO `publisher` VALUES (1, 'publisher-1', 'American');
INSERT INTO `publisher` VALUES (2, 'hehe', 'hehe');

-- ----------------------------
-- Table structure for reader
-- ----------------------------
DROP TABLE IF EXISTS `reader`;
CREATE TABLE `reader`  (
  `readerId` int NOT NULL,
  `readerName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phoneNo` int NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '123',
  PRIMARY KEY (`readerId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reader
-- ----------------------------
INSERT INTO `reader` VALUES (10, 'jack', '0', 0, '0', '123');

-- ----------------------------
-- Table structure for reserves
-- ----------------------------
DROP TABLE IF EXISTS `reserves`;
CREATE TABLE `reserves`  (
  `resNumber` int NOT NULL,
  `resDateTime` date NULL DEFAULT NULL,
  `resStatus` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `copyNo` int NULL DEFAULT NULL,
  `readerId` int NULL DEFAULT NULL,
  PRIMARY KEY (`resNumber`) USING BTREE,
  INDEX `copyNo`(`copyNo`) USING BTREE,
  INDEX `readerId`(`readerId`) USING BTREE,
  CONSTRAINT `reserves_ibfk_1` FOREIGN KEY (`copyNo`) REFERENCES `copy` (`copyNo`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `reserves_ibfk_2` FOREIGN KEY (`readerId`) REFERENCES `reader` (`readerId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of reserves
-- ----------------------------
INSERT INTO `reserves` VALUES (10, '2018-09-09', '', 1, 10);

SET FOREIGN_KEY_CHECKS = 1;

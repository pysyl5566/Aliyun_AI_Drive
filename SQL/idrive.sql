/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : idrive

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 22/05/2020 20:47:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `status` int(0) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES (1, 'admin', 'admin', 1);
INSERT INTO `account` VALUES (6, 'abc521', 'k99999', 1);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `uid` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `sex` char(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'F',
  `age` int(0) NULL DEFAULT NULL,
  `tel` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `account` int(0) NULL DEFAULT NULL,
  `parent` int(0) NULL DEFAULT NULL,
  `regTime` datetime(0) NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0),
  `status` int(0) NULL DEFAULT 1,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `idCardImg` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (2, 'Yanlei Song', 'M', NULL, '13193577710', NULL, 'abc@ayit.edu.cnd', NULL, NULL, '2020-05-22 17:21:08', 1, 'ggg', '2.jpg');
INSERT INTO `user` VALUES (3, '马云', 'M', NULL, '16666666666', NULL, 'admin@alibaba.com', NULL, 9, '2020-05-22 19:10:15', 1, '', '3.jpg');
INSERT INTO `user` VALUES (4, '马云弟弟', 'U', NULL, '16666666666', NULL, 'admin@alibaba.com', NULL, 2, '2020-05-22 18:23:44', 1, '', '4.jpg');
INSERT INTO `user` VALUES (5, '呃', 'U', NULL, '16666666666', NULL, 'henanpysyl@126.com', NULL, 4, '2020-05-22 18:18:27', 1, '', '');
INSERT INTO `user` VALUES (6, '呃', 'M', NULL, '16666666666', NULL, 'henanpysyl@126.com', NULL, 4, '2020-05-22 18:22:26', 1, '', '6.jpg');
INSERT INTO `user` VALUES (7, '小黑黑12', 'F', NULL, '16666666666', NULL, 'admin@alibaba.com', NULL, 2, '2020-05-22 18:10:37', 1, '', '7jw47nc6zvv');
INSERT INTO `user` VALUES (8, 'Yanlei Song', 'F', NULL, '13193577710', NULL, 'syl@ayit.edu.cn', NULL, NULL, '2020-05-22 19:05:01', 1, NULL, '5w8apdhjx4m');
INSERT INTO `user` VALUES (9, 'Yanlei Song', 'M', NULL, '13193577710', NULL, 'syl@ayit.edu.cn', NULL, NULL, '2020-05-22 19:08:19', 1, NULL, NULL);
INSERT INTO `user` VALUES (10, 'Yanlei Song', 'U', NULL, '16666666666', NULL, 'syl@ayit.edu.cn', NULL, NULL, '2020-05-22 19:09:29', 1, NULL, NULL);
INSERT INTO `user` VALUES (11, '呃', 'U', NULL, '13193577710', NULL, 'henanpysyl@126.com', NULL, NULL, '2020-05-22 19:12:32', 1, NULL, NULL);
INSERT INTO `user` VALUES (12, 'Yanlei Song', 'F', NULL, '13193577710', NULL, 'syl@ayit.edu.cn', NULL, 10, '2020-05-22 19:12:47', 1, NULL, NULL);
INSERT INTO `user` VALUES (13, 'Yanlei Song', 'U', NULL, '13193577710', NULL, 'syl@ayit.edu.cn', NULL, 8, '2020-05-22 19:13:02', 1, NULL, NULL);
INSERT INTO `user` VALUES (14, 'Yanlei Song', 'F', NULL, '13193577710', NULL, 'syl@ayit.edu.cn', NULL, 2, '2020-05-22 19:13:36', 1, NULL, '4xvmdtnimu9');
INSERT INTO `user` VALUES (15, 'Yanlei Song', 'F', NULL, '16666666666', NULL, 'syl@ayit.edu.cn', NULL, NULL, '2020-05-22 19:13:57', 1, 'CCCCCCCCCCCCCCCC', '97r31ja44yb');
INSERT INTO `user` VALUES (16, 'Yanlei Song', 'F', NULL, '13193577710', NULL, 'syl@ayit.edu.cn', NULL, 2, '2020-05-22 19:14:20', 1, 'DDDDDDDDDDDDDDDDDDDD', NULL);

SET FOREIGN_KEY_CHECKS = 1;

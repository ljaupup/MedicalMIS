/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : message

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 22/06/2023 21:39:20
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for txl
-- ----------------------------
DROP TABLE IF EXISTS `txl`;
CREATE TABLE `txl`  (
  `id` int NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birth` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of txl
-- ----------------------------
INSERT INTO `txl` VALUES (1, '天猫', '12345', '20020808');
INSERT INTO `txl` VALUES (22, 'jklkjd', '123656', '20230622');

SET FOREIGN_KEY_CHECKS = 1;

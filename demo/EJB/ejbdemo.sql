/*
Navicat MySQL Data Transfer

Source Server         : rootMySQL
Source Server Version : 50619
Source Host           : localhost:3306
Source Database       : ejbdemo

Target Server Type    : MYSQL
Target Server Version : 50619
File Encoding         : 65001

Date: 2014-07-14 08:44:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for nhomtk
-- ----------------------------
DROP TABLE IF EXISTS `nhomtk`;
CREATE TABLE `nhomtk` (
  `idNhom` int(11) NOT NULL AUTO_INCREMENT,
  `tenNhom` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `moTa` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`idNhom`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of nhomtk
-- ----------------------------
INSERT INTO `nhomtk` VALUES ('1', 'Nhom 1', 'Nhóm 1');
INSERT INTO `nhomtk` VALUES ('2', 'Nhom 2', 'Nhóm 2');

-- ----------------------------
-- Table structure for taikhoan
-- ----------------------------
DROP TABLE IF EXISTS `taikhoan`;
CREATE TABLE `taikhoan` (
  `userName` varchar(35) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `thanhVienID` varchar(9) COLLATE utf8_unicode_ci DEFAULT NULL,
  `idNhom` int(11) DEFAULT NULL,
  `ngayTao` date DEFAULT NULL,
  `ghiChu` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`userName`),
  KEY `fk_taiKhoan_nhoTK` (`idNhom`),
  KEY `fk_taiKhoan_thanhVien` (`thanhVienID`),
  CONSTRAINT `fk_taiKhoan_nhoTK` FOREIGN KEY (`idNhom`) REFERENCES `nhomtk` (`idNhom`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_taiKhoan_thanhVien` FOREIGN KEY (`thanhVienID`) REFERENCES `thanhvien` (`thanhVienID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of taikhoan
-- ----------------------------

-- ----------------------------
-- Table structure for thanhvien
-- ----------------------------
DROP TABLE IF EXISTS `thanhvien`;
CREATE TABLE `thanhvien` (
  `thanhVienID` varchar(9) COLLATE utf8_unicode_ci NOT NULL,
  `ho` varchar(35) COLLATE utf8_unicode_ci NOT NULL,
  `ten` varchar(15) COLLATE utf8_unicode_ci NOT NULL,
  `ngaySinh` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `gioiTinh` int(11) DEFAULT NULL,
  `diaChi` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `soDT1` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `soDT2` varchar(16) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `chuyenMon` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `chucDanh` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `loaiTV` int(11) DEFAULT NULL,
  `ghiChu` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`thanhVienID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of thanhvien
-- ----------------------------

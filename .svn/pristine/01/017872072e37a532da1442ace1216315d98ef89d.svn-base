/*
SQLyog Ultimate v8.32 
MySQL - 5.5.5-10.1.13-MariaDB : Database - esc
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`esc` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `esc`;

/*Table structure for table `accont_payment_details` */

DROP TABLE IF EXISTS `accont_payment_details`;

CREATE TABLE `accont_payment_details` (
  `APD_ID` varchar(50) NOT NULL,
  `LOG_ID` varchar(50) DEFAULT NULL,
  `APD_IOTYPE` int(11) DEFAULT NULL,
  `APD_PAYTYPE` int(11) DEFAULT NULL,
  `APD_CREATETIME` datetime DEFAULT NULL,
  `APD_AMOUNT` float DEFAULT NULL,
  `APD_DEALTYPE` int(11) DEFAULT NULL,
  `APD_ADMINORDERNO` varchar(60) DEFAULT NULL,
  `APD_DEALNO` varchar(60) DEFAULT NULL,
  `APD_COMMENT` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`APD_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `accont_payment_details` */

/*Table structure for table `account_card` */

DROP TABLE IF EXISTS `account_card`;

CREATE TABLE `account_card` (
  `AC_ID` varchar(50) NOT NULL,
  `LOG_ID` varchar(50) DEFAULT NULL,
  `AC_NO` varchar(30) DEFAULT NULL,
  `AC_CELL` varchar(15) DEFAULT NULL,
  `AC_CARDID` varchar(30) DEFAULT NULL,
  `AC_BANK` varchar(100) DEFAULT NULL,
  `AC_TYPE` int(11) DEFAULT NULL,
  `AC_CREATETIME` datetime DEFAULT NULL,
  `AC_ISDELETE` tinyint(1) DEFAULT NULL,
  `AC_COMMENT` varchar(200) DEFAULT NULL,
  `AC_NAME` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`AC_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `account_card` */

/*Table structure for table `account_info` */

DROP TABLE IF EXISTS `account_info`;

CREATE TABLE `account_info` (
  `ACC_ID` varchar(50) NOT NULL,
  `LOG_ID` varchar(50) DEFAULT NULL,
  `ACC_BALANCE` float DEFAULT NULL,
  `ACC_BLOCKBALANCE` float DEFAULT NULL,
  `ACC_PAYPASS` varchar(50) DEFAULT NULL,
  `ACC_DEFAULTCARD` varchar(50) DEFAULT NULL,
  `ACC_COMMENT` varchar(200) DEFAULT NULL,
  `ACC_POINT` float DEFAULT NULL,
  PRIMARY KEY (`ACC_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `account_info` */

insert  into `account_info`(`ACC_ID`,`LOG_ID`,`ACC_BALANCE`,`ACC_BLOCKBALANCE`,`ACC_PAYPASS`,`ACC_DEFAULTCARD`,`ACC_COMMENT`,`ACC_POINT`) values ('217b31c0a591488a994a408e57045ba3','e1f905ed7a504fa58d6121f8f58158b2',100001,0,NULL,NULL,NULL,NULL),('2ec36cbc3fc54adbad817d5a02315a14','0ce531feeb654826b06dff5a9c489a9e',0,0,NULL,NULL,NULL,NULL),('32aa5c744e5a411f9380cfc0a18fcba7','7369f83baf9b4533bb549c28bc334c79',0,0,NULL,NULL,NULL,NULL),('b579f193f7164b83b8c9f395fd602df1','4b3be9c0512649aca58da0e9b430377c',99998,0,'d0521106f6ba7f9ac0a7370fb28d0ec6',NULL,NULL,NULL),('ec692ea243664e8a8d70b9072f7c55e4','258a4f9d7e3948528ad68e298cf0004b',0,0,NULL,NULL,NULL,NULL),('f0117465e18f4e629e4def3bad65b9e3','b80c5b10eace4442a33dbcfedfa3aac4',0,0,NULL,NULL,NULL,NULL);

/*Table structure for table `admin_info` */

DROP TABLE IF EXISTS `admin_info`;

CREATE TABLE `admin_info` (
  `ADMIN_ID` varchar(50) NOT NULL,
  `ADMIN_NAME` varchar(15) DEFAULT NULL,
  `ADMIN_PASS` varchar(50) DEFAULT NULL,
  `ADMIN_REALNAME` varchar(10) DEFAULT NULL,
  `ADMIN_CREATETIME` datetime DEFAULT NULL,
  `ADMIN_CREATER` varchar(50) DEFAULT NULL,
  `ADMIN_CELL` varchar(50) DEFAULT NULL,
  `ADMIN_COMMENT` varchar(50) DEFAULT NULL,
  `ADMIN_ORIGINALPASS` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ADMIN_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `admin_info` */

insert  into `admin_info`(`ADMIN_ID`,`ADMIN_NAME`,`ADMIN_PASS`,`ADMIN_REALNAME`,`ADMIN_CREATETIME`,`ADMIN_CREATER`,`ADMIN_CELL`,`ADMIN_COMMENT`,`ADMIN_ORIGINALPASS`) values ('7','admin','9db06bcff9248837f86d1a6bcf41c9e7','超级管理员','2016-12-21 17:14:00','1','13212568897',NULL,'12345678');

/*Table structure for table `advertise_details` */

DROP TABLE IF EXISTS `advertise_details`;

CREATE TABLE `advertise_details` (
  `AD_ID` varchar(50) NOT NULL,
  `AP_ID` varchar(50) DEFAULT NULL,
  `AD_CLICK_NUM` int(11) DEFAULT NULL,
  `AD_COMMENT` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`AD_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `advertise_details` */

/*Table structure for table `advertise_position` */

DROP TABLE IF EXISTS `advertise_position`;

CREATE TABLE `advertise_position` (
  `AP_ID` varchar(50) NOT NULL,
  `AP_IMAGE` varchar(300) DEFAULT NULL,
  `AP_URL` varchar(300) DEFAULT NULL,
  `AP_TITLE` varchar(60) DEFAULT NULL,
  `AP_POSITION` varchar(30) DEFAULT NULL,
  `AP_CREATE_TIME` datetime DEFAULT NULL,
  `ADMIN_ID` varchar(50) DEFAULT NULL,
  `AP_ISDELETE` tinyint(1) DEFAULT NULL,
  `AP_COMMNET` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`AP_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `advertise_position` */

insert  into `advertise_position`(`AP_ID`,`AP_IMAGE`,`AP_URL`,`AP_TITLE`,`AP_POSITION`,`AP_CREATE_TIME`,`ADMIN_ID`,`AP_ISDELETE`,`AP_COMMNET`) values ('6685a7198d7544c09960609031566638','[{\"pictureName\":\"20170116093036_588.jpg\",\"url\":\"/escadmin/files/image/20170116/20170116093036_588.jpg\"}]','http://www.baidu.com','首页广告','1','2017-01-16 09:31:08','7',0,'你好吗？');

/*Table structure for table `background_handle_log` */

DROP TABLE IF EXISTS `background_handle_log`;

CREATE TABLE `background_handle_log` (
  `BHL_ID` varchar(50) NOT NULL,
  `ADMIN_ID` varchar(50) DEFAULT NULL,
  `BHL_TIME` datetime DEFAULT NULL,
  `BHL_CONTENT` varchar(300) DEFAULT NULL,
  `BHL_COMMENT` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`BHL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `background_handle_log` */

insert  into `background_handle_log`(`BHL_ID`,`ADMIN_ID`,`BHL_TIME`,`BHL_CONTENT`,`BHL_COMMENT`) values ('0b88427a1e224881a345eefdb07d4d6a','7','2017-01-17 09:16:06','admin给电话为[13444444444]的用户发送了一条消息!',NULL),('0da6f779186e4a2993fd3bd642212e33','7','2017-01-19 10:56:28','授权通过,用户真实姓名为：黄毅峰,用户电话为：13444444444',NULL),('12dd5aa523854e0e885cf60bc0299dcc','7','2017-01-19 11:08:47','授权通过,用户真实姓名为：黄毅峰,用户电话为：13444444444',NULL),('14c4511cac904150bb11e51087028235','7','2017-01-16 09:48:02','审核实名认证,实名认证通过,申请人电话为：18883179781',NULL),('164896bf06574f238c99e7c5093644ff','7','2017-01-20 11:04:01','admin给电话为[13444444444]的用户发送了一条消息!',NULL),('17225b482e0c4fcda2d630072104b045','7','2017-01-20 11:04:01','审核服务,服务通过,服务商真实名称为：黄毅峰,服务商电话为：13444444444',NULL),('19749060950a41feaef03a36bbbbca77','7','2017-01-17 14:11:48','admin给电话为[18581910315]的用户发送了一条消息!',NULL),('1c0c066cb8664993b6d2d2042f28f7df','7','2017-01-17 16:50:38','后台账户id为7修改了id为a599a5d18477471c9e7e9575759ae893的ProviderRecommend表的状态：从3变更为2',NULL),('1dd4d4b56ee846fea8e67821ec2145ec','7','2017-01-16 09:46:50','修改角色,角色名称为：ssr1,角色状态为：1',NULL),('20ae4a8913944625a0893b5112331cae','7','2017-01-16 09:47:04','新增角色,角色名称为：11,角色状态为：1',NULL),('249ddb9d72b44d03bb3ae796398587ab','7','2017-01-17 14:11:48','审核服务,服务通过,服务商真实名称为：谭江海,服务商电话为：18581910315',NULL),('24ea8f275cd649819fc6b7263494d93e','7','2017-01-19 11:34:08','授权通过,用户真实姓名为：黄毅峰,用户电话为：13444444444',NULL),('287c2d52722a4ada9c6a88424326fed9','7','2017-01-20 13:53:02','admin给电话为[18002301402]的用户发送了一条消息!',NULL),('293a58ac631d43a79dcfa01fdfa3a683','7','2017-01-17 16:49:27','后台账户id为7修改了id为a599a5d18477471c9e7e9575759ae893的ProviderRecommend表的状态：从2变更为3',NULL),('3f16f783b29040c48e85c39d21204c64','7','2017-01-20 13:53:01','审核服务,服务通过,服务商真实名称为：郑启阳,服务商电话为：18002301402',NULL),('41dfe1d44d2149e59f834be8d2d10d99','7','2017-01-16 09:21:24','新增权限,权限名称为通用信息管理',NULL),('42d56575d9344b0b82c0eeea05267e84','7','2017-01-19 11:27:36','授权通过,用户真实姓名为：黄毅峰,用户电话为：13444444444',NULL),('4335dd639c7447f681e1c085bcaafd74','7','2017-01-16 09:22:40','新增权限,权限名称为删除信息',NULL),('43dfb66afd214c0c98a262e47667dbb5','7','2017-01-19 11:36:52','授权通过,用户真实姓名为：黄毅峰,用户电话为：13444444444',NULL),('48df0eaf16d946e782b522a647d63367','7','2017-01-17 13:55:23','admin给电话为[18581910315]的用户发送了一条消息!',NULL),('4c485bdbd38d4b4a9fe174655d8ca398','7','2017-01-16 09:32:19','修改广告',NULL),('4d68fce22894464aaad046cc661a1f4b','7','2017-01-17 16:26:25','审核退款,订单编号：fdf16a2390a8494797b5d1a69444dc54',NULL),('4f3e26503bf64ff2a0f15b8e1f4c46f7','7','2017-01-16 09:56:09','admin给电话为[18983402082]的用户发送了一条消息!',NULL),('536e8a62dceb45bb96d4e4d67f7495e3','7','2017-01-17 14:14:13','修改成功',NULL),('543d2eb708954a3799ae4428a79e06fe','7','2017-01-16 09:33:37','添加轮播',NULL),('54f1bd958e70459184cd736cbdf5e8e2','7','2017-01-20 13:54:29','后台账户id为7修改了id为96887e0bef3942968cefc7556a870c72的ProviderRecommend表的状态：从0变更为2',NULL),('550a20236c8540219ae1fa735dd1bc23','7','2017-01-16 09:23:49','权限配置资源,权限名称为修改信息',NULL),('555dc46e9d0843a6b9bc1a33d0ef69b8','7','2017-01-19 11:20:06','admin给电话为[13444444444]的用户发送了一条消息!',NULL),('59d0b5a7cf5244958f6600d548493b57','7','2017-01-19 11:15:09','admin给电话为[13444444444]的用户发送了一条消息!',NULL),('6486499ee8f24c989e366b1a46a50e8a','7','2017-01-17 14:13:17','admin给电话为[18581910315]的用户发送了一条消息!',NULL),('6614dcc61a6b4e55b8fa4c3d3e8dc48b','7','2017-01-16 09:22:03','新增权限,权限名称为查询',NULL),('682f58a23f7f4129beff30e4fe23f631','7','2017-01-20 11:04:01','审核服务,服务通过,服务商真实名称为：郑启阳,服务商电话为：18002301402',NULL),('6af660acdffd4658ad337cabe348fe03','7','2017-01-20 11:04:01','admin给电话为[18002301402]的用户发送了一条消息!',NULL),('6f7dba1f2dde4b5e8c9d3ca8360f67e0','7','2017-01-20 11:03:52','审核服务,服务通过,服务商真实名称为：郑启阳,服务商电话为：18002301402',NULL),('77420e1b5da34d8e9bfc89ba66973ff1','7','2017-01-19 11:20:06','授权通过,用户真实姓名为：黄毅峰,用户电话为：13444444444',NULL),('782439b05cf94eba8f4029e9850f1e9c','7','2017-01-17 13:50:17','审核实名认证,实名认证通过,申请人电话为：18581910315',NULL),('78f0e4f45ff04e0f8c662e2ef880d4f1','7','2017-01-16 09:22:20','权限配置资源,权限名称为查询',NULL),('7a47d1dbfd3947728aa1567e95934a97','7','2017-01-19 11:27:36','admin给电话为[13444444444]的用户发送了一条消息!',NULL),('7cc8213bac01464985a29595eb2e842c','7','2017-01-20 11:03:52','admin给电话为[18002301402]的用户发送了一条消息!',NULL),('897fa3a80b894586be6c4f4a33d0e331','7','2017-01-19 11:34:08','admin给电话为[13444444444]的用户发送了一条消息!',NULL),('9b9eda9062b747e5a892a360fb5b2f82','7','2017-01-17 13:50:17','admin给电话为[18581910315]的用户发送了一条消息!',NULL),('9ce361ce61d24ec6a43c9d83ce2926de','7','2017-01-17 09:16:36','admin给电话为[13444444444]的用户发送了一条消息!',NULL),('a3ffa2f0a93e4c43be8b05e645b65753','7','2017-01-16 09:31:08','添加广告',NULL),('a65732981513418fbaa714c86cb8d970','7','2017-01-17 17:04:16','订单（约见）状态修改,状态由待服务商确认变为待服务,约见人真实名称为：老谭,约见人电话为：18581910315',NULL),('a838489eaadb4432926ec98f2204f752','7','2017-01-17 09:16:35','授权通过,用户真实姓名为：郑启阳,用户电话为：13444444444',NULL),('bc4a56852f95405aa12428b61c68001a','7','2017-01-17 14:13:40','修改成功',NULL),('c02c64b08c1a481c80073b90c6edd500','7','2017-01-16 09:22:58','新增权限,权限名称为修改信息',NULL),('c15ccd6aa0424b27bec6f3dda4f6da3b','7','2017-01-16 09:56:09','审核实名认证,实名认证通过,申请人电话为：18983402082',NULL),('c2510ef7e858431da4e4b0233fcc9e6f','7','2017-01-16 09:47:10','删除角色,删除角色：11',NULL),('c42b4378c1f44d64b486e5db1ffd6f4a','7','2017-01-17 09:16:06','授权不通过,用户真实姓名为：郑启阳,用户电话为：13444444444',NULL),('c6c23ecad44e43b496dd90c8df7086fc','7','2017-01-16 09:46:20','新增角色,角色名称为：ssr,角色状态为：1',NULL),('c8abb979f1fe45c89f23b8b9989e65f6','7','2017-01-16 09:54:17','审核实名认证,实名认证通过,申请人电话为：18883182116',NULL),('cb062d294d8348629bcdf0b56e7bf23a','7','2017-01-17 14:13:17','推荐服务商,服务商ID为0ce531feeb654826b06dff5a9c489a9e',NULL),('cc764e0edbe94fff852f8eb8dcbec1d1','7','2017-01-16 10:13:26','冻结会员,会员电话为：18883182116',NULL),('ce29a1244fe544238b01d407783f9aef','7','2017-01-19 11:08:47','admin给电话为[13444444444]的用户发送了一条消息!',NULL),('cf32a17325884756a8ab320619af7baf','7','2017-01-17 13:55:23','授权通过,用户真实姓名为：谭江海,用户电话为：18581910315',NULL),('d8907a70256a47e28be877a543811f83','7','2017-01-19 11:15:09','授权通过,用户真实姓名为：黄毅峰,用户电话为：13444444444',NULL),('d8a553d747584b8a8def3bf3c17fec9f','7','2017-01-16 09:54:17','admin给电话为[18883182116]的用户发送了一条消息!',NULL),('d9b63afb62574bfbbef4c02cdd381c1e','7','2017-01-16 09:24:04','权限配置资源,权限名称为添加通用信息',NULL),('dddd58be3eb44a26b4fc28b54720454c','7','2017-01-16 09:23:34','权限配置资源,权限名称为删除信息',NULL),('e1ea5a79df6644d4a8b2ba245d9f5f88','7','2017-01-16 09:48:02','admin给电话为[18883179781]的用户发送了一条消息!',NULL),('e4ee17567b214b45a6bb18556b1da60c','7','2017-01-16 10:13:37','解冻会员,会员电话为：18883182116',NULL),('e8a56cc182904411a85e9a3e0ba327f4','7','2017-01-19 11:36:52','admin给电话为[13444444444]的用户发送了一条消息!',NULL),('e8abfb06086d48efb83a089d0aa76fb4','7','2017-01-16 09:23:19','新增权限,权限名称为添加通用信息',NULL),('f7417c9f23dd4457aa5d8cc47cef5972','7','2017-01-19 10:56:28','admin给电话为[13444444444]的用户发送了一条消息!',NULL),('face56e45c8e436189a57af34ac54c2e','7','2017-01-17 14:13:25','后台账户id为7修改了id为a599a5d18477471c9e7e9575759ae893的ProviderRecommend表的状态：从0变更为2',NULL);

/*Table structure for table `brows_history` */

DROP TABLE IF EXISTS `brows_history`;

CREATE TABLE `brows_history` (
  `BH_ID` varchar(50) NOT NULL,
  `SERVICE_ID` varchar(50) DEFAULT NULL,
  `BH_PERSON` varchar(50) DEFAULT NULL,
  `BH_TIME` datetime DEFAULT NULL,
  `BH_ISDELETE` tinyint(1) DEFAULT NULL,
  `BH_COMMENT` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`BH_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `brows_history` */

/*Table structure for table `business_relation` */

DROP TABLE IF EXISTS `business_relation`;

CREATE TABLE `business_relation` (
  `BR_ID` varchar(50) NOT NULL,
  `BR_SELLER` varchar(50) DEFAULT NULL,
  `BR_BUYER` varchar(50) DEFAULT NULL,
  `BR_CREATE_TIME` datetime DEFAULT NULL,
  `BR_TYPE` int(11) DEFAULT NULL,
  `BR_STATE` int(11) DEFAULT NULL,
  `BR_ISDELETE` tinyint(1) DEFAULT NULL,
  `BR_COMMENT` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`BR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `business_relation` */

/*Table structure for table `business_team` */

DROP TABLE IF EXISTS `business_team`;

CREATE TABLE `business_team` (
  `BT_ID` varchar(50) NOT NULL,
  `BT_NAME` varchar(30) DEFAULT NULL,
  `BT_CONTENT` text,
  `LOG_ID` varchar(50) DEFAULT NULL,
  `BT_PROVIDERS` varchar(200) DEFAULT NULL,
  `BT_CREATETIME` datetime DEFAULT NULL,
  `BT_STATE` int(11) DEFAULT NULL,
  `BT_TYPE` int(11) DEFAULT NULL,
  `BT_ISDELETE` tinyint(1) DEFAULT NULL,
  `BT_COMMENT` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`BT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `business_team` */

/*Table structure for table `common_info` */

DROP TABLE IF EXISTS `common_info`;

CREATE TABLE `common_info` (
  `CI_ID` varchar(50) NOT NULL,
  `CI_TITLE` varchar(100) DEFAULT NULL,
  `CI_CONTENT` text,
  `CI_POS` int(11) DEFAULT NULL,
  `ADMIN_ID` varchar(50) DEFAULT NULL,
  `CI_CREATETIME` datetime DEFAULT NULL,
  `CI_SORT` int(11) DEFAULT NULL,
  `CI_COMMENT` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`CI_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `common_info` */

/*Table structure for table `common_type` */

DROP TABLE IF EXISTS `common_type`;

CREATE TABLE `common_type` (
  `CT_ID` varchar(50) NOT NULL,
  `CT_TYPE` int(11) DEFAULT NULL,
  `CT_NAME` varchar(50) DEFAULT NULL,
  `CT_FID` varchar(50) DEFAULT NULL,
  `CT_ISLEAF` tinyint(1) DEFAULT NULL,
  `CT_SORT` int(11) DEFAULT NULL,
  `CT_COMMENT` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`CT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `common_type` */

insert  into `common_type`(`CT_ID`,`CT_TYPE`,`CT_NAME`,`CT_FID`,`CT_ISLEAF`,`CT_SORT`,`CT_COMMENT`) values ('16121819550003',0,'SASAS','0',0,NULL,NULL),('16122118190004',4,'1232321','0',0,NULL,NULL),('16122118190005',4,'1232321','0',0,NULL,NULL),('16122118200001',4,'213124124','0',0,NULL,NULL),('16122214170001',3,'..........','0',0,NULL,NULL),('16122214210001',3,'叶子节点','0',1,NULL,NULL),('16122214210002',3,'weeqee','16122214210001',1,NULL,NULL),('16122214210003',3,'wqewewqe','16122214210002',1,NULL,NULL),('16122214210004',3,'qwewqeqwe','16122214210003',0,NULL,NULL),('16122214220001',3,'qeq','0',1,NULL,NULL),('16122214260001',3,'<h1>h1标签文本</h1>','0',0,NULL,NULL),('16122214270001',3,'11111111111111','16122214210003',1,NULL,NULL),('17010515520001',1,'需求策划','0',0,NULL,NULL),('17010515520002',1,'市场调研','0',0,NULL,NULL),('17010515520003',1,'产品设计','0',0,NULL,NULL),('17010515530001',1,'美工设计','0',0,NULL,NULL),('17010515530002',1,'技术开发','0',0,NULL,NULL),('17010515530003',1,'网站测试','0',0,NULL,NULL),('17010515540001',1,'产品运营','0',0,NULL,NULL),('17010515570001',1,'需求策划1','17010515520001',0,NULL,NULL),('17010515580001',1,'需求策划2','17010515520001',0,NULL,NULL),('17010515580002',1,'市场调研1','17010515520002',0,NULL,NULL),('17010515580003',1,'市场调研2','17010515520002',0,NULL,NULL),('17010515580004',1,'产品设计1','17010515520003',0,NULL,NULL),('17010515580005',1,'产品设计2','17010515520003',0,NULL,NULL),('17010516000001',1,'美工设计1','17010515530001',0,NULL,NULL),('17010516000002',1,'美工设计2','17010515530001',0,NULL,NULL),('17010516000003',1,'技术开发1','17010515530002',0,NULL,NULL),('17010516000004',1,'技术开发2','17010515530002',0,NULL,NULL),('17010516000005',1,'网站测试1','17010515530003',0,NULL,NULL),('17010516000006',1,'网站测试2','17010515530003',0,NULL,NULL),('17010516010001',1,'产品运营1','17010515540001',0,NULL,NULL),('17010516010002',1,'产品运营2','17010515540001',0,NULL,NULL);

/*Table structure for table `common_type_save` */

DROP TABLE IF EXISTS `common_type_save`;

CREATE TABLE `common_type_save` (
  `SAVE_ID` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `SAVE_TYPE` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SAVE_TYPE_NAME` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `SAVE_VALUE` text COLLATE utf8_unicode_ci,
  PRIMARY KEY (`SAVE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `common_type_save` */

insert  into `common_type_save`(`SAVE_ID`,`SAVE_TYPE`,`SAVE_TYPE_NAME`,`SAVE_VALUE`) values ('39ec678839ee48e983fc9dd5d98f5905','4','类型D','{\"saveValue\":[{\"id\":\"16122118190004\",\"text\":\"1232321\"},{\"id\":\"16122118190005\",\"text\":\"1232321\"},{\"id\":\"16122118200001\",\"text\":\"213124124\"}]}'),('3f7a7afdcd6246989f6142216dd20847','2','类型B','{\"saveValue\":[]}'),('835e8afbc0f54427968541f75277d9f7','1','类型A','{\"saveValue\":[{\"id\":\"17010515520001\",\"text\":\"需求策划\",\"children\":[{\"id\":\"17010515570001\",\"text\":\"需求策划1\"},{\"id\":\"17010515580001\",\"text\":\"需求策划2\"}]},{\"id\":\"17010515520002\",\"text\":\"市场调研\",\"children\":[{\"id\":\"17010515580002\",\"text\":\"市场调研1\"},{\"id\":\"17010515580003\",\"text\":\"市场调研2\"}]},{\"id\":\"17010515520003\",\"text\":\"产品设计\",\"children\":[{\"id\":\"17010515580004\",\"text\":\"产品设计1\"},{\"id\":\"17010515580005\",\"text\":\"产品设计2\"}]},{\"id\":\"17010515530001\",\"text\":\"美工设计\",\"children\":[{\"id\":\"17010516000001\",\"text\":\"美工设计1\"},{\"id\":\"17010516000002\",\"text\":\"美工设计2\"}]},{\"id\":\"17010515530002\",\"text\":\"技术开发\",\"children\":[{\"id\":\"17010516000003\",\"text\":\"技术开发1\"},{\"id\":\"17010516000004\",\"text\":\"技术开发2\"}]},{\"id\":\"17010515530003\",\"text\":\"网站测试\",\"children\":[{\"id\":\"17010516000005\",\"text\":\"网站测试1\"},{\"id\":\"17010516000006\",\"text\":\"网站测试2\"}]},{\"id\":\"17010515540001\",\"text\":\"产品运营\",\"children\":[{\"id\":\"17010516010001\",\"text\":\"产品运营1\"},{\"id\":\"17010516010002\",\"text\":\"产品运营2\"}]}]}'),('b734fad6ca594605a22bd93c10c9c533','3','类型C','{\"saveValue\":[{\"id\":\"16122214210001\",\"text\":\"叶子节点\",\"children\":[{\"id\":\"16122214210002\",\"text\":\"weeqee\",\"children\":[{\"id\":\"16122214210003\",\"text\":\"wqewewqe\",\"children\":[{\"id\":\"16122214210004\",\"text\":\"qwewqeqwe\"}]}]}]},{\"id\":\"16122214220001\",\"text\":\"qeq\"},{\"id\":\"16122214170001\",\"text\":\"..........\"}]}');

/*Table structure for table `error_loginfo_admin` */

DROP TABLE IF EXISTS `error_loginfo_admin`;

CREATE TABLE `error_loginfo_admin` (
  `ELA_ID` varchar(50) NOT NULL,
  `ELA_INFO` varchar(200) DEFAULT NULL,
  `ELA_CREATETIME` datetime DEFAULT NULL,
  `ADMIN_ID` varchar(50) DEFAULT NULL,
  `ELA_COMMENT` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ELA_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `error_loginfo_admin` */

/*Table structure for table `error_loginfo_home` */

DROP TABLE IF EXISTS `error_loginfo_home`;

CREATE TABLE `error_loginfo_home` (
  `ELH_ID` varchar(50) NOT NULL,
  `ELH_INFO` varchar(200) DEFAULT NULL,
  `ELH_CREATETIME` datetime DEFAULT NULL,
  `LOG_ID` varchar(50) DEFAULT NULL,
  `ELH_COMMENT` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ELH_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `error_loginfo_home` */

/*Table structure for table `friendly_link_info` */

DROP TABLE IF EXISTS `friendly_link_info`;

CREATE TABLE `friendly_link_info` (
  `FL_ID` varchar(50) NOT NULL,
  `FL_TITLE` varchar(30) DEFAULT NULL,
  `FL_URL` varchar(200) DEFAULT NULL,
  `FL_SORT` int(11) DEFAULT NULL,
  `ADMIN_ID` varchar(50) DEFAULT NULL,
  `FL_COMMENT` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`FL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `friendly_link_info` */

/*Table structure for table `log_info` */

DROP TABLE IF EXISTS `log_info`;

CREATE TABLE `log_info` (
  `LOG_ID` varchar(50) NOT NULL,
  `LOG_CELL` varchar(15) DEFAULT NULL,
  `LOG_EMAIL` varchar(30) DEFAULT NULL,
  `LOG_NAME` varchar(15) DEFAULT NULL,
  `LOG_PASS` varchar(50) DEFAULT NULL,
  `LOG_CREATETIME` datetime DEFAULT NULL,
  `LOG_ISDELETE` tinyint(1) DEFAULT NULL,
  `LOG_STATE` int(11) DEFAULT NULL,
  `LOG_TYPE` int(11) DEFAULT NULL,
  `LOG_REGIP` varchar(50) DEFAULT NULL,
  `LOG_ISLOG` tinyint(1) DEFAULT NULL,
  `LOG_COMMENT` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`LOG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `log_info` */

insert  into `log_info`(`LOG_ID`,`LOG_CELL`,`LOG_EMAIL`,`LOG_NAME`,`LOG_PASS`,`LOG_CREATETIME`,`LOG_ISDELETE`,`LOG_STATE`,`LOG_TYPE`,`LOG_REGIP`,`LOG_ISLOG`,`LOG_COMMENT`) values ('0ce531feeb654826b06dff5a9c489a9e','18581910315',NULL,'哟西','fc18d157ade481cb18f519405b97f3e3','2017-01-17 09:01:15',0,1,2,'0:0:0:0:0:0:0:1',1,NULL),('258a4f9d7e3948528ad68e298cf0004b','13102308297',NULL,NULL,'70873e8580c9900986939611618d7b1e','2017-01-17 15:42:37',0,1,2,'0:0:0:0:0:0:0:1',1,NULL),('4b3be9c0512649aca58da0e9b430377c','18883179781',NULL,'sdf','9db06bcff9248837f86d1a6bcf41c9e7','2017-01-16 09:37:03',0,1,2,'0:0:0:0:0:0:0:1',1,NULL),('7369f83baf9b4533bb549c28bc334c79','13452760513',NULL,'dsf','d0521106f6ba7f9ac0a7370fb28d0ec6','2017-01-16 10:15:11',0,1,2,'127.0.0.1',1,NULL),('b80c5b10eace4442a33dbcfedfa3aac4','18883182116',NULL,'df','9db06bcff9248837f86d1a6bcf41c9e7','2017-01-16 09:52:55',0,1,2,'0:0:0:0:0:0:0:1',1,NULL),('e1f905ed7a504fa58d6121f8f58158b2','18983402082',NULL,'zqy','d0521106f6ba7f9ac0a7370fb28d0ec6','2017-01-16 09:38:55',0,1,2,'0:0:0:0:0:0:0:1',1,NULL);

/*Table structure for table `meg_details` */

DROP TABLE IF EXISTS `meg_details`;

CREATE TABLE `meg_details` (
  `MD_ID` varchar(50) NOT NULL,
  `SM_ID` varchar(50) DEFAULT NULL,
  `LOG_ID` varchar(50) DEFAULT NULL,
  `MD_CREATETIME` datetime DEFAULT NULL,
  `MD_ISDELETE` tinyint(1) DEFAULT NULL,
  `MD_COMMENT` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`MD_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `meg_details` */

insert  into `meg_details`(`MD_ID`,`SM_ID`,`LOG_ID`,`MD_CREATETIME`,`MD_ISDELETE`,`MD_COMMENT`) values ('04cb72f967514c58874204ea2e0d334c','b43c4b38801744719478fa9b17dfdbd8','0ce531feeb654826b06dff5a9c489a9e','2017-01-17 13:55:23',0,NULL),('1e52bdb83edd46a4a15c1bbd6ae950a9','1ea01b71718f42f1babeb955bc79cb19','0ce531feeb654826b06dff5a9c489a9e','2017-01-17 14:13:17',0,NULL),('3c12bec5bad645c19906472ecc625b59','2968c260ea17495083d59ec77ec55776','b80c5b10eace4442a33dbcfedfa3aac4','2017-01-16 09:54:17',0,NULL),('57b3ff945522406e8e36ee35a0f02aa7','2f4ea9733d61445c87cf48b0545535f1','e1f905ed7a504fa58d6121f8f58158b2','2017-01-20 11:03:52',0,NULL),('60f79f517a3e48ef93a06ccdace967ed','cc6988a75a5e402ebfab37680f895915','e1f905ed7a504fa58d6121f8f58158b2','2017-01-17 09:16:35',0,NULL),('806cff2acbdc4322b891c8211be7d300','f0ac227232754afe88943c3995245d97','7369f83baf9b4533bb549c28bc334c79','2017-01-19 11:20:06',0,NULL),('b8861075865845b98e0ebbf10738ed09','ccf4acbd01124cc7a9324725c58b7933','7369f83baf9b4533bb549c28bc334c79','2017-01-19 10:56:28',0,NULL),('bf986bfa99444b17bfeca308d14a0cb5','b88cc981c2f4478c9b4e76b65f74716e','7369f83baf9b4533bb549c28bc334c79','2017-01-19 11:36:52',0,NULL),('ca4dcba2f5c44b41a4efe876debfca8b','1124aa6178b74287b056fd19951e136d','7369f83baf9b4533bb549c28bc334c79','2017-01-20 11:04:01',0,NULL),('cb4cb39f83e642a7b8fff49a70bb41c6','93148ed754ed45d08fe5726c1f2029ce','e1f905ed7a504fa58d6121f8f58158b2','2017-01-20 11:04:01',0,NULL),('d152c620ef924ded905be7b29edc8a96','d0df23c53f3b4155bd71f33c53c49577','0ce531feeb654826b06dff5a9c489a9e','2017-01-17 14:11:48',0,NULL),('db30807e19d9485984b0bdf0463c7e86','fb338ea5780546a996bc9daaa422683b','e1f905ed7a504fa58d6121f8f58158b2','2017-01-16 09:56:09',0,NULL),('db7628e38810478384916e71d29840f0','4e884b9db3b844da9bd0b18547a32da8','7369f83baf9b4533bb549c28bc334c79','2017-01-19 11:15:09',0,NULL),('dc84acd564f2480b9ad812d511df92fc','1aea34d970184b96a0b422f3f46a68bf','7369f83baf9b4533bb549c28bc334c79','2017-01-19 11:08:47',0,NULL),('e3eac7fe4b05496f90d574d93aabf378','91917268be9647fab46e3a9db8c98220','0ce531feeb654826b06dff5a9c489a9e','2017-01-17 13:50:17',0,NULL),('e6e2bd4a67ac438b8f519b562059ba88','911d73b0226840f7b96815254172a7f3','e1f905ed7a504fa58d6121f8f58158b2','2017-01-20 13:53:01',0,NULL),('e8320d5dca704f0d8a8d28db41afff61','d3795b703fee4e16a59e2be140f7ddcc','7369f83baf9b4533bb549c28bc334c79','2017-01-19 11:34:08',0,NULL),('e86576c0e0b14c4ebb3322cc1c633889','ccbf2847538b45b38c9882e76da51f92','4b3be9c0512649aca58da0e9b430377c','2017-01-16 09:48:02',0,NULL),('f12a74ae5d9542b4a7240d5a320f40a2','38352c3f1acd4e67b9f4745858ace764','7369f83baf9b4533bb549c28bc334c79','2017-01-19 11:27:36',0,NULL),('fbc909042be64868bd688b48f0fe8ebc','73e232e44c7f4868ae9bf06e9d62115d','e1f905ed7a504fa58d6121f8f58158b2','2017-01-17 09:16:06',0,NULL);

/*Table structure for table `navigation_info` */

DROP TABLE IF EXISTS `navigation_info`;

CREATE TABLE `navigation_info` (
  `NAV_ID` varchar(50) NOT NULL,
  `NAV_TYPE` varchar(50) DEFAULT NULL,
  `NAV_POSITION` varchar(50) DEFAULT NULL,
  `NAV_CONTENT` varchar(50) DEFAULT NULL,
  `NAV_CREATETIME` datetime DEFAULT NULL,
  `NAV_CREATOR` varchar(50) DEFAULT NULL,
  `NAV_COMMENT` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`NAV_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `navigation_info` */

/*Table structure for table `offline_used_goodsinfo` */

DROP TABLE IF EXISTS `offline_used_goodsinfo`;

CREATE TABLE `offline_used_goodsinfo` (
  `OUG_ID` varchar(50) NOT NULL,
  `OUG_CONTENT` text,
  `OUG_DESCRIBE` varchar(100) DEFAULT NULL,
  `LOG_ID` varchar(50) DEFAULT NULL,
  `OUG_CREATETIME` datetime DEFAULT NULL,
  `OUG_STATE` int(11) DEFAULT NULL,
  `OUG_COMMENT` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`OUG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `offline_used_goodsinfo` */

/*Table structure for table `order_done_details` */

DROP TABLE IF EXISTS `order_done_details`;

CREATE TABLE `order_done_details` (
  `ODD_ID` varchar(50) NOT NULL,
  `ODD_INFO` int(11) DEFAULT NULL,
  `ODD_CREATETIME` datetime DEFAULT NULL,
  `ODD_RESULT` varchar(20) DEFAULT NULL,
  `LOG_ID` varchar(50) DEFAULT NULL,
  `ORDER_ID` varchar(50) DEFAULT NULL,
  `ODD_COMMENT` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ODD_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `order_done_details` */

insert  into `order_done_details`(`ODD_ID`,`ODD_INFO`,`ODD_CREATETIME`,`ODD_RESULT`,`LOG_ID`,`ORDER_ID`,`ODD_COMMENT`) values ('0f8c397458e94d06a969d1d35253b1e3',2,'2017-01-20 09:25:29',NULL,'e1f905ed7a504fa58d6121f8f58158b2','d1196e1344a741bfa2849455de6bf754',NULL),('114bf45d0d2641e58e1118408d105e91',0,'2017-01-20 09:07:48',NULL,'0ce531feeb654826b06dff5a9c489a9e','7fef951d57514b659b49d5caf84baae4',NULL),('25fd50ca33444eb9a9a89bf9991fbc2e',2,'2017-01-17 16:20:22',NULL,'e1f905ed7a504fa58d6121f8f58158b2','892dd9c178124718b5bf6758fe2d3ea2',NULL),('3d18c5bad9104a8e92c843af69e073c6',0,'2017-01-17 14:19:08',NULL,'log005','892dd9c178124718b5bf6758fe2d3ea2',NULL),('45728e5d3e9941169e2b06cc4d01d663',0,'2017-01-20 13:56:20',NULL,'4b3be9c0512649aca58da0e9b430377c','3911a907276d469ba50fdadd315d1da4',NULL),('60f0d415c9444c4983031b6846365d59',0,'2017-01-17 14:18:21',NULL,'log005','0f1c448428de47a5a64dd94eb2af0612',NULL),('6afb62c8a83e49d6addc2c57f1149490',2,'2017-01-17 17:04:16','测试操作结果','7','0f1c448428de47a5a64dd94eb2af0612','测试描述'),('8be2a820c88244eaaf985ef0046f17b5',2,'2017-01-20 14:03:07',NULL,'e1f905ed7a504fa58d6121f8f58158b2','3911a907276d469ba50fdadd315d1da4',NULL),('94c7dc4dfa6747a6bd154b8a02e30606',0,'2017-01-20 09:14:48',NULL,'0ce531feeb654826b06dff5a9c489a9e','d1196e1344a741bfa2849455de6bf754',NULL),('b40da244b3a6451680a5120990affe1f',2,'2017-01-17 15:39:57',NULL,'e1f905ed7a504fa58d6121f8f58158b2','36c29f1089934b258c4bcbd7f631cd1d',NULL),('ea55f5d4c85b4f9cbf7f241560a0683b',0,'2017-01-17 14:16:41',NULL,'log005','36c29f1089934b258c4bcbd7f631cd1d',NULL);

/*Table structure for table `order_info` */

DROP TABLE IF EXISTS `order_info`;

CREATE TABLE `order_info` (
  `ORDER_ID` varchar(50) NOT NULL,
  `ORDER_BUYER` varchar(50) DEFAULT NULL,
  `ORDER_SELLER` varchar(50) DEFAULT NULL,
  `ORDER_CREATETIME` datetime DEFAULT NULL,
  `ORDER_NO` varchar(100) DEFAULT NULL,
  `ORDER_STATE` int(11) DEFAULT NULL,
  `ORDER_MEETTIME` datetime DEFAULT NULL,
  `ORDER_PERSON` varchar(20) DEFAULT NULL,
  `ORDER_PERSONCELL` varchar(15) DEFAULT NULL,
  `ORDER_AREA` varchar(100) DEFAULT NULL,
  `ORDER_ADDR` varchar(200) DEFAULT NULL,
  `ORDER_REQUEST` text,
  `ORDER_ISBILL` tinyint(1) DEFAULT NULL,
  `ORDER_BILLADDR` varchar(100) DEFAULT NULL,
  `ORDER_BILLCONTENT` text,
  `ORDER_AQ` text,
  `ORDER_CONFIRMTIME` datetime DEFAULT NULL,
  `ORDER_BUYERREPAYCONTENT` text,
  `ORDER_SELLERREPAYCONTENT` text,
  `ORDER_ADMINREPAYCONTENT` text,
  `ORDER_COMMENT` varchar(200) DEFAULT NULL,
  `ORDER_SERVICE` varchar(50) DEFAULT NULL,
  `ORDER_PRICE` float DEFAULT NULL,
  `ORDER_POINT` float DEFAULT NULL,
  `ORDER_BILLSTATE` int(11) DEFAULT NULL,
  `ORDER_CHECKTIME` datetime DEFAULT NULL,
  `ORDER_CHECKMAN` varchar(50) DEFAULT NULL,
  `ORDER_BILLCOST` float DEFAULT NULL,
  `ORDER_REFUNDPRICE` float DEFAULT NULL,
  `ORDER_REFUNDSTATE` int(11) DEFAULT '0',
  `ORDER_REFUNDDATE` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `ORDER_ISDELETE` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ORDER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `order_info` */

insert  into `order_info`(`ORDER_ID`,`ORDER_BUYER`,`ORDER_SELLER`,`ORDER_CREATETIME`,`ORDER_NO`,`ORDER_STATE`,`ORDER_MEETTIME`,`ORDER_PERSON`,`ORDER_PERSONCELL`,`ORDER_AREA`,`ORDER_ADDR`,`ORDER_REQUEST`,`ORDER_ISBILL`,`ORDER_BILLADDR`,`ORDER_BILLCONTENT`,`ORDER_AQ`,`ORDER_CONFIRMTIME`,`ORDER_BUYERREPAYCONTENT`,`ORDER_SELLERREPAYCONTENT`,`ORDER_ADMINREPAYCONTENT`,`ORDER_COMMENT`,`ORDER_SERVICE`,`ORDER_PRICE`,`ORDER_POINT`,`ORDER_BILLSTATE`,`ORDER_CHECKTIME`,`ORDER_CHECKMAN`,`ORDER_BILLCOST`,`ORDER_REFUNDPRICE`,`ORDER_REFUNDSTATE`,`ORDER_REFUNDDATE`,`ORDER_ISDELETE`) values ('0f1c448428de47a5a64dd94eb2af0612','4b3be9c0512649aca58da0e9b430377c','e1f905ed7a504fa58d6121f8f58158b2','2017-01-17 14:18:21','ad6fb4f6ce7545a39385bb1563834eca',4,'2017-01-17 14:17:00','老谭','18581910315','重大C区','重大C区','[{\"content\":\"呵呵\",\"sendId\":\"aaaa\",\"time\":1484633901485,\"type\":0}]',0,NULL,NULL,NULL,NULL,'sdfs',NULL,NULL,NULL,NULL,1,1,NULL,NULL,NULL,NULL,1,1,'2017-01-17 17:55:36','\0'),('36c29f1089934b258c4bcbd7f631cd1d','4b3be9c0512649aca58da0e9b430377c','e1f905ed7a504fa58d6121f8f58158b2','2017-01-17 14:16:41','afd0a5dae9ec4dc090ce82fedd09f3aa',5,'2017-01-17 14:15:00','郑启阳','13444444444','dsafsdf','sdfsdf','[{\"content\":\"阿萨德法师的\",\"sendId\":\"aaaa\",\"time\":1484633801294,\"type\":0}]',0,NULL,NULL,NULL,NULL,'dfas',NULL,NULL,NULL,NULL,1,1,NULL,NULL,NULL,NULL,1,1,'2017-01-17 16:19:02','\0'),('3911a907276d469ba50fdadd315d1da4','4b3be9c0512649aca58da0e9b430377c','e1f905ed7a504fa58d6121f8f58158b2','2017-01-20 13:56:20','17012013560001',4,'2017-01-20 13:55:00','似懂非懂','13444444444','aaaaaa','aaaaaaaaa','[{\"content\":\"撒旦法撒旦\",\"sendId\":\"aaaa\",\"time\":1484891780331,\"type\":0}]',0,NULL,NULL,NULL,NULL,'fsdfdsfsd','的发生大幅度是',NULL,NULL,NULL,0.01,0.01,NULL,NULL,NULL,NULL,0.01,3,'2017-01-20 14:11:34','\0'),('7fef951d57514b659b49d5caf84baae4','0ce531feeb654826b06dff5a9c489a9e','e1f905ed7a504fa58d6121f8f58158b2','2017-01-20 09:07:48','17012009070001',0,'2017-01-20 09:07:00','李强','18581910315','重大c区','重大c区','[{\"content\":\"重大c区\",\"sendId\":\"aaaa\",\"time\":1484874468652,\"type\":0}]',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,1,NULL,NULL,NULL,NULL,NULL,0,'2017-01-20 09:09:15',''),('892dd9c178124718b5bf6758fe2d3ea2','4b3be9c0512649aca58da0e9b430377c','e1f905ed7a504fa58d6121f8f58158b2','2017-01-17 14:19:08','fdf16a2390a8494797b5d1a69444dc54',4,'2017-01-17 14:15:00','郑启阳','13444444444','dsafsdf','sdfsdf','[{\"content\":\"阿萨德法师的\",\"sendId\":\"aaaa\",\"time\":1484633948226,\"type\":0}]',0,NULL,NULL,NULL,NULL,'sdaf','撒旦法撒旦浮点数撒旦法撒旦撒旦法',NULL,NULL,NULL,1,1,NULL,NULL,NULL,NULL,1,4,'2017-01-17 16:26:29','\0'),('d1196e1344a741bfa2849455de6bf754','0ce531feeb654826b06dff5a9c489a9e','e1f905ed7a504fa58d6121f8f58158b2','2017-01-20 09:14:48','17012009140001',2,'2017-01-20 09:14:00','哈哈','18481818181','重大c区','重大c区','[{\"content\":\"重大c区\",\"sendId\":\"aaaa\",\"time\":1484874888806,\"type\":0}]',0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,1,1,NULL,NULL,NULL,NULL,NULL,0,'2017-01-20 09:25:41','\0');

/*Table structure for table `order_service` */

DROP TABLE IF EXISTS `order_service`;

CREATE TABLE `order_service` (
  `OS_ID` varchar(50) NOT NULL,
  `ORDER_ID` varchar(50) DEFAULT NULL,
  `SERS_ID` varchar(50) DEFAULT NULL,
  `OS_GOODS_NUM` float DEFAULT NULL,
  `SS_ID` varchar(50) DEFAULT NULL,
  `OS_COMMENT` varchar(200) DEFAULT NULL,
  `OS_ATTRS` varchar(255) DEFAULT NULL,
  `OS_SOURCE` varchar(50) DEFAULT NULL,
  `OS_PRICE` float DEFAULT NULL,
  `OS_POINT` float DEFAULT NULL,
  `OS_SETPS` varchar(300) DEFAULT NULL,
  `OS_SERVICETITLE` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`OS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `order_service` */

insert  into `order_service`(`OS_ID`,`ORDER_ID`,`SERS_ID`,`OS_GOODS_NUM`,`SS_ID`,`OS_COMMENT`,`OS_ATTRS`,`OS_SOURCE`,`OS_PRICE`,`OS_POINT`,`OS_SETPS`,`OS_SERVICETITLE`) values ('6b9a48b00e6345b884bf4da0821cc58c','0f1c448428de47a5a64dd94eb2af0612','d38ccb98149546649df34f531266ba44',1,'d38ccb98149546649df34f531266ba44',NULL,NULL,'1',1,1,'[{\"logId\":\"e1f905ed7a504fa58d6121f8f58158b2\",\"serviceId\":\"50d53d03d3f248cc86c1c47a9edcdc91\",\"ssDescribe\":\"地方\",\"ssId\":\"9c1d5d098b4440038df7f4584ed30426\",\"ssName\":\"是\",\"ssPrice\":\"[{\\\"psetDiscountType\\\":\\\"1\\\",\\\"psetPoint\\\":\\\"1\\\",\\\"psetPrice\\\":\\\"1\\\"}]\",\"ssSort\":0}]',NULL),('8d0d7ced946b49b5b29917679b8698f0','892dd9c178124718b5bf6758fe2d3ea2','d38ccb98149546649df34f531266ba44',1,'d38ccb98149546649df34f531266ba44',NULL,NULL,'1',1,1,'[{\"logId\":\"e1f905ed7a504fa58d6121f8f58158b2\",\"serviceId\":\"50d53d03d3f248cc86c1c47a9edcdc91\",\"ssDescribe\":\"地方\",\"ssId\":\"9c1d5d098b4440038df7f4584ed30426\",\"ssName\":\"是\",\"ssPrice\":\"[{\\\"psetDiscountType\\\":\\\"1\\\",\\\"psetPoint\\\":\\\"1\\\",\\\"psetPrice\\\":\\\"1\\\"}]\",\"ssSort\":0}]',NULL),('914eea85b7fd43ef812f4b64490b29a2','3911a907276d469ba50fdadd315d1da4','7a2ee4e3495540488405886144b1949d',1,'7a2ee4e3495540488405886144b1949d',NULL,NULL,'1',0.01,0.01,'[{\"logId\":\"e1f905ed7a504fa58d6121f8f58158b2\",\"serviceId\":\"5d5f54e871984c738a02d2b5cf72fe96\",\"ssDescribe\":\"0.01\",\"ssId\":\"3bf172f0d29c45cb95378a98d08f2eae\",\"ssName\":\"撒旦法\",\"ssPrice\":\"[{\\\"psetDiscountType\\\":\\\"1\\\",\\\"psetPoint\\\":\\\"0.01\\\",\\\"psetPrice\\\":\\\"0.01\\\"}]\",\"ssSort\":0}]',NULL),('c91e4893c5f44f7cad82ca26f1711b16','d1196e1344a741bfa2849455de6bf754','d38ccb98149546649df34f531266ba44',1,'d38ccb98149546649df34f531266ba44',NULL,NULL,'1',1,1,'[{\"logId\":\"e1f905ed7a504fa58d6121f8f58158b2\",\"serviceId\":\"50d53d03d3f248cc86c1c47a9edcdc91\",\"ssDescribe\":\"地方\",\"ssId\":\"9c1d5d098b4440038df7f4584ed30426\",\"ssName\":\"是\",\"ssPrice\":\"[{\\\"psetDiscountType\\\":\\\"1\\\",\\\"psetPoint\\\":\\\"1\\\",\\\"psetPrice\\\":\\\"1\\\"}]\",\"ssSort\":0}]',NULL),('f3665e62c9fd4445a56b091e23381147','36c29f1089934b258c4bcbd7f631cd1d','d38ccb98149546649df34f531266ba44',1,'d38ccb98149546649df34f531266ba44',NULL,NULL,'1',1,1,'[{\"logId\":\"e1f905ed7a504fa58d6121f8f58158b2\",\"serviceId\":\"50d53d03d3f248cc86c1c47a9edcdc91\",\"ssDescribe\":\"地方\",\"ssId\":\"9c1d5d098b4440038df7f4584ed30426\",\"ssName\":\"是\",\"ssPrice\":\"[{\\\"psetDiscountType\\\":\\\"1\\\",\\\"psetPoint\\\":\\\"1\\\",\\\"psetPrice\\\":\\\"1\\\"}]\",\"ssSort\":0}]',NULL),('fcffe7d5ec634f2892c8d7c372b46356','7fef951d57514b659b49d5caf84baae4','d38ccb98149546649df34f531266ba44',1,'d38ccb98149546649df34f531266ba44',NULL,NULL,'1',1,1,'[{\"logId\":\"e1f905ed7a504fa58d6121f8f58158b2\",\"serviceId\":\"50d53d03d3f248cc86c1c47a9edcdc91\",\"ssDescribe\":\"地方\",\"ssId\":\"9c1d5d098b4440038df7f4584ed30426\",\"ssName\":\"是\",\"ssPrice\":\"[{\\\"psetDiscountType\\\":\\\"1\\\",\\\"psetPoint\\\":\\\"1\\\",\\\"psetPrice\\\":\\\"1\\\"}]\",\"ssSort\":0}]',NULL);

/*Table structure for table `pay_details` */

DROP TABLE IF EXISTS `pay_details`;

CREATE TABLE `pay_details` (
  `PAYD_ID` varchar(50) NOT NULL,
  `ORDER_ID` varchar(50) DEFAULT NULL,
  `PAYD_PAYTIME` datetime DEFAULT NULL,
  `PAYD_PAYER` varchar(50) DEFAULT NULL,
  `PAYD_RECEIVER` varchar(50) DEFAULT NULL,
  `PAYD_PAYAMMOUNT` float DEFAULT NULL,
  `PAYD_POINTS` float DEFAULT NULL,
  `PAYD_STEP` varchar(50) DEFAULT NULL,
  `PAYD_COMMENT` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`PAYD_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `pay_details` */

/*Table structure for table `person_checkname` */

DROP TABLE IF EXISTS `person_checkname`;

CREATE TABLE `person_checkname` (
  `PCN_ID` varchar(50) NOT NULL,
  `PCN_RELNAME` varchar(30) DEFAULT NULL,
  `PCN_IDNUMBER` varchar(30) DEFAULT NULL,
  `PCN_FRONTID` varchar(300) DEFAULT NULL,
  `PCN_REVERSEID` varchar(300) DEFAULT NULL,
  `PCN_INTRODUCE` text,
  `LOG_ID` varchar(50) DEFAULT NULL,
  `PCN_CREATETIME` datetime DEFAULT NULL,
  `PCN_STATE` int(11) DEFAULT NULL,
  `PCN_COMMENT` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`PCN_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `person_checkname` */

insert  into `person_checkname`(`PCN_ID`,`PCN_RELNAME`,`PCN_IDNUMBER`,`PCN_FRONTID`,`PCN_REVERSEID`,`PCN_INTRODUCE`,`LOG_ID`,`PCN_CREATETIME`,`PCN_STATE`,`PCN_COMMENT`) values ('3a5f277516a2459ca72c26599d6e757b','黄毅峰','500101199405133110','{\"pcnFrontidJust\":\"/esc/files/image/20170116/20170116101639_170.jpeg\",\"pcnFrontidBack\":\"/esc/files/image/20170116/20170116101644_96.jpeg\"}','/esc/files/image/20170116/20170116101649_573.jpeg',NULL,'7369f83baf9b4533bb549c28bc334c79','2017-01-16 10:16:53',2,NULL),('52b66865b4134de6a9bde952fae980b8','龚博','500237199408242250','{\"pcnFrontidJust\":\"/esc/files/image/20170116/20170116095336_891.jpg\",\"pcnFrontidBack\":\"/esc/files/image/20170116/20170116095341_439.jpg\"}','/esc/files/image/20170116/20170116095355_833.jpg',NULL,'b80c5b10eace4442a33dbcfedfa3aac4','2017-01-16 09:53:56',2,NULL),('5988d15bfce04c98afbc8877a5622e26','郑启阳','500113199310217114','{\"pcnFrontidJust\":\"/esc/files/image/20170116/20170116095425_442.jpg\",\"pcnFrontidBack\":\"/esc/files/image/20170116/20170116095428_410.jpg\"}','/esc/files/image/20170116/20170116095431_58.jpg',NULL,'e1f905ed7a504fa58d6121f8f58158b2','2017-01-16 09:54:32',2,NULL),('7218b56f5f6e4affbe7f2d003cf2b37e','肖帆江','500108199308060858','{\"pcnFrontidJust\":\"/esc/files/image/20170116/20170116094453_924.jpg\",\"pcnFrontidBack\":\"/esc/files/image/20170116/20170116094508_289.jpg\"}','/esc/files/image/20170116/20170116094523_319.jpg',NULL,'4b3be9c0512649aca58da0e9b430377c','2017-01-16 09:45:28',2,NULL),('de05fb9633194224ab5ec15b195cccbb','谭江海','511322199302107318','{\"pcnFrontidJust\":\"/esc/files/image/20170117/20170117134918_192.jpg\",\"pcnFrontidBack\":\"/esc/files/image/20170117/20170117134929_227.jpg\"}','/esc/files/image/20170117/20170117134938_201.jpg',NULL,'0ce531feeb654826b06dff5a9c489a9e','2017-01-17 13:49:40',2,NULL);

/*Table structure for table `point` */

DROP TABLE IF EXISTS `point`;

CREATE TABLE `point` (
  `POINT_ID` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `POINT_LBS_ID` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `POINT_PROVIDER` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `POINT_LAT` float DEFAULT NULL,
  `POINT_LNG` float DEFAULT NULL,
  PRIMARY KEY (`POINT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `point` */

insert  into `point`(`POINT_ID`,`POINT_LBS_ID`,`POINT_PROVIDER`,`POINT_LAT`,`POINT_LNG`) values ('11d4de8a2dd948df873e831cc4596133',NULL,'0ce531feeb654826b06dff5a9c489a9e',29.5446,106.531),('99bdada60f5449609dc6ff12bbd1f2e9','1936394754','7369f83baf9b4533bb549c28bc334c79',29.5247,106.504),('f9ef97af984f4b7982eae7e5df07891d',NULL,'e1f905ed7a504fa58d6121f8f58158b2',29.5446,106.531);

/*Table structure for table `point_payment_details` */

DROP TABLE IF EXISTS `point_payment_details`;

CREATE TABLE `point_payment_details` (
  `PPD_ID` varchar(50) NOT NULL,
  `LOG_ID` varchar(50) DEFAULT NULL,
  `PPD_IOTYPE` int(11) DEFAULT NULL,
  `PPD_CREATETIME` datetime DEFAULT NULL,
  `PPD_AMOUNT` int(11) DEFAULT NULL,
  `PPD_DEALTYPE` int(11) DEFAULT NULL,
  `PPD_ADMINORDERNO` varchar(60) DEFAULT NULL,
  `PPD_DEALNO` varchar(60) DEFAULT NULL,
  `PPD_COMMENT` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`PPD_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `point_payment_details` */

/*Table structure for table `price_set` */

DROP TABLE IF EXISTS `price_set`;

CREATE TABLE `price_set` (
  `PSET_ID` varchar(50) NOT NULL,
  `PSET_DISCOUNT_TYPE` int(11) DEFAULT NULL,
  `PSET_POINT_TYPE` int(11) DEFAULT NULL,
  `PSET_PRICE` float DEFAULT NULL,
  `PSET_POINT` float DEFAULT NULL,
  `PSET_CREATE_TIME` datetime DEFAULT NULL,
  `LOG_ID` varchar(50) DEFAULT NULL,
  `SERVICE_ID` varchar(50) DEFAULT NULL,
  `PSET_COMMENT` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`PSET_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `price_set` */

insert  into `price_set`(`PSET_ID`,`PSET_DISCOUNT_TYPE`,`PSET_POINT_TYPE`,`PSET_PRICE`,`PSET_POINT`,`PSET_CREATE_TIME`,`LOG_ID`,`SERVICE_ID`,`PSET_COMMENT`) values ('131ee518e31c4e91b4bc512cef5113b2',1,NULL,1,1,'2017-01-17 10:26:16','e1f905ed7a504fa58d6121f8f58158b2','50d53d03d3f248cc86c1c47a9edcdc91',NULL),('1924ccbcf3784ef28f03097fcc983952',111,NULL,100,10,'2017-01-17 14:11:26','0ce531feeb654826b06dff5a9c489a9e','7cb75dceb53547c28ecbb414b9aef139',NULL),('1d8eae43e3f9430c83a7e457674c1a5a',1,NULL,1,1,'2017-01-20 13:53:14','7369f83baf9b4533bb549c28bc334c79','45fd19c73d8f461384c11814c4c2eabb',NULL),('3478d8e359d6430f982f99392623f134',1,NULL,0.01,0.01,'2017-01-20 13:50:41','e1f905ed7a504fa58d6121f8f58158b2','5d5f54e871984c738a02d2b5cf72fe96',NULL),('34a9f92f337a4435b2f49d51d8367957',1,NULL,1,1,'2017-01-19 10:09:33','7369f83baf9b4533bb549c28bc334c79','83b7deb6b4084946954ad4f67056e1a5',NULL),('57701d88ab6344ebaa1bdb4c234d3bd3',1,NULL,0.01,1,'2017-01-20 11:01:33','e1f905ed7a504fa58d6121f8f58158b2','5f00e75eb5b1403fb881400a5a3c2304',NULL),('72139e126a6e47538e713b760f32ba03',1111,NULL,0.01,1,'2017-01-20 10:23:39','e1f905ed7a504fa58d6121f8f58158b2','964d64ed7e8345b09765709ad6a87194',NULL);

/*Table structure for table `provider_check_info` */

DROP TABLE IF EXISTS `provider_check_info`;

CREATE TABLE `provider_check_info` (
  `PCI_ID` varchar(50) NOT NULL,
  `PCI_IMAGE` varchar(300) DEFAULT NULL,
  `PCI_EADUCATE` varchar(300) DEFAULT NULL,
  `PCI_CREDENTIALS` varchar(300) DEFAULT NULL,
  `PCI_OTHERS` varchar(300) DEFAULT NULL,
  `PCI_INTRODUCE` varchar(2000) DEFAULT NULL,
  `PCI_STATE` int(11) DEFAULT NULL,
  `LOG_ID` varchar(50) DEFAULT NULL,
  `PCI_COMMENT` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`PCI_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `provider_check_info` */

insert  into `provider_check_info`(`PCI_ID`,`PCI_IMAGE`,`PCI_EADUCATE`,`PCI_CREDENTIALS`,`PCI_OTHERS`,`PCI_INTRODUCE`,`PCI_STATE`,`LOG_ID`,`PCI_COMMENT`) values ('475f2f451673498993edf49d29ee19e4','/esc/files/image/20170119/20170119175431_115.png,/esc/files/image/20170119/20170119175435_228.png','/esc/files/image/20170119/20170119175440_301.png,/esc/files/image/20170119/20170119175445_576.png','/esc/files/image/20170119/20170119175449_621.png,/esc/files/image/20170119/20170119175454_333.png','/esc/files/image/20170119/20170119175458_514.png,/esc/files/image/20170119/20170119175503_323.png',NULL,2,'e1f905ed7a504fa58d6121f8f58158b2',NULL),('abd7c11d42144adf9533cea1b1ae4ce2','/esc/files/image/20170117/20170117135225_591.jpg,/esc/files/image/20170117/20170117135234_154.jpg','/esc/files/image/20170117/20170117135240_869.jpg,/esc/files/image/20170117/20170117135248_998.jpg','/esc/files/image/20170117/20170117135301_880.jpg,/esc/files/image/20170117/20170117135308_200.jpg','/esc/files/image/20170117/20170117135314_125.jpg,/esc/files/image/20170117/20170117135320_963.jpg',NULL,2,'7369f83baf9b4533bb549c28bc334c79','');

/*Table structure for table `provider_collection` */

DROP TABLE IF EXISTS `provider_collection`;

CREATE TABLE `provider_collection` (
  `PC_ID` varchar(50) NOT NULL,
  `PC_PID` varchar(50) DEFAULT NULL,
  `LOG_ID` varchar(50) DEFAULT NULL,
  `PC_CREATETIME` datetime DEFAULT NULL,
  `PC_ISDELETE` tinyint(1) DEFAULT NULL,
  `PC_COMMENT` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`PC_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `provider_collection` */

/*Table structure for table `provider_info` */

DROP TABLE IF EXISTS `provider_info`;

CREATE TABLE `provider_info` (
  `PI_ID` varchar(50) NOT NULL,
  `PI_AREA` varchar(200) DEFAULT NULL,
  `PI_PHOTO` varchar(100) DEFAULT NULL,
  `PI_KEYWORDS` varchar(30) DEFAULT NULL,
  `PI_REMARK` varchar(100) DEFAULT NULL,
  `PI_TYPE` int(11) DEFAULT NULL,
  `PI_REALNAME` varchar(15) DEFAULT NULL,
  `PI_COMPANY` varchar(100) DEFAULT NULL,
  `PI_POSITION` varchar(30) DEFAULT NULL,
  `PI_WORKYEAR` int(11) DEFAULT NULL,
  `PI_EMAIL` varchar(100) DEFAULT NULL,
  `PI_CELL` varchar(15) DEFAULT NULL,
  `PI_ADDR` varchar(200) DEFAULT NULL,
  `PI_ISDELETE` tinyint(1) DEFAULT NULL,
  `PI_CONTENT` text,
  `LOG_ID` varchar(50) DEFAULT NULL,
  `PI_BRIEF` varchar(200) DEFAULT NULL,
  `PI_MEETNUM` int(11) DEFAULT NULL,
  `PI_DEALNUM` int(11) DEFAULT NULL,
  `PI_RESPONSETIME` int(11) DEFAULT NULL,
  `PI_URLS` varchar(500) DEFAULT NULL,
  `PI_COMMENT` varchar(200) DEFAULT NULL,
  `PI_MARK` float DEFAULT NULL,
  `PI_VIDEO` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`PI_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `provider_info` */

insert  into `provider_info`(`PI_ID`,`PI_AREA`,`PI_PHOTO`,`PI_KEYWORDS`,`PI_REMARK`,`PI_TYPE`,`PI_REALNAME`,`PI_COMPANY`,`PI_POSITION`,`PI_WORKYEAR`,`PI_EMAIL`,`PI_CELL`,`PI_ADDR`,`PI_ISDELETE`,`PI_CONTENT`,`LOG_ID`,`PI_BRIEF`,`PI_MEETNUM`,`PI_DEALNUM`,`PI_RESPONSETIME`,`PI_URLS`,`PI_COMMENT`,`PI_MARK`,`PI_VIDEO`) values ('7d07dded62124a059f2828cd52193530','北京市-东城区-','/esc/files/image/20170119/20170119175508_431.png',NULL,NULL,NULL,'郑启阳','123123','1231',11,'12312312@qq.com','18002301402','重庆市巴南区S103',0,'3123123123','e1f905ed7a504fa58d6121f8f58158b2','213213127369f83baf9b4533bb549c28bc334c79',NULL,NULL,NULL,'12312312312312',NULL,NULL,'/esc/files/media/20170119/20170119175517_964.mp4'),('c369493620944083af710388c21a42ea','北京市-东城区-','/esc/files/image/20170119/20170119104129_52.jpg',NULL,NULL,NULL,'黄毅峰','活活','活活',1,'vvvv@wew.com','13444444444','重庆市九龙坡区石坪桥正街',0,'213213213213','7369f83baf9b4533bb549c28bc334c79','213213213213213213',NULL,NULL,NULL,'213213213213213213213213213213213213',NULL,NULL,'/esc/files/media/20170119/20170119104407_533.mp4');

/*Table structure for table `provider_recommend` */

DROP TABLE IF EXISTS `provider_recommend`;

CREATE TABLE `provider_recommend` (
  `PR_ID` varchar(50) NOT NULL,
  `PR_DETAILS` text,
  `PR_PHOTO` varchar(300) DEFAULT NULL,
  `PR_CREATETIME` datetime DEFAULT NULL,
  `PR_STATE` int(11) DEFAULT NULL,
  `PR_SORT` int(11) DEFAULT NULL,
  `LOG_ID` varchar(50) DEFAULT NULL,
  `PR_COMMENT` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`PR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `provider_recommend` */

insert  into `provider_recommend`(`PR_ID`,`PR_DETAILS`,`PR_PHOTO`,`PR_CREATETIME`,`PR_STATE`,`PR_SORT`,`LOG_ID`,`PR_COMMENT`) values ('2','2','2','2017-01-17 14:13:17',2,2,'0ce531feeb654826b06dff5a9c489a9e','2'),('80c233532d5d48d0a4de4d6c13a1b259','afasfasfasfasdqwerdqefdgrthry','/esc/files/image/20170120/20170120144401_1.jpg','2017-01-20 14:44:02',1,0,'e1f905ed7a504fa58d6121f8f58158b2',NULL),('a599a5d18477471c9e7e9575759ae893','杀伤力不在于看得见的，无形才是最高境界','/esc/files/image/20170117/20170117135330_974.jpg','2017-01-17 14:13:17',2,0,'0ce531feeb654826b06dff5a9c489a9e',NULL);

/*Table structure for table `seervice_done_log` */

DROP TABLE IF EXISTS `seervice_done_log`;

CREATE TABLE `seervice_done_log` (
  `SDL_ID` varchar(50) NOT NULL,
  `SS_ID` varchar(50) DEFAULT NULL,
  `SDL_CREATETIME` datetime DEFAULT NULL,
  `SDL_STATE` int(11) DEFAULT NULL,
  `SDL_REVERSE` varchar(100) DEFAULT NULL,
  `SDL_CUSTOMER` varchar(100) DEFAULT NULL,
  `SDL_COMMENT` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`SDL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `seervice_done_log` */

/*Table structure for table `select_code_log_info` */

DROP TABLE IF EXISTS `select_code_log_info`;

CREATE TABLE `select_code_log_info` (
  `SCLI_ID` varchar(50) NOT NULL,
  `SCLI_CREATETIME` datetime DEFAULT NULL,
  `LOG_ID` varchar(50) DEFAULT NULL,
  `SCLI_CONTENT` varchar(60) DEFAULT NULL,
  `SCLI_COMMENT` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`SCLI_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `select_code_log_info` */

/*Table structure for table `service_cart` */

DROP TABLE IF EXISTS `service_cart`;

CREATE TABLE `service_cart` (
  `SCART_ID` varchar(50) NOT NULL,
  `SS_ID` varchar(50) DEFAULT NULL,
  `SERVICE_ID` varchar(50) DEFAULT NULL,
  `LOG_ID` varchar(50) DEFAULT NULL,
  `SCART_CREATETIME` datetime DEFAULT NULL,
  `SCART_ISDELETE` tinyint(1) DEFAULT NULL,
  `SCART_COMMENT` varchar(200) DEFAULT NULL,
  `SCART_ATTRS` varchar(255) DEFAULT NULL,
  `SCART_SOURCE` varchar(255) DEFAULT NULL,
  `SCART_NUM` int(11) DEFAULT NULL,
  `SCART_PRICE` float DEFAULT NULL,
  `SCART_POINT` float DEFAULT NULL,
  PRIMARY KEY (`SCART_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `service_cart` */

/*Table structure for table `service_collection` */

DROP TABLE IF EXISTS `service_collection`;

CREATE TABLE `service_collection` (
  `SCOL_ID` varchar(50) NOT NULL,
  `SERVICE_ID` varchar(50) DEFAULT NULL,
  `LOG_ID` varchar(50) DEFAULT NULL,
  `SCOL_CREATETIME` datetime DEFAULT NULL,
  `SCOL_ISDELETE` tinyint(1) DEFAULT NULL,
  `SCOL_COMMENT` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`SCOL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `service_collection` */

/*Table structure for table `service_info` */

DROP TABLE IF EXISTS `service_info`;

CREATE TABLE `service_info` (
  `SERVICE_ID` varchar(50) NOT NULL,
  `LOG_ID` varchar(50) DEFAULT NULL,
  `SERVICE_REMARK` varchar(50) DEFAULT NULL,
  `SERVICE_TITLE` varchar(50) DEFAULT NULL,
  `SERVICE_BIREF` varchar(200) DEFAULT NULL,
  `SERVICE_CONTENT` text,
  `SERVICE_PRICE` text,
  `SERVICE_RESPONSE` float DEFAULT NULL,
  `SERVICE_MEETNUM` int(11) DEFAULT NULL,
  `SERVICE_SUCCESSNUM` int(11) DEFAULT NULL,
  `SERVICE_ISDELETE` tinyint(1) DEFAULT NULL,
  `SERVICE_CREATETIME` datetime DEFAULT NULL,
  `SERVICE_STATE` int(11) DEFAULT NULL,
  `SERVICE_MEETTIME` float DEFAULT NULL,
  `SERVICE_TYPE` varchar(20) DEFAULT NULL,
  `SERVICE_ATTRINFO` varchar(500) DEFAULT NULL,
  `SERVICE_KEYWORDS` varchar(100) DEFAULT NULL,
  `SERVICE_COMMENT` varchar(200) DEFAULT NULL,
  `SERVICE_PIC` varchar(255) DEFAULT NULL,
  `SERVICE_TYPETREE` varchar(500) DEFAULT NULL,
  `SERVICE_MARK` float DEFAULT NULL,
  PRIMARY KEY (`SERVICE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `service_info` */

insert  into `service_info`(`SERVICE_ID`,`LOG_ID`,`SERVICE_REMARK`,`SERVICE_TITLE`,`SERVICE_BIREF`,`SERVICE_CONTENT`,`SERVICE_PRICE`,`SERVICE_RESPONSE`,`SERVICE_MEETNUM`,`SERVICE_SUCCESSNUM`,`SERVICE_ISDELETE`,`SERVICE_CREATETIME`,`SERVICE_STATE`,`SERVICE_MEETTIME`,`SERVICE_TYPE`,`SERVICE_ATTRINFO`,`SERVICE_KEYWORDS`,`SERVICE_COMMENT`,`SERVICE_PIC`,`SERVICE_TYPETREE`,`SERVICE_MARK`) values ('45fd19c73d8f461384c11814c4c2eabb','7369f83baf9b4533bb549c28bc334c79','{total:0.0,count:0}','21321213123','213213213','213213213213213213123','[{\"logId\":\"7369f83baf9b4533bb549c28bc334c79\",\"psetCreateTime\":1484891594795,\"psetDiscountType\":1,\"psetId\":\"1d8eae43e3f9430c83a7e457674c1a5a\",\"psetPoint\":1,\"psetPrice\":1,\"serviceId\":\"45fd19c73d8f461384c11814c4c2eabb\"}]',0,0,0,0,'2017-01-20 13:53:14',1,121,'17010515570001','[{\"name\":\"1\",\"value\":[]}]','[\"213213\"]',NULL,'/esc/files/image/20170120/20170120135306_41.jpg','17010515570001',0),('50d53d03d3f248cc86c1c47a9edcdc91','e1f905ed7a504fa58d6121f8f58158b2','','卖服务的服务商','似懂非懂是...','撒旦法','[{\"logId\":\"e1f905ed7a504fa58d6121f8f58158b2\",\"psetCreateTime\":1484619976777,\"psetDiscountType\":1,\"psetId\":\"131ee518e31c4e91b4bc512cef5113b2\",\"psetPoint\":1,\"psetPrice\":0.01,\"serviceId\":\"50d53d03d3f248cc86c1c47a9edcdc91\"}]',0,0,0,0,'2017-01-17 10:26:16',2,2,'17010515520001','[{\"name\":\"是\",\"value\":[]}]','[\"sdfsdf\"]',NULL,'/esc/files/image/20170117/20170117141059_296.jpg','17010515520001',0),('5d5f54e871984c738a02d2b5cf72fe96','e1f905ed7a504fa58d6121f8f58158b2','{total:0.0,count:0}','我是一个服务','撒旦法撒旦浮点数','发送发送地方','[{\"logId\":\"e1f905ed7a504fa58d6121f8f58158b2\",\"psetCreateTime\":1484891441434,\"psetDiscountType\":1,\"psetId\":\"3478d8e359d6430f982f99392623f134\",\"psetPoint\":0.01,\"psetPrice\":0.01,\"serviceId\":\"5d5f54e871984c738a02d2b5cf72fe96\"}]',0,0,0,0,'2017-01-20 13:50:41',2,2,'17010515520002','[{\"name\":\"地方\",\"value\":[]}]','[\"撒旦法撒旦浮点数\"]',NULL,'/esc/files/image/20170120/20170120135016_170.png','17010515520002',0),('5f00e75eb5b1403fb881400a5a3c2304','e1f905ed7a504fa58d6121f8f58158b2','{total:0.0,count:0}','111111111111111111111111','111111111111111111111111111','111111111111111111111111111111111','[{\"logId\":\"e1f905ed7a504fa58d6121f8f58158b2\",\"psetCreateTime\":1484881293551,\"psetDiscountType\":1,\"psetId\":\"57701d88ab6344ebaa1bdb4c234d3bd3\",\"psetPoint\":1,\"psetPrice\":0.01,\"serviceId\":\"5f00e75eb5b1403fb881400a5a3c2304\"}]',0,0,0,0,'2017-01-20 11:01:33',2,1,'17010516000005','[{\"name\":\"1\",\"value\":[\"1111\"]}]','[\"关键词1，关键词2\"]',NULL,'/esc/files/image/20170120/20170120110102_729.jpg','17010516000005',0),('83b7deb6b4084946954ad4f67056e1a5','7369f83baf9b4533bb549c28bc334c79','{total:0.0,count:0}','你好就是一个什么贵','13123123','2132132132132111111111111111111111111111111111111111111111111111111<img alt=\"\" src=\"/esc/files/image/20170119/20170119100905_530.jpg\" />','[{\"logId\": \"7369f83baf9b4533bb549c28bc334c79\", \"psetCreateTime\": 1484791773388, \"psetDiscountType\": 1, \"psetId\": \"34a9f92f337a4435b2f49d51d8367957\",\"psetPoint\": 1, \"psetPrice\": 0.01, \"serviceId\": \"83b7deb6b4084946954ad4f67056e1a5\"}]',0,0,0,0,'2017-01-19 10:09:33',2,22,'17010515580001','[{\"name\":\"2121\",\"value\":[\"213\",\"213123\"]}]','[\"请问请问213213213\"]',NULL,'/esc/files/image/20170119/20170119100917_326.jpg','17010515580001',0);

/*Table structure for table `service_remark` */

DROP TABLE IF EXISTS `service_remark`;

CREATE TABLE `service_remark` (
  `SR_ID` varchar(50) NOT NULL,
  `SR_REMARK` float DEFAULT NULL,
  `SR_CREATETIME` datetime DEFAULT NULL,
  `SR_CONTENT` text,
  `SR_APPENDTIME` datetime DEFAULT NULL,
  `SR_APPENDCONTENT` text,
  `SR_RESPONSETIME` datetime DEFAULT NULL,
  `SR_RESPONSECONTENT` text,
  `SR_RESPONSEAPPENDTIME` datetime DEFAULT NULL,
  `SR_RESPONSEAPPENDCONTENT` text,
  `LOG_ID` varchar(50) DEFAULT NULL,
  `SERVICE_ID` varchar(50) DEFAULT NULL,
  `SR_COMMENT` varchar(200) DEFAULT NULL,
  `SR_ORDER` varchar(255) DEFAULT NULL,
  `SR_LEVEL` int(11) DEFAULT NULL,
  PRIMARY KEY (`SR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `service_remark` */

/*Table structure for table `service_snapshot` */

DROP TABLE IF EXISTS `service_snapshot`;

CREATE TABLE `service_snapshot` (
  `SERS_ID` varchar(50) NOT NULL,
  `SERS_INFO` text,
  `SERS_CHOOSE` varchar(50) DEFAULT NULL,
  `SERS_PRICE` text,
  `SERS_PERPRICE` text,
  `SERS_CREATETIME` datetime DEFAULT NULL,
  `SERS_COMMENT` varchar(200) DEFAULT NULL,
  `SERVICE_ID` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`SERS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `service_snapshot` */

insert  into `service_snapshot`(`SERS_ID`,`SERS_INFO`,`SERS_CHOOSE`,`SERS_PRICE`,`SERS_PERPRICE`,`SERS_CREATETIME`,`SERS_COMMENT`,`SERVICE_ID`) values ('3dbbb7911e9148cea04eca043abb2dc4','{\"logId\":\"7369f83baf9b4533bb549c28bc334c79\",\"priceSets\":[{\"logId\":\"7369f83baf9b4533bb549c28bc334c79\",\"psetCreateTime\":1484791773388,\"psetDiscountType\":1,\"psetId\":\"34a9f92f337a4435b2f49d51d8367957\",\"psetPoint\":1,\"psetPrice\":0.01,\"serviceId\":\"83b7deb6b4084946954ad4f67056e1a5\"}],\"serviceAttrinfo\":\"[{\\\"name\\\":\\\"2121\\\",\\\"value\\\":[\\\"213\\\",\\\"213123\\\"]}]\",\"serviceBiref\":\"13123123\",\"serviceContent\":\"2132132132132111111111111111111111111111111111111111111111111111111<img alt=\\\"\\\" src=\\\"/esc/files/image/20170119/20170119100905_530.jpg\\\" />\",\"serviceCreatetime\":1484791773388,\"serviceId\":\"83b7deb6b4084946954ad4f67056e1a5\",\"serviceIsdelete\":false,\"serviceKeywords\":\"[\\\"请问请问213213213\\\"]\",\"serviceMark\":0,\"serviceMeetnum\":0,\"serviceMeettime\":22,\"servicePic\":\"/esc/files/image/20170119/20170119100917_326.jpg\",\"servicePrice\":\"[{\\\"logId\\\":\\\"7369f83baf9b4533bb549c28bc334c79\\\",\\\"psetCreateTime\\\":1484791773388,\\\"psetDiscountType\\\":1,\\\"psetId\\\":\\\"34a9f92f337a4435b2f49d51d8367957\\\",\\\"psetPoint\\\":1,\\\"psetPrice\\\":1,\\\"serviceId\\\":\\\"83b7deb6b4084946954ad4f67056e1a5\\\"}]\",\"serviceRemark\":\"{total:0.0,count:0}\",\"serviceResponse\":0,\"serviceState\":1,\"serviceSteps\":[{\"logId\":\"7369f83baf9b4533bb549c28bc334c79\",\"serviceId\":\"83b7deb6b4084946954ad4f67056e1a5\",\"ssDescribe\":\"123123213\",\"ssId\":\"044ff1171b3044cc8acec3e698eeb198\",\"ssName\":\"213213\",\"ssPrice\":\"[{\\\"psetDiscountType\\\":\\\"1\\\",\\\"psetPoint\\\":\\\"1\\\",\\\"psetPrice\\\":\\\"0.01\\\"}]\",\"ssSort\":0}],\"serviceSuccessnum\":0,\"serviceTitle\":\"你好就是一个什么贵\",\"serviceType\":\"17010515580001\",\"typeTree\":\"17010515580001\"}',NULL,'[{\"logId\":\"7369f83baf9b4533bb549c28bc334c79\",\"psetCreateTime\":1484791773388,\"psetDiscountType\":1,\"psetId\":\"34a9f92f337a4435b2f49d51d8367957\",\"psetPoint\":1,\"psetPrice\":0.01,\"serviceId\":\"83b7deb6b4084946954ad4f67056e1a5\"}]','[{\"logId\":\"7369f83baf9b4533bb549c28bc334c79\",\"serviceId\":\"83b7deb6b4084946954ad4f67056e1a5\",\"ssDescribe\":\"123123213\",\"ssId\":\"044ff1171b3044cc8acec3e698eeb198\",\"ssName\":\"213213\",\"ssPrice\":\"[{\\\"psetDiscountType\\\":\\\"1\\\",\\\"psetPoint\\\":\\\"1\\\",\\\"psetPrice\\\":\\\"0.01\\\"}]\",\"ssSort\":0}]','2017-01-19 10:09:33',NULL,'83b7deb6b4084946954ad4f67056e1a5'),('48335a27e51e4b25bfa31ba7a87a1841','{\"logId\":\"e1f905ed7a504fa58d6121f8f58158b2\",\"priceSets\":[{\"logId\":\"e1f905ed7a504fa58d6121f8f58158b2\",\"psetCreateTime\":1484881293551,\"psetDiscountType\":1,\"psetId\":\"57701d88ab6344ebaa1bdb4c234d3bd3\",\"psetPoint\":1,\"psetPrice\":0.01,\"serviceId\":\"5f00e75eb5b1403fb881400a5a3c2304\"}],\"serviceAttrinfo\":\"[{\\\"name\\\":\\\"1\\\",\\\"value\\\":[\\\"1111\\\"]}]\",\"serviceBiref\":\"111111111111111111111111111\",\"serviceContent\":\"111111111111111111111111111111111\",\"serviceCreatetime\":1484881293551,\"serviceId\":\"5f00e75eb5b1403fb881400a5a3c2304\",\"serviceIsdelete\":false,\"serviceKeywords\":\"[\\\"关键词1，关键词2\\\"]\",\"serviceMark\":0,\"serviceMeetnum\":0,\"serviceMeettime\":1,\"servicePic\":\"/esc/files/image/20170120/20170120110102_729.jpg\",\"servicePrice\":\"[{\\\"logId\\\":\\\"e1f905ed7a504fa58d6121f8f58158b2\\\",\\\"psetCreateTime\\\":1484881293551,\\\"psetDiscountType\\\":1,\\\"psetId\\\":\\\"57701d88ab6344ebaa1bdb4c234d3bd3\\\",\\\"psetPoint\\\":1,\\\"psetPrice\\\":0.01,\\\"serviceId\\\":\\\"5f00e75eb5b1403fb881400a5a3c2304\\\"}]\",\"serviceRemark\":\"{total:0.0,count:0}\",\"serviceResponse\":0,\"serviceState\":1,\"serviceSteps\":[{\"logId\":\"e1f905ed7a504fa58d6121f8f58158b2\",\"serviceId\":\"5f00e75eb5b1403fb881400a5a3c2304\",\"ssDescribe\":\"1111111111\",\"ssId\":\"156ceba98d514af6a676a2fc3739d002\",\"ssName\":\"111111\",\"ssPrice\":\"[{\\\"psetDiscountType\\\":\\\"1\\\",\\\"psetPoint\\\":\\\"1\\\",\\\"psetPrice\\\":\\\"0.01\\\"}]\",\"ssSort\":0}],\"serviceSuccessnum\":0,\"serviceTitle\":\"111111111111111111111111\",\"serviceType\":\"17010516000005\",\"typeTree\":\"17010516000005\"}',NULL,'[{\"logId\":\"e1f905ed7a504fa58d6121f8f58158b2\",\"psetCreateTime\":1484881293551,\"psetDiscountType\":1,\"psetId\":\"57701d88ab6344ebaa1bdb4c234d3bd3\",\"psetPoint\":1,\"psetPrice\":0.01,\"serviceId\":\"5f00e75eb5b1403fb881400a5a3c2304\"}]','[{\"logId\":\"e1f905ed7a504fa58d6121f8f58158b2\",\"serviceId\":\"5f00e75eb5b1403fb881400a5a3c2304\",\"ssDescribe\":\"1111111111\",\"ssId\":\"156ceba98d514af6a676a2fc3739d002\",\"ssName\":\"111111\",\"ssPrice\":\"[{\\\"psetDiscountType\\\":\\\"1\\\",\\\"psetPoint\\\":\\\"1\\\",\\\"psetPrice\\\":\\\"0.01\\\"}]\",\"ssSort\":0}]','2017-01-20 11:01:33',NULL,'5f00e75eb5b1403fb881400a5a3c2304'),('7a2ee4e3495540488405886144b1949d','{\"logId\":\"e1f905ed7a504fa58d6121f8f58158b2\",\"priceSets\":[{\"logId\":\"e1f905ed7a504fa58d6121f8f58158b2\",\"psetCreateTime\":1484891441434,\"psetDiscountType\":1,\"psetId\":\"3478d8e359d6430f982f99392623f134\",\"psetPoint\":0.01,\"psetPrice\":0.01,\"serviceId\":\"5d5f54e871984c738a02d2b5cf72fe96\"}],\"serviceAttrinfo\":\"[{\\\"name\\\":\\\"地方\\\",\\\"value\\\":[]}]\",\"serviceBiref\":\"撒旦法撒旦浮点数\",\"serviceContent\":\"发送发送地方\",\"serviceCreatetime\":1484891441434,\"serviceId\":\"5d5f54e871984c738a02d2b5cf72fe96\",\"serviceIsdelete\":false,\"serviceKeywords\":\"[\\\"撒旦法撒旦浮点数\\\"]\",\"serviceMark\":0,\"serviceMeetnum\":0,\"serviceMeettime\":2,\"servicePic\":\"/esc/files/image/20170120/20170120135016_170.png\",\"servicePrice\":\"[{\\\"logId\\\":\\\"e1f905ed7a504fa58d6121f8f58158b2\\\",\\\"psetCreateTime\\\":1484891441434,\\\"psetDiscountType\\\":1,\\\"psetId\\\":\\\"3478d8e359d6430f982f99392623f134\\\",\\\"psetPoint\\\":0.01,\\\"psetPrice\\\":0.01,\\\"serviceId\\\":\\\"5d5f54e871984c738a02d2b5cf72fe96\\\"}]\",\"serviceRemark\":\"{total:0.0,count:0}\",\"serviceResponse\":0,\"serviceState\":1,\"serviceSteps\":[{\"logId\":\"e1f905ed7a504fa58d6121f8f58158b2\",\"serviceId\":\"5d5f54e871984c738a02d2b5cf72fe96\",\"ssDescribe\":\"0.01\",\"ssId\":\"3bf172f0d29c45cb95378a98d08f2eae\",\"ssName\":\"撒旦法\",\"ssPrice\":\"[{\\\"psetDiscountType\\\":\\\"1\\\",\\\"psetPoint\\\":\\\"0.01\\\",\\\"psetPrice\\\":\\\"0.01\\\"}]\",\"ssSort\":0}],\"serviceSuccessnum\":0,\"serviceTitle\":\"我是一个服务\",\"serviceType\":\"17010515520002\",\"typeTree\":\"17010515520002\"}',NULL,'[{\"logId\":\"e1f905ed7a504fa58d6121f8f58158b2\",\"psetCreateTime\":1484891441434,\"psetDiscountType\":1,\"psetId\":\"3478d8e359d6430f982f99392623f134\",\"psetPoint\":0.01,\"psetPrice\":0.01,\"serviceId\":\"5d5f54e871984c738a02d2b5cf72fe96\"}]','[{\"logId\":\"e1f905ed7a504fa58d6121f8f58158b2\",\"serviceId\":\"5d5f54e871984c738a02d2b5cf72fe96\",\"ssDescribe\":\"0.01\",\"ssId\":\"3bf172f0d29c45cb95378a98d08f2eae\",\"ssName\":\"撒旦法\",\"ssPrice\":\"[{\\\"psetDiscountType\\\":\\\"1\\\",\\\"psetPoint\\\":\\\"0.01\\\",\\\"psetPrice\\\":\\\"0.01\\\"}]\",\"ssSort\":0}]','2017-01-20 13:50:41',NULL,'5d5f54e871984c738a02d2b5cf72fe96'),('a3b657d402204edaad028abefcf80213','{\"logId\":\"0ce531feeb654826b06dff5a9c489a9e\",\"priceSets\":[{\"logId\":\"0ce531feeb654826b06dff5a9c489a9e\",\"psetCreateTime\":1484633486403,\"psetDiscountType\":111,\"psetId\":\"1924ccbcf3784ef28f03097fcc983952\",\"psetPoint\":10,\"psetPrice\":0.01,\"serviceId\":\"7cb75dceb53547c28ecbb414b9aef139\"}],\"serviceAttrinfo\":\"[{\\\"name\\\":\\\"游戏\\\",\\\"value\\\":[\\\"哈哈\\\"]}]\",\"serviceBiref\":\"气温气温\",\"serviceContent\":\"qweqw\",\"serviceCreatetime\":1484633486403,\"serviceId\":\"7cb75dceb53547c28ecbb414b9aef139\",\"serviceIsdelete\":false,\"serviceKeywords\":\"[\\\"hehe\\\",\\\"haha\\\",\\\"xixi\\\"]\",\"serviceMark\":0,\"serviceMeetnum\":0,\"serviceMeettime\":2,\"servicePic\":\"/esc/files/image/20170117/20170117141059_296.jpg\",\"servicePrice\":\"[{\\\"logId\\\":\\\"0ce531feeb654826b06dff5a9c489a9e\\\",\\\"psetCreateTime\\\":1484633486403,\\\"psetDiscountType\\\":111,\\\"psetId\\\":\\\"1924ccbcf3784ef28f03097fcc983952\\\",\\\"psetPoint\\\":10,\\\"psetPrice\\\":0.01,\\\"serviceId\\\":\\\"7cb75dceb53547c28ecbb414b9aef139\\\"}]\",\"serviceRemark\":\"\",\"serviceResponse\":0,\"serviceState\":1,\"serviceSteps\":[{\"logId\":\"0ce531feeb654826b06dff5a9c489a9e\",\"serviceId\":\"7cb75dceb53547c28ecbb414b9aef139\",\"ssDescribe\":\"123123\",\"ssId\":\"b0df748782ac4d3cbe87544ecfaea614\",\"ssName\":\"11\",\"ssPrice\":\"[{\\\"psetDiscountType\\\":\\\"111\\\",\\\"psetPoint\\\":\\\"10\\\",\\\"psetPrice\\\":\\\"100\\\"}]\",\"ssSort\":0}],\"serviceSuccessnum\":0,\"serviceTitle\":\"heheheheehe\",\"serviceType\":\"17010516000005\",\"typeTree\":\"17010516000005\"}',NULL,'[{\"logId\":\"0ce531feeb654826b06dff5a9c489a9e\",\"psetCreateTime\":1484633486403,\"psetDiscountType\":111,\"psetId\":\"1924ccbcf3784ef28f03097fcc983952\",\"psetPoint\":10,\"psetPrice\":0.01,\"serviceId\":\"7cb75dceb53547c28ecbb414b9aef139\"}]','[{\"logId\":\"0ce531feeb654826b06dff5a9c489a9e\",\"serviceId\":\"7cb75dceb53547c28ecbb414b9aef139\",\"ssDescribe\":\"123123\",\"ssId\":\"b0df748782ac4d3cbe87544ecfaea614\",\"ssName\":\"11\",\"ssPrice\":\"[{\\\"psetDiscountType\\\":\\\"111\\\",\\\"psetPoint\\\":\\\"10\\\",\\\"psetPrice\\\":\\\"0.01\\\"}]\",\"ssSort\":0}]','2017-01-17 14:11:26',NULL,'7cb75dceb53547c28ecbb414b9aef139'),('d38ccb98149546649df34f531266ba44','{\"logId\":\"e1f905ed7a504fa58d6121f8f58158b2\",\"priceSets\":[{\"logId\":\"e1f905ed7a504fa58d6121f8f58158b2\",\"psetCreateTime\":1484619976777,\"psetDiscountType\":1,\"psetId\":\"131ee518e31c4e91b4bc512cef5113b2\",\"psetPoint\":1,\"psetPrice\":1,\"serviceId\":\"50d53d03d3f248cc86c1c47a9edcdc91\"}],\"serviceAttrinfo\":\"[{\\\"name\\\":\\\"是\\\",\\\"value\\\":[]}]\",\"serviceBiref\":\"似懂非懂是...\",\"serviceContent\":\"撒旦法\",\"serviceCreatetime\":1484619976777,\"serviceId\":\"50d53d03d3f248cc86c1c47a9edcdc91\",\"serviceIsdelete\":false,\"serviceKeywords\":\"[\\\"sdfsdf\\\"]\",\"serviceMark\":0,\"serviceMeetnum\":0,\"serviceMeettime\":2,\"servicePic\":\"/esc/files/image/20170117/20170117102557_601.jpg\",\"servicePrice\":\"[{\\\"logId\\\":\\\"e1f905ed7a504fa58d6121f8f58158b2\\\",\\\"psetCreateTime\\\":1484619976777,\\\"psetDiscountType\\\":1,\\\"psetId\\\":\\\"131ee518e31c4e91b4bc512cef5113b2\\\",\\\"psetPoint\\\":1,\\\"psetPrice\\\":0.01,\\\"serviceId\\\":\\\"50d53d03d3f248cc86c1c47a9edcdc91\\\"}]\",\"serviceRemark\":\"\",\"serviceResponse\":0,\"serviceState\":1,\"serviceSteps\":[{\"logId\":\"e1f905ed7a504fa58d6121f8f58158b2\",\"serviceId\":\"50d53d03d3f248cc86c1c47a9edcdc91\",\"ssDescribe\":\"地方\",\"ssId\":\"9c1d5d098b4440038df7f4584ed30426\",\"ssName\":\"是\",\"ssPrice\":\"[{\\\"psetDiscountType\\\":\\\"1\\\",\\\"psetPoint\\\":\\\"1\\\",\\\"psetPrice\\\":\\\"0.01\\\"}]\",\"ssSort\":0}],\"serviceSuccessnum\":0,\"serviceTitle\":\"卖服务的服务商\",\"serviceType\":\"17010515520001\",\"typeTree\":\"17010515520001\"}',NULL,'[{\"logId\":\"e1f905ed7a504fa58d6121f8f58158b2\",\"psetCreateTime\":1484619976777,\"psetDiscountType\":1,\"psetId\":\"131ee518e31c4e91b4bc512cef5113b2\",\"psetPoint\":1,\"psetPrice\":0.01,\"serviceId\":\"50d53d03d3f248cc86c1c47a9edcdc91\"}]','{\r\n    \"logId\": \"7369f83baf9b4533bb549c28bc334c79\",\r\n    \"priceSets\": [\r\n        {\r\n            \"logId\": \"7369f83baf9b4533bb549c28bc334c79\",\r\n            \"psetCreateTime\": 1484791773388,\r\n            \"psetDiscountType\": 1,\r\n            \"psetId\": \"34a9f92f337a4435b2f49d51d8367957\",\r\n            \"psetPoint\": 1,\r\n            \"psetPrice\": 0.01,\r\n            \"serviceId\": \"83b7deb6b4084946954ad4f67056e1a5\"\r\n        }\r\n    ],\r\n    \"serviceAttrinfo\": \"[{\\\"name\\\":\\\"2121\\\",\\\"value\\\":[\\\"213\\\",\\\"213123\\\"]}]\",\r\n    \"serviceBiref\": \"13123123\",\r\n    \"serviceContent\": \"2132132132132111111111111111111111111111111111111111111111111111111<img alt=\\\"\\\" src=\\\"/esc/files/image/20170119/20170119100905_530.jpg\\\" />\",\r\n    \"serviceCreatetime\": 1484791773388,\r\n    \"serviceId\": \"83b7deb6b4084946954ad4f67056e1a5\",\r\n    \"serviceIsdelete\": false,\r\n    \"serviceKeywords\": \"[\\\"请问请问213213213\\\"]\",\r\n    \"serviceMark\": 0,\r\n    \"serviceMeetnum\": 0,\r\n    \"serviceMeettime\": 22,\r\n    \"servicePic\": \"/esc/files/image/20170119/20170119100917_326.jpg\",\r\n    \"servicePrice\": \"[{\\\"logId\\\":\\\"7369f83baf9b4533bb549c28bc334c79\\\",\\\"psetCreateTime\\\":1484791773388,\\\"psetDiscountType\\\":1,\\\"psetId\\\":\\\"34a9f92f337a4435b2f49d51d8367957\\\",\\\"psetPoint\\\":1,\\\"psetPrice\\\":0.01,\\\"serviceId\\\":\\\"83b7deb6b4084946954ad4f67056e1a5\\\"}]\",\r\n    \"serviceRemark\": \"{total:0.0,count:0}\",\r\n    \"serviceResponse\": 0,\r\n    \"serviceState\": 1,\r\n    \"serviceSteps\": [\r\n        {\r\n            \"logId\": \"7369f83baf9b4533bb549c28bc334c79\",\r\n            \"serviceId\": \"83b7deb6b4084946954ad4f67056e1a5\",\r\n            \"ssDescribe\": \"123123213\",\r\n            \"ssId\": \"044ff1171b3044cc8acec3e698eeb198\",\r\n            \"ssName\": \"213213\",\r\n            \"ssPrice\": \"[{\\\"psetDiscountType\\\":\\\"1\\\",\\\"psetPoint\\\":\\\"1\\\",\\\"psetPrice\\\":\\\"0.01\\\"}]\",\r\n            \"ssSort\": 0\r\n        }\r\n    ],\r\n    \"serviceSuccessnum\": 0,\r\n    \"serviceTitle\": \"你好就是一个什么贵\",\r\n    \"serviceType\": \"17010515580001\",\r\n    \"typeTree\": \"17010515580001\"\r\n}','2017-01-17 10:26:16',NULL,'50d53d03d3f248cc86c1c47a9edcdc91'),('e65ca235e7634a439e491c2ff1f64fa2','{\"logId\":\"7369f83baf9b4533bb549c28bc334c79\",\"priceSets\":[{\"logId\":\"7369f83baf9b4533bb549c28bc334c79\",\"psetCreateTime\":1484891594795,\"psetDiscountType\":1,\"psetId\":\"1d8eae43e3f9430c83a7e457674c1a5a\",\"psetPoint\":1,\"psetPrice\":1,\"serviceId\":\"45fd19c73d8f461384c11814c4c2eabb\"}],\"serviceAttrinfo\":\"[{\\\"name\\\":\\\"1\\\",\\\"value\\\":[]}]\",\"serviceBiref\":\"213213213\",\"serviceContent\":\"213213213213213213123\",\"serviceCreatetime\":1484891594795,\"serviceId\":\"45fd19c73d8f461384c11814c4c2eabb\",\"serviceIsdelete\":false,\"serviceKeywords\":\"[\\\"213213\\\"]\",\"serviceMark\":0,\"serviceMeetnum\":0,\"serviceMeettime\":121,\"servicePic\":\"/esc/files/image/20170120/20170120135306_41.jpg\",\"servicePrice\":\"[{\\\"logId\\\":\\\"7369f83baf9b4533bb549c28bc334c79\\\",\\\"psetCreateTime\\\":1484891594795,\\\"psetDiscountType\\\":1,\\\"psetId\\\":\\\"1d8eae43e3f9430c83a7e457674c1a5a\\\",\\\"psetPoint\\\":1,\\\"psetPrice\\\":1,\\\"serviceId\\\":\\\"45fd19c73d8f461384c11814c4c2eabb\\\"}]\",\"serviceRemark\":\"{total:0.0,count:0}\",\"serviceResponse\":0,\"serviceState\":1,\"serviceSteps\":[{\"logId\":\"7369f83baf9b4533bb549c28bc334c79\",\"serviceId\":\"45fd19c73d8f461384c11814c4c2eabb\",\"ssDescribe\":\"1\",\"ssId\":\"779c1e7ef82c4fd69ee82ed77e78de14\",\"ssName\":\"1\",\"ssPrice\":\"[{\\\"psetDiscountType\\\":\\\"1\\\",\\\"psetPoint\\\":\\\"1\\\",\\\"psetPrice\\\":\\\"1\\\"}]\",\"ssSort\":0}],\"serviceSuccessnum\":0,\"serviceTitle\":\"21321213123\",\"serviceType\":\"17010515570001\",\"typeTree\":\"17010515570001\"}',NULL,'[{\"logId\":\"7369f83baf9b4533bb549c28bc334c79\",\"psetCreateTime\":1484891594795,\"psetDiscountType\":1,\"psetId\":\"1d8eae43e3f9430c83a7e457674c1a5a\",\"psetPoint\":1,\"psetPrice\":1,\"serviceId\":\"45fd19c73d8f461384c11814c4c2eabb\"}]','[{\"logId\":\"7369f83baf9b4533bb549c28bc334c79\",\"serviceId\":\"45fd19c73d8f461384c11814c4c2eabb\",\"ssDescribe\":\"1\",\"ssId\":\"779c1e7ef82c4fd69ee82ed77e78de14\",\"ssName\":\"1\",\"ssPrice\":\"[{\\\"psetDiscountType\\\":\\\"1\\\",\\\"psetPoint\\\":\\\"1\\\",\\\"psetPrice\\\":\\\"1\\\"}]\",\"ssSort\":0}]','2017-01-20 13:53:14',NULL,'45fd19c73d8f461384c11814c4c2eabb');

/*Table structure for table `service_step` */

DROP TABLE IF EXISTS `service_step`;

CREATE TABLE `service_step` (
  `SS_ID` varchar(50) NOT NULL,
  `SS_NAME` varchar(30) DEFAULT NULL,
  `SS_DESCRIBE` varchar(200) DEFAULT NULL,
  `SS_PRICE` varchar(200) DEFAULT NULL,
  `SERVICE_ID` varchar(50) DEFAULT NULL,
  `SS_SORT` int(11) DEFAULT NULL,
  `LOG_ID` varchar(50) DEFAULT NULL,
  `SS_COMMENT` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`SS_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `service_step` */

insert  into `service_step`(`SS_ID`,`SS_NAME`,`SS_DESCRIBE`,`SS_PRICE`,`SERVICE_ID`,`SS_SORT`,`LOG_ID`,`SS_COMMENT`) values ('044ff1171b3044cc8acec3e698eeb198','213213','123123213','[{\"psetDiscountType\":\"1\",\"psetPoint\":\"1\",\"psetPrice\":\"0.01\"}]','83b7deb6b4084946954ad4f67056e1a5',0,'7369f83baf9b4533bb549c28bc334c79',NULL),('156ceba98d514af6a676a2fc3739d002','111111','1111111111','[{\"psetDiscountType\":\"1\",\"psetPoint\":\"1\",\"psetPrice\":\"0.01\"}]','5f00e75eb5b1403fb881400a5a3c2304',0,'e1f905ed7a504fa58d6121f8f58158b2',NULL),('3bf172f0d29c45cb95378a98d08f2eae','撒旦法','0.01','[{\"psetDiscountType\":\"1\",\"psetPoint\":\"0.01\",\"psetPrice\":\"0.01\"}]','5d5f54e871984c738a02d2b5cf72fe96',0,'e1f905ed7a504fa58d6121f8f58158b2',NULL),('779c1e7ef82c4fd69ee82ed77e78de14','1','1','[{\"psetDiscountType\":\"1\",\"psetPoint\":\"1\",\"psetPrice\":\"1\"}]','45fd19c73d8f461384c11814c4c2eabb',0,'7369f83baf9b4533bb549c28bc334c79',NULL),('9c1d5d098b4440038df7f4584ed30426','是','地方','[{\"psetDiscountType\":\"1\",\"psetPoint\":\"1\",\"psetPrice\":\"0.01\"}]','50d53d03d3f248cc86c1c47a9edcdc91',0,'e1f905ed7a504fa58d6121f8f58158b2',NULL),('b0df748782ac4d3cbe87544ecfaea614','11','123123','[{\"psetDiscountType\":\"111\",\"psetPoint\":\"10\",\"psetPrice\":\"0.01\"}]','7cb75dceb53547c28ecbb414b9aef139',0,'0ce531feeb654826b06dff5a9c489a9e',NULL);

/*Table structure for table `switch_info` */

DROP TABLE IF EXISTS `switch_info`;

CREATE TABLE `switch_info` (
  `SWITCH_ID` varchar(50) NOT NULL,
  `SWITCH_NAME` varchar(50) DEFAULT NULL,
  `SWITCH_POS` int(11) DEFAULT NULL,
  `SWITCH_IMG` varchar(500) DEFAULT NULL,
  `SWITCH_CREATETIME` datetime DEFAULT NULL,
  `ADMIN_ID` varchar(50) DEFAULT NULL,
  `SWITCH_COMMENT` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`SWITCH_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `switch_info` */

insert  into `switch_info`(`SWITCH_ID`,`SWITCH_NAME`,`SWITCH_POS`,`SWITCH_IMG`,`SWITCH_CREATETIME`,`ADMIN_ID`,`SWITCH_COMMENT`) values ('ef2803120a714e92ba8616dde6e4bd12','首页轮播',1,'[{\"pictureName\":\"20170116093314_781.jpg\",\"switchUrl\":\"http://www.baidu.com\",\"url\":\"/escadmin/files/image/20170116/20170116093314_781.jpg\"},{\"pictureName\":\"20170116093314_343.jpg\",\"switchUrl\":\"http://www.baidu.com\",\"url\":\"/escadmin/files/image/20170116/20170116093314_343.jpg\"},{\"pictureName\":\"20170116093314_0.jpg\",\"switchUrl\":\"http://www.baidu.com\",\"url\":\"/escadmin/files/image/20170116/20170116093314_0.jpg\"}]','2017-01-16 09:33:37','7',NULL);

/*Table structure for table `sys_admin_role` */

DROP TABLE IF EXISTS `sys_admin_role`;

CREATE TABLE `sys_admin_role` (
  `ADMIN_ROLE_ID` varchar(50) NOT NULL,
  `ADMIN_ROLE_NAME` varchar(100) DEFAULT NULL,
  `ADMIN_ROLE_STATUS` int(11) DEFAULT NULL,
  `ADMIN_ROLE_REMARK` varchar(100) DEFAULT NULL,
  `ADMIN_ROLE_MANAGE` bit(1) DEFAULT NULL,
  PRIMARY KEY (`ADMIN_ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_admin_role` */

insert  into `sys_admin_role`(`ADMIN_ROLE_ID`,`ADMIN_ROLE_NAME`,`ADMIN_ROLE_STATUS`,`ADMIN_ROLE_REMARK`,`ADMIN_ROLE_MANAGE`) values ('19ce2dfbb7be42e58ede7b1f74fd3803','ssr1',1,'ssr','\0');

/*Table structure for table `sys_authority` */

DROP TABLE IF EXISTS `sys_authority`;

CREATE TABLE `sys_authority` (
  `AUTHORITY_ID` int(11) NOT NULL AUTO_INCREMENT,
  `AUTHORITY_NAME` varchar(100) DEFAULT NULL,
  `AUTHORITY_PARENT` int(11) DEFAULT NULL,
  `AUTHORITY_ISLEAF` tinyint(1) DEFAULT NULL,
  `AUTHORITY_REMARK` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`AUTHORITY_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8;

/*Data for the table `sys_authority` */

insert  into `sys_authority`(`AUTHORITY_ID`,`AUTHORITY_NAME`,`AUTHORITY_PARENT`,`AUTHORITY_ISLEAF`,`AUTHORITY_REMARK`) values (1,'系统管理',0,0,NULL),(4,'商城管理',0,0,''),(5,'用户管理',1,0,'用户管理'),(9,'会员管理',4,0,'会员管理'),(10,'查询',9,1,'查询'),(11,'查询',5,1,'查询'),(12,'审核管理',0,0,'审核管理'),(14,'服务信息管理',12,0,'服务信息管理'),(15,'查询',14,1,'查询'),(16,'审核',14,1,'审核'),(17,'新增',5,1,'新增'),(18,'删除',5,1,'删除'),(19,'修改',5,1,'修改'),(20,'配置角色',5,1,'配置角色'),(21,'广告管理',4,0,'广告管理'),(22,'新增',21,1,'新增'),(23,'查询',21,1,'查询'),(24,'删除',21,1,'删除'),(25,'修改',21,1,'修改'),(26,'轮播管理',4,0,'轮播管理'),(27,'查询',26,1,'查询'),(28,'新增',26,1,'新增'),(29,'删除',26,1,'删除'),(30,'修改',26,1,'修改'),(31,'角色管理',1,0,'角色管理'),(32,'查询',31,1,'查询'),(33,'新增',31,1,'新增'),(34,'删除',31,1,'删除'),(35,'修改',31,1,'修改'),(36,'配置权限',31,1,'配置权限'),(37,'冻结解冻',31,1,'冻结解冻'),(38,'权限管理',1,0,'权限管理'),(39,'查询',38,1,'查询'),(40,'新增',38,1,'新增'),(41,'删除',38,1,'删除'),(42,'修改',38,1,'修改'),(43,'配置资源',38,1,'配置资源'),(44,'资源管理',1,0,'资源管理'),(45,'查询',44,1,'查询'),(46,'新增',44,1,'新增'),(47,'删除',44,1,'删除'),(48,'修改',44,1,'修改'),(49,'日志管理',1,0,'日志管理'),(50,'查询',49,1,'查询'),(51,'删除恢复',9,1,'删除恢复'),(52,'冻结解冻',9,1,'冻结解冻'),(53,'订单管理',4,0,'订单管理'),(54,'查询',53,1,'查询'),(55,'修改',53,1,'修改'),(56,'设置分类',4,0,'设置分类'),(57,'查询',56,1,'查询'),(58,'新增',56,1,'新增'),(59,'删除',56,1,'删除'),(60,'修改',56,1,'修改'),(61,'保存勾选',56,1,''),(62,'保存基本分类',56,1,'保存基本分类'),(63,'消息管理',4,0,'消息管理'),(64,'删除',63,1,'删除'),(65,'发送平台消息',63,1,'发送平台消息'),(66,'冻结解冻',14,1,'冻结解冻'),(67,'实名认证管理',12,0,'实名认证管理'),(68,'查询',67,1,'查询'),(69,'审核',67,1,'审核'),(70,'申请推荐管理',12,0,'申请推荐管理'),(71,'查询',70,1,'查询'),(72,'审核',70,1,'审核'),(73,'排序',70,1,'排序'),(74,'服务商管理',12,0,'服务商管理'),(75,'查询',74,1,'查询'),(76,'删除恢复',74,1,'删除恢复'),(77,'冻结解冻',74,1,'冻结解冻'),(78,'审核',74,1,'审核'),(79,'推荐',74,1,'推荐'),(80,'发票管理',12,0,'发票管理'),(81,'查询',80,1,'查询'),(82,'审核',80,1,'审核'),(83,'报表管理',0,0,'报表管理'),(84,'接口管理',0,0,'接口管理'),(88,'退款管理',12,0,'退款管理'),(89,'查询',88,1,'查询'),(90,'审核',88,1,'审核'),(91,'发送短信消息',63,1,'发送短信消息'),(92,'查询',63,1,'查询'),(93,'通用信息管理',4,0,'通用信息管理'),(94,'查询',93,1,'查询'),(95,'删除信息',93,1,'删除信息'),(96,'修改信息',93,1,'修改信息'),(97,'添加通用信息',93,1,'添加通用信息');

/*Table structure for table `sys_authority_to_resource` */

DROP TABLE IF EXISTS `sys_authority_to_resource`;

CREATE TABLE `sys_authority_to_resource` (
  `ATR_AUTHORITY` int(11) NOT NULL,
  `ATR_RESOURCE` int(11) NOT NULL,
  PRIMARY KEY (`ATR_AUTHORITY`,`ATR_RESOURCE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_authority_to_resource` */

insert  into `sys_authority_to_resource`(`ATR_AUTHORITY`,`ATR_RESOURCE`) values (10,57),(10,58),(10,61),(10,63),(11,10),(11,12),(15,86),(15,87),(15,88),(16,89),(17,15),(18,16),(19,17),(20,18),(20,19),(22,22),(23,20),(23,21),(24,23),(25,24),(27,8),(27,9),(28,11),(29,14),(30,13),(32,38),(32,39),(33,40),(34,42),(35,41),(36,75),(36,76),(37,56),(39,44),(39,45),(40,46),(41,48),(42,47),(43,49),(43,50),(45,51),(45,52),(46,53),(47,55),(48,54),(50,36),(50,37),(51,34),(52,35),(54,64),(54,65),(54,66),(54,67),(54,69),(55,68),(57,77),(57,78),(57,82),(58,79),(59,81),(60,80),(61,83),(62,84),(62,85),(64,99),(65,101),(66,90),(68,59),(68,60),(69,62),(71,70),(71,71),(72,74),(73,72),(73,73),(75,30),(75,31),(76,34),(77,35),(78,32),(79,33),(81,25),(81,26),(82,27),(89,95),(89,97),(90,98),(91,102),(92,94),(92,96),(92,100),(94,104),(95,107),(96,106),(97,105);

/*Table structure for table `sys_company_role` */

DROP TABLE IF EXISTS `sys_company_role`;

CREATE TABLE `sys_company_role` (
  `COMPANY_ROLE_ID` varchar(50) NOT NULL,
  `COMPANY_ROLE_NAME` varchar(100) DEFAULT NULL,
  `COMPANY_ROLE_STATUS` int(11) DEFAULT NULL,
  `COMPANY_ROLE_REMARK` varchar(100) DEFAULT NULL,
  `COMPANY_ROLE_COMPANYID` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`COMPANY_ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_company_role` */

/*Table structure for table `sys_operation_log` */

DROP TABLE IF EXISTS `sys_operation_log`;

CREATE TABLE `sys_operation_log` (
  `SYS_OPLOG_ID` varchar(50) NOT NULL,
  `SYS_OPLOG_USER_NAME` varchar(50) DEFAULT NULL,
  `SYS_OPLOG_DATE` datetime DEFAULT NULL,
  `SYS_OPLOG_CONT` varchar(200) DEFAULT NULL,
  `SYS_OPLOG_ISDELETE` bit(1) DEFAULT NULL,
  PRIMARY KEY (`SYS_OPLOG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_operation_log` */

/*Table structure for table `sys_platform_para` */

DROP TABLE IF EXISTS `sys_platform_para`;

CREATE TABLE `sys_platform_para` (
  `SYS_PARA_ID` varchar(50) NOT NULL,
  `SYS_PARA_NAME` varchar(50) DEFAULT NULL,
  `SYS_PARA_SPECIFIC` float DEFAULT NULL,
  `SYS_PARA_REMARK` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`SYS_PARA_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_platform_para` */

/*Table structure for table `sys_resource` */

DROP TABLE IF EXISTS `sys_resource`;

CREATE TABLE `sys_resource` (
  `RESOURCE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `RESOURCE_NAME` varchar(100) DEFAULT NULL,
  `RESOURCE_URL` varchar(200) DEFAULT NULL,
  `RESOURCE_OPERATION` varchar(50) DEFAULT NULL,
  `RESOURCE_REMARK` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`RESOURCE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=108 DEFAULT CHARSET=utf8;

/*Data for the table `sys_resource` */

insert  into `sys_resource`(`RESOURCE_ID`,`RESOURCE_NAME`,`RESOURCE_URL`,`RESOURCE_OPERATION`,`RESOURCE_REMARK`) values (8,'pubinfo_switchInfo_jump','/pubinfo/switchInfo/jump.html',NULL,'轮播管理跳转页面'),(9,'pubinfo_switchInfo_list','/pubinfo/switchInfo/list.html',NULL,'轮播管理查询'),(10,'userinfo_adminInfo_queryAdmin','/userinfo/adminInfo/queryAdmin.html',NULL,'用户管理跳转页面'),(11,'pubinfo_switchInfo_add','/pubinfo/switchInfo/add.html',NULL,'轮播管理添加'),(12,'userinfo_adminInfo_queryAdminByCon','/userinfo/adminInfo/queryAdminByCon.html',NULL,'用户管理查询'),(13,'pubinfo_switchInfo_modify','/pubinfo/switchInfo/modify.html',NULL,'轮播管理修改'),(14,'pubinfo_switchInfo_delete','/pubinfo/switchInfo/delete.html',NULL,'轮播管理删除'),(15,'userinfo_adminInfo_addAdmin','/userinfo/adminInfo/addAdmin.html',NULL,'用户管理新增'),(16,'userinfo_adminInfo_removeAdminById','/userinfo/adminInfo/removeAdminById.html',NULL,'用户管理删除'),(17,'userinfo_adminInfo_modifyAdmin','/userinfo/adminInfo/modifyAdmin.html',NULL,'用户管理修改'),(18,'system_sysAdminRole_queryRoleByAdminId','/system/sysAdminRole/queryRoleByAdminId.html',NULL,'用户管理配置角色'),(19,'system_sysAdminRole_configAdminToRole','/system/sysAdminRole/configAdminToRole.html',NULL,'用户管理配置角色'),(20,'pubinfo_advertisePosition_turnTo','/pubinfo/advertisePosition/turnTo.html',NULL,'跳转广告管理'),(21,'pubinfo_advertisePosition_advertisePositionList','/pubinfo/advertisePosition/advertisePositionList.html',NULL,'广告管理查询'),(22,'pubinfo_advertisePosition_addAdvertisePosition','/pubinfo/advertisePosition/addAdvertisePosition.html',NULL,'广告管理新增'),(23,'pubinfo_advertisePosition_deleteAdvertisePosition','/pubinfo/advertisePosition/deleteAdvertisePosition.html',NULL,'广告管理删除'),(24,'pubinfo_advertisePosition_updateAdvertisePosition','/pubinfo/advertisePosition/updateAdvertisePosition.html',NULL,'广告管理修改'),(25,'saleinfo_invoice_showList','/saleinfo/invoice/showList.html',NULL,'发票管理跳转页面'),(26,'saleinfo_invoice_selectAll','/saleinfo/invoice/selectAll.html',NULL,'发票管理查询'),(27,'saleinfo_invoice_checkInvoiceById','/saleinfo/invoice/checkInvoiceById.html',NULL,'发票管理审核'),(28,'main_index','/main.html',NULL,'跳转主页'),(29,'main_editpassword','/editpassword.html',NULL,'用户修改密码'),(30,'userinfo_logUserinfo_queryLogUser','/userinfo/logUserinfo/queryLogUser.html',NULL,'服务商管理跳转页面'),(31,'userinfo_logUserinfo_list','/userinfo/logUserinfo/list.html',NULL,'服务商管理查询'),(32,'userinfo_logUserinfo_updateLogUserState','/userinfo/logUserinfo/updateLogUserState.html',NULL,'服务商管理审核通过/不通过'),(33,'userinfo_logUserinfo_nominate','/userinfo/logUserinfo/nominate.html',NULL,'服务商管理推荐'),(34,'userinfo_userInfo_removeUserById','/userinfo/userInfo/removeUserById.html',NULL,'服务商管理删除/恢复'),(35,'userinfo_userInfo_lockUserById','/userinfo/userInfo/lockUserById.html',NULL,'服务商冻结/解冻'),(36,'details_backgroundHandleLog_initPage','/details/backgroundHandleLog/initPage.html',NULL,'后台操作日志跳转页面'),(37,'details_backgroundHandleLog_query','/details/backgroundHandleLog/query.html',NULL,'后台操作日志查询'),(38,'system_sysAdminRole_queryRoleByCon','/system/sysAdminRole/queryRoleByCon.html',NULL,'角色管理根据条件查询角色'),(39,'system_sysAdminRole_queryRole','/system/sysAdminRole/queryRole.html',NULL,'角色管理跳转页面'),(40,'system_sysAdminRole_addRole','/system/sysAdminRole/addRole.html',NULL,'角色管理添加'),(41,'system_sysAdminRole_modifyRole','/system/sysAdminRole/modifyRole.html',NULL,'角色管理修改'),(42,'system_sysAdminRole_removeRoleById','/system/sysAdminRole/removeRoleById.html',NULL,'角色管理删除'),(43,'system_sysAdminRole_getRoleState','/system/sysAdminRole/getRoleState.html',NULL,'角色管理获取角色状态'),(44,'system_sysAuthority_sysAuthorityJump','/system/sysAuthority/sysAuthorityJump.html',NULL,'权限设置跳转页面'),(45,'system_sysAuthority_querySysAuthorityByCon','/system/sysAuthority/querySysAuthorityByCon.html',NULL,'权限设置查询'),(46,'system_sysAuthority_addSysAuthority','/system/sysAuthority/addSysAuthority.html',NULL,'权限设置新增'),(47,'system_sysAuthority_modifySysAuthority','/system/sysAuthority/modifySysAuthority.html',NULL,'权限设置修改'),(48,'system_sysAuthority_removeSysAuthority','/system/sysAuthority/removeSysAuthority.html',NULL,'权限设置删除'),(49,'system_sysResource_selectAuthorityToResourceList','/system/sysResource/selectAuthorityToResourceList.html',NULL,'权限设置配置资源'),(50,'system_sysResource_configAuthorityToResource','/system/sysResource/configAuthorityToResource.html',NULL,'权限设置配置资源'),(51,'system_sysResource_sysResourceJump','/system/sysResource/sysResourceJump.html',NULL,'资源管理跳转页面'),(52,'system_sysResource_querySysResourceList','/system/sysResource/querySysResourceList.html',NULL,'资源管理查询'),(53,'system_sysResource_addSysResource','/system/sysResource/addSysResource.html',NULL,'资源管理新增'),(54,'system_sysResource_updateSysResource','/system/sysResource/updateSysResource.html',NULL,'资源管理修改'),(55,'system_sysResource_deleteSysResource','/system/sysResource/deleteSysResource.html',NULL,'资源管理删除'),(56,'system_sysAdminRole_lockRoleById','/system/sysAdminRole/lockRoleById.html',NULL,'角色管理冻结解冻'),(57,'userinfo_userInfo_queryUser','/userinfo/userInfo/queryUser.html',NULL,'会员管理跳转页面'),(58,'userinfo_userInfo_queryUserByCon','/userinfo/userInfo/queryUserByCon.html',NULL,'会员管理查询'),(59,'checkinfo_PersonCheckname_gotoCheckinfo','/checkinfo/PersonCheckname/gotoCheckinfo.html',NULL,'实名认证管理跳转'),(60,'checkinfo_PersonCheckname_showCheckinfoList','/checkinfo/PersonCheckname/showCheckinfoList.html',NULL,'实名认证管理查询'),(61,'userinfo_userInfo_getLogState','/userinfo/userInfo/getLogState.html',NULL,'会员管理账号状态'),(62,'checkinfo_PersonCheckname_nameCheckById','/checkinfo/PersonCheckname/nameCheckById.html',NULL,'实名认证管理审核'),(63,'userinfo_userInfo_getLogType','/userinfo/userInfo/getLogType.html',NULL,'会员管理账号类型'),(64,'saleinfo_orderinfo_queryOrder','/saleinfo/orderinfo/queryOrder.html',NULL,'订单管理页面跳转'),(65,'saleinfo_orderinfo_queryOrderByCon','/saleinfo/orderinfo/queryOrderByCon.html',NULL,'订单管理查询'),(66,'saleinfo_orderinfo_getOrderState','/saleinfo/orderinfo/getOrderState.html',NULL,'订单管理状态查询'),(67,'details_orderdonedetails_queryOrderDoneDetailsByCon','/details/orderdonedetails/queryOrderDoneDetailsByCon.html',NULL,'订单管理订单操作记录查询'),(68,'saleinfo_orderinfo_checkOrderById','/saleinfo/orderinfo/checkOrderById.html',NULL,'订单管理状态修改'),(69,'saleinfo_orderinfo_queryOrderServiceByOrderId','/saleinfo/orderinfo/queryOrderServiceByOrderId.html',NULL,'订单管理订单详情查询'),(70,'userinfo_providerrecommend_queryProviderRecommend','/userinfo/providerrecommend/queryProviderRecommend',NULL,'申请推荐管理页面跳转'),(71,'userinfo_providerrecommend_queryProviderRecommendByCon','/userinfo/providerrecommend/queryProviderRecommendByCon.html',NULL,'申请推荐管理查询'),(72,'userinfo_providerrecommend_queryPRSortNum','/userinfo/providerrecommend/queryPRSortNum.html',NULL,'申请推荐管理可用顺序查询'),(73,'userinfo_providerrecommend_modifyPRSortById','/userinfo/providerrecommend/modifyPRSortById.html',NULL,'申请推荐管理顺序修改'),(74,'userinfo_providerrecommend_modifyPRStateById','/userinfo/providerrecommend/modifyPRStateById.html',NULL,'申请推荐管理审核通过/不通过'),(75,'system_sysAuthority_configRoleToAuthority','/system/sysAuthority/configRoleToAuthority.html',NULL,'角色管理配置权限'),(76,'system_sysAuthority_selectRoleToAuthorityList','/system/sysAuthority/selectRoleToAuthorityList.html',NULL,'角色管理配置权限'),(77,'pubinfo_commonType_queryCommonType','/pubinfo/commonType/queryCommonType.html',NULL,'设置分类跳转页面'),(78,'pubinfo_commonType_queryServiceTypeSave','/pubinfo/commonType/queryServiceTypeSave.html',NULL,'设置分类查询'),(79,'pubinfo_commonType_add','/pubinfo/commonType/add.html',NULL,'设置分类新增'),(80,'pubinfo_commonType_modifyByPrimaryKey','/pubinfo/commonType/modifyByPrimaryKey.html',NULL,'设置分类修改'),(81,'pubinfo_commonType_removeByPrimaryKey','/pubinfo/commonType/removeByPrimaryKey.html',NULL,'设置分类删除'),(82,'pubinfo_commonType_queryServiceType','/pubinfo/commonType/queryServiceType.html',NULL,'设置分类查询'),(83,'pubinfo_commonType_setServiceType','/pubinfo/commonType/setServiceType.html',NULL,'设置分类保存勾选'),(84,'pubinfo_commonType_modify','/pubinfo/commonType/modify.html',NULL,'设置分类保存基本分类'),(85,'esc_pubinfo_commonType_updateViewType','/esc/pubinfo/commonType/updateViewType.html',NULL,'设置分类保存基本分类'),(86,'goodsinfo_serviceInfo_queryServiceInfo','/goodsinfo/serviceInfo/queryServiceInfo.html',NULL,'服务信息管理跳转页面'),(87,'goodsinfo_serviceInfo_queryServiceByCon','/goodsinfo/serviceInfo/queryServiceByCon.html',NULL,'服务信息管理查询'),(88,'goodsinfo_serviceInfo_getServiceState','/goodsinfo/serviceInfo/getServiceState.html',NULL,'服务信息管理查询状态'),(89,'goodsinfo_serviceInfo_checkServiceById','/goodsinfo/serviceInfo/checkServiceById.html',NULL,'服务信息管理审核'),(90,'goodsinfo_serviceInfo_lockServiceById','/goodsinfo/serviceInfo/lockServiceById.html',NULL,'服务信息管理冻结/解冻'),(94,'details_megdetails_queryMegDetails','/details/megdetails/queryMegDetails.html',NULL,'消息管理跳转页面'),(95,'saleinfo_refund_turnto','/saleinfo/refund/turnto.html',NULL,'退款管理跳转页面'),(96,'details_megdetails_queryMegDetailsByCon','/details/megdetails/queryMegDetailsByCon.html',NULL,'消息管理根据条件查询消息数据'),(97,'saleinfo_refund_queryrefundbycon','/saleinfo/refund/queryrefundbycon.html',NULL,'退款管理查询'),(98,'saleinfo_refund_updaterefundstate','/saleinfo/refund/updaterefundstate.html',NULL,'退款管理状态修改'),(99,'details_megdetails_removeMegDetailsById','/details/megdetails/removeMegDetailsById.html',NULL,'消息管理通过id删除消息'),(100,'details_megdetails_queryLogInfoByCon','/details/megdetails/queryLogInfoByCon.html',NULL,'消息管理查询会员列表'),(101,'details_megdetails_addSystemMegs','/details/megdetails/addSystemMegs.html',NULL,'消息管理根据会员id发送消息'),(102,'details_megdetails_sendShortMessage','/details/megdetails/sendShortMessage.html',NULL,'消息管理发送短信'),(103,'pubinfo_commonInfo_jumpCommonInfo','/pubinfo//commonInfo/jumpCommonInfo.html',NULL,'公共信息跳转'),(104,'pubinfo_commonInfo_queryAllCommonInfo','/pubinfo/commonInfo/queryAllCommonInfo.html',NULL,'通用信息查询'),(105,'pubinfo_commonInfo_addCommonInfo','/pubinfo/commonInfo/addCommonInfo.html',NULL,'通用信息添加'),(106,'pubinfo_commonInfo_modifyCommonifo','/pubinfo/commonInfo/modifyCommonifo.html',NULL,'通用信息修改'),(107,'pubinfo_commonInfo_deleteCommonifo','/pubinfo/commonInfo/deleteCommonifo.html',NULL,'通用信息删除');

/*Table structure for table `sys_role_to_authority` */

DROP TABLE IF EXISTS `sys_role_to_authority`;

CREATE TABLE `sys_role_to_authority` (
  `RTA_ROLE` varchar(50) NOT NULL,
  `RTA_AUTHORITY` int(11) NOT NULL,
  PRIMARY KEY (`RTA_ROLE`,`RTA_AUTHORITY`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_role_to_authority` */

/*Table structure for table `sys_user_to_role` */

DROP TABLE IF EXISTS `sys_user_to_role`;

CREATE TABLE `sys_user_to_role` (
  `UTR_USER` varchar(50) NOT NULL,
  `UTR_ROLE` varchar(50) NOT NULL,
  PRIMARY KEY (`UTR_ROLE`,`UTR_USER`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_user_to_role` */

/*Table structure for table `system_megs` */

DROP TABLE IF EXISTS `system_megs`;

CREATE TABLE `system_megs` (
  `SM_ID` varchar(50) NOT NULL,
  `SM_TITLE` varchar(100) DEFAULT NULL,
  `SM_CONTENT` varchar(200) DEFAULT NULL,
  `SM_CREATETIME` datetime DEFAULT NULL,
  `ADMIN_ID` varchar(50) DEFAULT NULL,
  `SM_TYPE` int(11) DEFAULT NULL,
  `SM_ISDELETE` tinyint(1) DEFAULT NULL,
  `SM_COMMENT` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`SM_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `system_megs` */

insert  into `system_megs`(`SM_ID`,`SM_TITLE`,`SM_CONTENT`,`SM_CREATETIME`,`ADMIN_ID`,`SM_TYPE`,`SM_ISDELETE`,`SM_COMMENT`) values ('1124aa6178b74287b056fd19951e136d','服务审核','恭喜您,您的服务审核通过了!','2017-01-20 11:04:01','7',2,0,NULL),('1aea34d970184b96a0b422f3f46a68bf','服务商审核','恭喜您,服务商审核通过了!','2017-01-19 11:08:47','7',2,0,NULL),('1ea01b71718f42f1babeb955bc79cb19','服务商推荐','恭喜您,服务商推荐通过了!','2017-01-17 14:13:17','7',2,0,NULL),('2968c260ea17495083d59ec77ec55776','服务审核','恭喜您,您的实名认证审核通过了!','2017-01-16 09:54:17','7',2,0,NULL),('2f4ea9733d61445c87cf48b0545535f1','服务审核','恭喜您,您的服务审核通过了!','2017-01-20 11:03:52','7',2,0,NULL),('38352c3f1acd4e67b9f4745858ace764','服务商审核','恭喜您,服务商审核通过了!','2017-01-19 11:27:36','7',2,0,NULL),('4e884b9db3b844da9bd0b18547a32da8','服务商审核','恭喜您,服务商审核通过了!','2017-01-19 11:15:09','7',2,0,NULL),('73e232e44c7f4868ae9bf06e9d62115d','服务商审核','很遗憾,服务商审核未通过!','2017-01-17 09:16:06','7',2,0,NULL),('911d73b0226840f7b96815254172a7f3','服务审核','恭喜您,您的服务审核通过了!','2017-01-20 13:53:01','7',2,0,NULL),('91917268be9647fab46e3a9db8c98220','实名认证审核','恭喜您,您的实名认证审核通过了!','2017-01-17 13:50:17','7',2,0,NULL),('93148ed754ed45d08fe5726c1f2029ce','服务审核','恭喜您,您的服务审核通过了!','2017-01-20 11:04:01','7',2,0,NULL),('b43c4b38801744719478fa9b17dfdbd8','服务商审核','恭喜您,服务商审核通过了!','2017-01-17 13:55:23','7',2,0,NULL),('b88cc981c2f4478c9b4e76b65f74716e','服务商审核','恭喜您,服务商审核通过了!','2017-01-19 11:36:52','7',2,0,NULL),('cc6988a75a5e402ebfab37680f895915','服务商审核','恭喜您,服务商审核通过了!','2017-01-17 09:16:35','7',2,0,NULL),('ccbf2847538b45b38c9882e76da51f92','服务审核','恭喜您,您的实名认证审核通过了!','2017-01-16 09:48:02','7',2,0,NULL),('ccf4acbd01124cc7a9324725c58b7933','服务商审核','恭喜您,服务商审核通过了!','2017-01-19 10:56:28','7',2,0,NULL),('d0df23c53f3b4155bd71f33c53c49577','服务审核','恭喜您,您的服务审核通过了!','2017-01-17 14:11:48','7',2,0,NULL),('d3795b703fee4e16a59e2be140f7ddcc','服务商审核','恭喜您,服务商审核通过了!','2017-01-19 11:34:08','7',2,0,NULL),('f0ac227232754afe88943c3995245d97','服务商审核','恭喜您,服务商审核通过了!','2017-01-19 11:20:06','7',2,0,NULL),('fb338ea5780546a996bc9daaa422683b','服务审核','恭喜您,您的实名认证审核通过了!','2017-01-16 09:56:09','7',2,1,NULL);

/*Table structure for table `user_action` */

DROP TABLE IF EXISTS `user_action`;

CREATE TABLE `user_action` (
  `UA_ID` varchar(50) NOT NULL,
  `UA_CONTENT` varchar(100) DEFAULT NULL,
  `UA_TYPE` int(11) DEFAULT NULL,
  `UA_CREATETIME` datetime DEFAULT NULL,
  `LOG_ID` varchar(50) DEFAULT NULL,
  `UA_COMMENT` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`UA_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_action` */

/*Table structure for table `user_info` */

DROP TABLE IF EXISTS `user_info`;

CREATE TABLE `user_info` (
  `USER_ID` varchar(50) NOT NULL,
  `LOG_ID` varchar(50) DEFAULT NULL,
  `USER_REALNAME` varchar(30) DEFAULT NULL,
  `USER_WECHAT` varchar(30) DEFAULT NULL,
  `USER_PHOTO` varchar(300) DEFAULT NULL,
  `USER_COMMENT` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_info` */

insert  into `user_info`(`USER_ID`,`LOG_ID`,`USER_REALNAME`,`USER_WECHAT`,`USER_PHOTO`,`USER_COMMENT`) values ('07b604806ede4b97b4a0b109294ca37a','0ce531feeb654826b06dff5a9c489a9e','谭江海','18581910315','/esc/images/logo.png',NULL),('090e4a6d20ed48a6a4635ba2cd635b41','e1f905ed7a504fa58d6121f8f58158b2','郑启阳','13444444444','/esc/files/image/20170120/20170120151501_944.jpg',NULL),('57cc6c96f7c44b85aca45ce4e2640bc2','258a4f9d7e3948528ad68e298cf0004b',NULL,NULL,'/esc/images/logo.png',NULL),('a9e4293f22c740bf9935c250ec64a9f9','7369f83baf9b4533bb549c28bc334c79','黄毅峰',NULL,'/esc/images/logo.png',NULL),('c3cac8ac4d474674b1d93a61a6bcfb41','4b3be9c0512649aca58da0e9b430377c','肖帆江',NULL,'/esc/images/logo.png',NULL),('f4e80537e2e74bdfbc2a6ae9e8f01dcb','b80c5b10eace4442a33dbcfedfa3aac4','龚博',NULL,'/esc/images/logo.png',NULL);

/*Table structure for table `visit_record` */

DROP TABLE IF EXISTS `visit_record`;

CREATE TABLE `visit_record` (
  `VR_ID` varchar(50) NOT NULL,
  `VR_TIME` datetime DEFAULT NULL,
  `VR_IP` varchar(30) DEFAULT NULL,
  `VR_NAME` varchar(30) DEFAULT NULL,
  `VR_BROWER` varchar(60) DEFAULT NULL,
  `VR_SOURCE` varchar(60) DEFAULT NULL,
  `VR_COMMENT` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`VR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `visit_record` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

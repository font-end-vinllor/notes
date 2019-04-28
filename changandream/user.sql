/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 5.7.17-log : Database - fontend
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`fontend` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `fontend`;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` varchar(40) NOT NULL,
  `username` varchar(10) DEFAULT NULL,
  `sex` varchar(1) DEFAULT NULL,
  `mail` varchar(20) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `word` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`sex`,`mail`,`phone`,`word`) values ('3FE78DE40F9E4F4E96535A8E50264743','as','0','','',''),('8073D3D1D51E4A00B0583D14C9B72383','半人久','0','15091379817@163.com','',''),('93452498659F4FBBB8C3AF1C5847A5AA','飞飞','0','364621561@qq.com','15091379817',''),('A0A5BD7E900A48199C7822A2E061FBE8','asdfgh','0','15091379817@163.com','','');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

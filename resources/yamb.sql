/*
SQLyog Community v13.1.2 (64 bit)
MySQL - 10.1.38-MariaDB : Database - yamb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`yamb` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `yamb`;

/*Table structure for table `igra` */

DROP TABLE IF EXISTS `igra`;

CREATE TABLE `igra` (
  `igra_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `aktivna` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`igra_id`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=latin1;

/*Data for the table `igra` */

insert  into `igra`(`igra_id`,`aktivna`) values 
(1,'NOVA'),
(2,'NOVA'),
(3,'NOVA'),
(4,'NOVA'),
(5,'NOVA'),
(6,'NOVA'),
(7,'NOVA'),
(8,'NOVA'),
(9,'NOVA'),
(10,'NOVA'),
(11,'NOVA'),
(12,'NOVA'),
(13,'NOVA'),
(14,'NOVA'),
(15,'NOVA'),
(16,'NOVA'),
(17,'NOVA'),
(18,'NOVA'),
(19,'NOVA'),
(20,'NOVA'),
(21,'NOVA'),
(22,'NOVA'),
(23,'NOVA'),
(24,'NOVA'),
(25,'NOVA'),
(26,'NOVA'),
(27,'NOVA'),
(28,'NOVA'),
(29,'NOVA'),
(30,'NOVA'),
(31,'NOVA'),
(32,'NOVA'),
(33,'NOVA'),
(34,'NOVA'),
(35,'NOVA'),
(36,'NOVA'),
(37,'NOVA'),
(38,'NOVA'),
(39,'NOVA'),
(40,'NOVA'),
(41,'NOVA'),
(42,'NOVA'),
(43,'NOVA'),
(44,'NOVA'),
(45,'NOVA'),
(46,'NOVA'),
(47,'NOVA'),
(48,'NOVA'),
(49,'NOVA'),
(50,'NOVA'),
(51,'NOVA'),
(52,'NOVA'),
(53,'NOVA'),
(54,'NOVA'),
(55,'NOVA'),
(56,'NOVA'),
(57,'NOVA'),
(58,'NOVA'),
(59,'NOVA'),
(60,'AKTIVNA'),
(61,'NOVA'),
(62,'AKTIVNA'),
(63,'NOVA'),
(64,'AKTIVNA'),
(65,'NOVA'),
(66,'AKTIVNA'),
(67,'NOVA'),
(68,'AKTIVNA'),
(69,'NOVA'),
(70,'NOVA'),
(71,'AKTIVNA'),
(72,'NOVA'),
(73,'AKTIVNA'),
(74,'NOVA'),
(75,'AKTIVNA'),
(76,'NOVA'),
(77,'AKTIVNA'),
(78,'NOVA'),
(79,'AKTIVNA'),
(80,'NOVA'),
(81,'AKTIVNA'),
(82,'NOVA'),
(83,'AKTIVNA'),
(84,'NOVA'),
(85,'AKTIVNA'),
(86,'NOVA'),
(87,'AKTIVNA'),
(88,'NOVA'),
(89,'AKTIVNA'),
(90,'NOVA'),
(91,'AKTIVNA'),
(92,'NOVA'),
(93,'AKTIVNA'),
(94,'NOVA'),
(95,'AKTIVNA'),
(96,'NOVA'),
(97,'AKTIVNA'),
(98,'NOVA'),
(99,'AKTIVNA'),
(100,'NOVA'),
(101,'AKTIVNA'),
(102,'NOVA'),
(103,'AKTIVNA'),
(104,'NOVA'),
(105,'AKTIVNA'),
(106,'NOVA'),
(107,'AKTIVNA'),
(108,'NOVA'),
(109,'AKTIVNA');

/*Table structure for table `kolona` */

DROP TABLE IF EXISTS `kolona`;

CREATE TABLE `kolona` (
  `kolona_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `naziv` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`kolona_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `kolona` */

insert  into `kolona`(`kolona_id`,`naziv`) values 
(1,'Smer dole'),
(2,'Mesoviti smer'),
(3,'Smer gore'),
(4,'Najava');

/*Table structure for table `korisnik` */

DROP TABLE IF EXISTS `korisnik`;

CREATE TABLE `korisnik` (
  `korisnik_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `korisnicko_ime` varchar(30) DEFAULT NULL,
  `sifra` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`korisnik_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `korisnik` */

insert  into `korisnik`(`korisnik_id`,`korisnicko_ime`,`sifra`) values 
(1,'Marina','marina'),
(2,'Milos','milos'),
(3,'Anja','anja');

/*Table structure for table `matrica` */

DROP TABLE IF EXISTS `matrica`;

CREATE TABLE `matrica` (
  `igra_id_fk` bigint(20) unsigned NOT NULL,
  `matrica_id` bigint(20) unsigned NOT NULL,
  `krajnji_rezultat` bigint(20) DEFAULT NULL,
  `pobeda` tinyint(1) DEFAULT NULL,
  `korisnik_id_fk` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`igra_id_fk`,`matrica_id`),
  KEY `matrica_id` (`matrica_id`),
  KEY `matrica_korisnik_fk` (`korisnik_id_fk`),
  CONSTRAINT `matrica_igra_fk` FOREIGN KEY (`igra_id_fk`) REFERENCES `igra` (`igra_id`),
  CONSTRAINT `matrica_korisnik_fk` FOREIGN KEY (`korisnik_id_fk`) REFERENCES `korisnik` (`korisnik_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `matrica` */

insert  into `matrica`(`igra_id_fk`,`matrica_id`,`krajnji_rezultat`,`pobeda`,`korisnik_id_fk`) values 
(1,0,NULL,0,1),
(2,0,NULL,0,1),
(3,0,NULL,0,1),
(4,1,NULL,0,1),
(5,1,NULL,0,1),
(6,1,NULL,0,1),
(7,1,NULL,0,1),
(8,1,NULL,0,1),
(9,1,NULL,0,1),
(10,1,NULL,0,1),
(11,1,NULL,0,1),
(12,1,NULL,0,1),
(13,1,NULL,0,1),
(14,1,NULL,0,1),
(15,1,NULL,0,1),
(16,1,NULL,0,1),
(17,1,NULL,0,1),
(18,1,NULL,0,2),
(18,2,NULL,0,1),
(19,1,NULL,0,2),
(19,2,NULL,0,1),
(20,1,NULL,0,2),
(21,1,NULL,0,2),
(22,1,NULL,0,2),
(23,1,NULL,0,1),
(24,1,NULL,0,1),
(25,1,NULL,0,1),
(26,1,NULL,0,1),
(27,1,NULL,0,1),
(28,1,NULL,0,1),
(29,1,NULL,0,1),
(30,1,NULL,0,1),
(31,1,NULL,0,1),
(32,1,NULL,0,1),
(33,1,NULL,0,1),
(34,1,NULL,0,1),
(35,1,NULL,0,1),
(36,1,NULL,0,1),
(37,1,NULL,0,1),
(38,1,NULL,0,1),
(39,1,NULL,0,1),
(40,1,NULL,0,1),
(41,1,NULL,0,1),
(42,1,NULL,0,1),
(43,1,NULL,0,1),
(44,1,NULL,0,1),
(45,1,NULL,0,1),
(46,1,0,0,1),
(47,1,0,0,1),
(48,1,0,0,1),
(49,1,0,0,1),
(50,1,0,0,1),
(51,1,0,0,1),
(52,1,0,0,1),
(53,1,0,0,1),
(54,1,0,0,1),
(55,1,0,0,1),
(56,1,0,0,1),
(57,1,0,0,1),
(58,1,0,0,1),
(59,1,NULL,0,1),
(60,1,0,0,1),
(61,1,NULL,0,1),
(62,1,0,0,1),
(63,1,NULL,0,1),
(64,1,0,0,1),
(65,1,NULL,0,1),
(66,1,0,0,1),
(67,1,NULL,0,1),
(68,1,0,0,1),
(69,1,0,0,1),
(70,1,NULL,0,1),
(71,1,0,0,1),
(72,1,NULL,0,1),
(73,1,0,0,1),
(74,1,NULL,0,1),
(75,1,0,0,1),
(76,1,NULL,0,1),
(77,1,0,0,1),
(78,1,NULL,0,1),
(79,1,0,0,1),
(80,1,NULL,0,1),
(81,1,0,0,1),
(82,1,NULL,0,1),
(83,1,0,0,1),
(84,1,NULL,0,1),
(85,1,0,0,1),
(86,1,NULL,0,1),
(87,1,0,0,1),
(88,1,NULL,0,1),
(89,1,0,0,1),
(90,1,NULL,0,1),
(91,1,0,0,1),
(92,1,NULL,0,1),
(93,1,0,0,1),
(94,1,NULL,0,1),
(95,1,0,0,1),
(96,1,NULL,0,2),
(97,1,0,0,2),
(98,1,NULL,0,2),
(99,1,0,0,2),
(100,1,NULL,0,1),
(101,1,0,0,1),
(102,1,NULL,0,1),
(103,1,0,0,1),
(104,1,NULL,0,1),
(105,1,0,0,1),
(106,1,NULL,0,1),
(107,1,0,0,1),
(108,1,NULL,0,1),
(109,1,0,0,1);

/*Table structure for table `polje` */

DROP TABLE IF EXISTS `polje`;

CREATE TABLE `polje` (
  `igra_id_fk` bigint(20) unsigned NOT NULL,
  `matrica_id_fk` bigint(20) unsigned NOT NULL,
  `polje_id` int(20) unsigned NOT NULL AUTO_INCREMENT,
  `vrednost` bigint(20) DEFAULT NULL,
  `kolona_id_fk` bigint(20) unsigned DEFAULT NULL,
  `red_id_fk` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`igra_id_fk`,`matrica_id_fk`,`polje_id`),
  KEY `polje_kolona_fk` (`kolona_id_fk`),
  KEY `polje_red_fk` (`red_id_fk`),
  KEY `polje_id` (`polje_id`),
  CONSTRAINT `polje_kolona_fk` FOREIGN KEY (`kolona_id_fk`) REFERENCES `kolona` (`kolona_id`),
  CONSTRAINT `polje_matrica_fk` FOREIGN KEY (`igra_id_fk`, `matrica_id_fk`) REFERENCES `matrica` (`igra_id_fk`, `matrica_id`),
  CONSTRAINT `polje_red_fk` FOREIGN KEY (`red_id_fk`) REFERENCES `red` (`red_id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=latin1;

/*Data for the table `polje` */

insert  into `polje`(`igra_id_fk`,`matrica_id_fk`,`polje_id`,`vrednost`,`kolona_id_fk`,`red_id_fk`) values 
(81,1,1,18,3,7),
(83,1,2,4,3,3),
(83,1,3,4,3,3),
(83,1,4,4,3,3),
(83,1,5,4,3,3),
(83,1,6,4,3,3),
(85,1,7,10,3,6),
(87,1,8,76,3,12),
(87,1,9,76,3,12),
(87,1,10,76,3,12),
(87,1,11,76,3,12),
(89,1,12,75,3,15),
(89,1,13,75,3,15),
(89,1,14,75,3,15),
(91,1,15,10,2,9),
(91,1,16,0,2,10),
(93,1,17,9,2,3),
(93,1,18,9,2,7),
(93,1,19,25,2,8),
(93,1,20,0,2,10),
(99,1,21,10,4,5),
(99,1,22,10,4,7),
(99,1,23,46,4,12),
(99,1,24,46,4,15),
(99,1,25,56,2,13),
(99,1,26,56,2,15),
(99,1,27,25,4,8),
(99,1,28,0,4,10),
(99,1,29,15,2,5),
(99,1,30,15,2,7),
(99,1,31,23,2,8),
(99,1,32,0,2,10),
(99,1,33,2,1,1),
(99,1,34,2,1,7),
(101,1,35,3,1,1),
(101,1,36,3,1,7),
(103,1,37,2,1,1),
(103,1,38,2,1,7),
(105,1,39,60,2,13),
(105,1,40,90,2,15),
(105,1,41,44,2,12),
(107,1,42,15,4,3),
(107,1,43,15,4,7),
(107,1,44,4,2,2),
(107,1,45,4,2,7),
(107,1,46,21,2,8),
(107,1,47,0,2,10),
(107,1,48,48,4,12),
(107,1,49,48,4,15),
(107,1,50,3,1,1),
(107,1,51,3,1,7),
(107,1,52,2,2,1),
(107,1,53,16,2,4),
(109,1,54,76,4,11),
(109,1,55,106,4,15),
(109,1,56,0,4,12),
(109,1,57,47,2,12),
(109,1,58,47,2,15),
(109,1,59,4,2,2),
(109,1,60,13,2,7),
(109,1,61,4,1,1),
(109,1,62,4,1,7),
(109,1,63,9,2,3);

/*Table structure for table `red` */

DROP TABLE IF EXISTS `red`;

CREATE TABLE `red` (
  `red_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `naziv` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`red_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;

/*Data for the table `red` */

insert  into `red`(`red_id`,`naziv`) values 
(1,'1'),
(2,'2'),
(3,'3'),
(4,'4'),
(5,'5'),
(6,'6'),
(7,'Suma 1'),
(8,'Max'),
(9,'Min'),
(10,'Suma2'),
(11,'Kenta'),
(12,'Ful'),
(13,'Poker'),
(14,'Jamb'),
(15,'Suma 3');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

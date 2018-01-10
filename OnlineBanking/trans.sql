/*
SQLyog - Free MySQL GUI v5.02
Host - 5.0.19-nt : Database - jjs6
*********************************************************************
Server version : 5.0.19-nt
*/


create database if not exists `jjs6`;

USE `jjs6`;

/*Table structure for table `transaction` */

DROP TABLE IF EXISTS `transaction`;

CREATE TABLE `transaction` (
  `Tid` varchar(30) NOT NULL,
  `AccNo` varchar(50) default NULL,
  `Description` varchar(100) default NULL,
  `Balance` decimal(8,2) default NULL,
  `Date` date default NULL,
  PRIMARY KEY  (`Tid`),
  KEY `FK_transaction` (`AccNo`),
  CONSTRAINT `transaction_ibfk_1` FOREIGN KEY (`AccNo`) REFERENCES `bank` (`AccNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `transaction` */

insert into `transaction` values 
('-1054151178','SBI-391375399     ','hi','7240.00','2014-09-17'),
('-1619730324','SBI303924608','wer','43100.00','2014-09-07'),
('-1672225259','SBI1775468849','hjk','14500.00','2014-11-17'),
('-1904431318','SBI-391375399     ','rtyu','7200.00','2014-09-10'),
('-340354651','SBI-1101706326','asdf','9500.00','2014-09-07'),
('-680709302','SBI-1144192621','asdf','26500.00','2014-09-07'),
('-809865162','SBI269603617','wer','48000.00','2014-09-07'),
('1195267989','SBI-1144192621','rtyu','25500.00','2014-09-10'),
('1620408059','SBI-1459348293','','4960.00','2014-09-17'),
('950516778','SBI1775468849','hjk','15500.00','2014-11-17'),
('TID-1959024571','SBI-1101706326','dfghvb','8500.00','2015-01-13'),
('TID-2046685328','SBI1987679138','sdfgh','4500.00','2015-01-18'),
('TID-214979481','SBI-1144192621','aqwefg','0.00','2014-08-26'),
('TID-429958962','SBI-391375399','aqwefg','6200.00','2014-08-26'),
('TID201596640','SBI-472834792','sdfgh','12500.00','2015-01-18'),
('TID376918154','SBI-391375399','dfghvb','8240.00','2015-01-13');

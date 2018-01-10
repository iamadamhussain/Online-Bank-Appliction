/*
SQLyog - Free MySQL GUI v5.02
Host - 5.0.19-nt : Database - jjs6
*********************************************************************
Server version : 5.0.19-nt
*/


create database if not exists `jjs6`;

USE `jjs6`;

/*Table structure for table `bank` */

DROP TABLE IF EXISTS `bank`;

CREATE TABLE `bank` (
  `AccNo` varchar(50) NOT NULL,
  `firstname` varchar(50) default NULL,
  `lastname` varchar(50) default NULL,
  `mobileNo` varchar(50) default NULL,
  `Address` varchar(50) default NULL,
  `DOB` varchar(50) default NULL,
  `Gender` varchar(50) default NULL,
  `typeofAccount` varchar(40) default NULL,
  `password` varchar(50) default NULL,
  `Balance` decimal(11,3) default NULL,
  PRIMARY KEY  (`AccNo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `bank` */

insert into `bank` values 
('SBI-1101706326','as','asd','asd','ncm','14','male','fd','asd','8500.000'),
('SBI-1144192621','SANTHOSH','POOJARI','9482209937','Banashankari','14/01/1991','male','sb','asd','25500.000'),
('SBI-1459348293','adam','hussain','gfgfgfgf','hhh','2014-09-02','male','sb','adam','4960.000'),
('SBI-310858559','bn','nn','  ll',' mm','  mm','male','ca','asd','4000.000'),
('SBI-328777537','as','xcd','xcv','hdfj','x c','male','sb','asd','5689.000'),
('SBI-391375399','as','asd','9449241560','Zxdxfgv','2009-04-07','male','sb','asd','8240.000'),
('SBI-472834792','Krishna','poojari','9449241560','zxcvb','2013-01-07','male','sb','asd','12500.000'),
('SBI112005463','RAVI','S','9485632678','Jayanagar','5/02/1986','male','sb','asd','49000.000'),
('SBI1181406839','asdXc','scdv','xzc','xcsc','xz','male','sb','asd','456.000'),
('SBI1293699144','sdfg','fgg','sdfg','cv','78','male','sb','asd','78956.000'),
('SBI1775468849','asde','trytu','9485','asdfg','15','male','sb','qwer','15000.000'),
('SBI1987679138','SANTHOSH','POOJARI','9449241560','#519 3rd main nagar\r\njp nagar  1st phase bangalore','2015-01-19','male','sb','asd','4500.000'),
('SBI269603617','rama','kr','9886339116','asdfghgfd','2014-09-09','male','fd','asd','48000.000'),
('SBI303924608','xc','b','bn','bnm','2014-08-05','male','ca','asd','41100.000');

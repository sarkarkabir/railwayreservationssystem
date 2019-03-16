-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.41-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema bdrailwayone
--

CREATE DATABASE IF NOT EXISTS bdrailwayone;
USE bdrailwayone;

--
-- Definition of table `addstation`
--

DROP TABLE IF EXISTS `addstation`;
CREATE TABLE `addstation` (
  `stationid` int(10) unsigned NOT NULL auto_increment,
  `stationname` varchar(255) default NULL,
  PRIMARY KEY  (`stationid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `addstation`
--

/*!40000 ALTER TABLE `addstation` DISABLE KEYS */;
INSERT INTO `addstation` (`stationid`,`stationname`) VALUES 
 (1,'dhaka'),
 (2,'chittagong'),
 (3,'Noakhali'),
 (4,'Nillprimary');
/*!40000 ALTER TABLE `addstation` ENABLE KEYS */;


--
-- Definition of table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `catid` varchar(255) NOT NULL,
  `catname` varchar(255) default NULL,
  `description` varchar(255) default NULL,
  PRIMARY KEY  (`catid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`catid`,`catname`,`description`) VALUES 
 ('2','NON_AC','best quality');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;


--
-- Definition of table `compartmentsubtype`
--

DROP TABLE IF EXISTS `compartmentsubtype`;
CREATE TABLE `compartmentsubtype` (
  `comsubid` int(10) unsigned NOT NULL auto_increment,
  `comtypeid` int(10) unsigned default NULL,
  `comsubname` varchar(45) default NULL,
  PRIMARY KEY  (`comsubid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `compartmentsubtype`
--

/*!40000 ALTER TABLE `compartmentsubtype` DISABLE KEYS */;
INSERT INTO `compartmentsubtype` (`comsubid`,`comtypeid`,`comsubname`) VALUES 
 (1,1,'Ka'),
 (2,2,'KHA'),
 (3,3,'GHA');
/*!40000 ALTER TABLE `compartmentsubtype` ENABLE KEYS */;


--
-- Definition of table `compartmenttype`
--

DROP TABLE IF EXISTS `compartmenttype`;
CREATE TABLE `compartmenttype` (
  `comtypeid` int(10) unsigned NOT NULL auto_increment,
  `comname` varchar(45) default NULL,
  `totalseat` int(10) unsigned default NULL,
  PRIMARY KEY  (`comtypeid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `compartmenttype`
--

/*!40000 ALTER TABLE `compartmenttype` DISABLE KEYS */;
INSERT INTO `compartmenttype` (`comtypeid`,`comname`,`totalseat`) VALUES 
 (1,'AC',90),
 (2,'NON_AC',100),
 (3,'GENERAL',110);
/*!40000 ALTER TABLE `compartmenttype` ENABLE KEYS */;


--
-- Definition of table `farechart`
--

DROP TABLE IF EXISTS `farechart`;
CREATE TABLE `farechart` (
  `fareid` int(10) unsigned NOT NULL auto_increment,
  `fromstationid` varchar(45) default NULL,
  `tostationid` varchar(45) default NULL,
  `comname` varchar(45) default NULL,
  `fareamt` double default NULL,
  `passtypeid` varchar(45) default NULL,
  PRIMARY KEY  (`fareid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `farechart`
--

/*!40000 ALTER TABLE `farechart` DISABLE KEYS */;
INSERT INTO `farechart` (`fareid`,`fromstationid`,`tostationid`,`comname`,`fareamt`,`passtypeid`) VALUES 
 (1,'dhaka','Noakhali','AC',300,'Adult'),
 (2,'dhaka','Noakhali','NON_AC',270,'Adult'),
 (3,'dhaka','Noakhali','GENERAL',250,'Adult'),
 (4,'dhaka','chittagong','AC',700,'Adult'),
 (5,'dhaka','chittagong','NON_AC',500,'Adult');
/*!40000 ALTER TABLE `farechart` ENABLE KEYS */;


--
-- Definition of table `passengerinfo`
--

DROP TABLE IF EXISTS `passengerinfo`;
CREATE TABLE `passengerinfo` (
  `passid` int(10) unsigned NOT NULL auto_increment,
  `passname` varchar(45) default NULL,
  `passadd` varchar(45) default NULL,
  `passdob` date default NULL,
  `passgender` varchar(45) default NULL,
  `regdate` date default NULL,
  `passstatus` varchar(45) default NULL,
  `passemail` varchar(45) default NULL,
  PRIMARY KEY  (`passid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `passengerinfo`
--

/*!40000 ALTER TABLE `passengerinfo` DISABLE KEYS */;
INSERT INTO `passengerinfo` (`passid`,`passname`,`passadd`,`passdob`,`passgender`,`regdate`,`passstatus`,`passemail`) VALUES 
 (2,'sujan','malibag','1991-02-01','Male','2018-12-06','available','kabir@gmail.com'),
 (3,'sarkarkabir','dhaka','2017-02-08','Male','2018-12-19','available','skus@gmail.com'),
 (4,'mohiuddin','ctg','1992-02-04','Male','2019-01-01','available','one@gmail.com');
/*!40000 ALTER TABLE `passengerinfo` ENABLE KEYS */;


--
-- Definition of table `passengertype`
--

DROP TABLE IF EXISTS `passengertype`;
CREATE TABLE `passengertype` (
  `passtypeid` int(10) unsigned NOT NULL auto_increment,
  `passtype` varchar(45) default NULL,
  PRIMARY KEY  (`passtypeid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `passengertype`
--

/*!40000 ALTER TABLE `passengertype` DISABLE KEYS */;
INSERT INTO `passengertype` (`passtypeid`,`passtype`) VALUES 
 (1,'Adult'),
 (2,'Child');
/*!40000 ALTER TABLE `passengertype` ENABLE KEYS */;


--
-- Definition of table `payment`
--

DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `paymentid` int(10) unsigned NOT NULL auto_increment,
  `resid` int(10) unsigned default NULL,
  `qty` int(10) unsigned default NULL,
  `total` double default NULL,
  `fareid` int(10) unsigned default NULL,
  `fareamt` double default NULL,
  PRIMARY KEY  USING BTREE (`paymentid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payment`
--

/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` (`paymentid`,`resid`,`qty`,`total`,`fareid`,`fareamt`) VALUES 
 (1,1,2,500,3,250),
 (2,3,3,2100,4,700),
 (3,4,3,810,2,270),
 (5,5,2,1000,5,500),
 (6,11,2,600,1,300),
 (7,12,3,900,1,300);
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;


--
-- Definition of table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
CREATE TABLE `reservation` (
  `resid` int(10) unsigned NOT NULL auto_increment,
  `passid` int(10) unsigned default NULL,
  `resdate` varchar(45) default NULL,
  `ptn` int(10) unsigned default NULL,
  `resstatus` varchar(45) default NULL,
  `trainid` int(10) unsigned default NULL,
  `fromstationid` varchar(45) default NULL,
  `tostationid` varchar(45) default NULL,
  `depaturetime` varchar(45) default NULL,
  `arivaltime` varchar(45) default NULL,
  `adult` int(10) unsigned default NULL,
  `child` int(10) unsigned default NULL,
  `emailid` varchar(45) default NULL,
  `d` date default NULL,
  `comname` varchar(45) default NULL,
  `comsubname` varchar(45) default NULL,
  PRIMARY KEY  (`resid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reservation`
--

/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` (`resid`,`passid`,`resdate`,`ptn`,`resstatus`,`trainid`,`fromstationid`,`tostationid`,`depaturetime`,`arivaltime`,`adult`,`child`,`emailid`,`d`,`comname`,`comsubname`) VALUES 
 (1,2,'2019-01-05',62080,'ordered',2,'dhaka','Noakhali','12:10 AM','05:10 PM',2,1,'kabir@gmail.com','2019-02-02','AC','Ka'),
 (2,2,'2019-01-05',96879,'ordered',5,'dhaka','Noakhali','03:00 PM','07:00 PM',2,0,'kabir@gmail.com','2019-02-03','AC','Ka'),
 (3,2,'2019-01-05',6874,'ordered',1,'dhaka','chittagong','10:10 AM','03:10 PM',2,1,'kabir@gmail.com','2019-01-05','AC','KHA'),
 (4,2,'2019-01-05',32962,'ordered',4,'dhaka','chittagong','10:15 AM','03:10 PM',1,1,'kabir@gmail.com','2019-01-06','AC','KHA'),
 (5,2,'2019-01-05',16350,'ordered',1,'dhaka','chittagong','10:10 AM','03:10 PM',2,1,'kabir@gmail.com','2019-01-01','AC','KHA'),
 (6,2,'2019-01-05',5514,'ordered',1,'dhaka','chittagong','10:10 AM','03:10 PM',2,2,'kabir@gmail.com','2019-01-06','NON_AC','Ka'),
 (7,2,'2019-01-05',55763,'ordered',2,'dhaka','Noakhali','12:10 AM','05:10 PM',2,1,'kabir@gmail.com','2019-01-01','AC','KHA'),
 (8,2,'2019-01-05',22323,'ordered',2,'dhaka','Noakhali','12:10 AM','05:10 PM',2,1,'kabir@gmail.com','2019-01-05','AC','KHA'),
 (9,2,'2019-01-05',83494,'ordered',4,'dhaka','chittagong','10:15 AM','03:10 PM',1,1,'kabir@gmail.com','2019-01-26','AC','KHA'),
 (10,2,'2019-01-05',16077,'ordered',2,'dhaka','Noakhali','12:10 AM','05:10 PM',0,0,'kabir@gmail.com','2019-01-13','AC','GHA'),
 (11,4,'2019-01-07',84341,'ordered',4,'dhaka','chittagong','10:15 AM','03:10 PM',2,1,'one@gmail.com','2019-03-09','AC','KHA'),
 (12,2,'2019-01-12',48362,'ordered',2,'dhaka','Noakhali','12:10 AM','05:10 PM',2,1,'kabir@gmail.com','2019-01-12','AC','Ka');
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;


--
-- Definition of table `reservationdetails`
--

DROP TABLE IF EXISTS `reservationdetails`;
CREATE TABLE `reservationdetails` (
  `resdetid` int(10) unsigned NOT NULL auto_increment,
  `resid` int(10) unsigned default NULL,
  `comsubid` varchar(45) default NULL,
  `fareid` int(10) unsigned default NULL,
  `seatno` varchar(45) default NULL,
  PRIMARY KEY  (`resdetid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reservationdetails`
--

/*!40000 ALTER TABLE `reservationdetails` DISABLE KEYS */;
INSERT INTO `reservationdetails` (`resdetid`,`resid`,`comsubid`,`fareid`,`seatno`) VALUES 
 (1,1,'1',1,'1'),
 (2,1,'1',1,'2'),
 (3,1,'1',1,'3'),
 (4,2,'1',1,'1'),
 (5,2,'1',1,'10'),
 (6,3,'2',4,'11'),
 (7,3,'2',4,'12'),
 (8,3,'2',4,'13'),
 (9,4,'2',4,'14'),
 (10,4,'2',4,'8'),
 (11,5,'2',4,'5'),
 (12,5,'2',4,'9'),
 (13,5,'2',4,'20'),
 (14,6,'1',5,'15'),
 (15,6,'1',5,'16'),
 (16,6,'1',5,'17'),
 (17,6,'1',5,'3'),
 (18,8,'2',1,'39'),
 (19,8,'2',1,'4'),
 (20,8,'2',1,'74'),
 (21,9,'2',4,'98'),
 (22,9,'2',4,'12'),
 (23,11,'2',4,'70'),
 (24,11,'2',4,'44'),
 (25,12,'1',1,'23'),
 (26,12,'1',1,'34'),
 (27,12,'1',1,'6');
/*!40000 ALTER TABLE `reservationdetails` ENABLE KEYS */;


--
-- Definition of table `searchtrain`
--

DROP TABLE IF EXISTS `searchtrain`;
CREATE TABLE `searchtrain` (
  `fromstid` int(10) unsigned NOT NULL auto_increment,
  `tostid` varchar(45) default NULL,
  `date` date default NULL,
  `trainname` varchar(45) default NULL,
  `stationname` varchar(45) default NULL,
  PRIMARY KEY  (`fromstid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `searchtrain`
--

/*!40000 ALTER TABLE `searchtrain` DISABLE KEYS */;
/*!40000 ALTER TABLE `searchtrain` ENABLE KEYS */;


--
-- Definition of table `traininfo`
--

DROP TABLE IF EXISTS `traininfo`;
CREATE TABLE `traininfo` (
  `trainid` int(10) unsigned NOT NULL auto_increment,
  `trainnumber` varchar(45) default NULL,
  `trainname` varchar(45) default NULL,
  `fromstationid` varchar(45) default NULL,
  `tostationid` varchar(45) default NULL,
  `depaturetime` varchar(45) default NULL,
  `arivaltime` varchar(45) default NULL,
  `dayoff` varchar(45) default NULL,
  PRIMARY KEY  (`trainid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `traininfo`
--

/*!40000 ALTER TABLE `traininfo` DISABLE KEYS */;
INSERT INTO `traininfo` (`trainid`,`trainnumber`,`trainname`,`fromstationid`,`tostationid`,`depaturetime`,`arivaltime`,`dayoff`) VALUES 
 (1,'101','Ektaexpress','dhaka','chittagong','10:10 AM','03:10 PM','Wednesday'),
 (2,'102','durotajan','dhaka','Noakhali','12:10 AM','05:10 PM','Friday'),
 (3,'103','Nillsagor','dhaka','Nillprimary','10:00 Am','05:00 PM','Thursday'),
 (4,'104','duranta express','dhaka','chittagong','10:15 AM','03:10 PM','Wednesday'),
 (5,'105','upakul express','dhaka','Noakhali','03:00 PM','07:00 PM','Friday');
/*!40000 ALTER TABLE `traininfo` ENABLE KEYS */;


--
-- Definition of table `trainseat`
--

DROP TABLE IF EXISTS `trainseat`;
CREATE TABLE `trainseat` (
  `seatid` int(10) unsigned NOT NULL auto_increment,
  `trainid` int(10) unsigned default NULL,
  `comtypeid` int(10) unsigned default NULL,
  `noofcompartment` varchar(45) default NULL,
  PRIMARY KEY  (`seatid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trainseat`
--

/*!40000 ALTER TABLE `trainseat` DISABLE KEYS */;
INSERT INTO `trainseat` (`seatid`,`trainid`,`comtypeid`,`noofcompartment`) VALUES 
 (2,1,1,'5'),
 (3,1,2,'3'),
 (4,1,2,'4');
/*!40000 ALTER TABLE `trainseat` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `emailid` varchar(255) NOT NULL,
  `phone` varchar(255) default NULL,
  `username` varchar(255) default NULL,
  PRIMARY KEY  (`emailid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`emailid`,`phone`,`username`) VALUES 
 ('123@asd.asd','123','123'),
 ('kabir@gmail.com','01840029501','sujan'),
 ('kud@ddd.com','123','kuddus'),
 ('myapp@gmailcom','018400','azad'),
 ('one@gmail.com','+884634564','mohiuddin'),
 ('sku@gmail.com','+88','sk'),
 ('skus@gmail.com','+88','Sarkarsujan');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


--
-- Definition of table `userrole`
--

DROP TABLE IF EXISTS `userrole`;
CREATE TABLE `userrole` (
  `emailid` varchar(255) NOT NULL,
  `password` varchar(255) default NULL,
  `role` varchar(255) default NULL,
  `status` varchar(255) default NULL,
  PRIMARY KEY  (`emailid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userrole`
--

/*!40000 ALTER TABLE `userrole` DISABLE KEYS */;
INSERT INTO `userrole` (`emailid`,`password`,`role`,`status`) VALUES 
 ('123@asd.asd','123','ROLE_USER','True'),
 ('kabir@gmail.com','123','ROLE_ADMIN','True'),
 ('kud@ddd.com','123','ROLE_USER','True'),
 ('myapp@gmailcom','123','ROLE_USER','True'),
 ('one@gmail.com','123','ROLE_USER','True'),
 ('sku@gmail.com','1234','ROLE_USER','True'),
 ('skus@gmail.com','123','ROLE_USER','True');
/*!40000 ALTER TABLE `userrole` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

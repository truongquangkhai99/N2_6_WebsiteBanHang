-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: laptrinhweb
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.30-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `binhluan`
--

DROP TABLE IF EXISTS `binhluan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `binhluan` (
  `idPL` int(11) NOT NULL AUTO_INCREMENT,
  `idM` int(11) NOT NULL,
  `idP` int(11) NOT NULL,
  `content` varchar(45) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`idPL`),
  KEY `fk_binhluan_idM_idx` (`idM`),
  KEY `fk_binhluan_idP_idx` (`idP`),
  CONSTRAINT `fk_binhluan_idM` FOREIGN KEY (`idM`) REFERENCES `member` (`idM`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_binhluan_idP` FOREIGN KEY (`idP`) REFERENCES `product` (`idP`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `binhluan`
--

LOCK TABLES `binhluan` WRITE;
/*!40000 ALTER TABLE `binhluan` DISABLE KEYS */;
/*!40000 ALTER TABLE `binhluan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cartitem`
--

DROP TABLE IF EXISTS `cartitem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cartitem` (
  `idC` int(11) NOT NULL AUTO_INCREMENT,
  `idP` int(11) NOT NULL,
  `idO` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`idC`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cartitem`
--

LOCK TABLES `cartitem` WRITE;
/*!40000 ALTER TABLE `cartitem` DISABLE KEYS */;
INSERT INTO `cartitem` VALUES (2,2,3,1),(3,3,3,1),(4,1,4,1),(5,1,5,1),(6,1,6,1),(7,3,6,1),(8,1,7,3),(9,2,8,1),(10,1,9,1),(11,13,10,1),(12,32,11,1),(13,26,12,1),(14,9,13,1),(15,20,13,1),(16,23,14,1),(17,21,15,1),(18,13,15,1),(19,4,15,1),(20,15,16,1),(21,11,17,1),(22,12,17,1),(23,32,18,1),(24,37,18,1),(25,21,19,1),(26,7,20,1),(27,2,21,1),(28,3,22,1),(29,36,23,1),(30,29,24,1),(31,11,25,1),(32,31,25,1),(33,30,26,1),(34,18,26,1),(35,14,27,1),(36,29,28,1),(37,17,29,1),(38,26,29,1),(39,24,30,1),(40,16,31,1),(41,2,32,1),(42,27,33,1),(43,33,33,1),(44,31,34,1),(45,35,34,1),(46,38,35,1),(47,4,36,1),(48,37,37,1),(49,3,38,4),(50,25,39,2),(51,15,39,1);
/*!40000 ALTER TABLE `cartitem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `danhmuc`
--

DROP TABLE IF EXISTS `danhmuc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `danhmuc` (
  `idDM` int(11) NOT NULL AUTO_INCREMENT,
  `tenDM` varchar(45) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`idDM`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `danhmuc`
--

LOCK TABLES `danhmuc` WRITE;
/*!40000 ALTER TABLE `danhmuc` DISABLE KEYS */;
INSERT INTO `danhmuc` VALUES (1,'Smartphone'),(2,'Tablet'),(3,'Laptop'),(4,'Phụ kiện'),(5,'Sản phẩm mới'),(6,'Sản phẩm yêu thích');
/*!40000 ALTER TABLE `danhmuc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `member` (
  `idM` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) COLLATE utf8_bin NOT NULL,
  `password` varchar(45) COLLATE utf8_bin NOT NULL,
  `hoTen` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `gmail` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `role` int(1) DEFAULT NULL,
  PRIMARY KEY (`idM`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES (1,'admin','admin','admin','chinh123@gmail.com','0986505708',1),(2,'chinh123','chinh234','chinh','chinh123@gmail.com','0986505708',0),(3,'quynh123','quynhmupghe','quynh','quynhmupghe123@gmail.com','1234',0),(4,'vu123','vuvivu123','Vu Vi Vu','s@gmail.com','0986505708',0),(5,'quynhbb','quynh123','Nguyen Huu Quynh','quynhmupghe123@gmail.com','12346789',0),(6,'cuong','cuong123','Le Dinh Cuong','cuong@gmail.com','124322',0),(7,'quang','quang123','Pham Van Quang','quang@gmail.com','37363737',0),(8,'thuan','thuan123','Nguyen Duc Thuan','thuan@gmail.com','5656545765',0),(9,'trung','trung123','Nguyen Ba Trung','trung@gmail.con','3432432',0),(10,'manh','manh123','Nguyen Duc Manh','manh@gmail.com','987673334',0);
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `idOrder` int(11) NOT NULL AUTO_INCREMENT,
  `idMember` int(11) NOT NULL,
  `dateMua` date NOT NULL,
  PRIMARY KEY (`idOrder`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (3,2,'2018-12-30'),(4,2,'2018-01-30'),(5,2,'2018-06-30'),(6,2,'2018-10-20'),(7,1,'2018-09-20'),(8,4,'2018-02-10'),(9,5,'2018-06-20'),(10,4,'2018-05-20'),(11,4,'2018-11-07'),(12,4,'2018-06-10'),(13,4,'2018-02-25'),(14,5,'2018-07-19'),(15,5,'2018-08-01'),(16,5,'2018-09-08'),(17,6,'2018-10-15'),(18,6,'2018-11-12'),(19,6,'2018-10-20'),(20,6,'2018-11-12'),(21,7,'2018-02-11'),(22,7,'2018-09-09'),(23,7,'2018-10-17'),(24,7,'2018-04-16'),(25,7,'2018-01-30'),(26,7,'2018-08-06'),(27,8,'2018-11-16'),(28,8,'2018-07-12'),(29,8,'2018-06-27'),(30,8,'2018-07-03'),(31,8,'2018-03-16'),(32,10,'2018-07-12'),(33,10,'2018-06-28'),(34,10,'2018-05-09'),(35,10,'2018-06-19'),(36,9,'2018-05-22'),(37,9,'2018-04-12'),(38,4,'2018-12-30'),(39,4,'2018-12-30');
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `idP` int(11) NOT NULL AUTO_INCREMENT,
  `tenP` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `hang` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `nam` int(4) DEFAULT NULL,
  `mau` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `gia` int(20) DEFAULT NULL,
  `like` int(10) DEFAULT NULL,
  `img` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `idDanhMuc` int(11) DEFAULT NULL,
  PRIMARY KEY (`idP`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'IPhoneX 64GB','Apple',2017,'Đỏ',9780000,0,'ipx-64g.png',1),(2,'Samsung Galaxy S9+','Samsung',2018,'Xanh Ánh Kim',9490000,0,'ss-galaxy-s9.png',1),(3,'OPPO 9','Oppo',2017,'Đỏ',7690000,0,'oppo-f9.png',1),(4,'Nokia 6.1 Plus','Nokia',2018,'Đen',6590000,0,'nokia-61-plus.png',1),(5,'Asus Zenfone 5','Asus',2017,'Xanh Đen',7999000,0,'asus1.png',1),(6,'Asus Zenfone 4 Max','Asus',2018,'Vàng',1999000,0,'asus2.png',1),(7,'Asus Zenfone Max Plus','Asus',2018,'Đen',1199000,0,'asus3.png',1),(8,'ASUS ZENFONE 3 MAX','Asus',2018,'Bạc',2100000,0,'asus4.png',1),(9,'Lenovo Zuk Z2 Pro','Lenovo',2017,'Trắng',1599000,0,'lenovo1.png',1),(10,'Lenovo Zuk Z2','Lenovo',2018,'Đen',3560000,0,'lenovo2.png',1),(11,'Lenovo S5 Pro GT','Lenovo',2018,'Xanh',8350000,0,'lenovo3.png',1),(12,'Samsung Galaxy Tab A','Samsung',2018,'Xám',9450000,0,'tabss1.png',2),(13,'Samsung Galaxy Tab S4','Samsung',2019,'Nâu',1729900,0,'tabss2.png',2),(14,'Lenovo Tab 4 8\" ','Lenovo',2017,'Đen',2390000,0,'tablenovo1.png',2),(15,'iPad-Pro','Apple',2017,'Hồng',1699900,0,'ipad-pro.png',2),(16,'iPad-mini 4','Apple',2017,'Trắng Hồng',9999000,0,'ipad-mini-4.png',2),(17,'Samsung Galaxy Tab E','Samsung',2018,'Đen',4450000,0,'tabss3.png',2),(18,'Lenovo Yoga Book','Lenovo',2018,'Đen',9999000,0,'tablenovo2.png',2),(19,'ASUS ZENPAD','Asus',2017,'Đen Trắng',3999000,0,'tabasus1.png',2),(20,'Asus MeMo Pad 8','Asus',2018,'Trắng',1635000,0,'tabasus2.png',2),(21,'Laptop Asus Zenbook','Asus',2017,'Đen',1952000,0,'lt-asus-zenbook.png',3),(22,'Laptop Asus FX503VD','Asus',2018,'Xám',2569000,0,'lt-asus-fx503vd.png',3),(23,'Laptop Lenovo IdeaPad Y720','Lenovo',2017,'Đỏ Đen',4379000,0,'lt-lenovo-ideaPad-Y720.png',3),(24,'Laptop Lenovo Yoga 520','Lenovo',2018,'Vàng',1129900,0,'lt-lenovo-yoga-520.png',3),(25,'Apple Macbook pro MR','Apple',2018,'Trắng',4594000,0,'macbook-MR932.png',3),(26,'Appple Macbook Air MQ','Apple',2017,'Bạc',4449000,0,'macbook-air-MQD.png',3),(27,'SamSung NP900X4C','Samsung',2018,'Xám',1290000,0,'lt-ss-np900x4c.png',3),(28,'Laptop Samsung 740U5L','Samsung',2017,'Đen Trắng',1452000,0,'lt-ss-740u5l.png',3),(29,'Laptop Asus Rog Strix','Asus',2018,'Đen',2499000,0,'lt-asus-rog-strix.png',3),(30,'Sạc dự phòng 10000mhA','Samsung',2017,'Đen',320000,0,'sac-du-phong-evalu.png',4),(31,'Tai Nghe Sony MDR','Sony',2018,'Xám',999000,0,'tai-nghei-sony-mdr-xb550ap.png',4),(32,'Móc dán điện thoaị OSMIA','Apple',2017,'Bạc',999000,0,'moc-dan-dt.png',4),(33,'USB Sandisk','Asus',2018,'Đen Đỏ',499000,0,'usb-sandisk.png',4),(34,'Ốp lưng iphone 7 plus','Apple',2018,'Đỏ Xám',30000,0,'pkoplungip.png',4),(35,'sạc samsung s9 ','Samsung',2018,'Đen',500000,0,'pksacss.png',4),(36,'Dán cường lực samsung','Samsung',2017,'Trắng',99000,0,'pkcuonglucss.png',4),(37,'Bao da Asus Zenfone 3','Asus',2018,'Đen',299000,0,'pkbaodaasus.png',4),(38,'Pin Lenovo K4 ','Lenovo',2018,'Đen',999000,0,'pkpinlenovo.png',4);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'laptrinhweb'
--

--
-- Dumping routines for database 'laptrinhweb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-30 21:19:27

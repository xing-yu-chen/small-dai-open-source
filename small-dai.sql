-- MySQL dump 10.13  Distrib 5.7.22, for macos10.13 (x86_64)
--
-- Host: 127.0.0.1    Database: small-dai-open-source
-- ------------------------------------------------------
-- Server version	5.7.22

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
-- Table structure for table `t_permission`
--

DROP TABLE IF EXISTS `t_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_permission` (
  `p_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `p_name` varchar(30) NOT NULL COMMENT '权限名称',
  `p_name_remark` varchar(30) DEFAULT NULL COMMENT '权限名称解释',
  `p_module` varchar(255) NOT NULL COMMENT '模块',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=74 DEFAULT CHARSET=utf8 COMMENT='权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_permission`
--

LOCK TABLES `t_permission` WRITE;
/*!40000 ALTER TABLE `t_permission` DISABLE KEYS */;
INSERT INTO `t_permission` VALUES (49,'visitedPanel','访问数据面板','Panel','2022-01-09 02:36:03',NULL),(50,'visitedPermission','访问权限管理','Permission','2022-01-09 02:36:03',NULL),(51,'savePermission','新增权限','Permission','2022-01-09 02:36:03',NULL),(52,'deletePermission','删除权限','Permission','2022-01-09 02:36:03',NULL),(53,'updatePermission','修改权限','Permission','2022-01-09 02:36:03',NULL),(55,'visitedRole','访问角色管理','Role','2022-01-09 02:36:03',NULL),(56,'saveRole','新增角色','Role','2022-01-09 02:36:03',NULL),(57,'deleteRole','删除角色','Role','2022-01-09 02:36:03',NULL),(58,'updateRole','修改角色','Role','2022-01-09 02:36:03',NULL),(60,'visitedRoleToPermission','访问角色权限管理','RoleToPermission','2022-01-09 02:36:03',NULL),(61,'saveRoleToPermission','新增角色权限','RoleToPermission','2022-01-09 02:36:03',NULL),(62,'deleteRoleToPermission','删除角色权限','RoleToPermission','2022-01-09 02:36:03',NULL),(63,'updateRoleToPermission','修改角色权限','RoleToPermission','2022-01-09 02:36:03',NULL),(65,'visitedUser','访问用户管理','User','2022-01-09 02:36:03',NULL),(66,'saveUser','新增用户','User','2022-01-09 02:36:03',NULL),(67,'deleteUser','删除用户','User','2022-01-09 02:36:03',NULL),(68,'updateUser','修改用户','User','2022-01-09 02:36:03',NULL),(70,'clearPermission','批量删除权限','Permission','2022-01-13 20:16:40',NULL),(71,'clearRole','批量删除角色','Role','2022-01-13 20:16:41',NULL),(72,'clearRoleToPermission','批量删除角色权限','RoleToPermission','2022-01-13 20:16:41',NULL),(73,'clearUser','批量删除用户','User','2022-01-13 20:16:41',NULL);
/*!40000 ALTER TABLE `t_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_role`
--

DROP TABLE IF EXISTS `t_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_role` (
  `r_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `r_name` varchar(20) NOT NULL COMMENT '角色名称',
  `r_name_remark` varchar(20) DEFAULT NULL COMMENT '角色名称解释',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='角色表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_role`
--

LOCK TABLES `t_role` WRITE;
/*!40000 ALTER TABLE `t_role` DISABLE KEYS */;
INSERT INTO `t_role` VALUES (1,'root','管理员','2022-01-07 23:59:21',NULL);
/*!40000 ALTER TABLE `t_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_role_to_permission`
--

DROP TABLE IF EXISTS `t_role_to_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_role_to_permission` (
  `rp_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `r_id` int(11) NOT NULL COMMENT '角色ID',
  `p_id` int(11) NOT NULL COMMENT '权限ID',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`rp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='角色权限表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_role_to_permission`
--

LOCK TABLES `t_role_to_permission` WRITE;
/*!40000 ALTER TABLE `t_role_to_permission` DISABLE KEYS */;
INSERT INTO `t_role_to_permission` VALUES (1,1,49,'2022-01-09 02:40:17','2022-01-09 02:40:17'),(2,1,50,'2022-01-11 16:25:10','2022-01-11 16:25:10'),(3,1,51,'2022-01-11 16:25:15','2022-01-11 16:25:15'),(4,1,52,'2022-01-13 20:09:58',NULL),(5,1,53,'2022-01-13 20:10:07',NULL),(6,1,54,'2022-01-13 20:10:17',NULL),(7,1,55,'2022-01-13 20:10:30',NULL),(8,1,56,'2022-01-13 20:10:39',NULL),(9,1,57,'2022-01-13 20:10:48',NULL),(10,1,58,'2022-01-13 20:10:57',NULL),(11,1,70,'2022-01-13 20:18:09',NULL);
/*!40000 ALTER TABLE `t_role_to_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `u_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `u_name` varchar(20) NOT NULL COMMENT '用户名',
  `u_password` varchar(30) NOT NULL COMMENT '密码',
  `u_email` varchar(40) NOT NULL COMMENT '邮箱',
  `u_telephone` varchar(11) DEFAULT NULL COMMENT '手机号',
  `u_age` int(11) DEFAULT NULL COMMENT '年龄',
  `u_address` varchar(255) DEFAULT NULL COMMENT '地址',
  `u_role_id` bigint(20) NOT NULL DEFAULT '1' COMMENT '角色',
  `deleted` int(11) NOT NULL DEFAULT '1' COMMENT '逻辑删除',
  `gmt_create` datetime NOT NULL COMMENT '创建时间',
  `gmt_modified` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COMMENT='用户表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'admin','12345','123@qq.com','123231',12,'aaa',1,1,'2021-12-26 00:00:00','2022-01-08 01:36:29'),(2,'sdfg','dfgh','fdghj','dfghj',12,'dfghj',2,1,'2022-01-06 19:19:12','2022-01-08 00:15:08'),(3,'sddfs','asd','asd','asd',13,'asd',1,1,'2022-01-06 19:22:56',NULL),(4,'asd','1234567','12345@qq.com','17325678970',12,NULL,1,1,'2022-01-06 19:26:50',NULL),(5,'sdfgfh','123597gfhhg','1235457@qq.com','12336',12,'ghfjgkkjhklh',1,1,'2022-01-07 00:39:00',NULL),(6,'dsdff','1324dfgfgd','13224','1242543',12,'xfghgchvmbj,',1,1,'2022-01-07 00:39:41',NULL),(12,'asdasd','asdasdasd','132123','asdasd',12321321,'asdasd',1,1,'2022-01-08 00:00:00','2022-01-08 00:18:35');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-13 20:24:20

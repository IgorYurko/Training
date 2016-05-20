CREATE DATABASE IF NOT EXISTS `my`;
USE `my`;
CREATE TABLE IF NOT EXISTS `category` (
  `id` int(7) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(500) DEFAULT NULL,
  `name_url` varchar(500) DEFAULT NULL,
  `description` varchar(5000) DEFAULT NULL,
  `image` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Таблица с категориями';

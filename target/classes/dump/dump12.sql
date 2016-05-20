USE `my`;
CREATE TABLE IF NOT EXISTS `category` (
  `id` int(7) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(500) DEFAULT NULL,
  `name_url` varchar(500) DEFAULT NULL,
  `description` varchar(5000) DEFAULT NULL,
  `image` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='Таблица с категориями';


INSERT IGNORE INTO `category` (`id`, `name`, `name_url`, `description`, `image`) VALUES
	(1, 'Будь вниматилен', 'pay_attention', 'Веселые и интересные вопросы без возрасных ограничений.', 'fany-test.jpg'),
	(2, 'Для разминки', 'warm-up', 'Легкие и шуточные вопросы знакомые со школьной скамьи.', 'easy.gif'),
	(3, 'Блесни интелектом ', 'show-intellect', 'Вопросы средней степени тяжести для истинных ценитилей.', 'chess.jpg'),
	(4, 'Полный разрыв мозга', 'brain-explosion', 'Уровень, достойный Эйнштейна.', 'einstein.jpeg');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;

DROP TABLE `user_role`;
DROP TABLE `role`;
DROP TABLE `user`;

-- Дамп структуры для таблица my.role
CREATE TABLE`role` (
  `id` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='User''s role';

-- Дамп данных таблицы my.role: ~5 rows (приблизительно)
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT IGNORE INTO `role` (`id`, `name`) VALUES
	(1, 'ROLE_USER'),
	(2, 'ROLE_ADMIN'),
	(3, 'ROLE_MODERATOR'),
	(4, 'ROLE_SUPERUSER'),
	(5, 'ROLE_AUTHOR');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;


-- Дамп структуры для таблица my.user
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(100) NOT NULL,
  `date_authorization` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='User''s table';

-- Дамп данных таблицы my.user: ~2 rows (приблизительно)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT IGNORE INTO `user` (`id`, `first_name`, `last_name`, `email`, `password`, `date_authorization`) VALUES
	(1, 'Igor', 'Test', 'igor.yurko.mail@gmail.com', '1234', '2016-04-04'),
	(2, 'Vasia', 'Pupkin', 'vasia.pupkin.mail@gmail.com', '2', '2016-01-17');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


-- Дамп структуры для таблица my.user_role
CREATE TABLE `user_role` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(10) unsigned NOT NULL,
  `role_id` tinyint(3) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_user_role_user` (`user_id`),
  KEY `FK_user_role_role` (`role_id`),
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='Many-to-many user and role';

-- Дамп данных таблицы my.user_role: ~1 rows (приблизительно)
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT IGNORE INTO `user_role` (`id`, `user_id`, `role_id`) VALUES
	(4, 2, 1);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

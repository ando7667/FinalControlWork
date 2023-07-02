-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               11.2.0-MariaDB - mariadb.org binary distribution
-- Операционная система:         Win64
-- HeidiSQL Версия:              12.3.0.6589
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Дамп структуры базы данных human_friends
DROP DATABASE IF EXISTS `human_friends`;
CREATE DATABASE IF NOT EXISTS `human_friends` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */;
USE `human_friends`;

-- Дамп структуры для таблица human_friends.animals
DROP TABLE IF EXISTS `animals`;
CREATE TABLE IF NOT EXISTS `animals` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_name` tinytext DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Дамп данных таблицы human_friends.animals: ~2 rows (приблизительно)
DELETE FROM `animals`;
INSERT INTO `animals` (`id`, `class_name`) VALUES
	(1, 'Домашние'),
	(2, 'Вьючные');

-- Дамп структуры для таблица human_friends.camels
DROP TABLE IF EXISTS `camels`;
CREATE TABLE IF NOT EXISTS `camels` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` tinytext DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `commands` tinytext DEFAULT NULL,
  `id_genus` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_camels_pack_animals` (`id_genus`),
  CONSTRAINT `FK_camels_pack_animals` FOREIGN KEY (`id_genus`) REFERENCES `pack_animals` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Дамп данных таблицы human_friends.camels: ~3 rows (приблизительно)
DELETE FROM `camels`;
INSERT INTO `camels` (`id`, `name`, `birthday`, `commands`, `id_genus`) VALUES
	(7, 'Гоша', '2021-03-15', 'стой,ну,прр', 2),
	(8, 'Верблюд2', '2015-05-19', 'стой,цок-цок', 2),
	(9, 'Верблюд3', '2018-09-08', '', 2);

-- Дамп структуры для таблица human_friends.cats
DROP TABLE IF EXISTS `cats`;
CREATE TABLE IF NOT EXISTS `cats` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` tinytext DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `commands` tinytext DEFAULT NULL,
  `id_genus` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_genus` (`id_genus`),
  CONSTRAINT `cats_ibfk_1` FOREIGN KEY (`id_genus`) REFERENCES `home_animals` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Дамп данных таблицы human_friends.cats: ~8 rows (приблизительно)
DELETE FROM `cats`;
INSERT INTO `cats` (`id`, `name`, `birthday`, `commands`, `id_genus`) VALUES
	(1, 'Рубик', '2020-01-09', 'кличка,ко мне', 2),
	(2, 'Персик', '2021-06-12', 'кличка,голос', 2),
	(3, 'Ася', '2017-12-04', 'кличка,голос,ко мне', 2),
	(4, 'Фиона', '2018-08-21', 'кличка,сидеть,ползи,принеси,голос,прыжок,ко мне', 2),
	(5, 'Смоки', '2019-05-11', 'кличка,сидеть,ползи,принеси,голос,прыжок,ко мне', 2),
	(6, 'Лиззи', '2022-07-08', 'кличка,кис-кис', 2),
	(7, 'Люси', '2015-11-21', 'имя,кискис', 2),
	(8, 'Киса1', '2015-09-07', 'кис-кис-кис', 2);

-- Дамп структуры для таблица human_friends.dogs
DROP TABLE IF EXISTS `dogs`;
CREATE TABLE IF NOT EXISTS `dogs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` tinytext DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `commands` tinytext DEFAULT NULL,
  `id_genus` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_genus` (`id_genus`),
  CONSTRAINT `dogs_ibfk_1` FOREIGN KEY (`id_genus`) REFERENCES `home_animals` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Дамп данных таблицы human_friends.dogs: ~6 rows (приблизительно)
DELETE FROM `dogs`;
INSERT INTO `dogs` (`id`, `name`, `birthday`, `commands`, `id_genus`) VALUES
	(1, 'Вита', '2015-05-03', 'кличка,ко мне,фу,нельзя,сидеть,лежать,рядом,гуляй,место,фас', 1),
	(2, 'Оскар', '2021-06-12', 'кличка,ко мне,фу,сидеть,лежать,рядом,гуляй,место', 1),
	(3, 'Грей', '2022-09-18', 'кличка,ко мне,нельзя,сидеть', 1),
	(4, 'Жужа', '2018-12-10', 'кличка,ко мне,нельзя,сидеть,лежать,рядом,место', 1),
	(5, 'Лора', '2020-10-15', 'кличка,фу,сидеть,лежать,рядом,гуляй,место,фас', 1),
	(6, 'Буч', '2021-11-24', 'кличка,нельзя,сидеть,лежать,рядом,место', 1);

-- Дамп структуры для таблица human_friends.donkeys
DROP TABLE IF EXISTS `donkeys`;
CREATE TABLE IF NOT EXISTS `donkeys` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` tinytext DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `commands` tinytext DEFAULT NULL,
  `id_genus` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_donkeys_pack_animals` (`id_genus`),
  CONSTRAINT `FK_donkeys_pack_animals` FOREIGN KEY (`id_genus`) REFERENCES `pack_animals` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Дамп данных таблицы human_friends.donkeys: ~7 rows (приблизительно)
DELETE FROM `donkeys`;
INSERT INTO `donkeys` (`id`, `name`, `birthday`, `commands`, `id_genus`) VALUES
	(1, 'Герл', '2022-10-16', '', 3),
	(2, 'Перл', '2017-08-30', '', 3),
	(3, 'Тесси', '2016-04-14', '', 3),
	(4, 'Ава', '2019-05-14', '', 3),
	(5, 'Пенни', '2021-08-05', 'хрю-хрю', 3),
	(6, 'Луна', '2020-12-10', 'топ-топ', 3),
	(7, 'Осёл1', '2020-08-22', 'цок-цок,бррр', 3);

-- Дамп структуры для таблица human_friends.hamsters
DROP TABLE IF EXISTS `hamsters`;
CREATE TABLE IF NOT EXISTS `hamsters` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` tinytext DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `commands` tinytext DEFAULT NULL,
  `id_genus` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_genus` (`id_genus`),
  CONSTRAINT `hamsters_ibfk_1` FOREIGN KEY (`id_genus`) REFERENCES `home_animals` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Дамп данных таблицы human_friends.hamsters: ~6 rows (приблизительно)
DELETE FROM `hamsters`;
INSERT INTO `hamsters` (`id`, `name`, `birthday`, `commands`, `id_genus`) VALUES
	(1, 'Банни', '2020-01-08', 'стоять,поворот,фу,прыгай,найти', 3),
	(2, 'Черныш', '2021-06-22', 'стоять,фу,прыгай,найти', 3),
	(3, 'Бонни', '2019-05-16', 'стоять,поворот,фу,прыгай,найти', 3),
	(4, 'Джей', '2018-05-30', 'стоять,поворот,фу', 3),
	(5, 'Винни', '2018-12-31', 'стоять,фу,найти', 3),
	(6, 'Хома', '2021-05-10', 'стоять,поворот,фу,прыгай', 3);

-- Дамп структуры для таблица human_friends.home_animals
DROP TABLE IF EXISTS `home_animals`;
CREATE TABLE IF NOT EXISTS `home_animals` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `genus_name` tinytext DEFAULT NULL,
  `id_сlass` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_сlass` (`id_сlass`),
  CONSTRAINT `home_animals_ibfk_1` FOREIGN KEY (`id_сlass`) REFERENCES `animals` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Дамп данных таблицы human_friends.home_animals: ~3 rows (приблизительно)
DELETE FROM `home_animals`;
INSERT INTO `home_animals` (`id`, `genus_name`, `id_сlass`) VALUES
	(1, 'Собаки', 1),
	(2, 'Кошки', 1),
	(3, 'Хомяки', 1);

-- Дамп структуры для таблица human_friends.horses
DROP TABLE IF EXISTS `horses`;
CREATE TABLE IF NOT EXISTS `horses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` tinytext DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `commands` tinytext DEFAULT NULL,
  `id_genus` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_horses_pack_animals` (`id_genus`),
  CONSTRAINT `FK_horses_pack_animals` FOREIGN KEY (`id_genus`) REFERENCES `pack_animals` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Дамп данных таблицы human_friends.horses: ~6 rows (приблизительно)
DELETE FROM `horses`;
INSERT INTO `horses` (`id`, `name`, `birthday`, `commands`, `id_genus`) VALUES
	(1, 'Виконт', '2015-01-24', 'вперёд,стой,рысь,хоп,шагом,тише', 1),
	(2, 'Буран', '2019-03-28', 'вперёд,стой,тише', 1),
	(3, 'Базилик', '2016-09-12', 'вперёд,стой,рысь,хоп,шагом', 1),
	(4, 'Гранат', '2016-07-09', 'вперёд,стой,рысь,хоп,шагом,тише', 1),
	(5, 'Астон', '2018-09-14', 'вперёд,стой,рысь,хоп', 1),
	(6, 'Апполон', '2021-11-10', 'вперёд,стой', 1);

-- Дамп структуры для представление human_friends.horses_donkey
DROP VIEW IF EXISTS `horses_donkey`;
-- Создание временной таблицы для обработки ошибок зависимостей представлений
CREATE TABLE `horses_donkey` (
	`name` TEXT NULL COLLATE 'utf8mb4_general_ci',
	`birthday` DATE NULL,
	`commands` TEXT NULL COLLATE 'utf8mb4_general_ci',
	`id_genus` INT(11) NULL
) ENGINE=MyISAM;

-- Дамп структуры для таблица human_friends.pack_animals
DROP TABLE IF EXISTS `pack_animals`;
CREATE TABLE IF NOT EXISTS `pack_animals` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `genus_name` tinytext DEFAULT NULL,
  `id_сlass` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_сlass` (`id_сlass`),
  CONSTRAINT `pack_animals_ibfk_1` FOREIGN KEY (`id_сlass`) REFERENCES `animals` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Дамп данных таблицы human_friends.pack_animals: ~3 rows (приблизительно)
DELETE FROM `pack_animals`;
INSERT INTO `pack_animals` (`id`, `genus_name`, `id_сlass`) VALUES
	(1, 'Лошади', 2),
	(2, 'Верблюды', 2),
	(3, 'Ослы', 2);

-- Дамп структуры для таблица human_friends.yang_animal
DROP TABLE IF EXISTS `yang_animal`;
CREATE TABLE IF NOT EXISTS `yang_animal` (
  `name` text DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `commands` text DEFAULT NULL,
  `id_genus` int(11) DEFAULT NULL,
  `genus` varchar(6) NOT NULL DEFAULT '',
  `age_month` bigint(21) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Дамп данных таблицы human_friends.yang_animal: ~9 rows (приблизительно)
DELETE FROM `yang_animal`;
INSERT INTO `yang_animal` (`name`, `birthday`, `commands`, `id_genus`, `genus`, `age_month`) VALUES
	('Оскар', '2021-06-12', 'кличка,ко мне,фу,сидеть,лежать,рядом,гуляй,место', 1, 'Собаки', 24),
	('Лора', '2020-10-15', 'кличка,фу,сидеть,лежать,рядом,гуляй,место,фас', 1, 'Собаки', 32),
	('Буч', '2021-11-24', 'кличка,нельзя,сидеть,лежать,рядом,место', 1, 'Собаки', 18),
	('Персик', '2021-06-12', 'кличка,голос', 2, 'Кошки', 24),
	('Черныш', '2021-06-22', 'стоять,фу,прыгай,найти', 3, 'Хомяки', 23),
	('Хома', '2021-05-10', 'стоять,поворот,фу,прыгай', 3, 'Хомяки', 25),
	('Апполон', '2021-11-10', 'вперёд,стой', 1, 'Лошади', 19),
	('Пенни', '2021-08-05', '', 3, 'Ослы', 22),
	('Луна', '2020-12-10', '', 3, 'Ослы', 30);

-- Дамп структуры для представление human_friends.horses_donkey
DROP VIEW IF EXISTS `horses_donkey`;
-- Удаление временной таблицы и создание окончательной структуры представления
DROP TABLE IF EXISTS `horses_donkey`;
CREATE ALGORITHM=UNDEFINED SQL SECURITY DEFINER VIEW `horses_donkey` AS SELECT `name`, birthday, commands, id_genus
FROM horses
UNION SELECT  `name`, birthday, commands, id_genus
FROM donkeys ;

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;

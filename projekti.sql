-- --------------------------------------------------------
-- Verkkotietokone:              127.0.0.1
-- Palvelinversio:               10.4.12-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Versio:              10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for projekti
CREATE DATABASE IF NOT EXISTS `projekti` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `projekti`;

-- Dumping structure for taulu projekti.hibernate_sequence
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) unsigned NOT NULL,
  `cycle_option` tinyint(1) unsigned NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB SEQUENCE=1;

-- Dumping data for table projekti.hibernate_sequence: ~1 rows (suunnilleen)
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` (`next_not_cached_value`, `minimum_value`, `maximum_value`, `start_value`, `increment`, `cache_size`, `cycle_option`, `cycle_count`) VALUES
	(1001, 1, 9223372036854775806, 1, 1, 1000, 0, 0);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;

-- Dumping structure for taulu projekti.projekti
CREATE TABLE IF NOT EXISTS `projekti` (
  `id` bigint(20) NOT NULL,
  `hinta` varchar(255) DEFAULT NULL,
  `maara` varchar(255) DEFAULT NULL,
  `tuote` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table projekti.projekti: ~3 rows (suunnilleen)
/*!40000 ALTER TABLE `projekti` DISABLE KEYS */;
INSERT INTO `projekti` (`id`, `hinta`, `maara`, `tuote`) VALUES
	(1, '3,50 euroa', '500 grammaa', 'Voita'),
	(2, '2 euroa per tlk', '3 litraa', 'Maitoa'),
	(3, '3 euroa', '1 kpl', 'Leipää'),
	(4, '12,90', '32 rll', 'Vessapaperia'),
	(5, '10 euroa', '2 plo', 'Käsidesiä'),
	(6, '2 euroa', '10 pss', 'Makaronia'),
	(7, '3 euroa', '400g', 'Jauhelihaa');
/*!40000 ALTER TABLE `projekti` ENABLE KEYS */;

-- Dumping structure for taulu projekti.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table projekti.user: ~2 rows (suunnilleen)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `password`, `role`, `username`) VALUES
	(1, '$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6', 'USER', 'user'),
	(2, '$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C', 'ADMIN', 'admin');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

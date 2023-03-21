/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- CREATE DATABASE IF NOT EXISTS `arosaje` /*!40100 DEFAULT CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci */;
USE `arosaje`;

CREATE TABLE IF NOT EXISTS `conseils` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `contenu` varchar(5000) NOT NULL,
    `date` datetime(6) DEFAULT NULL,
    `botaniste_id` int(11) DEFAULT NULL,
    `plante_id` int(11) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FKo55vdqihphopy7lo8rp10rb9v` (`botaniste_id`),
    KEY `FKikml2duob8bddwywtxapmoq2j` (`plante_id`),
    CONSTRAINT `FKikml2duob8bddwywtxapmoq2j` FOREIGN KEY (`plante_id`) REFERENCES `plantes` (`id`),
    CONSTRAINT `FKo55vdqihphopy7lo8rp10rb9v` FOREIGN KEY (`botaniste_id`) REFERENCES `utilisateurs` (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

CREATE TABLE IF NOT EXISTS `historique_gardiennage` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `date_fin` date DEFAULT NULL,
    `date_debut` date DEFAULT NULL,
    `plante_id` int(11) DEFAULT NULL,
    `utilisateur_id` int(11) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FKmuulunwo0fvoc1164octobbfs` (`plante_id`),
    KEY `FK30r57alw50da014ksqv11aqx9` (`utilisateur_id`),
    CONSTRAINT `FK30r57alw50da014ksqv11aqx9` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateurs` (`id`),
    CONSTRAINT `FKmuulunwo0fvoc1164octobbfs` FOREIGN KEY (`plante_id`) REFERENCES `plantes` (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

CREATE TABLE IF NOT EXISTS `photo` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `contenu` longblob DEFAULT NULL,
    `date` datetime(6) DEFAULT NULL,
    `nom` varchar(255) NOT NULL,
    `type` varchar(255) NOT NULL,
    `taille` bigint(20) NOT NULL,
    `plante_id` int(11) DEFAULT NULL,
    `utilisateur_id` int(11) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FKf30hht39mcarkhpl3faba6f8f` (`plante_id`),
    KEY `FKs28vinlv5ce7khugy5jmexwje` (`utilisateur_id`),
    CONSTRAINT `FKf30hht39mcarkhpl3faba6f8f` FOREIGN KEY (`plante_id`) REFERENCES `plantes` (`id`),
    CONSTRAINT `FKs28vinlv5ce7khugy5jmexwje` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateurs` (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

CREATE TABLE IF NOT EXISTS `plantes` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `date_ajout` datetime(6) DEFAULT NULL,
    `date_fin` date DEFAULT NULL,
    `garder` bit(1) DEFAULT NULL,
    `date_dernier_entretien` datetime(6) DEFAULT NULL,
    `date_debut` date DEFAULT NULL,
    `titre` varchar(100) NOT NULL,
    `guardien_id` int(11) DEFAULT NULL,
    `proprio_id` int(11) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `FKst7xle6rkex0twswror0hddpx` (`guardien_id`),
    KEY `FKkoof39yvbdj5fxcfa2qlv5g4t` (`proprio_id`),
    CONSTRAINT `FKkoof39yvbdj5fxcfa2qlv5g4t` FOREIGN KEY (`proprio_id`) REFERENCES `utilisateurs` (`id`),
    CONSTRAINT `FKst7xle6rkex0twswror0hddpx` FOREIGN KEY (`guardien_id`) REFERENCES `utilisateurs` (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

CREATE TABLE IF NOT EXISTS `utilisateurs` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `email` varchar(255) NOT NULL,
    `mot_de_passe` varchar(255) NOT NULL,
    `role` varchar(25) NOT NULL,
    `prenom` varchar(50) DEFAULT NULL,
    `nom` varchar(50) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_6ldvumu3hqvnmmxy1b6lsxwqy` (`email`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;

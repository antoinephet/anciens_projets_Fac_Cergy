-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mer 19 Juillet 2017 à 03:43
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `aston`
--

-- --------------------------------------------------------

--
-- Structure de la table `articles`
--

CREATE TABLE IF NOT EXISTS `articles` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `image` varchar(255) NOT NULL,
  `prix` double(10,2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Contenu de la table `articles`
--

INSERT INTO `articles` (`id`, `nom`, `image`, `prix`) VALUES
(1, 'Injustice 2', 'images/jeu1.jpg', 60.00),
(2, 'Resident Evil 5 Special Edition', 'images/jeu2.jpg', 80.00),
(3, 'Mass Effect Andromeda', 'images/jeu3.jpg', 69.00),
(4, 'Batman Arkham Knight', 'images/jeu4.jpg', 69.00),
(5, 'Uncharted 4', 'images/jeu5.jpg', 60.00),
(6, 'Fifa 2017', 'images/jeu6.jpg', 80.00),
(7, 'Street Fighter V', 'images/jeu7.jpg', 69.00),
(8, 'Call Of Duty', 'images/jeu8.jpg', 69.00),
(13, 'Crash Bandicoot 2017', 'images/jeu9.jpg', 69.00),
(14, 'Watch Dogs 2', 'images/jeu10.jpg', 69.00);

-- --------------------------------------------------------

--
-- Structure de la table `membres`
--

CREATE TABLE IF NOT EXISTS `membres` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `mail` varchar(255) NOT NULL,
  `motdepasse` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `membres`
--

INSERT INTO `membres` (`id`, `nom`, `mail`, `motdepasse`) VALUES
(1, 'anousak', 'anousak@gmail.com', '7110eda4d09e062aa5e4a390b0a572ac0d2c0220'),
(2, 'anousak', 'anousak1@gmail.com', '7110eda4d09e062aa5e4a390b0a572ac0d2c0220'),
(3, 'gogo', 'gogo@hotmail.fr', '7110eda4d09e062aa5e4a390b0a572ac0d2c0220'),
(4, 'toto', 'toto@hotmail.fr', '7110eda4d09e062aa5e4a390b0a572ac0d2c0220'),
(5, 'tata', 'tata@gmail.com', '7110eda4d09e062aa5e4a390b0a572ac0d2c0220');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

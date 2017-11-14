-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Sam 14 Mars 2015 à 14:11
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `synthese`
--

-- --------------------------------------------------------

--
-- Structure de la table `exercice`
--

CREATE TABLE IF NOT EXISTS `exercice` (
  `id_execice` varchar(4) NOT NULL,
  `nom_execice` varchar(20) NOT NULL,
  `type_execice` varchar(20) NOT NULL,
  PRIMARY KEY (`id_execice`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `exercice`
--

INSERT INTO `exercice` (`id_execice`, `nom_execice`, `type_execice`) VALUES
('01', 'endurance', 'aérobie'),
('02', 'haltères', 'anaérobie'),
('03', 'étirement', 'flexibilité');

-- --------------------------------------------------------

--
-- Structure de la table `poids`
--

CREATE TABLE IF NOT EXISTS `poids` (
  `id_poids` varchar(4) NOT NULL,
  `poids_actuel` double NOT NULL,
  PRIMARY KEY (`id_poids`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `poids`
--

INSERT INTO `poids` (`id_poids`, `poids_actuel`) VALUES
('01', 63.1);

-- --------------------------------------------------------

--
-- Structure de la table `sport`
--

CREATE TABLE IF NOT EXISTS `sport` (
  `id_sport` varchar(4) NOT NULL,
  `nom_sport` varchar(20) NOT NULL,
  PRIMARY KEY (`id_sport`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `sport`
--

INSERT INTO `sport` (`id_sport`, `nom_sport`) VALUES
('01', 'Aikido'),
('02', 'Alpinisme'),
('03', 'Apnée'),
('04', 'Athlétisme'),
('05', 'Aviron'),
('06', 'Badminton'),
('07', 'BMX'),
('08', 'Bodyboard'),
('09', 'Boomerang'),
('10', 'Bowling'),
('11', 'Boxe'),
('12', 'Canoë kayak'),
('13', 'Capoeira'),
('14', 'Course à pied'),
('15', 'Cyclisme'),
('16', 'Danse'),
('17', 'Equitation'),
('18', 'Escalade'),
('19', 'Escrime'),
('20', 'Fitness'),
('21', 'Force athlétique'),
('22', 'Golf'),
('23', 'Gymnastique'),
('24', 'Haltérophilie'),
('25', 'Jeet kune do'),
('26', 'Ju-Jitsu'),
('27', 'Judo'),
('28', 'Karaté'),
('29', 'Karting'),
('30', 'Kempo'),
('31', 'Kendo'),
('32', 'Kick boxing'),
('33', 'Kung fu'),
('34', 'Luge'),
('35', 'Lutte'),
('36', 'Marche athlétique'),
('37', 'Moto cross'),
('38', 'Musculation'),
('39', 'Naginata'),
('40', 'Natation'),
('41', 'Ninjitsu'),
('42', 'Parachutisme'),
('43', 'Patinage artistique'),
('44', 'Pétanque'),
('45', 'Planche à voile'),
('46', 'Plongée'),
('47', 'Rallye'),
('48', 'Randonnée'),
('49', 'Roller'),
('50', 'Sambo'),
('51', 'Skateboard'),
('52', 'Ski'),
('53', 'Snowboard'),
('54', 'Sumo'),
('55', 'Surf'),
('56', 'Taekwondo'),
('57', 'Tennis'),
('58', 'Tennis de table'),
('59', 'Tir sportif'),
('60', 'Triathlon'),
('61', 'Voile'),
('62', 'VTT'),
('63', 'Yoga');

-- --------------------------------------------------------

--
-- Structure de la table `temps`
--

CREATE TABLE IF NOT EXISTS `temps` (
  `id_temps` varchar(4) NOT NULL,
  `heure` int(11) NOT NULL,
  `miniute` int(11) NOT NULL,
  `seconde` int(11) NOT NULL,
  PRIMARY KEY (`id_temps`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `temps`
--

INSERT INTO `temps` (`id_temps`, `heure`, `miniute`, `seconde`) VALUES
('01', 4, 32, 12);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id_utilisateur` varchar(4) NOT NULL,
  `sexe` varchar(10) NOT NULL,
  `nom_utilisateur` varchar(20) NOT NULL,
  `prenom_utilisateur` varchar(20) NOT NULL,
  `id_sport` varchar(4) NOT NULL,
  `mdp` varchar(2) NOT NULL,
  PRIMARY KEY (`id_utilisateur`),
  KEY `id_sport` (`id_sport`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id_utilisateur`, `sexe`, `nom_utilisateur`, `prenom_utilisateur`, `id_sport`, `mdp`) VALUES
('01', 'M', 'Miller', 'Richard', '02', 'bd'),
('02', 'M', 'Grant', 'Alain', '01', 'bd'),
('03', 'Mme', 'Chanteloup', 'Sandrine', '05', 'bd'),
('04', 'M', 'Dos Santos', 'Alexandre', '03', 'bd'),
('05', 'Mme', 'Dumas', 'Catherine', '05', 'bd'),
('M', '10', 'mister', 'Lee', '0', 'bd'),
('mme', '45', 'koko', 'kaka', '0', 'bd');

-- --------------------------------------------------------

--
-- Structure de la table `vitesse`
--

CREATE TABLE IF NOT EXISTS `vitesse` (
  `id_vitesse` varchar(4) NOT NULL,
  `vitesseMax` double NOT NULL,
  `vitesseMin` double NOT NULL,
  PRIMARY KEY (`id_vitesse`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `vitesse`
--

INSERT INTO `vitesse` (`id_vitesse`, `vitesseMax`, `vitesseMin`) VALUES
('01', 54.8, 34.1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 24, 2022 at 07:29 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `footballMatch`
--

-- --------------------------------------------------------

--
-- Table structure for table `football_player`
--

CREATE TABLE `football_player` (
  `fid` int(11) NOT NULL,
  `age` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `football_player`
--

INSERT INTO `football_player` (`fid`, `age`, `email`, `name`, `password`, `surname`) VALUES
(1, 29, 'deniz@mail.com', 'Deniz', '58b1216b06850385d9a4eadbedc806c4', 'Balcı'),
(2, 23, 'ali@mail.com', 'Ali', '58b1216b06850385d9a4eadbedc806c4', 'Bilir'),
(3, 25, 'ahmet@mail.com', 'Ahmet', '58b1216b06850385d9a4eadbedc806c4', 'Bilsin'),
(4, 20, 'arda@mail.com', 'Arda', '58b1216b06850385d9a4eadbedc806c4', 'Bildi'),
(5, 20, 'veli@mail.com', 'Veli', '58b1216b06850385d9a4eadbedc806c4', 'Bilki'),
(6, 36, 'fernando@mail.com', 'Fernando', '58b1216b06850385d9a4eadbedc806c4', 'Muslera'),
(7, 26, 'okan@mail.com', 'Okan', '58b1216b06850385d9a4eadbedc806c4', 'Kocuk'),
(8, 23, 'batuhan@mail.com', 'Batuhan', '58b1216b06850385d9a4eadbedc806c4', 'Sen'),
(9, 21, 'kaan@mail.com', 'Kaan', '58b1216b06850385d9a4eadbedc806c4', 'Arslan'),
(10, 23, 'gökay@mail.com', 'Gökay', '58b1216b06850385d9a4eadbedc806c4', 'Güney'),
(11, 26, 'emre@mail.com', 'Emre', '58b1216b06850385d9a4eadbedc806c4', 'Taşdemir'),
(12, 29, 'emrea@mail.com', 'Emre', '58b1216b06850385d9a4eadbedc806c4', 'Akbaba'),
(13, 22, 'yunus@mail.com', 'Yunus', '58b1216b06850385d9a4eadbedc806c4', 'Akgün'),
(14, 27, 'taylan@mail.com', 'Taylan', '58b1216b06850385d9a4eadbedc806c4', 'Antalyalı'),
(15, 24, 'altay@mail.com', 'Altay', '58b1216b06850385d9a4eadbedc806c4', 'Bayındır'),
(16, 31, 'serdar@mail.com', 'Serdar', '58b1216b06850385d9a4eadbedc806c4', 'Aziz'),
(17, 22, 'ferdi@mail.com', 'Ferdi', '58b1216b06850385d9a4eadbedc806c4', 'Kadioglu'),
(18, 32, 'filip@mail.com', 'Filip', '58b1216b06850385d9a4eadbedc806c4', 'Novak'),
(19, 28, 'nazim@mail.com', 'Nazim', '58b1216b06850385d9a4eadbedc806c4', 'Sangare'),
(20, 27, 'irfan@mail.com', 'Irfan Can', '58b1216b06850385d9a4eadbedc806c4', 'Kahveci'),
(21, 27, 'mert@mail.com', 'Mert Hakan', '58b1216b06850385d9a4eadbedc806c4', 'Yandas'),
(22, 19, 'ardag@mail.com', 'Arda', '58b1216b06850385d9a4eadbedc806c4', 'Güler'),
(23, 24, 'diego@mail.com', 'Diego', '58b1216b06850385d9a4eadbedc806c4', 'Rossi'),
(24, 24, 'emrem@mail.com', 'Emre', '58b1216b06850385d9a4eadbedc806c4', 'Mor'),
(25, 19, 'tiago@mail.com', 'Tiago', '58b1216b06850385d9a4eadbedc806c4', 'Cukur'),
(26, 29, 'ally@mail.com', 'Ally', '58b1216b06850385d9a4eadbedc806c4', 'Samata'),
(27, 29, 'ozan@mail.com', 'Ozan', '58b1216b06850385d9a4eadbedc806c4', 'Tufan'),
(28, 21, 'berke@mail.com', 'Berke', '58b1216b06850385d9a4eadbedc806c4', 'Ozer'),
(29, 23, 'diegor@mail.com', 'Diego', '58b1216b06850385d9a4eadbedc806c4', 'Rossi'),
(30, 35, 'bulent@mail.com', 'Bulent', '58b1216b06850385d9a4eadbedc806c4', 'Korkmaz'),
(31, 33, 'okanb@mail.com', 'Okan', '58b1216b06850385d9a4eadbedc806c4', 'Buruk'),
(32, 30, 'umıt@mail.com', 'Umit', '58b1216b06850385d9a4eadbedc806c4', 'Davala'),
(33, 31, 'omer@mail.com', 'Omer', '58b1216b06850385d9a4eadbedc806c4', 'Bayram'),
(34, 22, 'eren@mail.com', 'Eren', '58b1216b06850385d9a4eadbedc806c4', 'Aydın'),
(35, 40, 'fatih@mail.com', 'Fatih', '58b1216b06850385d9a4eadbedc806c4', 'Terim');

-- --------------------------------------------------------

--
-- Table structure for table `join_team_player`
--

CREATE TABLE `join_team_player` (
  `fid` int(11) NOT NULL,
  `age` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `team` varchar(255) DEFAULT NULL,
  `tid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `team`
--

CREATE TABLE `team` (
  `tid` int(11) NOT NULL,
  `fid` int(11) DEFAULT NULL,
  `team` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `team`
--

INSERT INTO `team` (`tid`, `fid`, `team`) VALUES
(1, 1, 'A'),
(2, 2, 'B'),
(3, 3, 'A'),
(4, 4, 'B'),
(5, 5, 'A'),
(6, 6, 'A'),
(7, 7, 'A'),
(8, 8, 'A'),
(9, 9, 'A'),
(10, 10, 'A'),
(11, 11, 'A'),
(12, 12, 'A'),
(13, 13, 'A'),
(14, 14, 'A'),
(15, 15, 'B'),
(16, 16, 'B'),
(17, 17, 'B'),
(18, 18, 'B'),
(19, 19, 'B'),
(20, 20, 'B'),
(21, 21, 'B'),
(22, 22, 'B'),
(23, 23, 'B'),
(24, 24, 'B'),
(25, 25, 'B'),
(26, 26, 'B'),
(27, 27, 'B'),
(28, 28, 'B'),
(29, 29, 'B'),
(30, 30, 'A'),
(31, 31, 'A'),
(32, 32, 'A'),
(33, 33, 'A'),
(34, 34, 'A'),
(35, 35, 'A');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `football_player`
--
ALTER TABLE `football_player`
  ADD PRIMARY KEY (`fid`),
  ADD UNIQUE KEY `UK_p6hyo19on9s7emin30uvmm95g` (`email`);

--
-- Indexes for table `join_team_player`
--
ALTER TABLE `join_team_player`
  ADD PRIMARY KEY (`fid`);

--
-- Indexes for table `team`
--
ALTER TABLE `team`
  ADD PRIMARY KEY (`tid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `football_player`
--
ALTER TABLE `football_player`
  MODIFY `fid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT for table `team`
--
ALTER TABLE `team`
  MODIFY `tid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

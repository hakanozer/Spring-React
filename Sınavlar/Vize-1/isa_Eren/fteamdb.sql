-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 24 Tem 2022, 07:35:05
-- Sunucu sürümü: 10.4.24-MariaDB
-- PHP Sürümü: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `fteamdb`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `footballer`
--

CREATE TABLE `footballer` (
  `fid` int(11) NOT NULL,
  `age` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `f_name` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  `surname` varchar(30) DEFAULT NULL,
  `team_tid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `footballer`
--

INSERT INTO `footballer` (`fid`, `age`, `email`, `f_name`, `password`, `surname`, `team_tid`) VALUES
(3, 35, 'adf@gmail.com', 'Gerard', '1234', 'Pique', 3),
(6, 31, 'afd@gmail.com', 'Robert', '1234', 'Khan', 4);

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `join_foot_team`
--

CREATE TABLE `join_foot_team` (
  `fid` int(11) NOT NULL,
  `f_name` varchar(255) DEFAULT NULL,
  `t_name` varchar(255) DEFAULT NULL,
  `tid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `team`
--

CREATE TABLE `team` (
  `tid` int(11) NOT NULL,
  `t_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `team`
--

INSERT INTO `team` (`tid`, `t_name`) VALUES
(3, 'A'),
(4, 'B');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `team_footballer_list`
--

CREATE TABLE `team_footballer_list` (
  `team_tid` int(11) NOT NULL,
  `footballer_list_fid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `footballer`
--
ALTER TABLE `footballer`
  ADD PRIMARY KEY (`fid`),
  ADD UNIQUE KEY `UK_ej557xjl1fi78ko6q9f1fedbm` (`email`),
  ADD KEY `FK7wc4rcqx734shh2hp72g1qcd4` (`team_tid`);

--
-- Tablo için indeksler `join_foot_team`
--
ALTER TABLE `join_foot_team`
  ADD PRIMARY KEY (`fid`);

--
-- Tablo için indeksler `team`
--
ALTER TABLE `team`
  ADD PRIMARY KEY (`tid`);

--
-- Tablo için indeksler `team_footballer_list`
--
ALTER TABLE `team_footballer_list`
  ADD UNIQUE KEY `UK_khds7e1bklxyjfgunuuaj2mju` (`footballer_list_fid`),
  ADD KEY `FK3xn8fesl9s22df6mi3yv9h57m` (`team_tid`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `footballer`
--
ALTER TABLE `footballer`
  MODIFY `fid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Tablo için AUTO_INCREMENT değeri `team`
--
ALTER TABLE `team`
  MODIFY `tid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Dökümü yapılmış tablolar için kısıtlamalar
--

--
-- Tablo kısıtlamaları `footballer`
--
ALTER TABLE `footballer`
  ADD CONSTRAINT `FK7wc4rcqx734shh2hp72g1qcd4` FOREIGN KEY (`team_tid`) REFERENCES `team` (`tid`);

--
-- Tablo kısıtlamaları `team_footballer_list`
--
ALTER TABLE `team_footballer_list`
  ADD CONSTRAINT `FK3xn8fesl9s22df6mi3yv9h57m` FOREIGN KEY (`team_tid`) REFERENCES `team` (`tid`),
  ADD CONSTRAINT `FKel81w8ikkn2bc5ka6k00n4nw9` FOREIGN KEY (`footballer_list_fid`) REFERENCES `footballer` (`fid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

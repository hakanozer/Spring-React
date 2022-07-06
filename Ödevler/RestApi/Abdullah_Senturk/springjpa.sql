-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 07 Tem 2022, 00:23:40
-- Sunucu sürümü: 10.4.24-MariaDB
-- PHP Sürümü: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `springjpa`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `note`
--

CREATE TABLE `note` (
  `nid` int(11) NOT NULL,
  `date` datetime DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `note`
--

INSERT INTO `note` (`nid`, `date`, `detail`, `title`) VALUES
(1, '2022-07-03 11:34:11', 'Vasat Ogrenci', 'Asya Okul Notu'),
(2, '2022-07-03 11:34:47', 'Vasat Ogrenci', 'Metin Okul Notu');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `user`
--

CREATE TABLE `user` (
  `uid` int(11) NOT NULL,
  `age` int(11) NOT NULL,
  `email` varchar(150) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `user`
--

INSERT INTO `user` (`uid`, `age`, `email`, `name`, `password`, `surname`) VALUES
(1, 23, 'm@mail.com', 'Metin', 'f32b134cd5663fa3dfc1e1f93de18640', 'Senturk'),
(2, 30, 'a@mail.com', 'a', '123', 'b'),
(3, 67, 're@mail.com', 'Recep', '70b3d30da575e04c9b54b56741f9e29e', 'Senturk'),
(4, 32, 'be@mail.com', 'Burak', '5f4ae39f7c935173caf5a8343d6e76e9', 'Senturk'),
(5, 38, 'ec@mail.com', 'Ece', '90e8c040f2fe0ffc22cad010258847c3', 'Senturk'),
(6, 45, 'em@mail.com', 'Emin', '6e56230070d4c06b8d648b2b953f6a08', 'Senturk');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `note`
--
ALTER TABLE `note`
  ADD PRIMARY KEY (`nid`);

--
-- Tablo için indeksler `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`uid`),
  ADD UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `note`
--
ALTER TABLE `note`
  MODIFY `nid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Tablo için AUTO_INCREMENT değeri `user`
--
ALTER TABLE `user`
  MODIFY `uid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

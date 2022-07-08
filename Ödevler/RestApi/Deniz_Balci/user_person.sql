-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Anamakine: localhost
-- Üretim Zamanı: 06 Tem 2022, 21:23:00
-- Sunucu sürümü: 10.4.21-MariaDB
-- PHP Sürümü: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `restusercontrol`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `user_person`
--

CREATE TABLE `user_person` (
  `uid` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(13) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `surname` varchar(13) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Tablo döküm verisi `user_person`
--

INSERT INTO `user_person` (`uid`, `email`, `name`, `password`, `surname`) VALUES
(1, 'person1@mail.com', 'PersonUpdate', '2ff3cd6d75b9630f13a79e2774d82276', 'SurnameUpdate'),
(2, 'person2@mail.com', 'Person2', '11c9d86c831222eb8478e79e5fa1e9bc', 'Surname2'),
(3, 'person3@mail.com', 'Person3', '11c9d86c831222eb8478e79e5fa1e9bc', 'Surname3');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `user_person`
--
ALTER TABLE `user_person`
  ADD PRIMARY KEY (`uid`),
  ADD UNIQUE KEY `UK_ql4hek6lao2mbnbor60lvf10b` (`email`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `user_person`
--
ALTER TABLE `user_person`
  MODIFY `uid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

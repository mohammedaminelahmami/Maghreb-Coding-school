-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 28, 2022 at 12:55 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `magcoding`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `idAdmin` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`idAdmin`, `username`, `password`, `email`) VALUES
(1, 'admin', 'test2009', 'admin@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `apprenant`
--

CREATE TABLE `apprenant` (
  `id` int(11) NOT NULL,
  `fullName` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `idP` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `apprenant`
--

INSERT INTO `apprenant` (`id`, `fullName`, `username`, `password`, `idP`) VALUES
(5, 'Mohammed Amine LAHMAMAI', 'amine0029', '123456', 3);

-- --------------------------------------------------------

--
-- Table structure for table `brief`
--

CREATE TABLE `brief` (
  `id` int(11) NOT NULL,
  `context` varchar(255) NOT NULL,
  `deadline` int(11) NOT NULL,
  `idP` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `brief`
--

INSERT INTO `brief` (`id`, `context`, `deadline`, `idP`) VALUES
(1, 'hello world in java', 7, 3);

-- --------------------------------------------------------

--
-- Table structure for table `formateur`
--

CREATE TABLE `formateur` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `fullName` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `formateur`
--

INSERT INTO `formateur` (`id`, `username`, `fullName`, `password`) VALUES
(4, 'acharf0029', 'Achraf blabla', '123456');

-- --------------------------------------------------------

--
-- Table structure for table `promotion`
--

CREATE TABLE `promotion` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `idF` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `promotion`
--

INSERT INTO `promotion` (`id`, `name`, `idF`) VALUES
(3, 'Margaret Hamilton', 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`idAdmin`);

--
-- Indexes for table `apprenant`
--
ALTER TABLE `apprenant`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idP` (`idP`);

--
-- Indexes for table `brief`
--
ALTER TABLE `brief`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idPromo` (`idP`);

--
-- Indexes for table `formateur`
--
ALTER TABLE `formateur`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `promotion`
--
ALTER TABLE `promotion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idF` (`idF`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `idAdmin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `apprenant`
--
ALTER TABLE `apprenant`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `brief`
--
ALTER TABLE `brief`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `formateur`
--
ALTER TABLE `formateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `promotion`
--
ALTER TABLE `promotion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `apprenant`
--
ALTER TABLE `apprenant`
  ADD CONSTRAINT `idP` FOREIGN KEY (`idP`) REFERENCES `promotion` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `brief`
--
ALTER TABLE `brief`
  ADD CONSTRAINT `idPromo` FOREIGN KEY (`idP`) REFERENCES `promotion` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `promotion`
--
ALTER TABLE `promotion`
  ADD CONSTRAINT `idF` FOREIGN KEY (`idF`) REFERENCES `formateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

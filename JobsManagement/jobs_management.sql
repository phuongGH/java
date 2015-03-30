-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 30, 2014 at 04:33 PM
-- Server version: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `jobs_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `fraction`
--

CREATE TABLE IF NOT EXISTS `fraction` (
  `FractionID` int(6) NOT NULL AUTO_INCREMENT,
  `FractionName` varchar(250) COLLATE utf8_unicode_ci NOT NULL,
  `JobID` int(6) NOT NULL,
  `rate` int(1) NOT NULL,
  `Status` set('1','0') COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`FractionID`),
  KEY `FK_fraction_Job` (`JobID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `job`
--

CREATE TABLE IF NOT EXISTS `job` (
  `JobID` int(6) NOT NULL AUTO_INCREMENT,
  `JobName` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `JobDescription` varchar(250) COLLATE utf8_unicode_ci DEFAULT NULL,
  `StartDate` date DEFAULT NULL,
  `EndDate` date DEFAULT NULL,
  PRIMARY KEY (`JobID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `jobsinday`
--

CREATE TABLE IF NOT EXISTS `jobsinday` (
  `JobsInDayID` int(6) NOT NULL AUTO_INCREMENT,
  `JobID` int(6) NOT NULL,
  PRIMARY KEY (`JobsInDayID`),
  KEY `FK_JobsInDay_Job` (`JobID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `jobsindaydetail`
--

CREATE TABLE IF NOT EXISTS `jobsindaydetail` (
  `JobsInDayDetailID` int(6) NOT NULL AUTO_INCREMENT,
  `CurrentDate` date NOT NULL,
  `JobID` int(6) NOT NULL,
  PRIMARY KEY (`JobsInDayDetailID`),
  KEY `FK_jobsindaydetail_Job` (`JobID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `fraction`
--
ALTER TABLE `fraction`
  ADD CONSTRAINT `FK_fraction_Job` FOREIGN KEY (`JobID`) REFERENCES `job` (`JobID`);

--
-- Constraints for table `jobsinday`
--
ALTER TABLE `jobsinday`
  ADD CONSTRAINT `FK_JobsInDay_Job` FOREIGN KEY (`JobID`) REFERENCES `job` (`JobID`);

--
-- Constraints for table `jobsindaydetail`
--
ALTER TABLE `jobsindaydetail`
  ADD CONSTRAINT `FK_jobsindaydetail_Job` FOREIGN KEY (`JobID`) REFERENCES `job` (`JobID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 25, 2014 at 05:27 PM
-- Server version: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: restaurant_db
--

-- --------------------------------------------------------

--
-- Table structure for table bookingdetails
--

CREATE TABLE IF NOT EXISTS bookingdetails (
  Booking_ID int(11) NOT NULL AUTO_INCREMENT,
  Day_Booking date NOT NULL,
  DayStart int(11) NOT NULL,
  TimeStart datetime NOT NULL,
  NumPerson int(11) NOT NULL,
  Table_ID int(11) NOT NULL,
  Customer_ID int(11) NOT NULL,
  PRIMARY KEY (Booking_ID),
  KEY FK_bookingdetails_table_t (Table_ID),
  KEY FK_bookingdetails_customer (Customer_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table categorizetable
--

CREATE TABLE IF NOT EXISTS categorizetable (
  CategorizeTable_id int(11) NOT NULL AUTO_INCREMENT,
  CategorizeTable_Name varchar(255),
  Description varchar(255) NOT NULL,
  PRIMARY KEY (CategorizeTable_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1 ;

--
-- Dumping data for table categorizetable
--

INSERT INTO categorizetable ( CategorizeTable_Name, Description) VALUES
('Pub_01', 'air conditioning, public'),
('Pub_02', 'air conditioning, public'),
('VIP', 'air conditioning, private');

-- --------------------------------------------------------

--
-- Table structure for table customer
--

CREATE TABLE IF NOT EXISTS customer (
  customer_ID int(11) NOT NULL,
  Name varchar(120) NOT NULL,
  Phone int(11) NOT NULL,
  Email varchar(255) NOT NULL,
  PRIMARY KEY (customer_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table table_t
--

CREATE TABLE IF NOT EXISTS table_t (
  Table_ID int(11) NOT NULL,
  MaxPerson int(11) NOT NULL,
  CategorizeTable_ID int(11) NOT NULL,
  Status int(11) NOT NULL,
  PRIMARY KEY (Table_ID),
  KEY FK_table_t_categorizetable (CategorizeTable_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table table_t
--

INSERT INTO table_t (Table_ID, MaxPerson, CategorizeTable_ID, Status) VALUES
(1, 6, 1, 0),
(2, 6, 1, 0),
(3, 0, 1, 0),
(7, 10, 2, 0),
(8, 6, 2, 0);

--
-- Constraints for dumped tables
--

--
-- Constraints for table bookingdetails
--
ALTER TABLE bookingdetails
  ADD CONSTRAINT FK_bookingdetails_customer FOREIGN KEY (Customer_ID) REFERENCES customer (customer_ID),
  ADD CONSTRAINT FK_bookingdetails_table_t FOREIGN KEY (Table_ID) REFERENCES table_t (Table_ID);

--
-- Constraints for table table_t
--
ALTER TABLE table_t
  ADD CONSTRAINT FK_table_t_categorizetable FOREIGN KEY (CategorizeTable_ID) REFERENCES categorizetable (CategorizeTable_ID);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

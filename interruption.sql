-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 15, 2022 at 02:51 PM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `electrogrid`
--

-- --------------------------------------------------------

--
-- Table structure for table `interruption`
--

CREATE TABLE `interruption` (
  `interruptionID` int(10) NOT NULL,
  `date` varchar(20) NOT NULL,
  `timeSlot` varchar(20) NOT NULL,
  `locationID` varchar(20) NOT NULL,
  `area` varchar(30) NOT NULL,
  `reason` varchar(200) NOT NULL,
  `status` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `interruption`
--

INSERT INTO `interruption` (`interruptionID`, `date`, `timeSlot`, `locationID`, `area`, `reason`, `status`) VALUES
(5, '08-08-2022', '10.30 - 13.30', 'P', 'Piliyandala', 'No Diesel', 'Pending'),
(9, '12-04-2022', '07.30 - 11.30', 'H', 'Kiridiwala', 'No Diesel', 'Pending'),
(15, '05-05-2022', '07.30 - 11.30', 'S', 'Rathnapura', 'No Rain', 'Done'),
(16, '18-04-2022', '13.30 - 17.30', 'R', 'Haggalla', 'No Water', 'Done'),
(17, '12-04-2022', '07.30 - 11.30', 'H', 'Kiridiwala', 'No Diesel', 'Done'),
(18, '12-04-2022', '07.30 - 12.30', 'U', 'Radawana', 'No Diesel', 'Done'),
(19, '06-05-2022', '9.30 - 11.30', 'W', 'Horagolla', 'No Water', 'Done'),
(20, '22-05-2022', '08.30 - 10.30', 'P', 'Kadawatha', 'No Diesel', 'Done'),
(22, '08-06-2022', '11.30 - 12.30', 'U', 'Pilimathalawa', 'No Diesel', 'Pending');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `interruption`
--
ALTER TABLE `interruption`
  ADD PRIMARY KEY (`interruptionID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `interruption`
--
ALTER TABLE `interruption`
  MODIFY `interruptionID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

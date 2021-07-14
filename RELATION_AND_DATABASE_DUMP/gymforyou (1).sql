-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Lug 14, 2021 alle 18:50
-- Versione del server: 10.4.6-MariaDB
-- Versione PHP: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `gymforyou`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `consultazione`
--

CREATE TABLE `consultazione` (
  `id` int(255) NOT NULL,
  `utente` varchar(255) NOT NULL,
  `dottore` varchar(255) DEFAULT NULL,
  `trainer` varchar(255) DEFAULT NULL,
  `categoria` varchar(255) NOT NULL,
  `domanda` varchar(255) NOT NULL,
  `risposta` varchar(255) DEFAULT NULL,
  `voto` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `credenziali`
--

CREATE TABLE `credenziali` (
  `id` int(5) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(32) NOT NULL,
  `type` varchar(3) NOT NULL DEFAULT 'usr'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `credenziali`
--

INSERT INTO `credenziali` (`id`, `email`, `password`, `type`) VALUES
(22, 'admin@admin.it', 'f6fdffe48c908deb0f4c3bd36c032e72', 'adm'),
(63, 'medicomedico', '0a79e66afa6e537a23dc62438f56c148', 'med'),
(64, 'trainer@trainer.it', 'c93216f92bc1e10d2bfa76be93bac1aa', 'trn'),
(68, 'trainer2@trainer2.it', 'c93216f92bc1e10d2bfa76be93bac1aa', 'trn');

-- --------------------------------------------------------

--
-- Struttura della tabella `diario`
--

CREATE TABLE `diario` (
  `id` int(5) NOT NULL,
  `utente` varchar(255) NOT NULL,
  `tipo` varchar(255) NOT NULL,
  `parte_corpo` varchar(255) DEFAULT NULL,
  `giorni` varchar(255) DEFAULT NULL,
  `mattina` varchar(255) DEFAULT NULL,
  `pomeriggio` varchar(255) DEFAULT NULL,
  `sera` varchar(255) DEFAULT NULL,
  `calorie` varchar(255) DEFAULT NULL,
  `trainer` varchar(255) DEFAULT NULL,
  `fabbisogno` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `dottore`
--

CREATE TABLE `dottore` (
  `email` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `cognome` varchar(255) NOT NULL,
  `voto` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `dottore`
--

INSERT INTO `dottore` (`email`, `nome`, `cognome`, `voto`) VALUES
('francescobiasi', 'francesco', 'biasi', 4.5),
('medicomedico', 'medico', 'medico', NULL);

-- --------------------------------------------------------

--
-- Struttura della tabella `esercizi`
--

CREATE TABLE `esercizi` (
  `id` int(5) NOT NULL,
  `email` varchar(255) NOT NULL,
  `tipo` varchar(255) NOT NULL,
  `Lunedi` mediumtext DEFAULT NULL,
  `Martedi` mediumtext DEFAULT NULL,
  `Mercoledi` mediumtext DEFAULT NULL,
  `Giovedi` mediumtext DEFAULT NULL,
  `Venerdi` mediumtext DEFAULT NULL,
  `Sabato` mediumtext DEFAULT NULL,
  `Domenica` mediumtext DEFAULT NULL,
  `data` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `fabbisogno` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `esercizicorso`
--

CREATE TABLE `esercizicorso` (
  `id` int(5) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `trainer` varchar(255) NOT NULL,
  `1` varchar(255) NOT NULL,
  `2` varchar(255) NOT NULL,
  `3` varchar(255) NOT NULL,
  `4` varchar(255) NOT NULL,
  `5` varchar(255) NOT NULL,
  `6` varchar(255) NOT NULL,
  `7` varchar(255) NOT NULL,
  `8` varchar(255) NOT NULL,
  `9` varchar(255) NOT NULL,
  `10` varchar(255) NOT NULL,
  `11` varchar(255) DEFAULT NULL,
  `12` varchar(255) DEFAULT NULL,
  `13` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `esercizicorso`
--

INSERT INTO `esercizicorso` (`id`, `nome`, `trainer`, `1`, `2`, `3`, `4`, `5`, `6`, `7`, `8`, `9`, `10`, `11`, `12`, `13`) VALUES
(1, 'Crossfit', 'trainer@trainer.it', 'Air Squat,9,15', 'Squat con sovraccarico,9,17', 'Burpee,8,8', 'Push up,8,10', 'Stacco da terra,9,7', 'Sit up,8,12', 'Flutter kick,7,13', 'Hspu,9,10', 'Tuck jumps,8,12', 'Mountain climber,7,20', 'Esame,7,13', NULL, NULL),
(2, 'Calisthenics', 'trainer@trainer.it', 'Triceps Dips,7,15', 'Piegamenti a terra,8,13', 'Piegamenti in verticale,9,7', 'Hollow push ups,8,12', 'Plank addominali,7,10', 'Barchetta,8,11', 'Affondi frontali,8,14', 'Plank laterale,9,10', 'Crunch addominale,8,15', 'V push ups,8,10', NULL, NULL, NULL),
(3, 'JuJitsu', 'trainer2@trainer2.it', 'Affondi,8,12', 'Squat,9,11', 'Rematore,8,12', 'Tirate al mento,8,13', 'Spinte del bacino,7,15', 'Pull over,8,14', 'Curl da seduti,8,11', 'Curl in concentrazione,8,10', 'Burpee,8,12', 'Piegamenti,8,15', NULL, NULL, NULL),
(4, 'Boxe', 'trainer2@trainer2.it', 'Clapping push up,8,15', 'Burpee,8,12', 'Pugni,9,14', 'Spider man,8,12', 'Piegamenti a diamante,8,13', 'Salto alla corda,9,50', 'Rotazione spalle avanti,7,14', 'Single arm biceps curl,8,10', 'Up downs,8,12', 'V Up,9,11', 'Gskianto,8,150', NULL, NULL),
(5, 'Funzionale', 'trainer2@trainer2.it', 'Farmer s Walk,8,20', 'Wall Push ups,8,16', 'Pull up,8,10', 'Crab Reach,8,12', 'Jump Squat,9,14', 'Turkish get up,8,17', 'Dumbbell Thruster,9,17', 'Glute bridge,7,15', 'Lateral Lunge,7,13', 'Woodchop,8,12', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Struttura della tabella `esercizischeda`
--

CREATE TABLE `esercizischeda` (
  `id` int(5) NOT NULL,
  `parte` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `met` double NOT NULL,
  `rep` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `esercizischeda`
--

INSERT INTO `esercizischeda` (`id`, `parte`, `nome`, `met`, `rep`) VALUES
(1, 'Petto', 'Piegamenti a braccia aperte', 8, 15),
(2, 'Petto', 'Piegamenti in ginocchio', 8, 16),
(3, 'Petto', 'Push up and rotate', 8, 17),
(4, 'Petto', 'Piegamenti Hindu', 8, 12),
(5, 'Petto', 'Burpee', 8, 13),
(6, 'Bicipiti', 'Piegamenti al muro', 8, 10),
(7, 'Bicipiti', 'Zottman Curl', 8, 11),
(8, 'Bicipiti', 'Pugni', 9.5, 13),
(9, 'Bicipiti', 'Narrow push-up', 8, 17),
(10, 'Bicipiti', 'Triceps bow', 7, 15),
(11, 'Avambracci', 'Curl in piedi', 8, 14),
(12, 'Avambracci', 'Reverse curl', 8, 14),
(13, 'Avambracci', 'Press pulse al Petto', 8, 17),
(14, 'Avambracci', 'Wrist curl', 8, 15),
(15, 'Avambracci', 'Hammer curl', 8, 15),
(16, 'Cosce', 'Squat', 9, 20),
(17, 'Cosce', 'Sollevamento laterale gambe', 8.5, 18),
(18, 'Cosce', 'Affondi', 8.5, 17),
(19, 'Cosce', 'Step up', 8.5, 18),
(20, 'Cosce', 'Boxe jump', 7, 19),
(21, 'Polpacci', 'Spinta polpacci in piedi', 8.5, 17),
(22, 'Polpacci', 'Calcio posteriore', 8.7, 16),
(23, 'Polpacci', 'Spinta polpacci sul gradino', 8.9, 14),
(24, 'Polpacci', 'Affondo incrociato', 8.5, 16),
(25, 'Polpacci', 'Saltelli sola gamba', 8.7, 17);

-- --------------------------------------------------------

--
-- Struttura della tabella `misure`
--

CREATE TABLE `misure` (
  `email` varchar(255) NOT NULL,
  `petto_iniz` float DEFAULT 0,
  `bicipite_iniz` float DEFAULT 0,
  `avambraccio_iniz` float DEFAULT 0,
  `cosce_iniz` float DEFAULT 0,
  `polpacci_iniz` float DEFAULT 0,
  `petto_inter` float DEFAULT 0,
  `bicipite_inter` float DEFAULT 0,
  `avambraccio_inter` float DEFAULT 0,
  `cosce_inter` float DEFAULT 0,
  `polpacci_inter` float DEFAULT 0,
  `petto_final` float DEFAULT 0,
  `bicipite_final` float DEFAULT 0,
  `avambraccio_final` float DEFAULT 0,
  `cosce_final` float DEFAULT 0,
  `polpacci_final` float DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `questionario`
--

CREATE TABLE `questionario` (
  `email` varchar(255) NOT NULL,
  `prima` varchar(2) NOT NULL,
  `seconda` varchar(2) NOT NULL,
  `terza` varchar(2) NOT NULL,
  `quarta` varchar(2) NOT NULL,
  `quinta` varchar(2) NOT NULL,
  `sesta` varchar(2) NOT NULL,
  `settima` varchar(2) NOT NULL,
  `ottava` varchar(2) NOT NULL,
  `nona` varchar(2) NOT NULL,
  `decima` varchar(2) NOT NULL,
  `undicesima` varchar(2) NOT NULL,
  `dodicesima` varchar(2) NOT NULL,
  `tredicesima` varchar(2) NOT NULL,
  `esito` varchar(10) NOT NULL DEFAULT 'vuoto'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `trainer`
--

CREATE TABLE `trainer` (
  `email` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `cognome` varchar(255) NOT NULL,
  `voto` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `trainer`
--

INSERT INTO `trainer` (`email`, `nome`, `cognome`, `voto`) VALUES
('trainer2@trainer2.it', 'trainer2', 'trainer2', 3),
('trainer@trainer.it', 'trainer', 'trainer', 3);

-- --------------------------------------------------------

--
-- Struttura della tabella `utente`
--

CREATE TABLE `utente` (
  `id` int(5) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `cognome` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `genere` varchar(10) NOT NULL,
  `peso` float NOT NULL DEFAULT 0,
  `altezza` float NOT NULL DEFAULT 0,
  `polso` float DEFAULT 0,
  `caviglia` float DEFAULT 0,
  `crf_vita` float DEFAULT 0,
  `crf_collo` float DEFAULT 0,
  `crf_fianchi` float DEFAULT 0,
  `questionario` varchar(2) NOT NULL DEFAULT 'no',
  `massa_grassa` double NOT NULL DEFAULT 0,
  `massa_magra` double NOT NULL DEFAULT 0,
  `esito` varchar(10) NOT NULL DEFAULT 'vuoto'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `consultazione`
--
ALTER TABLE `consultazione`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `credenziali`
--
ALTER TABLE `credenziali`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `diario`
--
ALTER TABLE `diario`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `dottore`
--
ALTER TABLE `dottore`
  ADD PRIMARY KEY (`email`);

--
-- Indici per le tabelle `esercizi`
--
ALTER TABLE `esercizi`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `esercizicorso`
--
ALTER TABLE `esercizicorso`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `esercizischeda`
--
ALTER TABLE `esercizischeda`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `misure`
--
ALTER TABLE `misure`
  ADD PRIMARY KEY (`email`);

--
-- Indici per le tabelle `questionario`
--
ALTER TABLE `questionario`
  ADD PRIMARY KEY (`email`);

--
-- Indici per le tabelle `trainer`
--
ALTER TABLE `trainer`
  ADD PRIMARY KEY (`email`);

--
-- Indici per le tabelle `utente`
--
ALTER TABLE `utente`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `consultazione`
--
ALTER TABLE `consultazione`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT per la tabella `credenziali`
--
ALTER TABLE `credenziali`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=76;

--
-- AUTO_INCREMENT per la tabella `diario`
--
ALTER TABLE `diario`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=107;

--
-- AUTO_INCREMENT per la tabella `esercizi`
--
ALTER TABLE `esercizi`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=64;

--
-- AUTO_INCREMENT per la tabella `esercizicorso`
--
ALTER TABLE `esercizicorso`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT per la tabella `esercizischeda`
--
ALTER TABLE `esercizischeda`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT per la tabella `utente`
--
ALTER TABLE `utente`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

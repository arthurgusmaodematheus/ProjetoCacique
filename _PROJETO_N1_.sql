-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 26-Abr-2020 às 11:34
-- Versão do servidor: 10.4.11-MariaDB
-- versão do PHP: 7.2.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `projeton1`
--
CREATE DATABASE IF NOT EXISTS `projeton1` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `projeton1`;

-- --------------------------------------------------------

--
-- Estrutura da tabela `carro`
--
-- Criação: 26-Abr-2020 às 00:06
-- Última actualização: 26-Abr-2020 às 09:23
--

DROP TABLE IF EXISTS `carro`;
CREATE TABLE `carro` (
  `id` bigint(20) NOT NULL,
  `modelo` varchar(30) NOT NULL,
  `marca` varchar(20) NOT NULL,
  `ano` int(11) NOT NULL,
  `categoria` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `carro`
--

INSERT INTO `carro` (`id`, `modelo`, `marca`, `ano`, `categoria`) VALUES
(5, 'Agera', 'koenigsegg', 2020, 'super-esportivo'),
(6, 'uno', 'fiat', 2020, 'economico'),
(7, 'chiron', 'bugatti', 2020, 'super-esportivo');

-- --------------------------------------------------------

--
-- Estrutura da tabela `jogo`
--
-- Criação: 26-Abr-2020 às 00:07
-- Última actualização: 26-Abr-2020 às 09:26
--

DROP TABLE IF EXISTS `jogo`;
CREATE TABLE `jogo` (
  `id` bigint(20) NOT NULL,
  `nome_time_a` varchar(30) NOT NULL,
  `nome_time_b` varchar(30) NOT NULL,
  `gols_time_a` int(11) NOT NULL,
  `gols_time_b` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Extraindo dados da tabela `jogo`
--

INSERT INTO `jogo` (`id`, `nome_time_a`, `nome_time_b`, `gols_time_a`, `gols_time_b`) VALUES
(5, 'SPFC', 'Palmeiras', 5, 1),
(6, 'Corinthians', 'Flamengo', 2, 7),
(7, 'Brasil', 'Alemanha', 10, 1);

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `carro`
--
ALTER TABLE `carro`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `jogo`
--
ALTER TABLE `jogo`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `carro`
--
ALTER TABLE `carro`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `jogo`
--
ALTER TABLE `jogo`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 20/06/2023 às 19:38
-- Versão do servidor: 10.4.28-MariaDB
-- Versão do PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `planejador`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `despesas`
--

CREATE TABLE `despesas` (
  `Id` int(11) NOT NULL,
  `User` int(11) NOT NULL,
  `Mes` int(11) NOT NULL,
  `Ano` int(11) NOT NULL,
  `Categoria` varchar(220) NOT NULL,
  `Despesa` varchar(220) NOT NULL,
  `Mensal` double NOT NULL,
  `Ocasional` double NOT NULL,
  `Total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `despesas_ocasionais`
--

CREATE TABLE `despesas_ocasionais` (
  `Id` int(11) NOT NULL,
  `User` int(11) NOT NULL,
  `Mes` int(11) NOT NULL,
  `Ano` int(11) NOT NULL,
  `Fundo` varchar(220) NOT NULL,
  `Mensal` double NOT NULL,
  `Ocasional` double NOT NULL,
  `Total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `investimento`
--

CREATE TABLE `investimento` (
  `Id` int(11) NOT NULL,
  `User` int(11) NOT NULL,
  `Mes` int(11) NOT NULL,
  `Ano` int(11) NOT NULL,
  `Investimento` varchar(220) NOT NULL,
  `Mensal` double NOT NULL,
  `Ocasional` double NOT NULL,
  `Total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `rendimento`
--

CREATE TABLE `rendimento` (
  `Id` int(11) NOT NULL,
  `User` int(11) NOT NULL,
  `Mes` int(11) NOT NULL,
  `Ano` int(11) NOT NULL,
  `Categoria` varchar(220) NOT NULL,
  `Rendimento` varchar(220) NOT NULL,
  `Mensal` double NOT NULL,
  `Ocasional` double NOT NULL,
  `Total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `resumo_ano`
--

CREATE TABLE `resumo_ano` (
  `Id` int(11) NOT NULL,
  `User` int(11) NOT NULL,
  `Ano` int(11) NOT NULL,
  `RendimentoTotal` double NOT NULL,
  `RendimentoMensal` double NOT NULL,
  `RendimentoOcasional` double NOT NULL,
  `InvestimentoTotal` double NOT NULL,
  `InvestimentoMensal` double NOT NULL,
  `InvestimentoOcasional` double NOT NULL,
  `DespesasOcasionaisTotal` double NOT NULL,
  `DespesasOcasionaisMensal` double NOT NULL,
  `DespesasOcasionais` double NOT NULL,
  `Total_Disponivel_Ano` double NOT NULL,
  `Total_Despesas_Mes` double NOT NULL,
  `Total_Despesas_Ocasionais` double NOT NULL,
  `Total_Restante` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `resumo_mes`
--

CREATE TABLE `resumo_mes` (
  `Id` int(11) NOT NULL,
  `User` int(11) NOT NULL,
  `Mes` int(11) NOT NULL,
  `Ano` int(11) NOT NULL,
  `Rendimento` double NOT NULL,
  `Investimento` double NOT NULL,
  `Despesas` double NOT NULL,
  `Valor_Disponiveis_Mes` double NOT NULL,
  `Valor_Despesas_Mes` double NOT NULL,
  `Total` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `tipo`
--

CREATE TABLE `tipo` (
  `Id` int(11) NOT NULL,
  `User` int(11) NOT NULL,
  `Nome` varchar(220) NOT NULL,
  `Modulo` varchar(220) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estrutura para tabela `usuario`
--

CREATE TABLE `usuario` (
  `Id` int(11) NOT NULL,
  `Login` varchar(220) NOT NULL,
  `Senha` varchar(220) NOT NULL,
  `Log` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `despesas`
--
ALTER TABLE `despesas`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `userdespesas` (`User`);

--
-- Índices de tabela `despesas_ocasionais`
--
ALTER TABLE `despesas_ocasionais`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `userdespesasocasionais` (`User`);

--
-- Índices de tabela `investimento`
--
ALTER TABLE `investimento`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `userinvestimento` (`User`);

--
-- Índices de tabela `rendimento`
--
ALTER TABLE `rendimento`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `userrendimento` (`User`);

--
-- Índices de tabela `resumo_ano`
--
ALTER TABLE `resumo_ano`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `userresumoano` (`User`);

--
-- Índices de tabela `resumo_mes`
--
ALTER TABLE `resumo_mes`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `userresumomes` (`User`);

--
-- Índices de tabela `tipo`
--
ALTER TABLE `tipo`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `usertipo` (`User`);

--
-- Índices de tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`Id`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `despesas`
--
ALTER TABLE `despesas`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `despesas_ocasionais`
--
ALTER TABLE `despesas_ocasionais`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `investimento`
--
ALTER TABLE `investimento`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `rendimento`
--
ALTER TABLE `rendimento`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de tabela `resumo_ano`
--
ALTER TABLE `resumo_ano`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `resumo_mes`
--
ALTER TABLE `resumo_mes`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `tipo`
--
ALTER TABLE `tipo`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de tabela `usuario`
--
ALTER TABLE `usuario`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `despesas`
--
ALTER TABLE `despesas`
  ADD CONSTRAINT `userdespesas` FOREIGN KEY (`User`) REFERENCES `usuario` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restrições para tabelas `despesas_ocasionais`
--
ALTER TABLE `despesas_ocasionais`
  ADD CONSTRAINT `userdespesasocasionais` FOREIGN KEY (`User`) REFERENCES `usuario` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restrições para tabelas `investimento`
--
ALTER TABLE `investimento`
  ADD CONSTRAINT `userinvestimento` FOREIGN KEY (`User`) REFERENCES `usuario` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restrições para tabelas `rendimento`
--
ALTER TABLE `rendimento`
  ADD CONSTRAINT `userrendimento` FOREIGN KEY (`User`) REFERENCES `usuario` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restrições para tabelas `resumo_ano`
--
ALTER TABLE `resumo_ano`
  ADD CONSTRAINT `userresumoano` FOREIGN KEY (`User`) REFERENCES `usuario` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restrições para tabelas `resumo_mes`
--
ALTER TABLE `resumo_mes`
  ADD CONSTRAINT `userresumomes` FOREIGN KEY (`User`) REFERENCES `usuario` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Restrições para tabelas `tipo`
--
ALTER TABLE `tipo`
  ADD CONSTRAINT `usertipo` FOREIGN KEY (`User`) REFERENCES `usuario` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

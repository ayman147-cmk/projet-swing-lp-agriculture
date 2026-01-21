#   Systeme de Gestion Integrée des Ventes 

-----------------------------------------------------------------------------------------------------------------------------------------

## Contexte :

-----------------------------------------------------------------------------------------------------------------------------------------------

Dans le cadre de la gestion d'une coopérative agricole, il est essentiel de disposer d'un outil efficace pour le suivi des ventes et des productions.
Cet outil permettra de centraliser les informations relatives aux produits, aux agriculteurs et aux transactions, facilitant ainsi la supervision
des revenus et l'analyse statistique des activités agricoles.

## Problematique :

--------------------------------------------------------------------------------------------------------------------------------------------

Actuellement, le suivi des activités de la coopérative agricole est réalisé de manière fragmentée, utilisant des méthodes manuelles ou des outils disparates.
Cela entraîne des difficultés dans la gestion des données des agriculteurs, le suivi rigoureux des ventes, et rend l’estimation des revenus ainsi que la production
de rapports précis extrêmement complexe et sujette aux erreurs.

## Objectifs :

---------------------------------------------------------------------------------------------------------------------------------------------

* **Centralisation** : Base de données unique pour les agriculteurs, produits et ventes.
* **Gestion simplifiée** : Interfaces CRUD (Ajouter, Modifier, Supprimer) intuitives.
* **Suivi analytique** : Estimation automatique des revenus et suivi des stocks vendus.
* **Recherche avancée** : Filtrage dynamique par commune et par type de produit.

## MCD :

----------------------------------------------------------------------------------------------------------------------------------------------


<img width="684" height="456" alt="mcd" src="https://github.com/user-attachments/assets/fe963431-140f-47a6-b5fd-9201c2fd8e1b" />

## MLD :

-----------------------------------------------------------------------------------------------------------------------------------------------

<img width="687" height="480" alt="mld" src="https://github.com/user-attachments/assets/17c0de11-4975-4a75-be15-d6a59a252ced" />

## Diagramme use case :

-----------------------------------------------------------------------------------------------------------------------------------------------


<img width="516" height="573" alt="Use-Case" src="https://github.com/user-attachments/assets/7ca3c86e-67fa-4fcd-bd55-13310ec8d0c3" />

## Diagramme de classe :

-----------------------------------------------------------------------------------------------------------------------------------------------


<img width="572" height="412" alt="diagramme-classe" src="https://github.com/user-attachments/assets/8dadbc42-fc12-49f1-a69c-c30d12ee4787" />


## Structure de la Base de Données :

-----------------------------------------------------------------------------------------------------------------------------------------------

Le système repose sur quatre entités principales :

* **Agriculteur** : Informations sur les membres (Nom, Commune, Contact).
* **ProduitAgro** : Catalogue des produits (Nom, Type, Prix/Kg).
* **VenteAgro** : Lien entre les produits et les agriculteurs (Date, Quantité vendue).
* **Utilisateur** : Informations d'authentification pour la gestion du système.

## Script de la base de donnee :

   ```bash
-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mer. 21 jan. 2026 à 16:26
-- Version du serveur : 9.1.0
-- Version de PHP : 8.3.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `cooperative_db`
--

-- --------------------------------------------------------

--
-- Structure de la table `agriculteur`
--

DROP TABLE IF EXISTS `agriculteur`;
CREATE TABLE IF NOT EXISTS `agriculteur` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) DEFAULT NULL,
  `commune` varchar(50) DEFAULT NULL,
  `contact` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `agriculteur`
--

INSERT INTO `agriculteur` (`id`, `nom`, `commune`, `contact`) VALUES
(1, 'sakyoud', 'oukaimdn', '06124587'),
(3, 'alauoi', 'tadla', '06124587'),
(4, 'kadouri', 'casa', '01478520'),
(9, 'rachid', 'casa', '0612457');

-- --------------------------------------------------------

--
-- Structure de la table `produitagro`
--

DROP TABLE IF EXISTS `produitagro`;
CREATE TABLE IF NOT EXISTS `produitagro` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) DEFAULT NULL,
  `type` varchar(30) DEFAULT NULL,
  `prixKg` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `produitagro`
--

INSERT INTO `produitagro` (`id`, `nom`, `type`, `prixKg`) VALUES
(1, 'Orange ', 'Fruit', 100),
(16, 'armine', 'Fruit', 1458),
(15, 'carotte', 'Légume', 123),
(18, 'carotte', 'Légume', 15),
(10, 'zeero', 'Fruit', 15),
(12, 'loli', 'Légume', 120);

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id`, `username`, `password`) VALUES
(1, 'ayman', '049424183ea34242092eecc8deb41ea06b8b66cf');

-- --------------------------------------------------------

--
-- Structure de la table `venteagro`
--

DROP TABLE IF EXISTS `venteagro`;
CREATE TABLE IF NOT EXISTS `venteagro` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_produit` int DEFAULT NULL,
  `id_agri` int DEFAULT NULL,
  `date_vente` date DEFAULT NULL,
  `quantite` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_produit` (`id_produit`),
  KEY `id_agri` (`id_agri`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `venteagro`
--

INSERT INTO `venteagro` (`id`, `id_produit`, `id_agri`, `date_vente`, `quantite`) VALUES
(1, 5, 1, '2026-01-01', 100),
(12, 1, 1, '2026-01-08', 1500),
(3, 2, 1, '2026-01-09', 600),
(4, 5, 4, '2026-01-03', 100),
(5, 11, 3, '2026-01-02', 1204),
(7, 15, 6, '2026-01-01', 500),
(10, 15, 3, '2026-01-08', 5000);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
```

##Technologies :
------------------------------------------------------------------------------------------------------------------------------------------------------

### **Développement**
* **Langage** : Java
* **Interface Graphique** : Java Swing
* **Accès aux données** : JDBC
* **Bibliothèque Statistique** : JFreeChart

### **Environnement**
* **IDE** : NetBeans
* **Base de données** : MySQL (via phpMyAdmin)
* **Gestion de version** : Git & GitHub
* **Modélisation** : UML (MagicDraw)

##  Installation
1. Cloner le dépôt :
   ```bash
   git clone [https://github.com/ayman147-cmk/projet-swing-lp-agriculture.git](https://github.com/ayman147-cmk/projet-swing-lp-agriculture.git)


## Vidéo sur les interfaces de l'application :
------------------------------------------------------------------------------------------------------------------------------------------------------



















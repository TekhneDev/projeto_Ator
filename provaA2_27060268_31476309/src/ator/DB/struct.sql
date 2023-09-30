/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  carla && taui
 * Created: 26 de set. de 2023
 */

CREATE DATABASE IF NOT EXISTS ator_db;

USE ator_db;

CREATE TABLE IF NOT EXISTS `ator` (
                                      `atorID` int NOT NULL AUTO_INCREMENT,
                                      `atorNome` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL,
                                      `atorIdade` int DEFAULT NULL,
                                      PRIMARY KEY (`atorID`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

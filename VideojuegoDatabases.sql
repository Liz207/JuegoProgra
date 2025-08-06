CREATE DATABASE Videojuego;
GO
USE Videojuego;
Go
--- Creaci�n de tablas
CREATE TABLE raza 
(
    id_raza INT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripci�n TEXT
);

CREATE TABLE arma
(
    id_arma INT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    tipo VARCHAR(50) NOT NULL,
    danio_minimo INT NOT NULL,
    danio_maximo INT NOT NULL,
    modificadores VARCHAR(100)
);

CREATE TABLE jugador
(
    id_jugador INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL UNIQUE,
    partidas_ganadas INT DEFAULT 0,
    partidas_perdidas INT DEFAULT 0
);

CREATE TABLE personaje 
(
    id_personaje INT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    raza_id INT REFERENCES raza(id_raza),
    vida_actual INT,
    id_arma INT REFERENCES arma(id_arma),
    fecha_creacion DATE
);


-- Datos iniciales
INSERT INTO raza (id_raza,nombre, descripci�n) VALUES 
(1, 'Humano', 'Puede usar armas de fuego'),
(2, 'Elfo', 'Puede usar magia de diferentes elementos'),
(3, 'Orco', 'Puede usar hacha o martillo'),
(4, 'Bestia', 'H�brido animal con habilidades especiales');

INSERT INTO arma (id_arma, nombre, tipo, danio_minimo, danio_maximo, modificadores) VALUES 
(1, 'Escopeta', 'Arma de fuego', 1, 5, '+2% de da�o'),
(2, 'Rifle francotirador', 'Arma de fuego', 1, 5, 'Mayor da�o a distancia'),
(3, 'B�culo de Fuego', 'Magia', 1, 5, '+10% de da�o'),
(4, 'B�culo de Tierra', 'Magia', 1, 5, '+2% de da�o, puede atacar dos veces'),
(5, 'B�culo de Aire', 'Magia', 1, 5, 'Mayor da�o a distancia'),
(6, 'B�culo de Agua', 'Magia', 1, 5, 'Sanaci�n mejorada'),
(7, 'Hacha', 'Cuerpo a cuerpo', 1, 5, 'Provoca sangrado'),
(8, 'Martillo', 'Cuerpo a cuerpo', 1, 5, 'Da�o consistente'),
(9, 'Pu�os', 'Natural', 25, 25, 'Atacante pierde 10 de vida'),
(10, 'Espada', 'Cuerpo a cuerpo', 1, 10, 'Da�o variable alto');





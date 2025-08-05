

--- Creación de tablas
CREATE TABLE raza 
(
    id_raza INT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    descripcion TEXT
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
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


-- Datos iniciales
INSERT INTO raza (nombre, descripcion) VALUES 
('Humano', 'Puede usar armas de fuego'),
('Elfo', 'Puede usar magia de diferentes elementos'),
('Orco', 'Puede usar hacha o martillo'),
('Bestia', 'Híbrido animal con habilidades especiales');

INSERT INTO arma (nombre, tipo, danio_minimo, danio_maximo, modificadores) VALUES 
('Escopeta', 'Arma de fuego', 1, 5, '+2% de daño'),
('Rifle francotirador', 'Arma de fuego', 1, 5, 'Mayor daño a distancia'),
('Báculo de Fuego', 'Magia', 1, 5, '+10% de daño'),
('Báculo de Tierra', 'Magia', 1, 5, '+2% de daño, puede atacar dos veces'),
('Báculo de Aire', 'Magia', 1, 5, 'Mayor daño a distancia'),
('Báculo de Agua', 'Magia', 1, 5, 'Sanación mejorada'),
('Hacha', 'Cuerpo a cuerpo', 1, 5, 'Provoca sangrado'),
('Martillo', 'Cuerpo a cuerpo', 1, 5, 'Daño consistente'),
('Puños', 'Natural', 25, 25, 'Atacante pierde 10 de vida'),
('Espada', 'Cuerpo a cuerpo', 1, 10, 'Daño variable alto');







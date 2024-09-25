DROP TABLE IF EXISTS Disponible_en ;
DROP TABLE IF EXISTS Plataformas ;
DROP TABLE IF EXISTS Peliculas ;

--
-- Estructura de las tablas
--
CREATE TABLE IF NOT EXISTS Peliculas (
codigo INT NOT NULL,
titulo VARCHAR(200) NOT NULL,    
sinopsis VARCHAR(200)NOT NULL,   
fEstreno DATE NOT NULL,
PRIMARY KEY  (codigo)
);
CREATE TABLE IF NOT EXISTS Plataformas (
   codigo INT NOT NULL,
nombre VARCHAR(200) NOT NULL ,    
urlLogotipo VARCHAR(200) NOT NULL,
PRIMARY KEY  (codigo)
);
CREATE TABLE IF NOT EXISTS Disponible_en (
codPlataforma INT NOT NULL,
codPelicula INT NOT NULL,
fDisponibilidadda DATE NOT NULL,
PRIMARY KEY (codPlataforma, codPelicula) ,
FOREIGN KEY (codPelicula) REFERENCES Peliculas(codigo)ON UPDATE CASCADE ON DELETE CASCADE ,
FOREIGN KEY (codPlataforma) REFERENCES Plataformas(codigo)ON UPDATE CASCADE ON DELETE CASCADE 

);
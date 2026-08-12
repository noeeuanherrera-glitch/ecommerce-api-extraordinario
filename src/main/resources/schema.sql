DROP TABLE IF EXISTS articulo_pedido;
DROP TABLE IF EXISTS pedido;
DROP TABLE IF EXISTS cliente;
DROP TABLE IF EXISTS prenda;
DROP TABLE IF EXISTS marca;

CREATE TABLE marca (
                       id INT AUTO_INCREMENT PRIMARY KEY,
                       nombre VARCHAR(100) NOT NULL
);

CREATE TABLE prenda (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        nombre VARCHAR(100) NOT NULL,
                        precio DOUBLE NOT NULL
);

CREATE TABLE cliente (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         nombre VARCHAR(100) NOT NULL,
                         email VARCHAR(100) NOT NULL
);

CREATE TABLE pedido (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        fecha TIMESTAMP NOT NULL,
                        cliente_id INT,
                        FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

CREATE TABLE articulo_pedido (
                                 id INT AUTO_INCREMENT PRIMARY KEY,
                                 cantidad INT NOT NULL,
                                 precio_unitario DOUBLE NOT NULL,
                                 prenda_id INT,
                                 pedido_id INT,
                                 FOREIGN KEY (prenda_id) REFERENCES prenda(id),
                                 FOREIGN KEY (pedido_id) REFERENCES pedido(id)
);
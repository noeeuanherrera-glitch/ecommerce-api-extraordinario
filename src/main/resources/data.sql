INSERT INTO marca (nombre) VALUES ('Nike'), ('Adidas'), ('Puma');

INSERT INTO prenda (nombre, precio) VALUES ('Playera Deportiva', 499.99), ('Chamarra Rompevientos', 1299.50);

INSERT INTO cliente (nombre, email) VALUES ('Juan Pérez', 'juan.perez@email.com'), ('Maria Lopez', 'maria.lopez@email.com');

INSERT INTO pedido (fecha, cliente_id) VALUES (CURRENT_TIMESTAMP, 1);

INSERT INTO articulo_pedido (cantidad, precio_unitario, prenda_id, pedido_id) VALUES (2, 499.99, 1, 1);
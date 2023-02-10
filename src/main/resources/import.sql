/* Populate tabla tiendas */

INSERT INTO tiendas (nombre, create_at) VALUES ('Adidas', '2023-02-07');
INSERT INTO tiendas (nombre, create_at) VALUES ('NIKE', '2023-02-08');
INSERT INTO tiendas (nombre, create_at) VALUES ('PUMA', '2023-02-09');
INSERT INTO tiendas (nombre, create_at) VALUES ('LEVIS', '2023-02-08');
INSERT INTO tiendas (nombre, create_at) VALUES ('JORDAN', '2023-02-09');

/* Populate tabla productos */

--INSERT INTO productos (nombre, descripcion, precio, create_at) VALUES ('tenis', 'pharrel williams', 350000, '2023-02-07');
--INSERT INTO productos (nombre, descripcion, precio, create_at) VALUES ('morral', 'doble fondo', 150000, '2023-02-08');
--INSERT INTO productos (nombre, descripcion, precio, create_at) VALUES ('guayos', 'futbol', 400000, '2023-02-09');
--INSERT INTO productos (nombre, descripcion, precio, create_at) VALUES ('jeans', 'ultima temporada', 150000, '2023-02-08');
--INSERT INTO productos (nombre, descripcion, precio, create_at) VALUES ('jordan', 'baloncesto', 700000, '2023-02-09');


/* Populate tabla productos */
INSERT INTO productos (nombre, descripcion, precio, tienda_id, create_at) VALUES ('Balon', 'Balon Mundial', 350000, 1, '2023-02-07');
INSERT INTO productos (nombre, descripcion, precio, tienda_id, create_at) VALUES ('Maletin', 'Maletin bolsillo PC', 150000, 2, '2023-02-08');
INSERT INTO productos (nombre, descripcion, precio, tienda_id, create_at) VALUES ('Guayos', 'Guayos Predator', 400000, 1, '2023-02-09');
INSERT INTO productos (nombre, descripcion, precio, tienda_id, create_at) VALUES ('Jeans', 'Desgasete Clásico', 150000, 4, '2023-02-08');
INSERT INTO productos (nombre, descripcion, precio, tienda_id, create_at) VALUES ('Tenis Jordan', 'Tenis deportivos', 700000, 5, '2023-02-09');
INSERT INTO productos (nombre, descripcion, precio, tienda_id, create_at) VALUES ('Camiseta', 'Camiseta Negra ', 700000, 5, '2023-02-09');

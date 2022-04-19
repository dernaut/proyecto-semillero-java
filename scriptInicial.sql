CREATE TABLE IF NOT exists libreria.tipoproducto(
	id 		tinyint not null PRIMARY key COMMENT 'LLave primaria de la tabla, no es incremental',
	tipo  varchar(50) not null COMMENT 'Nombre o descripcion del tipo de producto, ej, libro, revista, articulo'
)
ENGINE = InnoDB
COMMENT='Tabla donde se define los diferentes tipos de productos';


CREATE TABLE IF NOT exists libreria.producto(
 	productoid		int NOT null PRIMARY key auto_increment COMMENT 'LLave primaria de cada producto, es incremental',
	tipo			tinyint not null,
	nombre			varchar(50) not null,
	autor			varchar(10) not null,
	editorial		varchar(30) not null,
	cantidad        int not null,
	precioUnitario	decimal(14,4) not null,
	fechaRegistro	varchar(50) not null,
	descuento		int null,
	CONSTRAINT fk_prod_tipoproduct FOREIGN KEY (tipo) references libreria.tipoproducto(id)
)
ENGINE = InnoDB
COMMENT='Tabla de los productos para la venta';

insert into libreria.tipoproducto (ID, TIPO) 
values (1, 'Libro');

insert into libreria.tipoproducto (ID, TIPO) 
values (2, 'Revista');

insert into libreria.tipoproducto (ID, TIPO) 
values (3, 'Articulo');



insert into libreria.producto (tipo, nombre, autor, editorial, cantidad, precioUnitario, fechaRegistro, descuento) 
values (1, 'Cien anhos de soledad', 'Gabriel GM', 'Biblioteca Espanha', 7, 87000.0, '18/04/2022 08:42:40 PM', NULL);

insert into libreria.producto (tipo, nombre, autor, editorial, cantidad, precioUnitario, fechaRegistro, descuento) 
values (1, 'El coronel no tiene quien le', 'Gabriel GM', 'Biblioteca Espanha', 3, 25000.0, '18/04/2022 08:42:40 PM', NULL);

insert into libreria.producto (tipo, nombre, autor, editorial, cantidad, precioUnitario, fechaRegistro, descuento) 
values (1, 'La odisea', 'Eclipse', 'Biblioteca Espanha', 5, 35000.0, '18/04/2022 08:43:40 PM', NULL);

insert into libreria.producto (tipo, nombre, autor, editorial, cantidad, precioUnitario, fechaRegistro, descuento) 
values (2, 'National', 'Eclipse', 'Biblioteca Espanha', 3, 5000.0, '18/04/2022 08:52:40 PM', NULL);

insert into libreria.producto (tipo, nombre, autor, editorial, cantidad, precioUnitario, fechaRegistro, descuento) 
values (2, 'Motor', 'Davir', 'Biblioteca Colombi', 10, 15000.0, '18/04/2022 08:54:40 PM', NULL);

insert into libreria.producto (tipo, nombre, autor, editorial, cantidad, precioUnitario, fechaRegistro, descuento) 
values (3, 'Paper sobre Combustión Interna', 'Davirs', 'Biblioteca Colombi', 2, 85000.0, '18/04/2022 08:56:40 PM', NULL);

insert into libreria.producto (tipo, nombre, autor, editorial, cantidad, precioUnitario, fechaRegistro, descuento) 
values (3, 'Paper Programación orienta a Objetos', 'Davirs', 'Biblioteca Colombi', 5, 25000.0, '18/04/2022 08:58:40 PM', NULL);

commit;
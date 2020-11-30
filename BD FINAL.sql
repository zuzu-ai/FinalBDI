-- drop database hotel_general;
create database hotel_general;
use hotel_general;

create table sucursal (
id_sucursal int auto_increment primary key,
nombre varchar(20) not null,
direccion varchar(20) not null,
telefono varchar(20) not null
)engine=Innodb default charset=latin1;

create table bodega (
id_bodega int auto_increment primary key,
id_sucursal int not null,
nombre varchar(20) not null,
direccion varchar(40) not null,
estatus varchar(1) not null,
foreign key(id_sucursal) references
sucursal(id_sucursal)
)engine=Innodb default charset=latin1;

create table rol_usuario(
id_rol_usuario varchar (20) primary key not null,
nombre_rol varchar (40) not null,
rol_key varchar (35) not null,
estado varchar (1) not null
)engine = InnoDB default charset=latin1;

create table usuario_hoteleria(-- login de usuario hotel
id_usuario varchar (35) primary key not null,
nombre_usuario varchar (20) not null,
password_usuario varchar (35) not null,
estado varchar (1) not null
)engine = InnoDB default charset=latin1;

create table bitacora(
id_bitacora int primary key auto_increment,
id_usuario varchar(35) not null,
descripcion varchar(200),
fecha date not null,
hore time not null,
foreign key (id_usuario) references
usuario_hoteleria(id_usuario)
)engine=InnoDB  default charset=latin1;

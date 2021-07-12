drop database if exists bdlabo;

create database bdlabo;
use bdlabo;

create table if not exists clientes (
	Dni int not null, 
	IdUsuario int unsigned not null, 
    IdNacionalidad int not null,
    IdLocalidad int not null,
    Cuil varchar(15) unique not null, 
    Nombre varchar(45) not null,
    Apellido varchar(45) not null,
    Sexo varchar(20) not null, 
    FechaNacimiento date not null,
    Direccion varchar(45) not null,
    CorreoElectronico varchar(45) not null,
    Eliminado boolean default false not null,
    TelefonoFijo varchar(20),
    Celular varchar(20),
    Primary Key (Dni)
);
create table if not exists usuarios (
	IdUsuario int unsigned not null auto_increment,
    EsAdmin boolean default false not null,
    NombreUsuario varchar(45) not null,
    Contrasenia varchar(45) not null,
	Primary Key (IdUsuario)
);
create table if not exists nacionalidades (
	IdNacionalidad int auto_increment,
    Nombre varchar(45) not null,
    Primary Key (IdNacionalidad)
);
create table if not exists provincias (
	IdProvincia int auto_increment,
    Nombre varchar(45) not null,
    primary key (IdProvincia)
);
create table if not exists localidades (
	IdLocalidad int auto_increment,
    IdProvincia int not null,
    Nombre varchar(45) not null,
    primary Key (IdLocalidad)
);
create table if not exists cuentas (
	NumeroCuenta bigint AUTO_INCREMENT,
    Dni int null,
    IdTipoCuenta tinyint unsigned not null, 
    Saldo decimal(12,2) not null,
    Cbu varchar(22) unique not null,
    FechaCreacion date not null,
    Eliminado boolean default false not null,
    primary key (NumeroCuenta)
);
create table if not exists tiposDeCuenta (
	IdTipoCuenta tinyint unsigned auto_increment,
    Descripcion varchar(45) not null,
    Primary Key (IdTipoCuenta)
);
create table if not exists prestamos (
	IdPrestamos int unsigned auto_increment,
    NumeroCuenta bigint not null,
	Dni int not null,
    Fecha date not null,
    ImporteSolicitado decimal(12,2) not null,
    ImporteAPagar decimal(12,2) not null,
    MontoMensual decimal(12,2) not null,
    Cuotas tinyint unsigned not null,
    Estado tinyint not null, 
    primary Key (IdPrestamos)
);
create table if not exists cuotas (
	IdPrestamos int unsigned not null,
    NumeroCuota tinyint not null,
    Importe decimal(12,2) not null, 
    FechaVencimiento date not null,
    FechaPago date default null,
    Primary Key (IdPrestamos,NumeroCuota)
);
create table if not exists movimientos (
	IdMovimientos int unsigned auto_increment,
	IdTipoMovimiento tinyint unsigned not null,
    CuentaOrigen bigint null,
    CuentaDestino bigint null,	
    Fecha datetime not null,
    Detalles text not null,
    Importe decimal not null,
    Primary Key (IdMovimientos)
);
create table if not exists tiposMovimientos (
	IdTipoMovimiento tinyint unsigned auto_increment,
    Descripcion varchar(45) not null,
    Primary key (IdTipoMovimiento)
);

# --Clientes --
alter table clientes add foreign key (IdUsuario) references usuarios (IdUsuario); 
alter table clientes add foreign key (IdLocalidad) references localidades (IdLocalidad);
alter table clientes add foreign key (IdNacionalidad) references nacionalidades (IdNacionalidad);

# -- Localidad --
alter table localidades add foreign key (IdProvincia) references provincias (IdProvincia);

# -- Provincia --

# -- Cuenta --
ALTER TABLE cuentas AUTO_INCREMENT = 1000000;
alter table cuentas add foreign key (Dni) references clientes (Dni);
alter table cuentas add foreign key (IdTipoCuenta) references tiposDeCuenta (IdTipoCuenta);

# -- Prestamos --
alter table prestamos add foreign key (Dni) references clientes (Dni);
alter table prestamos add foreign key (NumeroCuenta) references cuentas (NumeroCuenta);

# -- Cuotas --
alter table cuotas add foreign key (IdPrestamos) references prestamos (IdPrestamos);

# -- Movimientos --
alter table movimientos add foreign key (CuentaOrigen) references Cuentas (NumeroCuenta);
alter table movimientos add foreign key (CuentaDestino) references Cuentas (NumeroCuenta);
alter table movimientos add foreign key (IdTipoMovimiento) references tiposMovimientos (IdTipoMovimiento);
alter table movimientos add constraint check (not(isnull(CuentaOrigen) and isnull(CuentaDestino)));

# -- Paises --
insert into nacionalidades (Nombre) values ("Argentina");
insert into nacionalidades (Nombre) values ("Brasil");
insert into nacionalidades (Nombre) values ("Chile");
insert into nacionalidades (Nombre) values ("Alemania");
insert into nacionalidades (Nombre) values ("Australia");
insert into nacionalidades (Nombre) values ("Grecia");
insert into nacionalidades (Nombre) values ("Alemania");
insert into nacionalidades (Nombre) values ("Palestina");
insert into nacionalidades (Nombre) values ("Reino Unido");
insert into nacionalidades (Nombre) values ("Colombia");
insert into nacionalidades (Nombre) values ("Mexico");
insert into nacionalidades (Nombre) values ("Estados Unidos");
insert into nacionalidades (Nombre) values ("Francia");
insert into nacionalidades (Nombre) values ("Filipinas");
insert into nacionalidades (Nombre) values ("Canada");

# -- Paises -- Provincias
#arg
insert into provincias (Nombre) values ("Buenos Aires");
insert into provincias (Nombre) values ("Cordoba");
insert into provincias (Nombre) values ("Santa fe");
insert into provincias (Nombre) values ("Tucuman");
insert into provincias (Nombre) values ("Santa cruz");
insert into provincias (Nombre) values ("Misiones");
insert into provincias (Nombre) values ("Tierra del fuego");
insert into provincias (Nombre) values ("La pampa");
insert into provincias (Nombre) values ("Rio negro");
insert into provincias (Nombre) values ("Entre rios");
# brasil
insert into provincias (Nombre) values ("Bahia");
insert into provincias (Nombre) values ("Minas gerais");
insert into provincias (Nombre) values ("Ceara");
#chile 
insert into provincias (Nombre) values ("Santiago");
insert into provincias (Nombre) values ("Cuyo");

insert into localidades (IdProvincia,Nombre) values (1,"Escobar");
insert into localidades (IdProvincia,Nombre) values (1,"Pacheco");
insert into localidades (IdProvincia,Nombre) values (1,"Caba");

insert into localidades (IdProvincia,Nombre) values (2,"EscobarEnBrasil");
insert into localidades (IdProvincia,Nombre) values (2,"LocalidadBrasil2");
insert into localidades (IdProvincia,Nombre) values (3,"LocalidadChile1");
insert into localidades (IdProvincia,Nombre) values (4,"Localidad1");
insert into localidades (IdProvincia,Nombre) values (5,"Localidad1");
insert into localidades (IdProvincia,Nombre) values (6,"Localidad1");
insert into localidades (IdProvincia,Nombre) values (7,"Localidad1");
insert into localidades (IdProvincia,Nombre) values (8,"Localidad1");
insert into localidades (IdProvincia,Nombre) values (9,"Localidad1");
insert into localidades (IdProvincia,Nombre) values (10,"Localidad1");
insert into localidades (IdProvincia,Nombre) values (11,"Localidad1");
insert into localidades (IdProvincia,Nombre) values (12,"Localidad1");


insert into usuarios (NombreUsuario,Contrasenia,EsAdmin) values ("AlonsoHS20","12345",true);

insert into usuarios (NombreUsuario,Contrasenia,EsAdmin) values ("Nose","123",false);
insert into usuarios (NombreUsuario,Contrasenia,EsAdmin) values ("Yase","123",false); 

insert into clientes (Dni,IdUsuario,IdNacionalidad,IdLocalidad,Cuil,Nombre,Apellido,Sexo,FechaNacimiento,Direccion,CorreoElectronico,TelefonoFijo,Celular) 
values (14203944,2,1,1,111111111111,"Nose","Valdez","Masculino","2021/06/25","Av.Siempre viva 123","prueba@gmail.com",01123948373, 1523344556);

insert into clientes (Dni,IdUsuario,IdNacionalidad,IdLocalidad,Cuil,Nombre,Apellido,Sexo,FechaNacimiento,Direccion,CorreoElectronico,TelefonoFijo,Celular) 
values (0303456,3,1,1,111111222111,"Yase","Gomez","Masculino","2021/06/25","Av.Nuenca muerta 987","prueba@gmail.com",01123848373, 1523344557);

insert into tiposdecuenta (Descripcion) values ("Caja de Ahorro");
insert into tiposdecuenta (Descripcion) values ("Cuenta Corriente");

insert into cuentas (numerocuenta,dni,idtipocuenta,saldo,cbu,fechacreacion) values (123813724,14203944,1,10000,124124123,current_date());
insert into cuentas (numerocuenta,dni,idtipocuenta,saldo,cbu,fechacreacion) values (123813725,14203944,2,10000,124124124,current_date());
insert into cuentas (numerocuenta,dni,idtipocuenta,saldo,cbu,fechacreacion) values (123813726,null,1,0,124124125,current_date());

insert into tiposmovimientos (descripcion) values ("Alta de cuenta");
insert into tiposmovimientos (descripcion) values ("Alta de prestamo");
insert into tiposmovimientos (descripcion) values ("Pago de prestamo");
insert into tiposmovimientos (descripcion) values ("Transferencia");

insert into movimientos (idtipomovimiento,cuentaorigen,cuentadestino,fecha,detalles,importe) values (2,123813724,123813726,current_timestamp(),"Alta de cuenta", 10000);

insert into prestamos (numerocuenta,dni,fecha,importesolicitado,importeapagar,montomensual,cuotas,estado) values (123813724,14203944,current_date(),50000,65000, 6500, 10, 3);
insert into prestamos (numerocuenta,dni,fecha,importesolicitado,importeapagar,montomensual,cuotas,estado) values (123813724,14203944,current_date(),5000,6500, 650, 10, 3);

insert into prestamos (numerocuenta,dni,fecha,importesolicitado,importeapagar,montomensual,cuotas,estado) values (123813724,14203944,current_date(),1000,1200, 120, 10, 1);

insert into cuotas (IdPrestamos,numerocuota,importe,FechaVencimiento,FechaPago) values (1,1,6500,DATE_FORMAT("2021-08-07", "%Y" "%m" "%d"),null);
insert into cuotas (IdPrestamos,numerocuota,importe,FechaVencimiento,FechaPago) values (1,2,6500,DATE_FORMAT("2021-09-07", "%Y" "%m" "%d"),null);
insert into cuotas (IdPrestamos,numerocuota,importe,FechaVencimiento,FechaPago) values (1,3,6500,DATE_FORMAT("2021-10-07", "%Y" "%m" "%d"),null);
insert into cuotas (IdPrestamos,numerocuota,importe,FechaVencimiento,FechaPago) values (1,4,6500,DATE_FORMAT("2021-11-07", "%Y" "%m" "%d"),null);
insert into cuotas (IdPrestamos,numerocuota,importe,FechaVencimiento,FechaPago) values (1,5,6500,DATE_FORMAT("2021-12-07", "%Y" "%m" "%d"),null);
insert into cuotas (IdPrestamos,numerocuota,importe,FechaVencimiento,FechaPago) values (1,6,6500,DATE_FORMAT("2022-01-07", "%Y" "%m" "%d"),null);
insert into cuotas (IdPrestamos,numerocuota,importe,FechaVencimiento,FechaPago) values (1,7,6500,DATE_FORMAT("2022-02-07", "%Y" "%m" "%d"),null);
insert into cuotas (IdPrestamos,numerocuota,importe,FechaVencimiento,FechaPago) values (1,8,6500,DATE_FORMAT("2022-03-07", "%Y" "%m" "%d"),null);
insert into cuotas (IdPrestamos,numerocuota,importe,FechaVencimiento,FechaPago) values (1,9,6500,DATE_FORMAT("2022-04-07", "%Y" "%m" "%d"),null);
insert into cuotas (IdPrestamos,numerocuota,importe,FechaVencimiento,FechaPago) values (1,10,6500,DATE_FORMAT("2022-05-07", "%Y" "%m" "%d"),null);

insert into cuotas (IdPrestamos,numerocuota,importe,FechaVencimiento,FechaPago) values (2,1,650,DATE_FORMAT("2021-08-07", "%Y" "%m" "%d"),null);
insert into cuotas (IdPrestamos,numerocuota,importe,FechaVencimiento,FechaPago) values (2,2,650,DATE_FORMAT("2021-09-07", "%Y" "%m" "%d"),null);
insert into cuotas (IdPrestamos,numerocuota,importe,FechaVencimiento,FechaPago) values (2,3,650,DATE_FORMAT("2021-10-07", "%Y" "%m" "%d"),null);
insert into cuotas (IdPrestamos,numerocuota,importe,FechaVencimiento,FechaPago) values (2,4,650,DATE_FORMAT("2021-11-07", "%Y" "%m" "%d"),null);
insert into cuotas (IdPrestamos,numerocuota,importe,FechaVencimiento,FechaPago) values (2,5,650,DATE_FORMAT("2021-12-07", "%Y" "%m" "%d"),null);
insert into cuotas (IdPrestamos,numerocuota,importe,FechaVencimiento,FechaPago) values (2,6,650,DATE_FORMAT("2022-01-07", "%Y" "%m" "%d"),null);
insert into cuotas (IdPrestamos,numerocuota,importe,FechaVencimiento,FechaPago) values (2,7,650,DATE_FORMAT("2022-02-07", "%Y" "%m" "%d"),null);
insert into cuotas (IdPrestamos,numerocuota,importe,FechaVencimiento,FechaPago) values (2,8,650,DATE_FORMAT("2022-03-07", "%Y" "%m" "%d"),null);
insert into cuotas (IdPrestamos,numerocuota,importe,FechaVencimiento,FechaPago) values (2,9,650,DATE_FORMAT("2022-04-07", "%Y" "%m" "%d"),null);
insert into cuotas (IdPrestamos,numerocuota,importe,FechaVencimiento,FechaPago) values (2,10,650,DATE_FORMAT("2022-05-07", "%Y" "%m" "%d"),null);

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


# -------------------------------------------------------------- INSERTS --------------------------------------------------------------

# -- Inserts para Usuarios Admins --
insert into usuarios (NombreUsuario,Contrasenia,EsAdmin) values ("AlonsoH","1",true); #tendriamos que encriptar la contrasenia el primer usuario va a tener IdUsuario 1 se supone
insert into usuarios (NombreUsuario,Contrasenia,EsAdmin) values ("NicoF","12",true);
insert into usuarios (NombreUsuario,Contrasenia,EsAdmin) values ("AndresC","123",true);
insert into usuarios (NombreUsuario,Contrasenia,EsAdmin) values ("DeniseR","1234",true);
insert into usuarios (NombreUsuario,Contrasenia,EsAdmin) values ("CristianP","12345",true);
insert into usuarios (NombreUsuario,Contrasenia,EsAdmin) values ("MarcosL","123456",true);
# -- Inserts para usuarios clientes --
insert into usuarios (NombreUsuario,Contrasenia,EsAdmin) values ("Martin","1",false); 
insert into usuarios (NombreUsuario,Contrasenia,EsAdmin) values ("Lorena","2",false); 
insert into usuarios (NombreUsuario,Contrasenia,EsAdmin) values ("Gaston","3",false); 
insert into usuarios (NombreUsuario,Contrasenia,EsAdmin) values ("Fabricio","4",false);
insert into usuarios (NombreUsuario,Contrasenia,EsAdmin) values ("Simon","5",false); 
insert into usuarios (NombreUsuario,Contrasenia,EsAdmin) values ("Jose","6",false); 
insert into usuarios (NombreUsuario,Contrasenia,EsAdmin) values ("Ramon","7",false); 
insert into usuarios (NombreUsuario,Contrasenia,EsAdmin) values ("Victor","8",false); 
insert into usuarios (NombreUsuario,Contrasenia,EsAdmin) values ("Diego","9",false);

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

# -- Provincias -- 
# Argentina
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
# Brasil
insert into provincias (Nombre) values ("Bahia");
insert into provincias (Nombre) values ("Minas gerais");
insert into provincias (Nombre) values ("Ceara");
# Chile 
insert into provincias (Nombre) values ("Santiago");
insert into provincias (Nombre) values ("Cuyo");

# -- Localidades -- 
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

# -- Inserts para Clientes --  
insert into clientes (Dni,IdUsuario,IdNacionalidad,IdLocalidad,Cuil,Nombre,Apellido,Sexo,FechaNacimiento,Direccion,CorreoElectronico,TelefonoFijo,Celular) 
values (11111111,1,1,1,121111111111,"Alonso","Huarcaya","Masculino","2021/06/25","Av.Siempre viva 123","prueba1@gmail.com",01123948373, 1523344556);
insert into clientes (Dni,IdUsuario,IdNacionalidad,IdLocalidad,Cuil,Nombre,Apellido,Sexo,FechaNacimiento,Direccion,CorreoElectronico,TelefonoFijo,Celular) 
values (22222222,2,1,1,131111222111,"Nicolas","Ferreira","Masculino","2021/06/25","Av.Nuenca muerta 987","prueba2@gmail.com",01123848373, 1523344557);
insert into clientes (Dni,IdUsuario,IdNacionalidad,IdLocalidad,Cuil,Nombre,Apellido,Sexo,FechaNacimiento,Direccion,CorreoElectronico,TelefonoFijo,Celular) 
values (33333333,3,1,1,141111222111,"Anders","Cacchione","Masculino","2021/06/25","Av.Nuenca muerta 987","prueba3@gmail.com",01123848373, 1523344557);
insert into clientes (Dni,IdUsuario,IdNacionalidad,IdLocalidad,Cuil,Nombre,Apellido,Sexo,FechaNacimiento,Direccion,CorreoElectronico,TelefonoFijo,Celular) 
values (44444444,4,1,1,151111222111,"Denise","Roccia","Femenino","2021/06/25","Av.Nuenca muerta 987","prueba4@gmail.com",01123848373, 1523344557);
insert into clientes (Dni,IdUsuario,IdNacionalidad,IdLocalidad,Cuil,Nombre,Apellido,Sexo,FechaNacimiento,Direccion,CorreoElectronico,TelefonoFijo,Celular) 
values (55555555,5,1,1,161111222111,"Cristian","Paolini","Masculino","2021/06/25","Av.Nuenca muerta 987","prueba5@gmail.com",01123848373, 1523344557);
insert into clientes (Dni,IdUsuario,IdNacionalidad,IdLocalidad,Cuil,Nombre,Apellido,Sexo,FechaNacimiento,Direccion,CorreoElectronico,TelefonoFijo,Celular) 
values (66666666,6,1,1,171111222111,"Marcos","Ledesma","Masculino","2021/06/25","Av.Nuenca muerta 987","prueba6@gmail.com",01123848373, 1523344557);
insert into clientes (Dni,IdUsuario,IdNacionalidad,IdLocalidad,Cuil,Nombre,Apellido,Sexo,FechaNacimiento,Direccion,CorreoElectronico,TelefonoFijo,Celular) 
values (77777777,7,1,1,181111222111,"Martin","Gomez","Masculino","2021/06/25","Av.Nuenca muerta 987","prueba7@gmail.com",01123848373, 1523344557);
insert into clientes (Dni,IdUsuario,IdNacionalidad,IdLocalidad,Cuil,Nombre,Apellido,Sexo,FechaNacimiento,Direccion,CorreoElectronico,TelefonoFijo,Celular) 
values (88888888,8,1,1,192111222111,"Lorena","Gomez","Masculino","2021/06/25","Av.Nuenca muerta 987","prueba8@gmail.com",01123848373, 1523344557);
insert into clientes (Dni,IdUsuario,IdNacionalidad,IdLocalidad,Cuil,Nombre,Apellido,Sexo,FechaNacimiento,Direccion,CorreoElectronico,TelefonoFijo,Celular) 
values (99999999,9,1,1,101111222111,"Gaston","Dalmau","Masculino","2021/06/25","Av.Nuenca muerta 987","prueba9@gmail.com",01123848373, 1523344557);
insert into clientes (Dni,IdUsuario,IdNacionalidad,IdLocalidad,Cuil,Nombre,Apellido,Sexo,FechaNacimiento,Direccion,CorreoElectronico,TelefonoFijo,Celular) 
values (10101010,10,1,1,191111222111,"Fabricio","Grande","Masculino","2021/06/25","Av.Nuenca muerta 987","prueba10@gmail.com",01123848373, 1523344557);
insert into clientes (Dni,IdUsuario,IdNacionalidad,IdLocalidad,Cuil,Nombre,Apellido,Sexo,FechaNacimiento,Direccion,CorreoElectronico,TelefonoFijo,Celular) 
values (11111112,11,1,1,201111222111,"Simon","Bolivar","Masculino","2021/06/25","Av.Nuenca muerta 987","prueba11@gmail.com",01123848373, 1523344557);
insert into clientes (Dni,IdUsuario,IdNacionalidad,IdLocalidad,Cuil,Nombre,Apellido,Sexo,FechaNacimiento,Direccion,CorreoElectronico,TelefonoFijo,Celular) 
values (12121212,12,1,1,251111222111,"Jose","Jose","Masculino","2021/06/25","Av.Nuenca muerta 987","prueba12@gmail.com",01123848373, 1523344557);
insert into clientes (Dni,IdUsuario,IdNacionalidad,IdLocalidad,Cuil,Nombre,Apellido,Sexo,FechaNacimiento,Direccion,CorreoElectronico,TelefonoFijo,Celular) 
values (13131313,13,1,1,211111222111,"Ramon","Valdez","Masculino","2021/06/25","Av.Nuenca muerta 987","prueba13@gmail.com",01123848373, 1523344557);
insert into clientes (Dni,IdUsuario,IdNacionalidad,IdLocalidad,Cuil,Nombre,Apellido,Sexo,FechaNacimiento,Direccion,CorreoElectronico,TelefonoFijo,Celular) 
values (14141414,14,1,1,221111222111,"Victor","Domingo","Masculino","2021/06/25","Av.Nuenca muerta 987","prueba14@gmail.com",01123848373, 1523344557);
insert into clientes (Dni,IdUsuario,IdNacionalidad,IdLocalidad,Cuil,Nombre,Apellido,Sexo,FechaNacimiento,Direccion,CorreoElectronico,TelefonoFijo,Celular) 
values (15151515,15,1,1,231111222111,"Diego","Maradona","Masculino","2021/06/25","Av.Nuenca muerta 987","prueba15@gmail.com",01123848373, 1523344557);

# -- Inserts tipos de cuenta -- 
insert into tiposdecuenta (Descripcion) values ("Caja de Ahorro");
insert into tiposdecuenta (Descripcion) values ("Cuenta Corriente");

# -- Inserts cuentas -- 
insert into cuentas (numerocuenta,dni,idtipocuenta,saldo,cbu,fechacreacion) values (123813724,11111111,1,10000,121111111111,current_date());
insert into cuentas (numerocuenta,dni,idtipocuenta,saldo,cbu,fechacreacion) values (123813725,22222222,2,10000,131111222111,current_date());
insert into cuentas (numerocuenta,dni,idtipocuenta,saldo,cbu,fechacreacion) values (123813726,33333333,1,10000,141111222111,current_date());
insert into cuentas (numerocuenta,dni,idtipocuenta,saldo,cbu,fechacreacion) values (123813727,44444444,2,10000,151111222111,current_date());
insert into cuentas (numerocuenta,dni,idtipocuenta,saldo,cbu,fechacreacion) values (123813728,55555555,2,10000,161111222111,current_date());
insert into cuentas (numerocuenta,dni,idtipocuenta,saldo,cbu,fechacreacion) values (123813729,66666666,1,10000,171111222111,current_date());
insert into cuentas (numerocuenta,dni,idtipocuenta,saldo,cbu,fechacreacion) values (123813710,77777777,2,10000,181111222111,current_date());
insert into cuentas (numerocuenta,dni,idtipocuenta,saldo,cbu,fechacreacion) values (123813711,88888888,2,10000,192111222111,current_date());
insert into cuentas (numerocuenta,dni,idtipocuenta,saldo,cbu,fechacreacion) values (123813712,99999999,2,10000,101111222111,current_date());
insert into cuentas (numerocuenta,dni,idtipocuenta,saldo,cbu,fechacreacion) values (123813713,10101010,2,10000,191111222111,current_date());
insert into cuentas (numerocuenta,dni,idtipocuenta,saldo,cbu,fechacreacion) values (123813714,11111112,1,10000,201111222111,current_date());
insert into cuentas (numerocuenta,dni,idtipocuenta,saldo,cbu,fechacreacion) values (123813715,12121212,2,10000,251111222111,current_date());
insert into cuentas (numerocuenta,dni,idtipocuenta,saldo,cbu,fechacreacion) values (123813716,13131313,1,10000,211111222111,current_date());
insert into cuentas (numerocuenta,dni,idtipocuenta,saldo,cbu,fechacreacion) values (123813717,14141414,2,10000,221111222111,current_date());
insert into cuentas (numerocuenta,dni,idtipocuenta,saldo,cbu,fechacreacion) values (123813718,15151515,1,10000,231111222111,current_date());

# -- Inserts tipos de movimientos -- 
insert into tiposmovimientos (descripcion) values ("Alta de cuenta");
insert into tiposmovimientos (descripcion) values ("Alta de prestamo");
insert into tiposmovimientos (descripcion) values ("Pago de prestamo");
insert into tiposmovimientos (descripcion) values ("Transferencia");

insert into movimientos (idtipomovimiento,cuentaorigen,cuentadestino,fecha,detalles,importe) values (2,123813724,123813726,current_timestamp(),"Alta de cuenta", 10000);

# -- Estan los dni de los primeros clientes 
insert into prestamos (numerocuenta,dni,fecha,importesolicitado,importeapagar,montomensual,cuotas,estado) values (123813724,11111111,current_date(),50000,65000, 6500, 10, 3);
insert into prestamos (numerocuenta,dni,fecha,importesolicitado,importeapagar,montomensual,cuotas,estado) values (123813724,22222222,current_date(),5000,6500, 650, 10, 3);

# -- Estan los dni de los primeros clientes 
insert into prestamos (numerocuenta,dni,fecha,importesolicitado,importeapagar,montomensual,cuotas,estado) values (123813724,11111111,current_date(),1000,1200, 120, 10, 1);

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

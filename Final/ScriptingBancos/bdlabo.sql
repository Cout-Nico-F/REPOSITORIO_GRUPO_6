drop database if exists bdlabo;

create database bdlabo;
use bdlabo;

create table if not exists clientes (
	Dni int not null, #unique el valor ingresado no se puede repetir en registros posteriores
	IdUsuario int unsigned not null, #Es autoincrementable le agregue unique porque sino no dejaba que tipoUsuarios lo tenga como FK
    IdNacionalidad int not null,
    IdLocalidad int not null,
    Cuil varchar(15) unique not null, 
    Nombre varchar(45) not null,
    Apellido varchar(45) not null,
    Sexo varchar(20) not null, #Serian masculino - femenino - otro enviamos directamente la cadena las opciones van a ser seleccionables no es un input de texto
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
	NumeroCuenta bigint not null auto_increment, #Hay que validar que sean numeros
    Dni int null,
    IdTipoCuenta tinyint unsigned not null, #Solo hay 2 tipos de cuentas por eso tinyint(1) esta obsoleto ya lo saque
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
	IdPrestamos int unsigned auto_increment, #primero hacemos que sea pk y despues lo modificamos para que sea autoincrementable
    NumeroCuenta bigint not null,
	Dni int not null,
    Fecha date not null,
    ImporteSolicitado decimal(12,2) not null,
    ImporteAPagar decimal(12,2) not null,
    MontoMensual decimal(12,2) not null,
    Cuotas tinyint unsigned not null,
    Estado tinyint not null, #En MySQL, cero se considera falso y el valor distinto de cero se considera verdadero. Para usar literales booleanos,
    primary Key (IdPrestamos)
);
create table if not exists cuotas (
	IdPrestamos int unsigned not null,
    NumeroCuota tinyint not null,
    Importe decimal(12,2) not null, # que tipo de importe es?
    FechaVencimiento date not null,
    FechaPago date default null,
    Primary Key (IdPrestamos,NumeroCuota)
);
create table if not exists movimientos (
	IdMovimientos int unsigned auto_increment, #primero hacemos que sea pk y despues lo modificamos para que sea autoincrementable
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

# -------------------------------------------------- PRIMARY KEY --------------------------------------------------

# -- Clientes --
#alter table clientes add primary key (Dni);

# -- Usuarios --
#alter table usuarios add primary key (IdUsuario);

# -- Nacionalidad --
#alter table nacionalidades add primary key (IdNacionalidad);

# -- Localidad --
#alter table localidades add primary key (IdLocalidad);

# -- Provincia --
#alter table provincias add primary key (IdProvincia);

# -- Cuenta --
#alter table cuentas add primary key (NumeroCuenta);

# -- Tipo Cuentas --
#alter table tiposDeCuenta add primary key (IdTipoCuenta);

# -- Prestamos --
#alter table prestamos add primary key (IdPrestamos);

# -- Cuotas --
# Los pks estan declarados en la tabla

# -- Movimientos --
#alter table movimientos add primary key (IdMovimientos);

# -- Tipos Movimientos --
#alter table tiposMovimientos add primary key (IdTipoMovimiento);

# -------------------------------------------------- FOREIGN KEY --------------------------------------------------

# --Clientes --
alter table clientes add foreign key (IdUsuario) references usuarios (IdUsuario); #Error 1822 IdUsuario tenia que ser unique o pk
alter table clientes add foreign key (IdLocalidad) references localidades (IdLocalidad);
alter table clientes add foreign key (IdNacionalidad) references nacionalidades (IdNacionalidad);

# -- Localidad --
alter table localidades add foreign key (IdProvincia) references provincias (IdProvincia);

# -- Provincia --

# -- Cuenta --
alter table cuentas auto_increment=1000000;
alter table cuentas add foreign key (Dni) references clientes (Dni);
alter table cuentas add foreign key (IdTipoCuenta) references tiposDeCuenta (IdTipoCuenta);

# -- Tipo Cuentas --
#alter table tiposDeCuenta add foreign key (IdTipoCuenta) references cuentas (IdTipoCuenta); Esta foreign key no corresponde
#alter table tiposdecuenta drop constraint `tiposdecuenta_ibfk_1`;

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

# -- Tipos Movimientos --


#  --------------------------------------------------  MODIFY --------------------------------------------------

# -- Clientes --
#alter table clientes modify IdLocalidad int unsigned auto_increment;
#alter table clientes modify IdNacionalidad int unsigned auto_increment;

# -- Usuarios -- 
#alter table usuarios modify IdUsuario int unsigned auto_increment; #para que pueda ser autoincrementable primero tiene que ser pk o unique

# -- Nacionalidad --
#alter table nacionalidades modify IdNacionalidad int unsigned auto_increment not null;

# -- Localidad --
#alter table localidades modify IdLocalidad int unsigned auto_increment not null;
#alter table localidades modify IdProvincia int unsigned auto_increment not null;

# -- Provincia --
#alter table provincias modify IdProvincia int unsigned auto_increment not null;

# -- Prestamos --
#alter table prestamos modify IdPrestamos int unsigned auto_increment; #De forma predeterminada empieza en 1
#Dato el atributo auto_increment no es compatible con el datatype tinyint 

# -- Cuotas -- 
#alter table cuotas modify IdPrestamos int unsigned auto_increment;

# -- Movimientos -- 
#alter table movimientos modify IdMovimientos int unsigned auto_increment;

#SET Foreign_key_checks = 0; # Desactivamos las comprobaciones de reestricciones porque no se puede hacer auto_increment a un campo FK

#alter table usuarios modify IdUsuario int unsigned auto_increment;
#alter table tiposusuarios modify IdTipoUsuario int unsigned auto_increment;
#alter table nacionalidades modify IdNacionalidad int unsigned auto_increment;
#alter table localidades modify IdLocalidad int unsigned auto_increment;
#alter table provincias modify IdProvincia int unsigned auto_increment;
#alter table movimientos modify IdMovimientos int unsigned auto_increment;
#alter table tiposmovimientos modify IdTipoMovimiento tinyint unsigned auto_increment;
#alter table tiposDeCuenta modify IdTipoCuenta tinyint unsigned auto_increment;
#alter table prestamos modify IdPrestamos int unsigned auto_increment;

#SET Foreign_key_checks = 1; # Lo volvemos a activar

# -- Harcodeo algunos registros --
insert into nacionalidades (Nombre) values ("Argentina");
insert into provincias (Nombre) values ("Buenos Aires");
insert into localidades (IdProvincia,Nombre) values (1,"Escobar");

-- Agrego un usuario para probar el login --
insert into usuarios (NombreUsuario,Contrasenia,EsAdmin) values ("AlonsoHS20","12345",true); #tendriamos que encriptar la contrasenia el primer usuario va a tener IdUsuario 1 se supone

# -- Agrego un cliente y a ese cliente le creo un usuario --
insert into usuarios (NombreUsuario,Contrasenia,EsAdmin) values ("Nose","123",false); 
insert into usuarios (NombreUsuario,Contrasenia,EsAdmin) values ("Yase","123",false); 
insert into usuarios (NombreUsuario,Contrasenia,EsAdmin) values ("Rosa","123",false); 


insert into clientes (Dni,IdUsuario,IdNacionalidad,IdLocalidad,Cuil,Nombre,Apellido,Sexo,FechaNacimiento,Direccion,CorreoElectronico,TelefonoFijo,Celular) 
values (14203944,2,1,1,111111111111,"Nose","Valdez","Masculino","1975/08/13","Av.Siempre viva 123","prueba@gmail.com",01123948373, 1523344556);

insert into clientes (Dni,IdUsuario,IdNacionalidad,IdLocalidad,Cuil,Nombre,Apellido,Sexo,FechaNacimiento,Direccion,CorreoElectronico,TelefonoFijo,Celular) 
values (0303456,3,1,1,111111222111,"Yase","Gomez","Masculino","2000/06/25","Av.Nuenca muerta 987","prueba2@gmail.com",01123848373, 1523344557);

insert into clientes (Dni,IdUsuario,IdNacionalidad,IdLocalidad,Cuil,Nombre,Apellido,Sexo,FechaNacimiento,Direccion,CorreoElectronico,TelefonoFijo,Celular) 
values (30303030,4,1,1,112311222111,"Rosa","Flores","Femenino","1992/02/06","Av.San Martin 342","prueba3@gmail.com",01123848374, 1523344558);

insert into tiposdecuenta (Descripcion) values ("Caja de Ahorro");
insert into tiposdecuenta (Descripcion) values ("Cuenta Corriente");

insert into cuentas (dni,idtipocuenta,saldo,cbu,fechacreacion) values (14203944,1,10000,124124123,current_date());
insert into cuentas (dni,idtipocuenta,saldo,cbu,fechacreacion) values (14203944,2,10000,124124124,current_date());
insert into cuentas (dni,idtipocuenta,saldo,cbu,fechacreacion) values (null,1,0,124124125,current_date());
insert into cuentas (dni,idtipocuenta,saldo,cbu,fechacreacion) values (null,1,0,124124126,current_date());
insert into cuentas (dni,idtipocuenta,saldo,cbu,fechacreacion) values (0303456,1,10000,124124127,current_date());
insert into cuentas (dni,idtipocuenta,saldo,cbu,fechacreacion) values (null,2,0,124124128,current_date());
insert into cuentas (dni,idtipocuenta,saldo,cbu,fechacreacion) values (0303456,1,10000,124124129,"2021/06/13");
insert into cuentas (dni,idtipocuenta,saldo,cbu,fechacreacion) values (null,1,0,124124130,"2021/04/01");
insert into cuentas (dni,idtipocuenta,saldo,cbu,fechacreacion) values (null,2,10000,124124131,"2021/02/07");
insert into cuentas (dni,idtipocuenta,saldo,cbu,fechacreacion) values (30303030,2,10000,124124132,current_date());
insert into cuentas (dni,idtipocuenta,saldo,cbu,fechacreacion) values (30303030,1,10000,124124133,current_date());
insert into cuentas (dni,idtipocuenta,saldo,cbu,fechacreacion) values (30303030,1,10000,124124134,current_date());
insert into cuentas (dni,idtipocuenta,saldo,cbu,fechacreacion) values (null,1,0,124124135,"2021/06/17");
insert into cuentas (dni,idtipocuenta,saldo,cbu,fechacreacion) values (null,1,0,124124136,"2021/01/07");
insert into cuentas (dni,idtipocuenta,saldo,cbu,fechacreacion) values (null,1,0,124124137,"2020/12/06");


insert into tiposmovimientos (descripcion) values ("Alta de cuenta");
insert into tiposmovimientos (descripcion) values ("Alta de prestamo");
insert into tiposmovimientos (descripcion) values ("Pago de prestamo");
insert into tiposmovimientos (descripcion) values ("Transferencia");

insert into movimientos (idtipomovimiento,cuentaorigen,cuentadestino,fecha,detalles,importe) values (2,1000000,null,current_timestamp(),"Alta de cuenta", 10000);

insert into prestamos (numerocuenta,dni,fecha,importesolicitado,importeapagar,montomensual,cuotas,estado) values (1000000,14203944,current_date(),50000,65000, 6500, 10, 3);
insert into prestamos (numerocuenta,dni,fecha,importesolicitado,importeapagar,montomensual,cuotas,estado) values (1000001,14203944,current_date(),5000,6500, 650, 10, 3);
insert into prestamos (NumeroCuenta, Dni, Fecha, ImporteSolicitado, ImporteAPagar, MontoMensual, Cuotas, Estado)
values (1000006,0303456, current_date(), 100000, 120000, 10000, 12, 1);
insert into prestamos (NumeroCuenta, Dni, Fecha, ImporteSolicitado, ImporteAPagar, MontoMensual, Cuotas, Estado)
values (1000004,0303456, current_date(), 30000, 36000, 3000, 12, 1);
insert into prestamos (NumeroCuenta, Dni, Fecha, ImporteSolicitado, ImporteAPagar, MontoMensual, Cuotas, Estado)
values (1000004,0303456, current_date(), 30000, 33000, 5500, 6, 1);
insert into prestamos (NumeroCuenta, Dni, Fecha, ImporteSolicitado, ImporteAPagar, MontoMensual, Cuotas, Estado)
values (1000009,30303030, current_date(), 30000, 33000, 5500, 6, 1);
insert into prestamos (NumeroCuenta, Dni, Fecha, ImporteSolicitado, ImporteAPagar, MontoMensual, Cuotas, Estado)
values (1000009,30303030, current_date(), 60000, 72000, 6000, 12, 3);
insert into prestamos (numerocuenta,dni,fecha,importesolicitado,importeapagar,montomensual,cuotas,estado) values (1000000,14203944,current_date(),1000,1200, 120, 10, 1);

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

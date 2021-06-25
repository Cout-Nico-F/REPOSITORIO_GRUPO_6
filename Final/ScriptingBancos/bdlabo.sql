#use bdpersonas;
#drop database bdlabo;

create database bdlabo;
use bdlabo;

create table if not exists clientes (
	IdUsuario int unsigned not null, #Es autoincrementable
    IdNacionalidad int not null,
    IdLocalidad int not null,
	Dni int unique not null, #unique el valor ingresado no se puede repetir en registros posteriores
    Cuil bigint unique not null, 
    Nombre varchar(45) not null,
    Apellido varchar(45) not null,
    Sexo varchar(20) not null, #Serian masculino - femenino - otro enviamos directamente la cadena las opciones van a ser seleccionables no es un input de texto
    FechaNacimiento datetime not null,
    Direccion varchar(45) not null,
    CorreoElectronico varchar(45) not null,
	primary Key (IdUsuario,Dni)
);
create table if not exists usuarios (
	IdUsuario int unsigned not null,
    IdTipoUsuario tinyint(1) unsigned unique not null, #tinyint(1) ya que en MySQL no hay un tipo de datos booleano 
    #Error 1822: Para la relacion de foreign key, la columna de la tabla principal en la que se esta creando la relacion debe ser unique o primary y deben tener el mismo datatype y size.
    NombreUsuario varchar(45) not null,
    Contrasenia varchar(45) not null
);
create table if not exists tiposUsuarios (
	IdTipoUsuario tinyint(1) unsigned unique not null,
    Descripcion varchar(45) not null
);
create table if not exists telefonos(
	Dni int unique not null,
    Telefono int unique not null,
    Primary Key(Dni,Telefono)
);
create table if not exists nacionalidad (
	IdNacionalidad int not null,
    Nombre varchar(45) not null
);
create table if not exists localidad (
	IdLocalidad int not null,
    IdProvincia int not null,
    Nombre varchar(45) not null
);
create table if not exists provincia (
	IdProvincia int not null,
    Nombre varchar(45) not null
);
create table if not exists cuenta (
	NumeroCuenta bigint unique not null, #Hay que validar que sean numeros 
    Dni int unique not null,
    IdTipoCuenta tinyint(1) unsigned unique not null, #Solo hay 2 tipos de cuentas por eso tinyint(1)
    Saldo decimal not null,
    Cbu int unique not null,
    FechaCreacion datetime not null
);
create table if not exists tipoCuenta (
	IdTipoCuenta tinyint(1) unsigned unique not null,
    Descripcion varchar(45) not null
);
create table if not exists prestamos (
	IdPrestamos int unsigned unique, #primero hacemos que sea pk y despues lo modificamos para que sea autoincrementable
    NumeroCuenta bigint unique not null, #Los numeros de  cuenta no se repiten? por las dudas unique
	Dni int unique not null,
    Fecha datetime not null,
    ImporteSolicitado decimal not null,
    ImporteAPagar decimal not null,
    PlazoPagoMeses decimal not null,
    MontoMensual decimal not null,
    Cuotas tinyint unsigned not null,
    Estado tinyint(1) not null #En MySQL, cero se considera falso y el valor distinto de cero se considera verdadero. Para usar literales booleanos,
);
create table if not exists cuotas (
	IdPrestamos int unsigned unique,
    NumeroCuenta bigint unique not null,
    Importe decimal not null, # que tipo de importe es?
    FechaVencimiento datetime not null,
    FechaPago datetime not null,
    Primary Key (IdPrestamos,NumeroCuenta)
);
create table if not exists movimientos (
	IdMovimientos int unsigned unique, #primero hacemos que sea pk y despues lo modificamos para que sea autoincrementable
	IdTipoMovimiento tinyint unsigned unique not null,
	Dni int unique not null,
    CuentaOrigen bigint unique not null,
    CuentaDestino bigint unique not null,	
    Fecha datetime not null,
    Detalles text not null,
    Importe decimal not null
);
create table if not exists tiposMovimientos (
	IdTipoMovimiento tinyint unsigned unique not null,
    Descripcion varchar(45) not null
);

#Primary Key

# -- Clientes --
alter table clientes add primary key (Dni);
#alter table clientes modify IdUsuario int unsigned auto_increment; #para que pueda ser autoincrementable primero tiene que ser pk

# -- Usuarios --
alter table usuarios add primary key (IdUsuario);

# -- Tipos de usuarios --
alter table tiposUsuarios add primary key (IdTipoUsuario);

# -- Telefonos --
# Los pks estan declarados en la tabla

# -- Nacionalidad --
alter table nacionalidad add primary key (IdNacionalidad);
alter table nacionalidad modify IdNacionalidad int unsigned auto_increment;

# -- Localidad --
alter table localidad add primary key (IdLocalidad);
alter table localidad modify IdLocalidad int unsigned auto_increment;

# -- Provincia --
alter table provincia add primary key (IdProvincia);
alter table provincia modify IdProvincia int unsigned auto_increment;

# -- Cuenta --
alter table cuenta add primary key (NumeroCuenta);

# -- Tipo Cuentas --
alter table tipoCuenta add primary key (IdTipoCuenta);

# -- Prestamos --
alter table prestamos add primary key (IdPrestamos);
alter table prestamos modify IdPrestamos int unsigned auto_increment; #De forma predeterminada empieza en 1
#Dato el atributo auto_increment no es compatible con el datatype tinyint 

# -- Cuotas --
# Los pks estan declarados en la tabla

# -- Movimientos --
alter table movimientos add primary key (IdMovimientos);
alter table movimientos modify IdMovimientos int unsigned unique auto_increment;

# -- Tipos Movimientos --
alter table tiposMovimientos add primary key (IdTipoMovimiento);


# FOREIGN KEY

# --Clientes --


# -- Usuarios --
alter table usuarios add foreign key (IdUsuario) references clientes (IdUsuario);
 
# -- Tipos usuarios --
alter table tiposUsuarios add foreign key (IdTipoUsuario) references usuarios (IdTipoUsuario); #Por defecto cuando se crea una cuenta se setea en 1

# -- Cuenta --
alter table cuenta add foreign key (Dni) references clientes (Dni);
#alter table cuenta add foreign key (IdTipoCuenta) references tipoCuenta (IdTipoCuenta);

# -- Tipo Cuentas --
alter table tipoCuenta add foreign key (IdTipoCuenta) references cuenta (IdTipoCuenta);

# -- Prestamos --
alter table prestamos add foreign key (Dni) references clientes (Dni);
alter table prestamos add foreign key (NumeroCuenta) references cuenta (NumeroCuenta);

# -- Movimientos --
alter table movimientos add foreign key (Dni) references clientes (Dni);
#alter table movimientos add foreign key (IdTipoMovimiento) references tiposMovimientos (IdTipoMovimiento); esto va aca?

# -- Tipos Movimientos --
alter table tiposMovimientos add foreign key (IdTipoMovimiento) references movimientos (IdTipoMovimiento);

# Estos datos van a ser harcodeados por nosotros supongo

# -- Nacionalidad --
alter table nacionalidad add foreign key (IdNacionalidad) references clientes (IdNacionalidad);

# -- Localidad --
alter table localidad add foreign key (IdLocalidad) references clientes (IdLocalidad);

# -- Provincia --
alter table provincia add foreign key (IdProvincia) references localidad (IdProvincia);


# Agregando un cliente
Insert into clientes (idNacionalidad,IdLocalidad,Dni,Cuil,Nombre,Apellido,Sexo,Nacionalidad,FechaNacimiento,Direccion,Localidad,Provincia,CorreoElectronico,Telefono) 
values (1,1,14302823,11111111111,"Simon","Molina","Masculino",1,"2021/06/23","Av.Brasil 1233","Boulogne Sur Mer","Buenos Aires","prueba@gmail.com",47103847);

Insert into clientes (idNacionalidad,IdLocalidad,Dni,Cuil,Nombre,Apellido,Sexo,Nacionalidad,FechaNacimiento,Direccion,Localidad,Provincia,CorreoElectronico) 
values (1,1,24302823,22222222222,"Ramon","Molina","Masculino","Argentino","2021/06/23","Av.Brasil 1233","Boulogne Sur Mer","Buenos Aires","prueba@gmail.com"); #El telefono es opcional 

# Datos harcodeados
# Creo que la relacion localidad - provincia esta al reves
insert into nacionalidad (descripcion) values ("Argentina"); #Como el campo es ai entonces tendra como id = 1;
insert into localidad (descripcion) values ("San isidro");
insert into provincia (descripcion) values ("Buenos Aires");


#use bdpersonas;
#drop database bdlabo;

create database bdlabo;
use bdlabo;

create table if not exists clientes (
	Dni int not null, #unique el valor ingresado no se puede repetir en registros posteriores
	IdUsuario int unsigned not null, #Es autoincrementable le agregue unique porque sino no dejaba que tipoUsuarios lo tenga como FK
    IdNacionalidad int not null,
    IdLocalidad int not null,
    Cuil bigint unique not null, 
    Nombre varchar(45) not null,
    Apellido varchar(45) not null,
    Sexo varchar(20) not null, #Serian masculino - femenino - otro enviamos directamente la cadena las opciones van a ser seleccionables no es un input de texto
    FechaNacimiento datetime not null,
    Direccion varchar(45) not null,
    CorreoElectronico varchar(45) not null,
    Primary Key (Dni)
);
create table if not exists usuarios (
	IdUsuario int unsigned not null auto_increment,
    IdTipoUsuario tinyint unsigned not null, #tinyint(1) ya que en MySQL no hay un tipo de datos booleano 
    #Error 1822: Para la relacion de foreign key, la columna de la tabla principal en la que se esta creando la relacion debe ser unique o primary y deben tener el mismo datatype y size.
    NombreUsuario varchar(45) not null,
    Contrasenia varchar(45) not null,
	Primary Key (IdUsuario)
    
);
create table if not exists tiposUsuarios (
	IdTipoUsuario tinyint unsigned auto_increment,
    Descripcion varchar(45) not null,
	Primary Key (IdTipoUsuario)
);
create table if not exists telefonos(
	Dni int not null,
    Telefono int not null,
    Primary Key(Dni,Telefono)
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
	NumeroCuenta bigint not null, #Hay que validar que sean numeros 
    Dni int not null,
    IdTipoCuenta tinyint unsigned not null, #Solo hay 2 tipos de cuentas por eso tinyint(1) esta obsoleto ya lo saque
    Saldo decimal not null,
    Cbu int unique not null,
    FechaCreacion datetime not null,
    Primary Key (NumeroCuenta)
);
create table if not exists tiposDeCuenta (
	IdTipoCuenta tinyint unsigned auto_increment,
    Descripcion varchar(45) not null,
    Primary Key (IdTipoCuenta)
);
create table if not exists prestamos (
	IdPrestamos int unsigned auto_increment, #primero hacemos que sea pk y despues lo modificamos para que sea autoincrementable
    NumeroCuenta bigint not null, #Los numeros de  cuenta no se repiten? por las dudas unique
	Dni int not null,
    Fecha datetime not null,
    ImporteSolicitado decimal not null,
    ImporteAPagar decimal not null,
    PlazoPagoMeses decimal not null,
    MontoMensual decimal not null,
    Cuotas tinyint unsigned not null,
    Estado tinyint not null, #En MySQL, cero se considera falso y el valor distinto de cero se considera verdadero. Para usar literales booleanos,
    primary Key (IdPrestamos)
);
create table if not exists cuotas (
	IdPrestamos int unsigned not null,
    NumeroCuota tinyint not null,
    Importe decimal not null, # que tipo de importe es?
    FechaVencimiento datetime not null,
    FechaPago datetime not null,
    Primary Key (IdPrestamos,NumeroCuota)
);
create table if not exists movimientos (
	IdMovimientos int unsigned auto_increment, #primero hacemos que sea pk y despues lo modificamos para que sea autoincrementable
	IdTipoMovimiento tinyint unsigned not null,
	Dni int not null,
    CuentaOrigen bigint not null,
    CuentaDestino bigint not null,	
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

# -- Tipos de usuarios --
#alter table tiposUsuarios add primary key (IdTipoUsuario);

# -- Telefonos --
# Los pks estan declarados en la tabla

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

# -- Usuarios --
alter table usuarios add foreign key (IdTipoUsuario) references tiposUsuarios (IdTipoUsuario); #Por defecto cuando se crea una cuenta se setea en 1

# -- Tipos usuarios --


# -- Telefono --
alter table telefonos add foreign key (Dni) references clientes (Dni);
 
# -- Nacionalidad --


# -- Localidad --
alter table localidades add foreign key (IdProvincia) references provincias (IdProvincia);

# -- Provincia --

# -- Cuenta --
alter table cuentas add foreign key (Dni) references clientes (Dni);
alter table cuentas add foreign key (IdTipoCuenta) references tiposDeCuenta (IdTipoCuenta);

# -- Tipo Cuentas --
alter table tiposDeCuenta add foreign key (IdTipoCuenta) references cuentas (IdTipoCuenta);

# -- Prestamos --
alter table prestamos add foreign key (Dni) references clientes (Dni);
alter table prestamos add foreign key (NumeroCuenta) references cuentas (NumeroCuenta);

# -- Cuotas --
alter table cuotas add foreign key (IdPrestamos) references prestamos (IdPrestamos);

# -- Movimientos --
alter table movimientos add foreign key (Dni) references clientes (Dni);
alter table movimientos add foreign key (IdTipoMovimiento) references tiposMovimientos (IdTipoMovimiento);

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






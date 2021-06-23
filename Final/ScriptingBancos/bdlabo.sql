#use bdpersonas;
#drop database bdlabo;
 

create database bdlabo;
use bdlabo;

create table if not exists clientes (
	IdUsuario int unsigned not null,
	Dni int unique not null, #unique el valor ingresado no se puede repetir en registros posteriores
    Nombre varchar(45) not null,
    Apellido varchar(45) not null,
    Sexo char not null,
    Nacionalidad varchar(45) not null,
    FechaNacimiento datetime not null,
    Direccion varchar(45) not null,
    Localidad varchar(45) not null,
    Provincia varchar(45) not null,
    CorreoElectronico varchar(45) not null,
    Telefono int unsigned null, #unsigned hacer que no se acepten valores negativos por lo tanto puede almacenar el doble de valores positivos
	primary Key (IdUsuario,Dni)
);
create table if not exists usuarios (
	IdUsuario int unsigned not null,
    IdTipoUsuario char not null,
    NombreUsuario varchar(45) not null,
    Contrasenia varchar(45) not null
);
create table if not exists tiposUsuarios (
	IdTipoUsuario char not null,
    Descripcion varchar(45) not null
);
create table if not exists cuenta (
	NumeroCuenta int unique not null,
    Dni int unique not null,
    IdTipoCuenta tinyint unsigned not null,
    Saldo decimal not null,
    Cbu int unique not null,
    FechaCreacion datetime not null
);
create table if not exists tipoCuenta (
	IdTipoCuenta tinyint unsigned not null,
    Descripcion varchar(45) not null
);
create table if not exists prestamos (
	IdPrestamos int unsigned,
	Dni int unique not null,
    NumeroCuenta int unique not null, #Los numeros de  cuenta no se repiten? por las dudas unique
    Fecha datetime not null,
    ImporteSolicitado decimal not null,
    ImporteAPagar decimal not null,
    PlazoPagoMeses decimal not null,
    MontoMensual decimal not null,
    Cuotas tinyint unsigned not null
);
create table if not exists movimientos (
	Dni int unique not null,
    IdTipoMovimiento char not null,
    Fecha datetime not null,
    Detalles text not null, 
    Importe decimal not null,
    Primary Key (Dni,IdTipoMovimiento) #Creo que de esta manera se puede concatenar pks
);
create table if not exists tiposMovimientos (
	IdTipoMovimiento char not null,
    Descripcion varchar(45) not null
);

#Primary Key

# -- Clientes --
#Las pks estan declarados en la tabla
alter table clientes modify IdUsuario int unsigned auto_increment; #para que pueda ser autoincrementable primero tiene que ser pk

# -- Usuarios --
alter table usuarios add primary key (IdUsuario);

# -- Tipos de usuarios --
alter table tiposUsuarios add primary key (IdTipoUsuario);

# -- Prestamos --
alter table prestamos add primary key (IdPrestamos);

# -- Movimientos --
#Las pks estan declarados en la tabla

# -- Tipos Movimientos --
alter table tiposMovimientos add primary key (IdTipoMovimiento);

# -- Cuenta --
alter table cuenta add primary key (NumeroCuenta);

# -- Tipo Cuentas --
alter table tipoCuenta add primary key (IdTipoCuenta);

# FOREIGN KEY

# --Clientes --


# -- Usuarios --
alter table usuarios add foreign key (IdUsuario) references clientes (IdUsuario);
 
# -- Tipos usuarios --
alter table tiposUsuarios add foreign key (IdTipoUsuarios) references usuarios (IdTiposUsuarios); #Por defecto cuando se crea una cuenta se setea en 1

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





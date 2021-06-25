
use bdlabo;

# -- Harcodeo algunos registros --
insert into nacionalidades (IdNacionalidad,Nombre) values (1,"Agentina");
insert into provincias (IdProvincia,Nombre) values (1,"Buenos Aires");
insert into localidades (IdLocalidad,IdProvincia,Nombre) values (1,1,"Escobar");

# -- Para crear un cliente primero tiene que tener un cuenta -- Agrego un usuario para probar el login --
insert into tiposusuarios (IdTipoUsuario,Descripcion) values (1,"Cliente");
insert into tiposusuarios (IdTipoUsuario,Descripcion) values (2,"Admin");
insert into usuarios (IdUsuario,IdTipoUsuario,NombreUsuario,Contrasenia) values (1,2,"AlonsoHS20","12345"); #tendriamos que encriptar la contrasenia

# -- Agrego un cliente --
insert into clientes (Dni,IdUsuario,IdNacionalidad,IdLocalidad,Cuil,Nombre,Apellido,Sexo,FechaNacimiento,Direccion,CorreoElectronico) 
values (14203944,1,1,1,111111111111,"Alonso","Huarcaya","Masculino","2021/06/25","Av.Siempre viva 123","prueba@gmail.com");

use bdlabo;

# -- Harcodeo algunos registros --
insert into nacionalidades (IdNacionalidad,Nombre) values (1,"Agentina");
insert into provincias (IdProvincia,Nombre) values (1,"Buenos Aires");
insert into localidades (IdLocalidad,IdProvincia,Nombre) values (1,1,"Escobar");

# -- Para crear un cliente primero tiene que tener un cuenta 
insert into tiposusuarios (IdTipoUsuario,Descripcion) values (1,"Cliente");
insert into tiposusuarios (IdTipoUsuario,Descripcion) values (2,"Admin");

-- Agrego un usuario para probar el login --
insert into usuarios (IdUsuario,IdTipoUsuario,NombreUsuario,Contrasenia) values (1,2,"AlonsoHS20","12345"); #tendriamos que encriptar la contrasenia

# -- Agrego un cliente y a ese cliente le creo un usuario --
insert into usuarios (IdUsuario,IdTipoUsuario,NombreUsuario,Contrasenia) values (2,1,"Nose","123"); #tendriamos que encriptar la contrasenia -- tiene que tener un usuario antes para que pueda ser cliente?
insert into clientes (Dni,IdUsuario,IdNacionalidad,IdLocalidad,Cuil,Nombre,Apellido,Sexo,FechaNacimiento,Direccion,CorreoElectronico) 
values (14203944,2,1,1,111111111111,"Nose","Valdez","Masculino","2021/06/25","Av.Siempre viva 123","prueba@gmail.com");



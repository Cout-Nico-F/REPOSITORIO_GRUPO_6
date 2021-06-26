
use bdlabo;

# -- Harcodeo algunos registros --
insert into nacionalidades (Nombre) values ("Agentina");
insert into provincias (Nombre) values ("Buenos Aires");
insert into localidades (IdProvincia,Nombre) values (1,"Escobar");

# -- Para crear un cliente primero tiene que tener un cuenta 
insert into tiposusuarios (Descripcion) values ("Admin"); #El primer tipo de usuario ingresado es 1 
insert into tiposusuarios (Descripcion) values ("Cliente"); 


-- Agrego un usuario para probar el login --
insert into usuarios (IdTipoUsuario,NombreUsuario,Contrasenia) values (2,"AlonsoHS20","12345"); #tendriamos que encriptar la contrasenia el primer usuario va a tener IdUsuario 1 se supone

# -- Agrego un cliente y a ese cliente le creo un usuario --
insert into usuarios (IdTipoUsuario,NombreUsuario,Contrasenia) values (1,"Nose","123"); #tendriamos que encriptar la contrasenia -- tiene que tener un usuario antes para que pueda ser cliente?
insert into clientes (Dni,IdUsuario,IdNacionalidad,IdLocalidad,Cuil,Nombre,Apellido,Sexo,FechaNacimiento,Direccion,CorreoElectronico) 
values (14203944,2,1,1,111111111111,"Nose","Valdez","Masculino","2021/06/25","Av.Siempre viva 123","prueba@gmail.com");

Select * From usuarios 

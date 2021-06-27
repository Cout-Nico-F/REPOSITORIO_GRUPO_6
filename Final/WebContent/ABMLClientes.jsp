<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>ABML Clientes</title>
    <%@ include file="HeaderAdmin.jsp" %>  
    <script>
    $(document).ready(function() {
        var table = $('#clientes').DataTable( {
            language: {
                zeroRecords: "No hay resultados",
                info: "Página _PAGE_ de _PAGES_",
                infoEmpty: "No hay registros",
                infoFiltered: "(filtrada de _MAX_ registros totales)",
                search: "Buscar: "
            },
            lengthChange: false,
            data: [
            	  {
            		    "usuario": "WillieBenton",
            		    "nombre": "Hartman",
            		    "apellido": "Holman",
            		    "dni": 34886802
            		  },
            		  {
            		    "usuario": "BritneyRollins",
            		    "nombre": "Donna",
            		    "apellido": "Walsh",
            		    "dni": 18415869
            		  },
            		  {
            		    "usuario": "LandryWilliam",
            		    "nombre": "Hatfield",
            		    "apellido": "Ford",
            		    "dni": 19251677
            		  },
            		  {
            		    "usuario": "CarverFarrell",
            		    "nombre": "Kasey",
            		    "apellido": "Holcomb",
            		    "dni": 8779556
            		  },
            		  {
            		    "usuario": "WebsterMason",
            		    "nombre": "Trevino",
            		    "apellido": "Flynn",
            		    "dni": 17039425
            		  },
            		  {
            		    "usuario": "LydiaOrtega",
            		    "nombre": "Vanessa",
            		    "apellido": "Mcknight",
            		    "dni": 44215459
            		  },
            		  {
            		    "usuario": "DanielleMiddleton",
            		    "nombre": "Crosby",
            		    "apellido": "Freeman",
            		    "dni": 27120512
            		  },
            		  {
            		    "usuario": "ShannaNavarro",
            		    "nombre": "Kirkland",
            		    "apellido": "Greer",
            		    "dni": 14895148
            		  },
            		  {
            		    "usuario": "KatelynMoreno",
            		    "nombre": "Wendi",
            		    "apellido": "Harmon",
            		    "dni": 49490435
            		  },
            		  {
            		    "usuario": "GloverPugh",
            		    "nombre": "Turner",
            		    "apellido": "Mcmillan",
            		    "dni": 1534883
            		  },
            		  {
            		    "usuario": "MorganMayer",
            		    "nombre": "Carla",
            		    "apellido": "Page",
            		    "dni": 21150386
            		  },
            		  {
            		    "usuario": "DarlaFerguson",
            		    "nombre": "Barrett",
            		    "apellido": "Snyder",
            		    "dni": 25065382
            		  },
            		  {
            		    "usuario": "WheelerWeiss",
            		    "nombre": "Rachelle",
            		    "apellido": "Nash",
            		    "dni": 13210152
            		  },
            		  {
            		    "usuario": "HurstWalters",
            		    "nombre": "Florence",
            		    "apellido": "Dean",
            		    "dni": 50426189
            		  },
            		  {
            		    "usuario": "TanishaHouston",
            		    "nombre": "Roy",
            		    "apellido": "Bullock",
            		    "dni": 31229807
            		  },
            		  {
            		    "usuario": "PittmanSullivan",
            		    "nombre": "Hernandez",
            		    "apellido": "Carpenter",
            		    "dni": 15689770
            		  },
            		  {
            		    "usuario": "BallRamos",
            		    "nombre": "Woodard",
            		    "apellido": "Barber",
            		    "dni": 27443717
            		  },
            		  {
            		    "usuario": "WilkinsBoone",
            		    "nombre": "Mckay",
            		    "apellido": "Larsen",
            		    "dni": 29858217
            		  },
            		  {
            		    "usuario": "RenaOconnor",
            		    "nombre": "Chelsea",
            		    "apellido": "Kirk",
            		    "dni": 50111542
            		  },
            		  {
            		    "usuario": "PopeRichardson",
            		    "nombre": "Pugh",
            		    "apellido": "Horton",
            		    "dni": 54351674
            		  },
            		  {
            		    "usuario": "MarshallSellers",
            		    "nombre": "Audra",
            		    "apellido": "Hensley",
            		    "dni": 35916914
            		  },
            		  {
            		    "usuario": "MaynardKnox",
            		    "nombre": "Reid",
            		    "apellido": "Stout",
            		    "dni": 44789472
            		  },
            		  {
            		    "usuario": "DarleneGarza",
            		    "nombre": "Jordan",
            		    "apellido": "Garrett",
            		    "dni": 15934095
            		  },
            		  {
            		    "usuario": "MarleneMathews",
            		    "nombre": "Kathy",
            		    "apellido": "Pruitt",
            		    "dni": 48268726
            		  },
            		  {
            		    "usuario": "ElisabethCleveland",
            		    "nombre": "Angelina",
            		    "apellido": "Pitts",
            		    "dni": 51640836
            		  },
            		  {
            		    "usuario": "BenitaJimenez",
            		    "nombre": "Sweeney",
            		    "apellido": "Owen",
            		    "dni": 26723416
            		  },
            		  {
            		    "usuario": "LanePotter",
            		    "nombre": "Estela",
            		    "apellido": "Wiley",
            		    "dni": 43378012
            		  },
            		  {
            		    "usuario": "NellPena",
            		    "nombre": "Knight",
            		    "apellido": "Puckett",
            		    "dni": 36372011
            		  },
            		  {
            		    "usuario": "NortonMorton",
            		    "nombre": "Bowen",
            		    "apellido": "Bradford",
            		    "dni": 43089496
            		  },
            		  {
            		    "usuario": "ShepherdNoble",
            		    "nombre": "Clemons",
            		    "apellido": "Lindsay",
            		    "dni": 29077884
            		  },
            		  {
            		    "usuario": "TateHammond",
            		    "nombre": "Cleveland",
            		    "apellido": "Gilliam",
            		    "dni": 44217120
            		  },
            		  {
            		    "usuario": "McgowanHickman",
            		    "nombre": "Walls",
            		    "apellido": "Knight",
            		    "dni": 13903189
            		  },
            		  {
            		    "usuario": "HouseBoyd",
            		    "nombre": "Christi",
            		    "apellido": "Chavez",
            		    "dni": 17196421
            		  },
            		  {
            		    "usuario": "CindyGlass",
            		    "nombre": "Rosario",
            		    "apellido": "Brock",
            		    "dni": 13257742
            		  },
            		  {
            		    "usuario": "ConcepcionBradley",
            		    "nombre": "Barron",
            		    "apellido": "Mosley",
            		    "dni": 14415340
            		  },
            		  {
            		    "usuario": "BerniceWheeler",
            		    "nombre": "Sanders",
            		    "apellido": "Atkins",
            		    "dni": 51488102
            		  },
            		  {
            		    "usuario": "DenaDixon",
            		    "nombre": "Jacobson",
            		    "apellido": "Black",
            		    "dni": 11949850
            		  },
            		  {
            		    "usuario": "RosalesYork",
            		    "nombre": "Liz",
            		    "apellido": "Johns",
            		    "dni": 29116051
            		  },
            		  {
            		    "usuario": "BlackBaxter",
            		    "nombre": "Decker",
            		    "apellido": "Park",
            		    "dni": 11574098
            		  },
            		  {
            		    "usuario": "RobertChan",
            		    "nombre": "Cara",
            		    "apellido": "Lawson",
            		    "dni": 10202164
            		  },
            		  {
            		    "usuario": "JacobsHardin",
            		    "nombre": "Mayo",
            		    "apellido": "Bridges",
            		    "dni": 37621653
            		  },
            		  {
            		    "usuario": "SpencerPatton",
            		    "nombre": "Lindsay",
            		    "apellido": "Jefferson",
            		    "dni": 27309123
            		  },
            		  {
            		    "usuario": "AliciaMoss",
            		    "nombre": "Fern",
            		    "apellido": "Dennis",
            		    "dni": 25779993
            		  },
            		  {
            		    "usuario": "TamikaChang",
            		    "nombre": "Gladys",
            		    "apellido": "Garcia",
            		    "dni": 1511327
            		  },
            		  {
            		    "usuario": "BrowningHale",
            		    "nombre": "Grant",
            		    "apellido": "Jensen",
            		    "dni": 18534064
            		  },
            		  {
            		    "usuario": "LesleyBauer",
            		    "nombre": "Gutierrez",
            		    "apellido": "Franco",
            		    "dni": 20920635
            		  },
            		  {
            		    "usuario": "JeniferMarshall",
            		    "nombre": "Mueller",
            		    "apellido": "Carey",
            		    "dni": 53720619
            		  },
            		  {
            		    "usuario": "BrandyAvery",
            		    "nombre": "Torres",
            		    "apellido": "Wolfe",
            		    "dni": 37718537
            		  },
            		  {
            		    "usuario": "BarbraBecker",
            		    "nombre": "Celeste",
            		    "apellido": "Mcclure",
            		    "dni": 39212235
            		  },
            		  {
            		    "usuario": "SingletonAnderson",
            		    "nombre": "Berry",
            		    "apellido": "Roy",
            		    "dni": 35916145
            		  }
            		],
            columns: [
                {
                    data: 'usuario'
                },
                {
                    data: 'nombre'
                },
                {
                    data: 'apellido'
                },
                {
                	data: 'dni'
                },
                {
                	data: null,
               	 	render: function ( data, type, row ) {
                        return '<div class="text-center"v><button class="btn"><i class="bi bi-info-lg"></i></button><button class="btn"><i class="bi bi-pencil-fill"></i></button><button class="btn"><i class="bi bi-trash-fill"></i></button></div>'
                    }
                }
            ]
        } );
    } );
    </script>
  </head>
  <body>
    <div class="row">
      <div class="col  px-4 py-2">
        <form method="post" action="servletClientes">
          <fieldset>
            <legend>Nuevo cliente</legend>
            <div class="form-group row my-2">
              <label for="nombre" class="col-sm-3 col-form-label">Nombre</label>
              <div class="col-sm-9">      
                <input type="text" class="form-control" id="nombre" placeholder="Ingrese el nombre">
              </div>
            </div>
             <div class="form-group row my-2">
              <label for="apellido" class="col-sm-3 col-form-label">Apellido</label>
              <div class="col-sm-9">      
                <input type="text" class="form-control" id="apellido" placeholder="Ingrese el apellido">
              </div>
            </div>
             <div class="form-group row my-2">
              <label for="dni" class="col-sm-3 col-form-label">DNI</label>
              <div class="col-sm-9">      
                <input type="number" class="form-control" id="dni" placeholder="Ingrese el DNI">
              </div>
            </div>
             <div class="form-group row my-2">
              <label for="cuil" class="col-sm-3 col-form-label">CUIL</label>
              <div class="col-sm-9">      
                <input type="number" class="form-control" id="cuil" placeholder="Ingrese el CUIL">
              </div>
            </div>
            <div class="form-group row my-2">
              <label for="fecha" class="col-sm-3 col-form-label">Fecha de nacimiento</label>
              <div class="col-sm-9">      
                <input type="date" class="form-control" id="fecha" value="2000-01-01">
              </div>
            </div>
            <div class="form-group row my-2">
              <label for="sexo" class="col-sm-3 col-form-label">Sexo</label>
                <div class="col-sm-9">      
                <select class="form-control" id="sexo">
                <option>Femenino</option>
                <option>Masculino</option>
              </select>
              </div>
            </div>
             <div class="form-group row my-2">
              <label for="nacionalidad" class="col-sm-3 col-form-label">Nacionalidad</label>
                <div class="col-sm-9">      
                <select class="form-control" id="nacionalidad">
                <option>Argentina</option>
                <option>Otra</option>
              </select>
              </div>
            </div>
             <div class="form-group row my-2">
              <label for="provincia" class="col-sm-3 col-form-label">Provincia</label>
                <div class="col-sm-9">      
                <select class="form-control" id="provincia">
                <option>Buenos Aires</option>
 				<option>Capital Federal</option>
                <option>Otra</option>
              </select>
              </div>
            </div>
            <div class="form-group row my-2">
              <label for="localidad" class="col-sm-3 col-form-label">Localidad</label>
                <div class="col-sm-9">      
                <select class="form-control" id="localidad">
                <option>Tigre</option>
 				<option>Don Torcuato</option>
                <option>Otra</option>
              </select>
              </div>
            </div>
             <div class="form-group row my-2">
              <label for="telefono" class="col-sm-3 col-form-label">Teléfono</label>
              <div class="col-sm-9">      
                <input type="number" class="form-control" id="telefono" placeholder="Ingrese el teléfono">
              </div>
            </div>
            <div class="form-group row my-2">
              <label for="correo" class="col-sm-3 col-form-label">Correo electrónico</label>
              <div class="col-sm-9">      
                <input type="email" class="form-control" id=correo placeholder="Ingrese el correo electrónico">
              </div>
            </div>
            <div class="form-group row my-2">
              <label for="usuario" class="col-sm-3 col-form-label">Usuario</label>
              <div class="col-sm-9">      
                <input type="text" class="form-control" id="usuario" placeholder="Ingrese el usuario">
              </div>
            </div>
            <div class="form-group row my-2">
              <label for="contrasena" class="col-sm-3 col-form-label">Contraseña</label>
              <div class="col-sm-9">      
                <input type="password" class="form-control" id="contrasena" placeholder="Ingrese la contraseña">
              </div>
            </div>
            <div class="mt-3 py-4">
            <input type="submit" class="btn btn-primary" value="Registrar" name="btnRegistrar">
            <button type="submit" class="btn btn-secondary">Limpiar</button>
            </div>
          </fieldset>
        </form>
      </div>
      <div class="col px-4 py-2">
        <table id="clientes" class="table table-hover nowrap">
          <thead>
            <tr>
              <th scope="col" class="text-center">Usuario</th>
              <th scope="col" class="text-center">Nombre</th>
              <th scope="col" class="text-center">Apellido</th>
              <th scope="col" class="text-center">DNI</th>
              <th scope="col" class="text-center">Acciones</th>
            </tr>
          </thead>
        </table>
      </div>
    </div>
  </body>
</html>
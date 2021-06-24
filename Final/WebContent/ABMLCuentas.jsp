<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <title>ABML Cuentas</title>
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
            		    "usuario": "DoreenFletcher",
            		    "nombre": "Staci",
            		    "apellido": "Levine",
            		    "dni": 5326650,
            		    "numero": 3,
            		    "cbu": 44843806526,
            		    "fecha": "2018-01-25",
            		    "saldo": "$3882"
            		  },
            		  {
            		    "usuario": "LesterCobb",
            		    "nombre": "Palmer",
            		    "apellido": "Delaney",
            		    "dni": 4264546,
            		    "numero": 1,
            		    "cbu": 51635638227,
            		    "fecha": "2015-11-20",
            		    "saldo": "$2630"
            		  },
            		  {
            		    "usuario": "CastanedaFranco",
            		    "nombre": "Reba",
            		    "apellido": "Page",
            		    "dni": 39129617,
            		    "numero": 1,
            		    "cbu": 53989927151,
            		    "fecha": "2019-05-29",
            		    "saldo": "$3575"
            		  },
            		  {
            		    "usuario": "EvangelinaJarvis",
            		    "nombre": "Dillard",
            		    "apellido": "Dorsey",
            		    "dni": 16641934,
            		    "numero": 2,
            		    "cbu": 80327532440,
            		    "fecha": "2020-08-19",
            		    "saldo": "$1752"
            		  },
            		  {
            		    "usuario": "MitchellRojas",
            		    "nombre": "Emilia",
            		    "apellido": "Valenzuela",
            		    "dni": 11444139,
            		    "numero": 1,
            		    "cbu": 65280623022,
            		    "fecha": "2014-07-04",
            		    "saldo": "$3747"
            		  },
            		  {
            		    "usuario": "ReevesWatson",
            		    "nombre": "Neal",
            		    "apellido": "Carney",
            		    "dni": 6888359,
            		    "numero": 1,
            		    "cbu": 26411014509,
            		    "fecha": "2017-05-30",
            		    "saldo": "$2520"
            		  },
            		  {
            		    "usuario": "MarvaPierce",
            		    "nombre": "Bauer",
            		    "apellido": "Fitzgerald",
            		    "dni": 31025816,
            		    "numero": 1,
            		    "cbu": 22483121840,
            		    "fecha": "2021-02-19",
            		    "saldo": "$3286"
            		  },
            		  {
            		    "usuario": "SweetSullivan",
            		    "nombre": "Townsend",
            		    "apellido": "Morris",
            		    "dni": 8412589,
            		    "numero": 2,
            		    "cbu": 14603632567,
            		    "fecha": "2016-03-04",
            		    "saldo": "$2346"
            		  },
            		  {
            		    "usuario": "BarryMejia",
            		    "nombre": "Pansy",
            		    "apellido": "Morgan",
            		    "dni": 31272705,
            		    "numero": 1,
            		    "cbu": 60483786593,
            		    "fecha": "2014-06-03",
            		    "saldo": "$2146"
            		  },
            		  {
            		    "usuario": "ReeseReyes",
            		    "nombre": "Fernandez",
            		    "apellido": "Carroll",
            		    "dni": 38545234,
            		    "numero": 2,
            		    "cbu": 94891524558,
            		    "fecha": "2019-10-17",
            		    "saldo": "$2233"
            		  },
            		  {
            		    "usuario": "OlsonHouston",
            		    "nombre": "Lindsey",
            		    "apellido": "Hill",
            		    "dni": 36355108,
            		    "numero": 1,
            		    "cbu": 43123676428,
            		    "fecha": "2014-12-17",
            		    "saldo": "$3722"
            		  },
            		  {
            		    "usuario": "TrishaPreston",
            		    "nombre": "Marcy",
            		    "apellido": "Hudson",
            		    "dni": 39255520,
            		    "numero": 1,
            		    "cbu": 68459300859,
            		    "fecha": "2020-12-07",
            		    "saldo": "$3960"
            		  },
            		  {
            		    "usuario": "KaufmanCrane",
            		    "nombre": "Christie",
            		    "apellido": "Phillips",
            		    "dni": 24498956,
            		    "numero": 1,
            		    "cbu": 75165854166,
            		    "fecha": "2015-10-03",
            		    "saldo": "$1823"
            		  },
            		  {
            		    "usuario": "EbonyGarcia",
            		    "nombre": "Sherman",
            		    "apellido": "Hinton",
            		    "dni": 47825466,
            		    "numero": 3,
            		    "cbu": 87193390217,
            		    "fecha": "2017-08-20",
            		    "saldo": "$3599"
            		  },
            		  {
            		    "usuario": "LaraDuffy",
            		    "nombre": "Keisha",
            		    "apellido": "Cabrera",
            		    "dni": 15147245,
            		    "numero": 2,
            		    "cbu": 26593736091,
            		    "fecha": "2014-08-16",
            		    "saldo": "$1948"
            		  },
            		  {
            		    "usuario": "RasmussenChang",
            		    "nombre": "Goldie",
            		    "apellido": "Gould",
            		    "dni": 38587321,
            		    "numero": 2,
            		    "cbu": 30965774969,
            		    "fecha": "2015-11-18",
            		    "saldo": "$1203"
            		  },
            		  {
            		    "usuario": "ElenaRatliff",
            		    "nombre": "Deena",
            		    "apellido": "Valencia",
            		    "dni": 3394860,
            		    "numero": 1,
            		    "cbu": 91824581186,
            		    "fecha": "2016-06-08",
            		    "saldo": "$3343"
            		  },
            		  {
            		    "usuario": "OllieCase",
            		    "nombre": "Lee",
            		    "apellido": "Mcpherson",
            		    "dni": 47268778,
            		    "numero": 3,
            		    "cbu": 98408963742,
            		    "fecha": "2017-09-05",
            		    "saldo": "$2801"
            		  },
            		  {
            		    "usuario": "MurphyRoberts",
            		    "nombre": "Navarro",
            		    "apellido": "Eaton",
            		    "dni": 51338018,
            		    "numero": 1,
            		    "cbu": 56376811971,
            		    "fecha": "2015-10-26",
            		    "saldo": "$2239"
            		  },
            		  {
            		    "usuario": "AllenLong",
            		    "nombre": "Eva",
            		    "apellido": "Bullock",
            		    "dni": 32039694,
            		    "numero": 1,
            		    "cbu": 24949167484,
            		    "fecha": "2020-10-12",
            		    "saldo": "$1028"
            		  },
            		  {
            		    "usuario": "DelacruzAnthony",
            		    "nombre": "Wells",
            		    "apellido": "Ware",
            		    "dni": 29318946,
            		    "numero": 3,
            		    "cbu": 60584171622,
            		    "fecha": "2020-04-17",
            		    "saldo": "$3777"
            		  },
            		  {
            		    "usuario": "VelazquezHeath",
            		    "nombre": "Latoya",
            		    "apellido": "Franklin",
            		    "dni": 6341010,
            		    "numero": 1,
            		    "cbu": 45160001671,
            		    "fecha": "2019-12-15",
            		    "saldo": "$1088"
            		  },
            		  {
            		    "usuario": "LottieHobbs",
            		    "nombre": "Carol",
            		    "apellido": "Ingram",
            		    "dni": 6935738,
            		    "numero": 3,
            		    "cbu": 35320648795,
            		    "fecha": "2017-11-20",
            		    "saldo": "$2767"
            		  },
            		  {
            		    "usuario": "LorraineWeiss",
            		    "nombre": "Kline",
            		    "apellido": "Jensen",
            		    "dni": 24394884,
            		    "numero": 3,
            		    "cbu": 96579659442,
            		    "fecha": "2020-10-15",
            		    "saldo": "$2838"
            		  },
            		  {
            		    "usuario": "StokesLyons",
            		    "nombre": "Noel",
            		    "apellido": "Bolton",
            		    "dni": 43889489,
            		    "numero": 3,
            		    "cbu": 32716065393,
            		    "fecha": "2020-10-13",
            		    "saldo": "$3537"
            		  },
            		  {
            		    "usuario": "MorseDyer",
            		    "nombre": "Summer",
            		    "apellido": "Mayo",
            		    "dni": 26849964,
            		    "numero": 3,
            		    "cbu": 22270314393,
            		    "fecha": "2017-01-08",
            		    "saldo": "$2052"
            		  },
            		  {
            		    "usuario": "LatonyaStafford",
            		    "nombre": "Angelita",
            		    "apellido": "Perez",
            		    "dni": 38363266,
            		    "numero": 1,
            		    "cbu": 17945698678,
            		    "fecha": "2016-08-30",
            		    "saldo": "$3426"
            		  },
            		  {
            		    "usuario": "BarlowDoyle",
            		    "nombre": "Dyer",
            		    "apellido": "Knapp",
            		    "dni": 53613947,
            		    "numero": 2,
            		    "cbu": 26860995341,
            		    "fecha": "2019-08-10",
            		    "saldo": "$1934"
            		  },
            		  {
            		    "usuario": "VivianGarza",
            		    "nombre": "Walls",
            		    "apellido": "Stephens",
            		    "dni": 26268870,
            		    "numero": 1,
            		    "cbu": 34565374150,
            		    "fecha": "2020-05-20",
            		    "saldo": "$2270"
            		  },
            		  {
            		    "usuario": "NicholeWilder",
            		    "nombre": "Dana",
            		    "apellido": "Morales",
            		    "dni": 3597890,
            		    "numero": 1,
            		    "cbu": 28423088358,
            		    "fecha": "2014-09-11",
            		    "saldo": "$3934"
            		  },
            		  {
            		    "usuario": "MercadoRusso",
            		    "nombre": "Dawson",
            		    "apellido": "Hoover",
            		    "dni": 47329406,
            		    "numero": 3,
            		    "cbu": 48230726327,
            		    "fecha": "2020-06-23",
            		    "saldo": "$3561"
            		  },
            		  {
            		    "usuario": "HaneyTravis",
            		    "nombre": "Vicki",
            		    "apellido": "Atkins",
            		    "dni": 38667574,
            		    "numero": 1,
            		    "cbu": 45584604160,
            		    "fecha": "2015-04-13",
            		    "saldo": "$1637"
            		  },
            		  {
            		    "usuario": "McguireHampton",
            		    "nombre": "Johnnie",
            		    "apellido": "Knox",
            		    "dni": 37568509,
            		    "numero": 2,
            		    "cbu": 31963900468,
            		    "fecha": "2017-06-11",
            		    "saldo": "$1064"
            		  },
            		  {
            		    "usuario": "TuckerCarlson",
            		    "nombre": "Julianne",
            		    "apellido": "Vance",
            		    "dni": 43992688,
            		    "numero": 2,
            		    "cbu": 11947232783,
            		    "fecha": "2018-04-03",
            		    "saldo": "$2281"
            		  },
            		  {
            		    "usuario": "LucyGarner",
            		    "nombre": "Melissa",
            		    "apellido": "Coleman",
            		    "dni": 43546153,
            		    "numero": 3,
            		    "cbu": 66846049939,
            		    "fecha": "2019-01-18",
            		    "saldo": "$2358"
            		  },
            		  {
            		    "usuario": "MarisolHolman",
            		    "nombre": "Gould",
            		    "apellido": "Barrera",
            		    "dni": 18058058,
            		    "numero": 1,
            		    "cbu": 25554660763,
            		    "fecha": "2014-08-11",
            		    "saldo": "$1360"
            		  },
            		  {
            		    "usuario": "JacobsonWolfe",
            		    "nombre": "Caroline",
            		    "apellido": "Ramos",
            		    "dni": 25653396,
            		    "numero": 1,
            		    "cbu": 86948782644,
            		    "fecha": "2017-10-29",
            		    "saldo": "$1840"
            		  },
            		  {
            		    "usuario": "RobbieWitt",
            		    "nombre": "Karin",
            		    "apellido": "Hester",
            		    "dni": 22357956,
            		    "numero": 2,
            		    "cbu": 77082672568,
            		    "fecha": "2016-10-14",
            		    "saldo": "$3511"
            		  },
            		  {
            		    "usuario": "AnastasiaBooth",
            		    "nombre": "Melton",
            		    "apellido": "Barr",
            		    "dni": 37066056,
            		    "numero": 3,
            		    "cbu": 14288089948,
            		    "fecha": "2017-01-24",
            		    "saldo": "$1027"
            		  },
            		  {
            		    "usuario": "VictoriaFry",
            		    "nombre": "Head",
            		    "apellido": "Sandoval",
            		    "dni": 21639719,
            		    "numero": 1,
            		    "cbu": 17114951546,
            		    "fecha": "2015-12-24",
            		    "saldo": "$3447"
            		  },
            		  {
            		    "usuario": "FeleciaSimmons",
            		    "nombre": "Dale",
            		    "apellido": "Vincent",
            		    "dni": 30940833,
            		    "numero": 1,
            		    "cbu": 83215643562,
            		    "fecha": "2020-03-01",
            		    "saldo": "$3645"
            		  },
            		  {
            		    "usuario": "MullinsKirby",
            		    "nombre": "Chapman",
            		    "apellido": "Ortega",
            		    "dni": 52423383,
            		    "numero": 3,
            		    "cbu": 90312776356,
            		    "fecha": "2014-05-07",
            		    "saldo": "$1893"
            		  },
            		  {
            		    "usuario": "MarciVinson",
            		    "nombre": "Mccall",
            		    "apellido": "Henderson",
            		    "dni": 40460409,
            		    "numero": 1,
            		    "cbu": 93319384990,
            		    "fecha": "2017-10-14",
            		    "saldo": "$2454"
            		  },
            		  {
            		    "usuario": "SandyJohnston",
            		    "nombre": "Annette",
            		    "apellido": "Hartman",
            		    "dni": 24493624,
            		    "numero": 2,
            		    "cbu": 77429734515,
            		    "fecha": "2017-01-22",
            		    "saldo": "$3523"
            		  },
            		  {
            		    "usuario": "MorganSellers",
            		    "nombre": "Cantrell",
            		    "apellido": "Key",
            		    "dni": 27229673,
            		    "numero": 3,
            		    "cbu": 69299931068,
            		    "fecha": "2019-08-20",
            		    "saldo": "$3794"
            		  },
            		  {
            		    "usuario": "AlissaCruz",
            		    "nombre": "Patterson",
            		    "apellido": "Ortiz",
            		    "dni": 16942858,
            		    "numero": 2,
            		    "cbu": 98172969779,
            		    "fecha": "2016-05-24",
            		    "saldo": "$1222"
            		  },
            		  {
            		    "usuario": "ComptonMercer",
            		    "nombre": "Carrillo",
            		    "apellido": "Sampson",
            		    "dni": 54762896,
            		    "numero": 1,
            		    "cbu": 56512009171,
            		    "fecha": "2015-07-11",
            		    "saldo": "$1362"
            		  },
            		  {
            		    "usuario": "RhodesJordan",
            		    "nombre": "Bond",
            		    "apellido": "Woodard",
            		    "dni": 55213190,
            		    "numero": 1,
            		    "cbu": 35129649419,
            		    "fecha": "2019-07-03",
            		    "saldo": "$2090"
            		  },
            		  {
            		    "usuario": "JonesHodges",
            		    "nombre": "Joanne",
            		    "apellido": "Hawkins",
            		    "dni": 23723840,
            		    "numero": 1,
            		    "cbu": 57950379212,
            		    "fecha": "2021-02-18",
            		    "saldo": "$2960"
            		  },
            		  {
            		    "usuario": "MeredithGallagher",
            		    "nombre": "Stevenson",
            		    "apellido": "Norton",
            		    "dni": 52036596,
            		    "numero": 2,
            		    "cbu": 67934768204,
            		    "fecha": "2017-08-31",
            		    "saldo": "$3051"
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
                	data: 'numero',
                	className: 'dt-body-right'
                },
                {
                	data: 'cbu'
                },
                {
                	data: 'fecha',
                	className: 'dt-body-center'
                }, 
                {
                	data: 'saldo',
                	className: 'dt-body-right'
                },
                {
                	data: null,
               	 	render: function ( data, type, row ) {
                        return '<div class="text-center"><button class="btn"><i class="bi bi-pencil-fill"></i></button><button class="btn"><i class="bi bi-trash-fill"></i></button></div>'
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
        <form>
          <fieldset>
            <legend>Nueva cuenta</legend>
             <div class="form-group row my-2">
              <label for="dni" class="col-sm-3 col-form-label">DNI del cliente</label>
              <div class="col-sm-9">      
                <input type="number" class="form-control" id="dni" placeholder="Ingrese el DNI">
              </div>
            </div>
            <div class="form-group row my-2">
              <label for="tipo" class="col-sm-3 col-form-label">Tipo de cuenta</label>
                <div class="col-sm-9">      
                <select class="form-control" id="tipo">
                <option>Caja de ahorro</option>
                <option>Cuenta corriente</option>
              </select>
              </div>
            </div>
             <div class="form-group row my-2">
              <label for="numero" class="col-sm-3 col-form-label">Número de cuenta</label>
              <div class="col-sm-9">      
                <input type="number" class="form-control" id="numero" placeholder="Ingrese el Número de cuenta">
              </div>
            </div>
            <div class="form-group row my-2">
              <label for="cbu" class="col-sm-3 col-form-label">CBU</label>
              <div class="col-sm-9">      
                <input type="number" class="form-control" id="cbu" placeholder="Ingrese el CBU">
              </div>
            </div>
            <div class="form-group row my-2">
              <label for="saldo" class="col-sm-3 col-form-label">Saldo</label>
              <div class="col-sm-9">      
                <input type="number" class="form-control" id="saldo" placeholder="Ingrese el Saldo">
              </div>
            </div>
            <div class="mt-3">
            <button type="submit" class="btn btn-primary">Registrar</button>
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
              <th scope="col" class="text-center">Número de cuenta</th>
              <th scope="col" class="text-center">CBU</th>
              <th scope="col" class="text-center">Fecha de creación</th>
              <th scope="col" class="text-center">Saldo</th>
              <th scope="col" class="text-center">Acciones</th>
            </tr>
          </thead>
        </table>
      </div>
    </div>
  </body>
</html>
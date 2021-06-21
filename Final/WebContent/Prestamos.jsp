<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Solicitud de prestamo</title>
<link href="style-prestamos.css" rel="stylesheet" type="text/css">
</head>
<body>

        <br><br><br><br><br><br><br>
        <div class="wrapper">
        <div class="title">
          Bank loan application
        </div>
        <div class="form">
           <div class="inputfield">
              <label>DNI</label>
              <input type="number" class="input"> <!-- Only numbers-->
           </div>
           <div class="inputfield">
            <label>Account</label>
            <div class="custom_select">
              <select>
                <option value="">Select</option> <!-- Esto esta harcodeado nose si va el numero de cuenta a seleccionar o el nombre de la cuenta seleccionada -->
                <option value="credito">1212321312312312313213131231312</option>
                <option value="debito">2333333333333333333111111111114</option>
                <option value="corriente">3665555555677777777775666666665</option>
              </select>
            </div>
         </div>   
            <div class="inputfield">
              <label>Date</label>
              <input type="date" class="input">
           </div> 
          <div class="inputfield">
              <label>Amount requested</label>
              <input type="number" class="input">
           </div> 
          <div class="inputfield">
              <label>Total amount to pay</label> <!-- Esto se calculara y se mostrara un monto dependiendo de el importe solicitado -->
              <input type="number" class="input">
           </div> 
          <div class="inputfield">
              <label>payment term in months</label>
              <input type="number" class="input">
           </div> 
           <div class="inputfield">
            <label>Amount requested</label>
            <input type="number" class="input">
         </div>
         <div class="inputfield">
            <label>Monthly amount</label>
            <input type="number" class="input">
         </div>
         <div class="inputfield">
            <label>Dues</label>
            <div class="custom_select">
              <select>
                <option value="">Select</option> <!-- Esto esta harcodeado supongo que traeremos de bd la cantidad de cuotas disponible para el tipo de prestamo -->
                <option value="6">6</option>
                <option value="12">12</option>
                <option value="24">24</option>
                <option value="36">36</option>
              </select>
            </div>
         </div> 
          <div class="inputfield terms">
              <label class="check">
                <input type="checkbox">
                <span class="checkmark"></span>
              </label>
              <p>Agreed to terms and conditions</p>
           </div> 
          <div class="inputfield">
            <input type="submit" value="Apply for" class="btn">
          </div>
        </div>
    </div>	
</body>
</html>
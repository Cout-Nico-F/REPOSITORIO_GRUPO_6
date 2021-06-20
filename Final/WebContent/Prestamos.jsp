<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	   <style>
            *{
      margin: 0;
      padding: 0;
      box-sizing: border-box;
      font-family: 'Montserrat', sans-serif;
    }
    body{
      background: #000;
      background-image: url(https://images.unsplash.com/photo-1501167786227-4cba60f6d58f?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8YmFua3xlbnwwfHwwfHw%3D&ixlib=rb-1.2.1&w=1000&q=80);
      background-size: cover;
      padding: 0 10px;
    }
    .wrapper{
      max-width: 600px;
      width: 100%;
      background: #fff;
      margin: 20px auto;
      box-shadow: 2px 2px 4px rgba(0,0,0,0.125);
      padding: 30px;
      border: grey 1px solid;
    }
    
    .wrapper .title{
      font-size: 24px;
      font-weight: 700;
      margin-bottom: 25px;
      color: #fec107;
      text-transform: uppercase;
      text-align: center;
    }
    
    .wrapper .form{
      width: 100%;
    }
    
    .wrapper .form .inputfield{
      margin-bottom: 15px;
      display: flex;
      align-items: center;
    }
    
    .wrapper .form .inputfield label{
       width: 200px;
       color: #757575;
       margin-right: 10px;
      font-size: 14px;
    }
    
    .wrapper .form .inputfield .input,
    .wrapper .form .inputfield .textarea{
      width: 100%;
      outline: none;
      border: 1px solid #d5dbd9;
      font-size: 15px;
      padding: 8px 10px;
      border-radius: 3px;
      transition: all 0.3s ease;
    }
    
    .wrapper .form .inputfield .textarea{
      width: 100%;
      height: 125px;
      resize: none;
    }
    
    .wrapper .form .inputfield .custom_select{
      position: relative;
      width: 100%;
      height: 37px;
    }
    
    .wrapper .form .inputfield .custom_select:before{
      content: "";
      position: absolute;
      top: 12px;
      right: 10px;
      border: 8px solid;
      border-color: #d5dbd9 transparent transparent transparent;
      pointer-events: none;
    }
    
    .wrapper .form .inputfield .custom_select select{
      -webkit-appearance: none;
      -moz-appearance:   none;
      appearance:        none;
      outline: none;
      width: 100%;
      height: 100%;
      border: 0px;
      padding: 8px 10px;
      font-size: 15px;
      border: 1px solid #d5dbd9;
      border-radius: 3px;
    }
    
    
    .wrapper .form .inputfield .input:focus,
    .wrapper .form .inputfield .textarea:focus,
    .wrapper .form .inputfield .custom_select select:focus{
      border: 1px solid #fec107;
    }
    
    .wrapper .form .inputfield p{
       font-size: 14px;
       color: #757575;
    }
    .wrapper .form .inputfield .check{
      width: 15px;
      height: 15px;
      position: relative;
      display: block;
      cursor: pointer;
    }
    .wrapper .form .inputfield .check input[type="checkbox"]{
      position: absolute;
      top: 0;
      left: 0;
      opacity: 0;
    }
    .wrapper .form .inputfield .check .checkmark{
      width: 15px;
      height: 15px;
      border: 1px solid #fec107;
      display: block;
      position: relative;
    }
    .wrapper .form .inputfield .check .checkmark:before{
      content: "";
      position: absolute;
      top: 1px;
      left: 2px;
      width: 5px;
      height: 2px;
      border: 2px solid;
      border-color: transparent transparent #fff #fff;
      transform: rotate(-45deg);
      display: none;
    }
    .wrapper .form .inputfield .check input[type="checkbox"]:checked ~ .checkmark{
      background: #fec107;
    }
    
    .wrapper .form .inputfield .check input[type="checkbox"]:checked ~ .checkmark:before{
      display: block;
    }
    
    .wrapper .form .inputfield .btn{
      width: 100%;
       padding: 8px 10px;
      font-size: 15px; 
      border: 0px;
      background:  #fec107;
      color: #fff;
      cursor: pointer;
      border-radius: 3px;
      outline: none;
    }
    
    .wrapper .form .inputfield .btn:hover{
      background: #000;
    }
    
    .wrapper .form .inputfield:last-child{
      margin-bottom: 0;
    }
    
    @media (max-width:420px) {
      .wrapper .form .inputfield{
        flex-direction: column;
        align-items: flex-start;
      }
      .wrapper .form .inputfield label{
        margin-bottom: 5px;
      }
      .wrapper .form .inputfield.terms{
        flex-direction: row;
      }
    }
        </style>
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
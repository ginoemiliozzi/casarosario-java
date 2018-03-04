<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CasaRosario | Registrarse</title>
  <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Oswald" rel="stylesheet"> 

    <!-- Custom styles -->
    <link href="css/landing-page.min.css" rel="stylesheet">
    <script>
function pswderr() {
    var pswd1 = document.getElementById("password").value;
    var pswd2 = document.getElementById("cpassword").value;
    if (pswd1 !== pswd2) {
        document.getElementById("passValid").innerHTML = "Las contraseñas no coinciden. Intente nuevamente.";
        return false;
    } else {document.getElementById("passValid").innerHTML = "";
        return true;
        }
}
</script>
</head>
<body>
 <!-- Navigation -->

    <nav class="navbar navbar-light bg-light static-top">
      <div class="container">
  <a class="navbar-brand" href="index.jsp"><img alt="Casa Rosario" src="img/logo.png"></a>

      </div>
    </nav>
    
    
    <div class="container">
	<div class="row">
    <div class="col-md-8">
      <section>      
        <h1 class="entry-title"><span>Registrarse en Casa Rosario</span> </h1>
        <hr>
   <form class="form-horizontal" method="post" name="signup" id="signup" onsubmit="return pswderr(this);" action="Registro" >        
        <div class="form-group">
          <label class="control-label col-sm-3">Usuario <span class="text-danger">*</span></label>
          <div class="col-md-8 col-sm-9">
              <div class="input-group">
              <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
              <input type="text" class="form-control" name="userid" id="userid" placeholder="Ingresa el nombre de usuario" value="">
            </div>
		 </div>
        </div>
    
       	 <%if(request.getAttribute("userInvalido")!=null && (Boolean)request.getAttribute("userInvalido")){ %>
       	<div class="alert alert-danger">El nombre de usuario ya está en uso. Elija otro por favor.</div>
       	<%} %>
        
        <div class="form-group">
          <label class="control-label col-sm-3">Contraseña <span class="text-danger">*</span></label>
          <div class="col-md-5 col-sm-8">
            <div class="input-group">
              <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
              <input type="password" class="form-control" name="password" id="password" placeholder="Ingrese una contraseña" value="">
           </div>   
          </div>
        </div>
        <div class="form-group">
          <label class="control-label col-sm-3">Repetir contraseña <span class="text-danger">*</span></label>
          <div class="col-md-5 col-sm-8">
            <div class="input-group">
              <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
              <input type="password" class="form-control" name="cpassword" id="cpassword" placeholder="Confirme su contraseña" value="">
            </div>  
          </div>
        </div>
       <div id="passValid" ></div>
        
        <div class="form-group">
          <label class="control-label col-sm-3">Nombre <span class="text-danger">*</span></label>
          <div class="col-md-8 col-sm-9">
            <input type="text" class="form-control" name="nombre" id="nombre" placeholder="Ingrese su nombre" value="">
          </div>
        </div>
        
        <div class="form-group">
          <label class="control-label col-sm-3">Apellido <span class="text-danger">*</span></label>
          <div class="col-md-8 col-sm-9">
            <input type="text" class="form-control" name="apellido" id="apellido" placeholder="Ingrese su apellido" value="">
          </div>
        </div>
        
       <div class="form-group">
          <label class="control-label col-sm-3">DNI <span class="text-danger">*</span></label>
          <div class="col-md-8 col-sm-9">
            <input type="text" class="form-control" name="dni" id="dni" placeholder="Número de documento" value="">
          </div>
        </div>

        
        <div class="form-group">
          <label class="control-label col-sm-3">Teléfono <span class="text-danger">*</span></label>
          <div class="col-md-5 col-sm-8">
          	<div class="input-group">
              <span class="input-group-addon"><i class="glyphicon glyphicon-phone"></i></span>
            <input type="text" class="form-control" name="tel" id="tel" placeholder="Número de contacto" value="">
            </div>
          </div>
        </div>
        
        <div class="form-group">
          <div class="col-xs-offset-3 col-xs-10">
            <input name="registrar" type="submit" value="Registrarse" class="btn btn-primary" onClick="return pswderr();">
          </div>
        </div>
      </form>
    </div>
</div>
</div>
    
    

</body>
</html>
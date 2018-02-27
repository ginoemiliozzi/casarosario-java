<%@page import="java.sql.SQLException"%>
<%@page import="Entidades.Piso"%>
<%@page import="Utils.BaseDatos"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CasaRosario | Alquilar</title>

 	<!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Oswald" rel="stylesheet"> 

    <!-- Custom styles-->
    <link href="css/landing-page.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    
</head>
<body>
    <!-- Navigation -->

    <nav class="navbar navbar-light bg-light static-top">
      <div class="container">
        <a class="navbar-brand" href="index.jsp"><img alt="Casa Rosario" src="img/logo.png"></a>
 <%
 boolean userLogueado;
 if(request.getSession().getAttribute("currentUser")==null){//No hay nigun usuario logeado
	userLogueado =false;
	 
	 if(request.getAttribute("errorLogin")!=null){
		%>
		<div class="alert alert-danger">Usuario o contrasena incorrectos</div>
	<%}%>
	
	<form action="Login?sec=2" method="post">
	Usuario <input type="text" name="user">
	Contrasena <input type="password" name="password">
	<button type="submit" name="loguear" class="btn btn-primary">Ingresar</button>
	</form>
	
	<% } else { userLogueado =true; //Esta logeado un usuario%>

	<h5>Bienvenido <%=request.getSession().getAttribute("currentUser")%> </h5>
	<a href="Logout" class="btn btn-danger">Cerrar sesión</a>
	<% }%>
      </div>      
    </nav>
    
     <!-- Contenido -->
  



     <%if(userLogueado){ %>
     
    	    <div id="wrapper">

        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                    <a href="#">
                       Casa Rosario
                    </a>
                </li>
                <li>
                    <a href="Section?sec=2">Mis pisos</a>
                </li>
                <li>
                    <a href="Section?sec=3">Notificaciones</a>
                </li>
                <li>
                    <a href="Section?sec=1">Busco Piso</a>
                </li>
            </ul>
        </div>
        
        <!-- /#sidebar-wrapper -->
        
                <!-- Page Content -->        
        <div id="page-content-wrapper">
            <div class="container-fluid">
          <a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle">Menú</a>
    <%	   
    ArrayList<Piso> misPisos = (ArrayList) request.getAttribute("mispisos"); 	   			    			 
	    		 
	    		
	     %>
	     	<h1 class="text-center sec-titl">Mis inmuebles</h1>
		<%if(misPisos.isEmpty()){ //No hay inmuebles para mostrar al usuario%>		
			<p>Actualmente no tiene cargado ningún inmueble.</p>
		
		<%} else{//Hay inmuebles para mostrar al usuario
		for(Piso p: misPisos){%>
			<div class="card card-custom hvr-grow">
			  <div class="card-body">
			  <div style="float:left">
			  	<h5>Zona: <%=p.getZona() %></h5>
		
			  	<h6>
						Dirección:
						<%=p.getDireccion()%></h6>
					<h6><%=p.getHabitaciones()%>
						Habitaciones
					</h6>
					<h6><%=p.getBanos()%>
						Baños
					</h6>
			  </div>
			  <div style="float:right; padding: 20px;">
			  <img width=250 src="img/deptos/<%=p.getImg_url()%>">
			  </div>
			  </div>
			</div>
		<%}%>
	
	
	
		<%}%>

            </div>
        </div>
        <!-- /#page-content-wrapper -->

    </div>
    <!-- /#wrapper -->
     	
     <%}else{%>
     <div class="alert alert-warning text-center">Debe estar logueado para poder gestionar inmuebles.</div>
     <div class="text-center extra-info">
	     <p>Confía en nuestra labor como <b>administradores de tu vivienda</b> y alquila con <b>total tranquilidad</b>. Olvídate de solucionar cualquier problema que surja con el inquilino, nosotros nos encargaremos de todo. Te garantizamos que cobrarás la renta de tu inmueble el <b>día 5 de cada mes.</b></p>
		 <p>Queremos que tu única preocupación sea contar cuánto falta para el próximo DIA 5.</p>
     </div>
     
     <%} %>
                


    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Menu Toggle Script -->
    <script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
    </script>

</body>
</html>
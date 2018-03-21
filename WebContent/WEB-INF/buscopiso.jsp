<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="Entidades.Piso"%>
<%@page import="java.util.ArrayList"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CasaRosario | Busco Piso</title>
<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts -->
<link href="vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
	<script defer src="https://use.fontawesome.com/releases/v5.0.6/js/all.js"></script>

	
<link href="vendor/simple-line-icons/css/simple-line-icons.css"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Oswald"
	rel="stylesheet">

<!-- Custom styles -->
<link href="css/landing-page.min.css" rel="stylesheet">

    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<!-- Navigation -->

	<div class="container">
	<nav class="navbar navbar-light bg-light static-top">
		<a class="navbar-brand" href="index.jsp"><img alt="Casa Rosario"
			src="img/logo.png"></a>
		<%
			boolean userLogueado;
			if (request.getSession().getAttribute("currentUser") == null) {//No hay nigun usuario logeado
				userLogueado = false;

		if (request.getAttribute("errorLogin") != null) {
		%>
		<div class="alert alert-danger">Usuario o contrase�a incorrectos</div>
		<%}	%>		
		

		<form action="Login?sec=1" method="post">
			Usuario <input type="text" name="user"> Contrase�a <input
				type="password" name="password">
			<button type="submit" name="loguear" class="btn btn-primary">Ingresar</button>
		</form>
			<a href="registro.jsp"><button name="registrar" class="btn btn-sm btn-primary">Registrarse</button></a>

		<%} else {
				userLogueado = true; //Esta logeado un usuario %>
			
		<h5>
			Bienvenido
			<%=request.getSession().getAttribute("currentUser")%>
		</h5>
		<a href="Logout" class="btn btn-danger">Cerrar sesi�n</a>
		<%}	
			if (request.getAttribute("userNotificado") != null) {
				System.out.println(request.getAttribute("userNotificado"));
			%>
			<div class="alert alert-success">Se envi� la notificaci�n al usuario propietario!</div>
			<%}	%>

	</nav>
	<h1>Busco piso</h1>
	<form action="Section">
	<input type="hidden" name="sec" value="1">
  <div class="form-row">
  	<div class="col-2">
	Precio minimo:	<input type="number" class="form-control" name="min"><br>
  	</div>
  	<div class="col-2">
	Precio maximo: <input type="number" class="form-control" name="max">
  	</div>
  	<div class="col-4 offset-3">
		<button type="submit" class="btn btn-lg btn-primary">Filtrar</button>
  	</div>
	

	</div>
	</form>
	<div id="page-content-wrapper">
		<div class="row container-fluid">
			<%
				ArrayList<Piso> misPisos = (ArrayList) request.getAttribute("pisos");
				for (Piso p : misPisos) {
					
			%>
			<div class="card card-custom hvr-grow col-md-3">
				<div class="card-body">
					<img alt="Foto" src="img/deptos/<%=p.getImg_url()%>" height="120">
				
					<h5><%=p.getZona()%></h5>
					<h5 style="color:green">Precio Venta: $<%=p.getPrecio_venta() %></h5>
					<h6>Direcci�n:	<%=p.getDireccion()%></h6>
					<h6><%=p.getHabitaciones()%> Habitaciones</h6>
					<h6><%=p.getBanos()%> Ba�os</h6>
					<button class="info" onclick="document.getElementById('<%=p.getId() %>').style.display='block'"
class="w3-button">Ver Detalles</button>

					<!-- The Modal -->
					<div id="<%=p.getId() %>" class="w3-modal">
					  <div class="w3-modal-content">
					    <div class="w3-container">
					      <span onclick="document.getElementById('<%=p.getId() %>').style.display='none'" 
					      class="w3-button w3-display-topright">&times;</span>
					      	<img style="padding-top: 10px" ="Foto" src="img/deptos/<%=p.getImg_url()%>" height="480">
					      
					      <h2><%=p.getDireccion()%></h2>
					      <h3><%=p.getZona() %></h3>
					      <h3><%=p.getHabitaciones()%> Habitaciones</h3>
						  <h3><%=p.getBanos()%> Ba�os</h3>
						  <%if(p.isPermite_mascotas()){
							  %>
							 <p> <i class="fas fa-paw"></i> Permite Mascotas</p>

						 <%  }%>
						 <%if(p.isAmueblado()){
							  %>
							 <p> <i class="fas fa-truck"></i> Ya Amueblado</p>

						 <%  }%>
						 <%if(p.isAscensor()){
							  %>
							 <p> <i class="fas fa-caret-square-up"></i> Tiene Ascensor</p>

						 <%  }%>
						  <%if(p.isGimnasio()){
							  %>
							  <p><i class="fas fa-basketball-ball"></i> Tiene Gimnasio</p>

						 <%  }%>
						 <%if(p.isPiscina()){
							  %>
							  <p><i class="fas fa-tint"></i> Tiene Piscina</p>

						 <%  }%>
						 <%if(p.isAire_acondicionado()){
							  %>
							  <p><i class="fas fa-snowflake"></i> Tiene Aire Acondicionado</p>

						 <%  }%>
						 
						 
					 
					    </div>
					  </div>
					</div>
					
				
					<!-- End Modal -->
					<form action="Comprar" method="post">
						<input type="hidden" name="id" value="<%=p.getId()%>"> 
						<input	type="hidden" name="usuario"
							value="<%=request.getSession().getAttribute("currentUser")%>">
						<%if (userLogueado) {%>
						<button type="Submit" class="btn-primary">Comprar!</button>
						<%} else {%>
						<span onclick="alert('Debe estar logueado para comprar!')">
							<button type="button" class="btn-primary">Comprar!</button>
						</span>
						<%}%>
					</form>
				</div>
			</div>
			</div>
				<%
				}%>
		</div>
	</div>
</body>
</html>
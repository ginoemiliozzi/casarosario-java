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

	<nav class="navbar navbar-light bg-light static-top">
	<div class="container">
		<a class="navbar-brand" href="index.jsp"><img alt="Casa Rosario"
			src="img/logo.png"></a>
		<%
			boolean userLogueado;
			if (request.getSession().getAttribute("currentUser") == null) {//No hay nigun usuario logeado
				userLogueado = false;

				if (request.getAttribute("errorLogin") != null) {
		%>
		<div class="alert alert-danger">Usuario o contraseña incorrectos</div>
		<%}	%>

		<form action="Login?sec=1" method="post">
			Usuario <input type="text" name="user"> Contraseña <input
				type="password" name="password">
			<button type="submit" name="loguear" class="btn btn-primary">Ingresar</button>
		</form>

		<%} else {
				userLogueado = true; //Esta logeado un usuario %>

		<h5>
			Bienvenido
			<%=request.getSession().getAttribute("currentUser")%>
		</h5>
		<a href="Logout" class="btn btn-danger">Cerrar sesión</a>
		<%}	%>
	</div>
	</nav>
	<h1>Busco piso</h1>
	<div id="page-content-wrapper">
		<div class="row container-fluid">
			<%
				ArrayList<Piso> misPisos = (ArrayList) request.getAttribute("pisos");
				for (Piso p : misPisos) {
					if (p.getEstado().equals("Libre")) {
						//Esto lo podemos hacer en el SQL directamente, lo dejo aca por si lo queremos cambiar 
			%>
			<div class="card card-custom hvr-grow col-md-3">
				<div class="card-body">
					<img alt="Foto" src="img/deptos/<%=p.getImg_url()%>" height="120">
				
					<h5><%=p.getZona()%></h5>
					<h5 style="color:green">Precio Venta: $<%=p.getPrecio_venta() %></h6>
					<h6>Dirección:	<%=p.getDireccion()%></h6>
					<h6><%=p.getHabitaciones()%> Habitaciones</h6>
					<h6><%=p.getBanos()%> Baños</h6>
					<button class="info" onclick="document.getElementById('id01').style.display='block'"
class="w3-button">Ver Detalles</button>

					<!-- The Modal -->
					<div id="id01" class="w3-modal">
					  <div class="w3-modal-content">
					    <div class="w3-container">
					      <span onclick="document.getElementById('id01').style.display='none'" 
					      class="w3-button w3-display-topright">&times;</span>
					      	<img style="padding-top: 10px" ="Foto" src="img/deptos/<%=p.getImg_url()%>" height="480">
					      
					      <h2><%=p.getDireccion()%></h2>
					      <h3><%=p.getZona() %></h3>
					      <h3><%=p.getHabitaciones()%> Habitaciones</h3>
						  <h3><%=p.getBanos()%> Baños</h3>
						  <%if(p.isPermite_mascotas()){
							  %>
							 <p> <i class="fas fa-paw"></i> Permite Mascotas

						 <%  }%>
						 <%if(p.isAmueblado()){
							  %>
							 <p> <i class="fas fa-truck"></i> Ya Amueblado

						 <%  }%>
						 <%if(p.isAscensor()){
							  %>
							 <p> <i class="fas fa-caret-square-up"></i> Tiene Ascensor

						 <%  }%>
						  <%if(p.isGimnasio()){
							  %>
							  <p><i class="fas fa-basketball-ball"></i> Tiene Gimnasio

						 <%  }%>
						 <%if(p.isPiscina()){
							  %>
							  <p><i class="fas fa-tint"></i> Tiene Piscina

						 <%  }%>
						 <%if(p.isAire_acondicionado()){
							  %>
							  <p><i class="fas fa-snowflake"></i> Tiene Aire Acondicionado

						 <%  }%>
						 
						 
					      <p>
					    </div>
					  </div>
					</div>
					<!-- End Modal -->
					<form action="Comprar" method="post">
						<input type="hidden" name="id" value="<%=p.getId()%>"> <input
							type="hidden" name="usuario"
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
				<%}
				}%>
		</div>
</body>
</html>
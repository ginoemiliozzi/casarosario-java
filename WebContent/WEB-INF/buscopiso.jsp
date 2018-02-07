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
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Oswald" rel="stylesheet"> 

    <!-- Custom styles -->
    <link href="css/landing-page.min.css" rel="stylesheet">
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
		<div class="alert alert-danger">Usuario o contraseña incorrectos</div>
	<%}%>
	
	<form action="Login?sec=1" method="post">
	Usuario <input type="text" name="user">
	Contraseña <input type="password" name="password">
	<button type="submit" name="loguear" class="btn btn-primary">Ingresar</button>
	</form>
	
	<% } else { userLogueado =true; //Esta logeado un usuario%>

	<h5>Bienvenido <%=request.getSession().getAttribute("currentUser")%> </h5>
	<a href="Logout" class="btn btn-danger">Cerrar sesión</a>
	<% }%>
      </div>
    </nav>
	<h1>
		Busco piso
	</h1>
	 <div id="page-content-wrapper">
            <div class="container-fluid">
            <% ArrayList<Piso> misPisos = (ArrayList) request.getAttribute("pisos");
            for(Piso p: misPisos){
            	if(p.getEstado().equals("libre")){
            	%>
			<div class="card card-custom hvr-grow">
			  <div class="card-body">
			  	<h5><%=p.getZona() %></h5>
			  	<h6>Dirección: <%= p.getDireccion() %></h6>
			  	<h6><%= p.getHabitaciones() %> Habitaciones</h6>
			  	<h6><%=p.getBaños() %> Baños</h6>
			  	<form action="Comprar" method="post">
				<input type="hidden" name="id" value="<%=p.getId()%>">
				<input type="hidden" name="usuario" value="<%=request.getSession().getAttribute("currentUser")%>">
				
			  	<button type="Submit" class="btn-primary">Comprar!</button>
			  	</form>
			</div>
		<%}}%>
            </div>
	</div>
</body>
</html>
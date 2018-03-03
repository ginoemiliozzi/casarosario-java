<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Casa Rosario </title>

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

		<form action="Login?sec=<%= request.getAttribute("secError") %>" method="post">
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

	<div class="text-center">
		<h2>Disculpe, ocurrió un error inesperado...</h2>
		<img alt="error" src="img/error.jpg" height="250px" style="margin-top:10px;"><br>
		<a href="Section?sec=<%= request.getAttribute("secError") %>"><button class="btn btn-danger">Volver a intentar</button></a>
	</div>
	
	



</body>
</html>
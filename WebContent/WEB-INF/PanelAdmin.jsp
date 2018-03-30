<%@page import="Entidades.*"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CasaRosario | Panel de administrador</title>

  <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="vendor/simple-line-icons/css/simple-line-icons.css" rel="stylesheet" type="text/css">
	<link href="https://fonts.googleapis.com/css?family=Oswald" rel="stylesheet"> 

    <!-- Custom styles -->
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

		<h5>
			Bienvenido
			<%=request.getSession().getAttribute("currentUser")%>
		</h5>

		<a href="Logout" class="btn btn-danger">Cerrar sesión</a>
	</div>
	</nav>

	<div id="wrapper">

		<!-- Sidebar -->
		<div id="sidebar-wrapper">
			<ul class="sidebar-nav">
				<li class="sidebar-brand"><a href="#"> Casa Rosario </a></li>
				<li><a href="Section?sec=2">Mis pisos</a></li>
				<li><a href="Section?sec=3">Notificaciones</a></li>
				<li><a href="Section?sec=1">Busco Piso</a></li>
			</ul>
		</div>

		<!-- /#sidebar-wrapper -->

		<!-- Page Content -->
		<div id="page-content-wrapper">
			<div class="container-fluid">
				<a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle">Menú</a>
				<% List<Usuario> usuarios = (List<Usuario>)request.getAttribute("usuarios");  %>

				
					<%		for (Usuario usuario : usuarios) { %>

					<div class="card-body">
					Usuario: <%=usuario.getUsuario() %> - <%=usuario.getNombre() %> <%=usuario.getApellido() %>
					<%if(usuario.getInhabilitado()) {
					%>	
					<form action="PanelAdmin" method="post">
					<input type="hidden" value="<%=usuario.getUsuario()%>" name="usuario">
					<button type="submit" value="hab" name="hab">Habilitar</button>
					</form>
					<%}else{%>
					<form action="PanelAdmin" method="post">
					<input type="hidden" value="<%=usuario.getUsuario()%>" name="usuario">
					<button type="submit" value="inh" name="inh">Inhabilitar</button>
					</form>
					<% }%>
					</div>					
					
					<%} %>
				
			</div>
		</div>
	</div>



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
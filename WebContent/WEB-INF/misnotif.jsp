<%@page import="Entidades.Transaccion"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CasaRosario | Notificaciones</title>

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

	<h5>Bienvenido <%=request.getSession().getAttribute("currentUser")%>  </h5>
		
	<a href="Logout" class="btn btn-danger">Cerrar sesión</a>
      </div>
    </nav>
    
    
    <% ArrayList<Transaccion> misnotif = (ArrayList<Transaccion>)request.getAttribute("misnotif");  %>
    
    <ul>
    	<%for(Transaccion t : misnotif){ %>
    	<li> <%=t.id %> </li>
    	<%} %>
    </ul>
</body>
</html>
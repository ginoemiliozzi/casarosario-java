<%@page import="java.sql.SQLException"%>
<%@page import="Entidades.*"%>
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
		<div class="alert alert-danger"><%=request.getAttribute("errorLogin")%></div>
	<%}%>
	
	<form action="Login?sec=2" method="post">
	Usuario <input type="text" name="user">
	Contrasena <input type="password" name="password">
	<button type="submit" name="loguear" class="btn btn-primary">Ingresar</button>
	</form>
	
	<% } else { userLogueado =true; //Esta logeado un usuario%>

	<h5>Bienvenido <%=request.getSession().getAttribute("currentUser")%> </h5>
	<%if(request.getSession().getAttribute("misnotif")!=null){
		ArrayList<Transaccion> misnotif = (ArrayList<Transaccion>)request.getSession().getAttribute("misnotif"); 
		%><a href="Section?sec=3"><h5><%=misnotif.size() %> Notificaciones</h5></a><%} %>
		
	<a href="Logout" class="btn btn-danger">Cerrar sesi�n</a>
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
          <a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle">Men�</a>
    <%	   
    ArrayList<Piso> misPisos = (ArrayList) request.getAttribute("mispisos"); 	   			    			 
	    		 
	    		
	     %>
	     	<h1 class="text-center">Mis inmuebles
			<hr>
     		<a href="ABM-pisos.jsp" style="margin-top: 7px;">
				<button class="btn btn-success">Agregar nuevo!</button>					
			</a>
	     	</h1>
		<%if(misPisos.isEmpty()){ //No hay inmuebles para mostrar al usuario%>		
			<p>Actualmente no tiene cargado ningun inmueble.</p>
		
		<%} else{//Hay inmuebles para mostrar al usuario
		for(Piso p: misPisos){%>
			<div class="card card-custom hvr-grow">
			  <div class="card-body row">
			  <div class="col-md-6">
			  	<h5><%=p.getDireccion()%></h5>
		
			  	<h6>Zona: <%=p.getZona() %>	</h6>
					<h6><%=p.getHabitaciones()%>
						Habitaciones
					</h6>
					<h6><%=p.getBanos()%>
					<%
					if(p.getBanos()==1){%>
						Ba�o
				<% 	}else{	%>
						Ba�os
				<%	} %>
					</h6>
					<hr>
					<h4><b><%=p.getPrecio_venta()%></b></h4>
					<%
					String estado = p.getEstado();
					String color;
					boolean editar = false;
					if(estado.equals("Libre")){
						color = "green";
						editar = true;
					}else{
						color = "red";
					}
					%>
					<h6 style="color:<%=color%>"><%=p.getEstado()%>	</h6>
					<%if(editar){%>
					<form action="ABMPisos">
					<input type="hidden" name="id" value="<%=p.getId()%>">
					<input type="hidden" name="accion" value="consulta">
					<button class="btn btn-primary">Editar inmueble</button>					
					</form>
					<%}%>
			  </div>
			  <div class="col-md-6" style="padding: 20px;">
			  <img src="img/deptos/<%=p.getImg_url()%>">
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
	     <p>Conf�a en nuestra labor como <b>administradores de tu vivienda</b> y alquila con <b>total tranquilidad</b>. Olv�date de solucionar cualquier problema que surja con el inquilino, nosotros nos encargaremos de todo. Te garantizamos que cobrar�s la renta de tu inmueble el <b>d�a 5 de cada mes.</b></p>
		 <p>Queremos que tu �nica preocupaci�n sea contar cu�nto falta para el pr�ximo DIA 5.</p>
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
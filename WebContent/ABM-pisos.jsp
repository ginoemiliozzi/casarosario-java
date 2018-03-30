<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="Entidades.Piso"%>
<%@page import="Utils.BaseDatos"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CasaRosario | Piso</title>
<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts -->
<link href="vendor/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link href="vendor/simple-line-icons/css/simple-line-icons.css"
	rel="stylesheet" type="text/css">
<link href="https://fonts.googleapis.com/css?family=Oswald"
	rel="stylesheet">

<!-- Custom styles -->
<link href="css/landing-page.min.css" rel="stylesheet">

</head>
<body>
	<!-- Navigation -->
	<nav class="navbar navbar-light bg-light static-top">
	<div class="container">
		<a class="navbar-brand" href="index.jsp"><img alt="Casa Rosario"
			src="img/logo.png"></a>
			
 <%
 boolean userLogueado;
 if(request.getSession().getAttribute("currentUser")==null){//No hay nigun usuario logeado
	userLogueado =false;
	 
	 if(request.getAttribute("errorLogin")!=null){
		%>
		<div class="alert alert-danger"><%=request.getAttribute("errorLogin")%></div>
	<%}%>
	
	<form action="Login?sec=0" method="post">
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

<%
	Piso p= new Piso(true);
	if(request.getAttribute("piso")!=null){
		p = (Piso) request.getAttribute("piso");
		
	}
%>


	<div class="container">
		<div class="row">
			<div class="col-md-8">
				<section>
				<h1 class="entry-title">
					<span>Informacion del inmueble</span>
				</h1>
				<hr>
				<form class="form-horizontal" method="post" action="ABMPisos">
				<input type="hidden" name="id" value="<%=p.getId()%>">

	<%	 if(request.getSession().getAttribute("currentUser")!=null){						//Hay nigun usuario logeado %>
					<input type="hidden" name="propietario" value="<%=request.getSession().getAttribute("currentUser")%>" >		 
	<% 	 }	%>
					<div class="form-group">
						<label class="control-label col-sm-3" for="direccion">Direccion
							<span class="text-danger">*</span>
						</label>
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-envelope"></i></span> <input type="text"
								required class="form-control" name="direccion" id="direccion"	maxlength=100
								value="<%=p.getDireccion()%>" >
						</div>
					</div>


					<div class="form-group">
						<label class="control-label col-sm-3" for="zona">Zona <span
							class="text-danger">*</span></label> <select name="zona"
							class="form-control" id="zona">
							<% int zona = Integer.parseInt(p.getZona());
								switch(zona){
								case 1:		%>
							<option selected value=1>Norte</option>
							<option value=2>Este</option>
							<option value=3>Sur</option>
							<option value=4>Oeste</option>
							<option value=5>Centro</option>	
								<% 	break;
							case 2:		%>
							<option  value=1>Norte</option>
							<option selected value=2>Este</option>
							<option value=3>Sur</option>
							<option value=4>Oeste</option>
							<option value=5>Centro</option>	
								<% 	break;
							case 3:		%>
							<option value=1>Norte</option>
							<option value=2>Este</option>
							<option selected value=3>Sur</option>
							<option value=4>Oeste</option>
							<option value=5>Centro</option>	
								<% 	break;
							case 4:		%>
							<option value=1>Norte</option>
							<option value=2>Este</option>
							<option value=3>Sur</option>
							<option selected value=4>Oeste</option>
							<option value=5>Centro</option>	
								<% 	break;
							case 5:		%>
							<option value=1>Norte</option>
							<option value=2>Este</option>
							<option value=3>Sur</option>
							<option value=4>Oeste</option>
							<option selected value=5>Centro</option>	
								<% 	break;
								}
							%>
							
						</select>
					</div>

					<div class="form-group row">
						<div class="col-md-6">
							<label class="control-label" for="habitaciones">Cantidad
								de habitaciones <span class="text-danger"></span>
							</label>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-envelope"></i></span> <input type="number"
									class="form-control" name="habitaciones" id="habitaciones"
									value="<%=p.getHabitaciones()%>">
							</div>
						</div>
						<div class="col-md-6">
							<label class="control-label" for="banos">Cantidad de
								baños <span class="text-danger"></span>
							</label>
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-envelope"></i></span> <input type="number"
									class="form-control" name="banos" id="banos"
									value="<%=p.getBanos()%>">
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-6" style="padding-left: 5%;">
							<div class="form-check">
								<input class="form-check-input" name="permite_mascotas"
									type="checkbox" value="1" id="defaultCheck1"
									<%if(p.isPermite_mascotas()){%>
									checked
									<%} %>
									>
									<label	class="form-check-label" for="defaultCheck1"> Permite
									mascotas </label>
							</div>
							<div class="form-check">
								<input class="form-check-input" name="amueblado" type="checkbox"
									value="1" id="defaultCheck2"
									<%if(p.isAmueblado()){%>
									checked
									<%} %>									
									> <label
									class="form-check-label" for="defaultCheck2"> Amueblado
								</label>
							</div>
							<div class="form-check">
								<input class="form-check-input" name="aire_acondicionado"
									type="checkbox" value="1" id="defaultCheck3"
									<%if(p.isAire_acondicionado()){%>
									checked
									<%} %>
									> <label
									class="form-check-label" for="defaultCheck3"> Aire
									acondicionado </label>
							</div>
							<div class="form-check">
								<input class="form-check-input" name="piscina" type="checkbox"
									value="1" id="defaultCheck4"
									<%if(p.isPiscina()){%>
									checked
									<%} %>									
									> <label
									class="form-check-label" for="defaultCheck4"> Piscina </label>
							</div>
							<div class="form-check">
								<input class="form-check-input" name="ascensor" type="checkbox"
									value="1" id="defaultCheck5"
									<%if(p.isAscensor()){%>
									checked
									<%} %>
									> <label
									class="form-check-label" for="defaultCheck5"> Ascensor
								</label>
							</div>
							<div class="form-check">
								<input class="form-check-input" name="gimnasio" type="checkbox"
									value="1" id="defaultCheck6"
									<%if(p.isGimnasio()){%>
									checked
									<%} %>
									> <label
									class="form-check-label" for="defaultCheck6"> Gimnasio
								</label>

							</div>
						</div>
						<div class="form-group col-md-6">
							<label class="control-label" for="precio_venta">Precio de
								venta<span class="text-danger"></span>
							</label>
							<div class="input-group">
								<span class="input-group-addon">
								<i class="glyphicon glyphicon-envelope"></i></span>
								<input type="number" class="form-control" name="precio_venta" id="precio_venta" value="<%=p.getPrecio_venta()%>">
							</div>
						</div>
					</div>

	<%	 if(request.getSession().getAttribute("currentUser")!=null){						//Hay usuario logeado
			if(p.getId()!=-1){	//es modif (le pongo id -1 a los nuevos)  %>
				<button name="accion" type="submit" value="modif"	class="btn btn-primary">Confirmar modificacion</button>	
			<% }else{    //es alta %>
				<button name="accion" type="submit" value="alta"	class="btn btn-success">Agregar inmueble</button>	
			<% }	%>
	<%}else{	//no hay usuario logueado	%>
					<input name="acc" type="button" disabled value="Debe estar logueado para continuar"	class="btn btn-primary">		
	<%}%>
	

				</form>
			</div>
		</div>
	</div>
	</div>



</body>
</html>
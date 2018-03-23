<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Entidades.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CasaRosario | Home! </title>
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
	
	<%if(request.getAttribute("userRegistrado")!=null){
		%>
		<div class="alert alert-success">Usuario registrado con éxito!</div>
	<%}%>
	
	<form action="Login" method="post">
	Usuario <input type="text" name="user">
	Contraseña <input type="password" name="password">
	<button type="submit" name="loguear" class="btn btn-primary">Ingresar</button>
	</form>
	<a href="registro.jsp"><button name="registrar" class="btn btn-sm btn-primary">Registrarse</button></a>
	
	<% } else { userLogueado =true; //Esta logeado un usuario%>

	<h5>Bienvenido <%=request.getSession().getAttribute("currentUser")%>  </h5>
	<%if(request.getAttribute("misnotif")!=null){
		ArrayList<Transaccion> misnotif = (ArrayList<Transaccion>)request.getAttribute("misnotif"); 
		%><a href="Section?sec=3"><h5><%=misnotif.size() %></h5></a><%} %>
		
	<a href="Logout" class="btn btn-danger">Cerrar sesión</a>
	<% }%>
      </div>
    </nav>

    <!-- Masthead -->
    <header class="masthead text-white text-center">
      <div class="overlay"></div>
      <div class="container">
        <div class="row">
          <div class="col-xl-9 mx-auto">
            <h1 class="mb-5">Encontrá el lugar que estás buscando. Alquilá o vendé tu propiedad.</h1>
            <h3></h3>
            <p>Bienvenidos a <b>Casa Rosario</b>. Somos una agencia inmobiliaria dedicada a la venta y alquiler de pisos en las diferentes zonas de Rosario y alrededores, con el objetivo de ser la mejor alternativa para los vecinos de los barrios donde tenemos presencia.</p>
          </div>
        </div>
      </div>
    </header>

    <!-- Icons Grid -->
    <section class="features-icons bg-light text-center">
      <div class="container">
        <div class="row">
          <div class="col-lg-6">
            <div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3">
            
            <a href="Section?sec=1">
              <div class="features-icons-icon d-flex">
                <i class="icon-directions m-auto text-primary"></i>
              </div>              
              <h3>Busco piso</h3>
              </a>              
              <p class="lead mb-0">Encontrá tu lugar ideal!</p>
              
            </div>
          </div>
<!--           <div class="col-lg-4"> -->
<!--             <div class="features-icons-item mx-auto mb-5 mb-lg-0 mb-lg-3"> -->
            
<!--             <a href="Section?sec=2"> -->
<!--               <div class="features-icons-icon d-flex"> -->
<!--                 <i class="icon-key m-auto text-primary"></i> -->
<!--               </div>               -->
<!--               <h3>Quiero alquilar</h3> -->
<!--               </a> -->
<!--               <p class="lead mb-0">Conseguí al inquilino en poco tiempo!</p> -->
              
<!--             </div> -->
<!--           </div> -->
          <div class="col-lg-6">
            <div class="features-icons-item mx-auto mb-0 mb-lg-3">
            
            <a href="Section?sec=2">
              <div class="features-icons-icon d-flex">
                <i class="icon-home m-auto text-primary"></i>
              </div>              
              <h3>Quiero vender</h3>
              </a>
              <p class="lead mb-0">Acá podés vender tu piso!</p>
            </div>
          </div>
        </div>
      </div>
    </section>

    <!-- Image Showcases para poner los destacados
    <section class="showcase">
      <div class="container-fluid p-0">
        <div class="row no-gutters">

          <div class="col-lg-6 order-lg-2 text-white showcase-img" style="background-image: url('img/bg-showcase-1.jpg');"></div>
          <div class="col-lg-6 order-lg-1 my-auto showcase-text">
            <h2>Fully Responsive Design</h2>
            <p class="lead mb-0">When you use a theme created by Start Bootstrap, you know that the theme will look great on any device, whether it's a phone, tablet, or desktop the page will behave responsively!</p>
          </div>
        </div>
        <div class="row no-gutters">
          <div class="col-lg-6 text-white showcase-img" style="background-image: url('img/bg-showcase-2.jpg');"></div>
          <div class="col-lg-6 my-auto showcase-text">
            <h2>Updated For Bootstrap 4</h2>
            <p class="lead mb-0">Newly improved, and full of great utility classes, Bootstrap 4 is leading the way in mobile responsive web development! All of the themes on Start Bootstrap are now using Bootstrap 4!</p>
          </div>
        </div>
        <div class="row no-gutters">
          <div class="col-lg-6 order-lg-2 text-white showcase-img" style="background-image: url('img/bg-showcase-3.jpg');"></div>
          <div class="col-lg-6 order-lg-1 my-auto showcase-text">
            <h2>Easy to Use &amp; Customize</h2>
            <p class="lead mb-0">Landing Page is just HTML and CSS with a splash of SCSS for users who demand some deeper customization options. Out of the box, just add your content and images, and your new landing page will be ready to go!</p>
          </div>
        </div>
      </div>
    </section>
-->
    <!-- Footer -->
    <footer class="footer bg-light">
      <div class="container">
        <div class="row">
          <div class="col-lg-6 h-100 text-center text-lg-left my-auto">
            <ul class="list-inline mb-2">
              <li class="list-inline-item">
                <a href="#">About</a>
              </li>
              <li class="list-inline-item">&sdot;</li>
              <li class="list-inline-item">
                <a href="#">Contact</a>
              </li>
              <li class="list-inline-item">&sdot;</li>
              <li class="list-inline-item">
                <a href="#">Terms of Use</a>
              </li>
              <li class="list-inline-item">&sdot;</li>
              <li class="list-inline-item">
                <a href="#">Privacy Policy</a>
              </li>
            </ul>
            <p class="text-muted small mb-4 mb-lg-0">&copy; Casa Rosario 2017. All Rights Reserved.</p>
          </div>
          <div class="col-lg-6 h-100 text-center text-lg-right my-auto">
            <ul class="list-inline mb-0">
              <li class="list-inline-item mr-3">
                <a href="#">
                  <i class="fa fa-facebook fa-2x fa-fw"></i>
                </a>
              </li>
              <li class="list-inline-item mr-3">
                <a href="#">
                  <i class="fa fa-twitter fa-2x fa-fw"></i>
                </a>
              </li>
              <li class="list-inline-item">
                <a href="#">
                  <i class="fa fa-instagram fa-2x fa-fw"></i>
                </a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    
    
	
</body>
</html>
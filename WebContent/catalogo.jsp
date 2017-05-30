<%@page import="modelo.QuerysBD"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
  <script>
    function Limpiar(){ 
      sessionStorage.clear();
      sessionStorage.removeItem('nombre');
      alert("salio todo")
    } 
  </script>
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>ECOCAMBIO</title>

    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link rel="stylesheet" type="text/css" href="assets/js/bootstrap-datepicker/css/datepicker.css" />
    <link rel="stylesheet" type="text/css" href="assets/js/bootstrap-daterangepicker/daterangepicker.css" />
        
    <!-- Custom styles for this template -->
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/style-responsive.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
  <style>
table.GeneratedTable {
  width: 100%;
  background-color: #ffffff;
  border-collapse: collapse;
  border-width: 5px;
  border-color: #302013;
  border-style: solid;
  color: #000000;
}

table.GeneratedTable td, table.GeneratedTable th {
  border-width: 5px;
  border-color: #302013;
  border-style: solid;
  padding: 3px;
}

table.GeneratedTable thead {
  background-color: #007f00;
}
</style>
  
    <section id="container" >
      <header class="header black-bg" bgcolor = "#007f00">
            <div class="sidebar-toggle-box">
              <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
            </div>
            <!--logo start-->
            <a href="index.html" class="logo"><b>ECOCAMBIO</b></a>
            <!--logo end-->
            <div class="nav notify-row" id="top_menu">
                <!--  notification start -->
                <ul class="nav top-menu">
                </ul>
                <!--  notification end -->
            </div>
          <div class="top-menu" bgcolor = "#007f00">
            	<ul class="nav pull-right top-menu">
                    <li><a class="logout" href="Inicio.html" bgcolor = "#68dff0" onclick = "Limpiar()">Cerrar sesion</a></li>
            	</ul>
          </div>
      </header>
      <!--header end-->
      <aside>
          <div id="sidebar"  class="nav-collapse ">
              <!-- sidebar menu start-->
              <ul class="sidebar-menu" id="nav-accordion">
              
              	  <p class="centered"><a href="home.jsp"><img src="assets/img/ui-sam.jpg" class="img-circle" width="60"></a></p>
              	  <h5 class="centered"><%=session.getAttribute("boleta")%></h5>
              	  <br>
              	  <h5 class="centered">Puntos: <%=session.getAttribute("puntos")%></h5>
              	  
              	  <li class="mt">
                      <a href="home.jsp">
                          <i class="fa fa-book"></i>
                          <span>Informacion del usuario</span>
                      </a>
                  </li>
                  <li class="mt">
                      <a href="catalogo.jsp">
                          <i class="fa fa-book"></i>
                          <span>Productos</span>
                      </a>
                  </li>
                  <li class="mt">
                      <a data-toggle="modal" href="home.jsp#myModal">
                          <i class="fa fa-book"></i>
                          <span>Modificar informacion</span>
                      </a>
                  </li>
              </ul>
              <!-- sidebar menu end-->
          </div>
      </aside>
      <!--sidebar end-->
      
      <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
      <!--main content start-->
     <section id="main-content">
          <section class="wrapper site-min-height">
          	<h3><i class="fa fa-angle-right"></i>Productos en nuestra sistema.</h3>
          	<div class="row mt">
          		<div class="col-lg-12">

              	<section id="unseen">
                      <table class="GeneratedTable">
                        <thead>
                        <tr>
                            <th align = "center" style="width:600px; font-size:25px;"> Producto </th>
                            <th align = "center" style="width:300px; font-size:25px;"> Costo </th>
                        </tr>
                        </thead>
                        <tbody>
                        <%
                        String [][] productos = QuerysBD.Productos();
      	               	for(int i = 0; i < productos.length; i++){
                     		out.print("<tr>");
                     		out.print("<td align = 'center' style='font-size:25px;'>" + productos[i][0]+ "</td>");
                     		out.print("<td align = 'center' style='font-size:25px;'>" + productos[i][1]+ "</td>");
                     		out.print("<td align = 'center'> <a class='btn btn-theme' href = 'ComprarProducto?costo=" + productos[i][1] + "&nombre=" + productos[i][0] + "&boleta=" + session.getAttribute("boleta") + "' >comprar</a></td>");
                     		out.print("</tr>");
                     	}
                        %>
                        </tbody>
                    </table>
                    </section>

          		</div>
          	</div>
			
		    </section><!--/wrapper -->
      </section><!--/MAIN CONTENT -->
      <!--main content end-->
      <!--footer start-->
      <footer class="site-footer">
          <div class="text-center">
              2014 - Alvarez.is
              Aplicacion Creada en 2016.
              Admin Tool.
              Plantilla publica.
              <a href="form_component.html" class="go-top">
                  <i class="fa fa-angle-up"></i>
              </a>
          </div>
      </footer>
      <!--footer end-->
    </section>
    <form class="form-login" action="UpdateInfo" method = "POST">
              <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
                  <div class="modal-dialog">
                      <div class="modal-content">
                          <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                              <h4 class="modal-title">Modificacion de tu informacion</h4>
                          </div>
                          <div class="modal-body">
                              <p>Nuevo nombre</p>
                              <input type="text" name="nombre" placeholder="Nombre" autocomplete="off" class="form-control placeholder-no-fix">
                              <br>
                              <p>Nuevo correo</p>
                              <input type="email" name="email" placeholder="Correo" autocomplete="off" class="form-control placeholder-no-fix">
                              <br>
                              <p>Nueva contraseña</p>
                              <input type="password" name="password" placeholder="Contraseña" autocomplete="off" class="form-control placeholder-no-fix">
    
                          </div>
                          <div class="modal-footer">
                              <button data-dismiss="modal" class="btn btn-default" type="button">Cancel</button>
                              <button class="btn btn-theme" type="submit">Enviar</button>
                          </div>
                      </div>
                  </div>
              </div>
      </form>
    <!-- js placed at the end of the document so the pages load faster -->
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script class="include" type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="assets/js/jquery.scrollTo.min.js"></script>
    <script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>


    <!--common script for all pages-->
    <script src="assets/js/common-scripts.js"></script>

    <!--script for this page-->
    <script src="assets/js/jquery-ui-1.9.2.custom.min.js"></script>

	<!--custom switch-->
	<script src="assets/js/bootstrap-switch.js"></script>
	
	<!--custom tagsinput-->
	<script src="assets/js/jquery.tagsinput.js"></script>
	
	<!--custom checkbox & radio-->
	
	<script type="text/javascript" src="assets/js/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
	<script type="text/javascript" src="assets/js/bootstrap-daterangepicker/date.js"></script>
	<script type="text/javascript" src="assets/js/bootstrap-daterangepicker/daterangepicker.js"></script>
	
	<script type="text/javascript" src="assets/js/bootstrap-inputmask/bootstrap-inputmask.min.js"></script>
	
	
	<script src="assets/js/form-component.js"></script>    
    
    
  <script>
      //custom select box

      $(function(){
          $('select.styled').customSelect();
      });
  </script>

  </body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="http://maps.google.com/maps/api/js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
<script src="js/index.js"></script>
<!-- Custom Theme JavaScript -->
<script src="js/freelancer.js"></script>

<!--  link rel="stylesheet" type="text/css" href="css/menu.css" /-->
<link href="css/bootstrap.css" rel="stylesheet" type = "text/css">
<!--  link href="css/bootstrap-theme.css" rel="stylesheet" type = "text/css"-->
<link href="css/freelancer.css" rel="stylesheet">
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" type="image/x-icon" href="img/auto.png" />
<title>Les fous du volant - Accueil</title>
</head>
<body onload="afficherBL()">

<nav class="navbar navbar-default navbar-fixed-top navbar-shrink">
  <div class="container-fluid">
    <div class="navbar-header page-scroll">
        <a class="navbar-brand" href="#"><i class="fa fa-car"></i> Les Fous du volant</a>
    </div>
      <ul class="nav navbar-nav navbar-right">
        <li class="hidden">
            <a href="#page-top"></a>
        </li>
        <li>
            <a class="page-scroll" href="Login">Se connecter</a>
        </li>
        <li>
            <a class="page-scroll" href="Register">S'inscrire</a>
        </li>
      </ul>
  </div>
</nav>

<section class="success">
    <div class="container">
            <div class="col-lg-12 text-center">
                <h3>Les fous du volant</h3>
                <hr class="star-light">
            </div>        
    </div>
</section>

<section>
	<div class="container">   
	    <div id="destinationForm">
	        <form action="Index" method="POST" name="direction" id="direction">
	            <div class="row control-group">
	                <div class="form-group col-xs-6 floating-label-form-group controls">
	                    <label>Adresse à chercher</label>
	                    <input type="text" name="origin" id="origin" class="form-control" placeholder="Adresse à chercher" id="adresse" required data-validation-required-message="Please enter adresse." aria-invalid="false">
	                    <p class="help-block text-danger"></p>
	                </div>
	                <span class="col-xs-1"></span>
	                <SELECT class="liste_d col-xs-2 input-lg" name="area" size="1" id="area">
	                    <OPTION value="1">1 Km</option>
	                    <OPTION value="2">2 Km</option>
	                    <OPTION value="3">3 Km</option>
	                    <OPTION value="4">4 Km</option>
	                    <OPTION value="5" selected>5 Km</option>
	                    <OPTION value="10">10 Km</option>
	                    <OPTION value="20">20 Km</option>
	                    <OPTION value="30">30 Km</option>
	                </SELECT>
	                <span class="col-xs-1"></span>
	                <button class="btn btn-success btn-lg col-xs-2" type="button" value="Rechercher" onclick="javascript:sendToServer()">Rechercher</button>
	            </div>
	            <!--  input class="col-sm-6" type="text" name="origin" id="origin" placeholder="Adresse..." onchange="calcRoute();"-->
	            <div class="col-sm3"> 
	            </div>
	                            
	        </form>
	    </div>
	    <br>
	    <h5>Emplacements des conducteurs prêts à vous amener à Berger-Levrault</h5>
	</div>
	   
	<div id="map_canvas"></div>
	
</section>
<footer class="text-center">
	<div class="footer-below">
	    <div class="container">
	        <div class="row">
	            <div class="col-lg-12">
	                &copy; 2016 Les fous du volant
	            </div>
	        </div>
	    </div>
	</div>
</footer>
</body>
</html>
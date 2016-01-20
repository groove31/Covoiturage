<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="http://maps.google.com/maps/api/js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
<script src="js/index.js"></script>
<link rel="stylesheet" type="text/css" href="css/menu.css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accueil</title>
</head>
<body onload="afficherBL()">
<!--  <input type="hidden" id="conducteurs" value="${conducteurs}"> -->
<input type="hidden" id="ADDRESSE_BL" value="${ADDRESSE_BL}">

	<div id="menu" class="fixed">
		<ul>
			<li><a href="Login" />Se connecter</a></li>
			<li><a href="Register" />S'inscrire</a></li>
		</ul>
	</div>

	<div id="entete">
		<center>
			<p>Les fous du volant</p>
		</center>
	</div>

	<div id="contenu">
		<center>
			<div id="destinationForm">
				<form action="Index" method="POST" name="direction" id="direction">
					<input type="text" name="origin" id="origin" placeholder="Adresse..."> 
					<SELECT class="liste_d" name="area" size="1" id="area">
						<OPTION value="1 Km">1 Km</option>
						<OPTION value="2 Km">2 Km</option>
						<OPTION value="3 Km">3 Km</option>
						<OPTION value="4 Km">4 Km</option>
						<OPTION value="5 Km" selected>5 Km</option>
						<OPTION value="10 Km">10 Km</option>
						<OPTION value="20 Km">20 Km</option>
						<OPTION value="30 Km">30 Km</option>
					</SELECT>
					<input type="button" value="Rechercher" onclick="javascript:sendToServer()">
				</form>
			</div>
			<h4>Emplacements des conducteurs prêts à vous amener à Berger-Levrault</h4>
		</center>

		<div id="map_canvas"></div>
	</div>

	<center>

		<div id="pied">&copy; 2016 Les fous du volant</div>

		<!--  <div style="visibility: hidden"><input type="text" id="ADDRESSE_BL" value="${ADDRESSE_BL}"></div> -->
		<!--   <div style="visibility: hidden"><input type="text" id="conducteurs" value="${conducteurs}"></div> -->

	</center>

</body>
</html>
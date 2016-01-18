<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="http://maps.google.com/maps/api/js"></script>
<script src="js/index.js"></script>
<link rel="stylesheet" type="text/css" href="css/menu.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil</title>
</head>
<body onload="initialize()">
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
				<form action="" method="get" name="direction" id="direction">
					<input type="text" name="origin" id="origin"
						placeholder="Adresse..." onchange="calcRoute();"> <SELECT
						class="liste_d" name="rayon" size="1">
						<OPTION>1 Km
						<OPTION>2 Km
						<OPTION>3 Km
						<OPTION>4 Km
						<OPTION selected>5 Km
						<OPTION>10 Km
					</SELECT> <input type="button" value="Rechercher"
						onclick="javascript:calculate()">
				</form>
			</div>
			<h4>Emplacements des conducteurs prêts à vous amener à
				Berger-Levrault</h4>
		</center>

		<div id="map_canvas"></div>
	</div>

	<center>

		<div id="pied">&copy; 2016 Les fous du volant</div>

		<!--  <div style="visibility: hidden"><input type="text" id="ADDRESSE_BL" value="${ADDRESSE_BL}"></div> -->
		<!--   <div style="visibility: hidden"><input type="text" id="conducteurs" value="${conducteurs}"></div> -->

	</center>

</body>
<script>
	var addressesString = ${conducteurs};
	//var ADDRESSE_BL = "64 Rue Jean Rostand, 31670 Labège";
	var ADDRESSE_BL = "${ADDRESSE_BL}";
</script>
</html>
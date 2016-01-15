<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type="text/javascript" src="http://maps.google.com/maps/api/js"></script>
    <link rel= "stylesheet" type = "text/css" href="css/menu.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Accueil</title>
    
    <script>
  
    function initialize() {
    	     var addressesString = ${conducteurs};
    	    //var ADDRESSE_BL = "64 Rue Jean Rostand, 31670 Lab�ge";
    	    var ADDRESSE_BL = "${ADDRESSE_BL}";
    	    var geocoder = new google.maps.Geocoder();
    	    var directionsDisplay;
    	    var directionsService = new google.maps.DirectionsService();
    	    var map;
    	    
    	    geocoder.geocode( { 'address': ADDRESSE_BL}, function(results, status) {
    	        if (status == google.maps.GeocoderStatus.OK) {
    	            map = new google.maps.Map(document.getElementById('map_canvas'), 
    	                      {
    	                        zoom: 10,
    	                        center: results[0].geometry.location
    	                      }
    	                );
    	            var marker = new google.maps.Marker({
    	                map: map,
    	                position: results[0].geometry.location,
    	                title: "Berger-Levrault",
    	                //icon : "http://www.berger-levrault.com/public/css/page/logo.png"
    	                icon : "http://maps.gstatic.com/mapfiles/markers2/boost-marker-mapview.png",
    	                title :  "Berger-Levrault"
    	            });
    	        }
    	    });
    	
    	
    	    for (var i = 0; i < addressesString.length; i++) {
    	        geocoder.geocode( { 'address': addressesString[i]}, function(results, status) {
    	            if (status == google.maps.GeocoderStatus.OK) {
    	                var marker = new google.maps.Marker({
    	                    map: map,
    	                    position: results[0].geometry.location,
    	                    title: addressesString[i]
    	                });
    	            }
    	        });
    	        
    	    }
    }
    
    </script>
        
</head>
<body onload="initialize()">
    
    <div id="menu" class="fixed">
 	    <ul>
	        <li><a href="Login"/>Se connecter</a></li>
	        <li><a href="Register"/>S'inscrire</a></li>
	    </ul>
    </div>
    
    <div id="entete">
        <center><p>Les fous du volant</p></center>
    </div>

	<div id="contenu">

		<center>
			<div id="destinationForm">
				<form action="" method="get" name="direction" id="direction">
					<input type="text" name="origin" id="origin"
						placeholder="Adresse..." onchange="calcRoute();"> <SELECT
						class="liste_d" name="rayon" size="1">
						<OPTION>1
						<OPTION>2
						<OPTION>3
						<OPTION>4
						<OPTION selected>5
						<OPTION>10
					</SELECT> km <input type="button" value="Rechercher"
						onclick="javascript:calculate()">
				</form>
			</div>
			<h4>Emplacements des conducteurs pr�ts � vous amener � Berger-Levrault </h4>
		</center>
 
		<div id="map_canvas"></div>
	</div>

	<center>

    <div id="pied">
        &copy; 2016 Les fous du volant
    </div>
    
    <!--  <div style="visibility: hidden"><input type="text" id="ADDRESSE_BL" value="${ADDRESSE_BL}"></div> -->
    <!--   <div style="visibility: hidden"><input type="text" id="conducteurs" value="${conducteurs}"></div> -->

    </center>

    </body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=true"></script>
    <link rel= "stylesheet" type = "text/css" href="css/menu.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Accueil</title>
    
    <script>
    var directionsDisplay;
    var directionsService = new google.maps.DirectionsService();
    var map;

    function initialize() {
      directionsDisplay = new google.maps.DirectionsRenderer();
      var destination = new google.maps.LatLng(43.5408083, 1.5140049999999974);
      var mapOptions = {
        zoom: 12,
        center: destination,
      }      
      
      map = new google.maps.Map(document.getElementById("map_canvas"), mapOptions);
      var optionsMarqueur = {
              position: map.getCenter(),
              map: map,
              title: "Berger-Levrault"
      };
      var marqueur = new google.maps.Marker(optionsMarqueur);
      
      directionsDisplay.setMap(map);
    }

    function calcRoute() {
      var start = document.getElementById("origin").value;
      var end = new google.maps.LatLng(43.5408083, 1.5140049999999974); //document.getElementById("end").value;
      var request = {
        origin:start,
        destination:end,
        travelMode: google.maps.TravelMode.DRIVING
      };
      directionsService.route(request, function(result, status) {
        if (status == google.maps.DirectionsStatus.OK) {
          directionsDisplay.setDirections(result);
        }
      });
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
            <input type="text" name="origin" id="origin" placeholder="Adresse..." onchange="calcRoute();">
         
            <SELECT name="rayon" size="1">
                <OPTION>1 
                <OPTION>2
                <OPTION>3
                <OPTION>4
                <OPTION selected>5
                <OPTION>10
            </SELECT>
            km  
            
            <input type="button" value="Rechercher" onclick="javascript:calculate()">       
        </form>
        </div>
        </center>
      
        <div id="map_canvas"></div>
    </div>

    <center>

    <div id="pied">
        &copy; 2016 Les fous du volant
    </div>

    </center>

    </body>
</html>
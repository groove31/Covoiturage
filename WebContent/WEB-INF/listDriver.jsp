<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript" src="http://maps.google.com/maps/api/js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
	<script src="js/index.js"></script>
    <link href="css/bootstrap.css" rel="stylesheet" type = "text/css">
    <link href="css/freelancer.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="shortcut icon" type="image/x-icon" href="img/auto.png" />
    <title>Les fous du volant - Utilisateurs</title>
    
    <script>
    function init() {
    	afficherBL();
    	//String lat = "${latitude}";
    	//String lng = "${longitude}";
    	//String latlng = "{lat:${latitude},lng:${longitude}}";
    	//afficheTrajet("{lat:${latitude},lng:${longitude}}","${ADDRESSE_BL}");
  	    
        var directionsService = new google.maps.DirectionsService();
        var latlng = new google.maps.LatLng(51.764696,5.526042);
	    var myOptions = {
	      zoom: 14,
	      center: "Toulouse",
	      mapTypeId: google.maps.MapTypeId.ROADMAP,
	    };
    
	    var map = new google.maps.Map(document.getElementById("map_canvas"),myOptions);
	    var marker = new google.maps.Marker({
	      position: "Toulouse", 
	      map: map, 
	      title:"My location"
	    }); 
   
	    var direction = new google.maps.DirectionsRenderer({
	        map   : map,
	        //,
	        //panel : panel // Dom element pour afficher les instructions d'itinéraire
	    });
	    var start = "4 rue des Pyrénées, 31600 Labastidette";
	    var end = "64 Rue Jean Rostand, 31670 Labège";
	    var request = {
	      origin:start,
	      destination:end,
	      travelMode: google.maps.DirectionsTravelMode.DRIVING
	    };
	    directionsService.route(request, function(response, status) {
	      if (status == google.maps.DirectionsStatus.OK) {
	        direction.setDirections(response);
	      }
	    });
  
    }
    </script>
</head>

<body onload="init()">
    <!--  <input type="hidden" id="conducteurs" value="${conducteurs}"> -->
    <input type="hidden" id="ADDRESSE_BL" value="${ADDRESSE_BL}">
    <input type="hidden" id="LATLONG" value="${latitude},${longitude}">

<nav class="navbar navbar-default navbar-fixed-top navbar-shrink">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="Index"><i class="fa fa-car"></i> Les Fous du volant</a>
    </div>
      <ul class="nav navbar-nav navbar-right">
        <li class="hidden">
            <a href="#page-top"></a>
        </li>
        <li>
            <a class="page-scroll" href="Register"><span>${email}</span></a>
        </li>
        <li>
            <a class="page-scroll" href="Deconnexion">Se deconnecter</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
    <div id="contenu">
    <form class="form-horizontal well col-sm-12" method="POST" action="Register">
        <div id="form" style="width: 900px;" class="col-sm-12">
            <fieldset>
            
            <div class="form-group">
                <legend style="color: blue; font-weight: bold;"><span class="glyphicon glyphicon-pencil"> Liste des conducteurs</legend>
            </div>
            <table class="table table-striped table-bordered no-userselection listTable">
                <thead>
                    <tr>
                        <th scope="col"> Nom  </th>
                        <th scope="col"> Prénom </th>
                        <th scope="col"> Distance </th>
                        <th scope="col"> Sexe </th>
                        <th scope="col"> Fumeur </th>
                        <th scope= "col"> Numéro de téléphone </th>
                        <th scope= "col"> Conducteur </th> 
                    </tr>
                </thead>
 
                <tbody>
	               <!--  Parcours de la Map des utilisateurs en session, et utilisation de l'objet varStatus.
	                TODO : affichage de la table -->
	                  <c:forEach var="user" items="${sessionScope.users}" varStatus="i">
	                  <tr>
	                         <td>${user.value.lastName}</td>
	                         <td>${user.value.firstName}</td>
	                         <td>${user.value.area}</td>
	                         <td>${user.value.sexe}</td>
	                         <td>${user.value.isSmoker}</td>
	                         <td>${user.value.phoneNumber}</td>
	                         <td>${user.value.isConducteur}</td>
	                  </tr>
	                    
	                   </c:forEach>
                </tbody>
            </table>
            </fieldset>
        </div>
        <div id="map_canvas" class="form-group"></div>
        </form>
        
    </div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript" src="http://maps.google.com/maps/api/js"></script>
    <link href="css/bootstrap.css" rel="stylesheet" type = "text/css">
    <link href="css/bootstrap-theme.css" rel="stylesheet" type = "text/css">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Liste des conducteurs</title>
	
	<script>
  
    function initialize() {
            var addressesString = ${conducteurs};
            var ADDRESSE_BL = "64 Rue Jean Rostand, 31670 Labège";
            //var ADDRESSE_BL = "${ADDRESSE_BL}";
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
                        icon : "http://www.berger-levrault.com/public/css/page/logo.png"
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
    
<nav class="navbar navbar-info navbar-fixed-top" role="navigation">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Les Fous du volant</a>
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
                        <th scope="col">
                            Nom
                        </th>
                        <th scope="col">
                            Prénom
                        </th>
                        <th scope="col">
                            Distance
                        </th>
                        <th scope="col">
                            Sexe
                        </th>
                        <th scope="col">
                            Fumeur
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            TEST
                        </td>
                        <td>
                            JEAN
                        </td>
                        <td>
                            0.8 kms
                        </td>
                        <td>
                            H
                        </td>
                        <td>
                            Oui
                        </td>
                    </tr> 
                    <tr>
                        <td>
                            DUPONT
                        </td>
                        <td>
                            MARTINE
                        </td>
                        <td>
                            1.5 kms
                        </td>
                        <td>
                            F
                        </td>
                        <td>
                            Non
                        </td>
                    </tr> 
                </tbody>
            </table>
            </fieldset>
        </div>
        <div id="map_canvas"></div>
        </form>
        
    </div>
</body>
</html>
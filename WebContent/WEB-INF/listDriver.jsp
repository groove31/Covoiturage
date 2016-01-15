<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="http://maps.google.com/maps/api/js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<link rel= "stylesheet" type = "text/css" href="css/menu.css" />
<title>Liste des conducteurs</title>

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
<body>
    <div class="form-group">
    <form class="form-horizontal well col-sm-12" method="POST" action="Register">
        <div id="form" style="width: 900px;" class="col-sm-12">
            <fieldset>
            <div style="visibility: hidden"><input type="text" id="email" value="${email}"></div>
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
            
            
            <div class="row">
               <div class="col-sm-6">
               <div class="form-group">
                   <button class="btn btn-primary" type="submit" name="submit" value="Inscription">Voir fiche Inscription</button>
                   <button class="btn btn-default" type="reset" name="reset" value="Annuler" onclick="location.href='index.jsp'">Annuler</button>
               </div>
               </div>
            </div>
            </fieldset>
        </div>
        
    </form>
    </div>
    <div id="contenu">
        <div id="map_canvas"></div>
    </div>
</body>
</html>
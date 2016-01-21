<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script type="text/javascript" src="http://maps.google.com/maps/api/js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/bootstrap-table.js"></script>
    
    <link href="css/bootstrap.css" rel="stylesheet" type = "text/css">
    <link href="css/bootstrap.min.css" rel="stylesheet" type = "text/css">
    <link href="css/bootstrap-table.css" rel="stylesheet" type = "text/css">
    <link href="css/freelancer.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="shortcut icon" type="image/x-icon" href="img/auto.png" />
    <title>Les fous du volant - Utilisateurs</title>

</head>
<body onload="loadData()">
    
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

            <table id="table"
               data-toggle="table"
               data-toolbar="#toolbar"
               data-height="460"
               data-side-pagination="server"
               data-pagination="true"
               data-url="http://localhost:8080/Covoiturage/ListJson">
               
            <thead>
            
            <tr>
                <th data-field="firstName">Nom</th>
                <th data-field="lastName">Prénom</th>
                <th data-field="area">Distance</th>
                <th data-field="sexe">Sexe</th>
                <th data-field="phoneNumber">Numéro de téléphone</th>
                <th data-field="email">Email</th>
                <th data-field="isConducteur">Conducteur</th>
                <th data-field="isSmoker">Fumeur</th>
            </tr>
            </thead>
        </table>
        
        <script>
        
        function loadData() {
        	$('#table').bootstrapTable('getData');
        	
        }
        </script>
                
            </fieldset>
        </div>
        <div id="map_canvas"></div>
        </form>
        
    </div>
</body>
</html>
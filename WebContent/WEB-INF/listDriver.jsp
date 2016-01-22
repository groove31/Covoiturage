<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="http://maps.google.com/maps/api/js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.10.0/bootstrap-table.min.js"></script>

<link href="css/bootstrap.css" rel="stylesheet" type = "text/css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.10.0/bootstrap-table.min.css"
	rel="stylesheet" type="text/css">
<link href="css/freelancer.css" rel="stylesheet">
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" type="image/x-icon" href="img/auto.png" />
<title>Les fous du volant - Utilisateurs</title>

</head>
<body onload="loadData()">

<nav class="navbar navbar-default navbar-fixed-top navbar-shrink">
  <div class="container-fluid">
    <div class="navbar-header page-scroll">
        <a class="navbar-brand" href="#"><i class="fa fa-car"></i> Les Fous du volant</a>
    </div>
		<ul class="nav navbar-nav navbar-right">
        <li class="hidden">
            <a href="#page-top"></a>
        </li>
			<li><a class="page-scroll" href="Register"><span>${email}</span></a>
			</li>
			<li><a class="page-scroll" href="Deconnexion">Se deconnecter</a>
			</li>
		</ul>
	</div>
</nav>
<br>
<br>

   	   <!--  div id="contenu"-->
		
			<div id="form" style="width: 900px;" class="col-sm-12">
				<fieldset>

					<div class="form-group">
						<legend style="color: blue; font-weight: bold;">
							<span class="glyphicon glyphicon-pencil"> Liste des	conducteurs 
						</legend>
					</div>

					<!-- data-toolbar="#toolbar" 
               data-url="http://localhost:8080/Covoiturage/ListJson">
               data-side-pagination="server"
               -->
					<div class="container">
						<div class="row">
							<div class="col-xs-12">
								<div class="table-responsive">
									<table class="table table-striped" id="tableBS" 
									data-height="600" 
									data-toggle="table"
									data-toolbar="#toolbar"
           
                                    data-search="true"
                                    data-show-refresh="true"
                                    data-show-toggle="true"
                                    data-show-columns="true"
                                    data-show-export="true"
                                    data-detail-view="true"
                                    data-detail-formatter="detailFormatter"
                                    data-minimum-count-columns="2"
                                    data-show-pagination-switch="true"
                                    
                                    
                                    data-page-list="[10, 25, 50, 100, ALL]"
                                    data-show-footer="true"
                                    
			
										data-pagination="true"
										data-url="http://localhost:8080/Covoiturage/ListJson">

										<thead>

											<tr>
												<th data-field="lastName">Nom</th>
												<th data-field="firstName">Prénom</th>
												<th data-field="area">Distance</th>
												<th data-field="sexe">Sexe</th>
												<th data-field="phoneNumber">Numéro de téléphone</th>
												<th data-field="email">Email</th>
												<th data-field="isConducteur">Conducteur</th>
												<th data-field="isSmoker">Fumeur</th>
											</tr>
										</thead>
									</table>
								</div>

								<script>
									function loadData() {
										$('#tableBS').bootstrapTable('getData');
									}
								</script>
							</div>
						</div>
					</div>
				</fieldset>
			</div>
			<div id="map_canvas"></div>

</body>
</html>
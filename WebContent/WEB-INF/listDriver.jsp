<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script type="text/javascript" src="http://maps.google.com/maps/api/js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
	<script src="js/index.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.10.0/bootstrap-table.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.10.0/extensions/filter-control/bootstrap-table-filter-control.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.10.0/extensions/multiple-sort/bootstrap-table-multiple-sort.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.10.0/extensions/filter-control/bootstrap-table-multiple-sort.js"></script>
    
    <link
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.10.0/bootstrap-table.min.css"
	rel="stylesheet" type="text/css">
    <link href="css/bootstrap.css" rel="stylesheet" type = "text/css">
    <link href="css/freelancer.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <!-- <link href="css/bootstrap.min.css" rel="stylesheet"> -->
    
    
    
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
  	      
    }
    </script>
</head>

<body onload="init();loadData()">
    <!--  <input type="hidden" id="conducteurs" value="${conducteurs}"> -->
    <input type="hidden" id="ADDRESSE_BL" value="${ADDRESSE_BL}">
    <input type="hidden" id="LATLONG" value="${latitude},${longitude}">

<nav class="navbar navbar-default navbar-fixed-top navbar-shrink">
  <div class="container-fluid">
    <div class="navbar-header page-scroll">
      <a class="navbar-brand" href="Index"><i class="fa fa-car"></i> Les Fous du volant</a>
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
<br>
<br>
<br>

<div class="box box-primary">
    <div id="box-content" class="box-body">
        <div class="panel-primary">
            <div class="col-lg-7">
			         <!--  div id="form" style="width: 900px;" class="col-sm-12"-->
				<fieldset>

					<!--  div class="form-group">
						<legend style="color: blue; font-weight: bold;">
							<span class="glyphicon glyphicon-pencil"> Liste des	conducteurs 
						</legend>
					</div-->

					<!-- data-toolbar="#toolbar" 
                        data-url="http://localhost:8080/Covoiturage/ListJson">
                        data-side-pagination="server"
                    -->
					<!--  div class="container"-->
						<!--  div class="row"-->
							<div class="col-xs-12">
								<div class="table-responsive">
									<table class="table table-striped" id="tableBS" 
										data-height="600" 
										data-toggle="table"
										data-toolbar="#toolbar"
										
						                data-filter-control="true"
                                        data-show-multi-sort="true" 
                                        data-sort-priority='[{"sortName": "github.count.forks","sortOrder":"desc"},{"sortName":"github.count.stargazers","sortOrder":"desc"}]'
                    
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
                                                <th data-field="lastName" data-filter-control="input" data-sortable="true">Nom</th>
                                                <th data-field="firstName" data-filter-control="input" data-sortable="true">Prénom</th>
                                                <th data-field="area" data-filter-control="select" data-sortable="true">Distance</th>
                                                <th data-field="sexe" data-filter-control="select" data-sortable="true">Sexe</th>
                                                <th data-field="phoneNumber" data-filter-control="input" data-sortable="true">Numéro de téléphone</th>
                                                <th data-field="email" data-filter-control="input" data-sortable="true">Email</th>
                                                <th data-field="isConducteur" data-filter-control="select" data-sortable="true">Conducteur</th>
                                                <th data-field="isSmoker" data-filter-control="select" data-sortable="true">Fumeur</th>
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

				</fieldset>
            </div>
            <div class="col-lg-5">
                <div class="map_canvas_listDriver">
                    <div id="map_canvas" class="map_canvas_listDriver"></div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
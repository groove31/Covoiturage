<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/bootstrap.css" rel="stylesheet" type = "text/css">
<link href="css/bootstrap-theme.css" rel="stylesheet" type = "text/css">
<script src="js/menu.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Connexion</title>
</head>
<body>
<!-- Collect the nav links, forms, and other content for toggling -->

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
            <a class="page-scroll" href="Register">S'inscrire</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
<form class="form-horizontal well col-lg-12" name="login" method="POST" action="Login">
    <div id="form" style="width: 900px;" class="col-sm-6">
    <fieldset>
    <div class="form-group">
        <legend style="color: blue; font-weight: bold;"> <span class="glyphicon glyphicon-user">Connexion</legend>
    </div>
    <p>Vous pouvez vous connecter.</p>
    
        <div class="col-sm-12">
	        <div class="row">
                <div class="form-group">
		            <label for="Adresse email" class="col-sm-2 control-label">Adresse Email <span class='required'>* </span></label>
                    <div class="col-sm-6">
		                  <!--  input type="text" class="form-control" name="email" value="${form['email']}"></input> -->
		                  <input type="text" class="form-control" name="email" value="${email}"></input>
		              </div>
		        </div>
            </div>
            <div class="error">${erreurs['email']}</div>
            <div class="row">
                <div class="form-group">
	                  <label for="password" class="col-sm-2 control-label">Mot de passe <span class='required'>* </span></label>
	                  <div class="col-sm-6">
	                       <input type="password" class="form-control" name="pwd1" value="${form['pwd1']}"></input>
	                  </div>
                </div>	            
            </div>
           
            <span class="error">${erreurs['pwd1']}</span>
            <div class="row">
               <div class="col-sm-6">
		           <div class="form-group">
		               <button class="btn btn-success" type="submit" name="submit" value="Connexion">Connexion</button>
		               <button class="btn btn-default" type="reset" name="reset" value="Annuler" onclick="location.href='Index'">Annuler</button>
		           </div>
	           </div>
	        </div>
	        <c:if test="${not empty actionMessage}">
	            <div class="row">
	               <div class="col-sm-6">
	                    <div class="form-group">
	                        <div class="alert alert-danger">
                                <b>Erreur : </b> <span>${actionMessage}</span>
	                        </div>
	                    </div>
	                </div>
	            </div>
            </c:if>
        </div>	        

    </fieldset>
    </div>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/theme.css" rel="stylesheet" type="text/css">
<script src="js/menu.js"></script>
<title>Menu Principal</title>
</head>
<body>
<form name="menu" method="POST" action="Menu">
	<fieldset>
	    <!-- http://www.w3schools.com/bootstrap/tryit.asp?filename=trybs_dropdown-menu&stacked=h -->
            <div class="dropdown">
                <button id="dLabel" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Menu
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
				      <li><a href="<c:url value="/Register"/>">S'inscrire</a></li>
				      <li><a href="<c:url value="/Login"/>">Se connecter</a></li>
				      <li><a href="#">S'identifier</a></li>
                </ul>
            </div>
	</fieldset>
</form>
</body>
</html>
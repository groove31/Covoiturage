<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <link rel= "stylesheet" type = "text/css" href="css/menu.css" />
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Accueil</title>
</head>
<body>
    <center>
        <p>Les fous du volant</p><br>
        <p><img src="img/covoiturage.jpg" /></p><br>
		<div id="menu">		
			<a href="<c:url value="/Login"/>">Conducteur</a>
			<a href="<c:url value="/ListDriver"/>">Passager</a>
		</div>
    </center>
</body>
</html>
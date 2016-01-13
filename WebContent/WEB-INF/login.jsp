<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<script src="js/menu.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Connexion</title>
</head>
<body>
<c:import url="/WEB-INF/Menu/menu.jsp" />
<form name="login" method="POST" action="Login">
    <fieldset>
    <legend>Connexion</legend>
        <p>Vous pouvez vous connecter.</p>
        <div>
            <label>Adresse email<span class="requis">*</span></label>
            <input type="text" name="email" value="${form['email']}"></input>
            <span class="error">${erreurs['email']}</span>
            <br>
            
            <label>Mot de passe<span class="requis">*</span></label> 
            <input type="password" name="pwd1" value="${form['pwd1']}"></input>
            <span class="error">${erreurs['pwd1']}</span>
            <br>
            
            <input class="sansLabel" type="submit" name="submit" value="Connexion">
            <br>
        </div>
        
        <p class="info">${actionMessage}</p>
    </fieldset>
</form>
</body>
</html>
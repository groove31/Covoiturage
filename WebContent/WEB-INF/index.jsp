<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
<script src="js/menu.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Covoiturage</title>
</head>
<body>
<!-- http://www.w3schools.com/bootstrap/tryit.asp?filename=trybs_dropdown-menu&stacked=h -->
    <div class="dropdown">
  <button id="dLabel" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    Menu
    <span class="caret"></span>
  </button>
  <ul class="dropdown-menu">
      <li><a href="#">S'inscrite</a></li>
      <li><a href="#">Se connecter</a></li>
      <li><a href="#">S'identifier</a></li>
    </ul>
</div>
    <form action="Register" method="POST">
        <div id="form" style="width: 900px;">
            <fieldset>
            <legend style="color: blue; font-weight: bold;">Inscription</legend>
                Vous pouvez vous inscrire via ce formulaire.
                <br>
                <br>
                <label for="email">Adresse email<span class="requis"> *</span></label>
                <input type="text" name="email" id="email" value="${form.email}"/>
                <span class="error">${erreurs.email}</span>
                <br>
                <label for="pwd1">Mot de passe<span class="requis"> *</span></label>
                <input type="password" name="pwd1" id="pwd1" required="required" value="${form.pwd1}"/>
                <span class="error">${erreurs.pwd1}</span>
                <br>
                <label for="pwd2">Confirmation  du mot de passe<span class="requis"> *</span></label>
                <input type="password" name="pwd2" id="pwd2" required="required" value="${form.pwd2}"/>
                <span class="error">${erreurs.pwd2}</span>
                <br>
                <label for="userName">Nom d'utilisateur</label>
                <input type="text" name="name" id="name" value="${form.name}"/>
                <span class="error">${erreurs.name}</span>
                <br>
                <input class="sansLabel" type=submit name="inscription" value="Inscription"/>
                <br>
                <span class="info">${actionMessage}</span>
            </fieldset>
        </div>
    </form>
    <br>
    <fieldset>
        <div>
            <p>Email : ${ newUser.email }</p>
            <p>Nom : ${ newUser.name }</p>
        </div>
    </fieldset>
</body>

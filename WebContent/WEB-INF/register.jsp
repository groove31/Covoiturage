<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<c:import url="/WEB-INF/Menu/menu.jsp" />
    <form action="Register" method="POST">
        <div id="form" style="width: 900px;" class="col-sm-6">
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
                <label for="lastName">Nom</label>
                <input type="text" name="lastName" id="lastName" value="${form.lastName}"/>
                <span class="error">${erreurs.lastName}</span>
                <br>
                <label for="firstName">Prénom</label>
                <input type="text" name="firstName" id="firstName" value="${form.firstName}"/>
                <br>
                <label for="adressNumber">N° Rue</label>
                <input type="text" name="adressNumber" id="adressNumber" value="${form.adressNumber}"/>
                <br>
                <label for="adressWay">Rue</label>
                <input type="text" name="adressWay" id="adressWay" value="${form.adressWay}"/>
                <br>
                <label for="adressCp">CP</label>
                <input type="text" name="adressCp" id="adressCp" value="${form.adressCp}"/>
                <br>
                <label for="adressCity">Ville</label>
                <input type="text" name="adressCity" id="adressCity" value="${form.adressCity}"/>
                <br>
                <label for="phoneNumber">Téléphone</label>
                <input type="text" name="phoneNumber" id="phoneNumber" value="${form.phoneNumber}"/>
                <br>
                <label for="sexe">Sexe</label>
                <input type="text" name="sexe" id="sexe" value="${form.sexe}"/>
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
            <p>Nom : ${ newUser.lastName }</p>
        </div>
    </fieldset>
</body>

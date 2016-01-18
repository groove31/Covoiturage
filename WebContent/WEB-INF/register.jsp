<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link href="css/bootstrap.css" rel="stylesheet" media="screen">
<link href="css/bootstrap-theme.css" rel="stylesheet" media="screen">
<script src="js/menu.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<title>Covoiturage</title>
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
            <a class="page-scroll" href="Login">Se connecter</a>
        </li>
      </ul>
    </div>
  </div>
</nav>
    <form class="form-horizontal well col-lg-12" action="Register" method="POST">
        <div id="form" style="width: 900px;" class="col-sm-8">
        
            <fieldset>
            <div class="form-group">
                <legend style="color: blue; font-weight: bold;"><span class="glyphicon glyphicon-pencil"> Inscription</legend>
            </div>
                Vous pouvez vous inscrire via ce formulaire.
                <br>
                <br>
                <div class="col-sm-12">
                    <div class="row">
                        <div class="form-group">
                            <label for="email" class="col-sm-3 control-label">Adresse email<span class="requis"> *</span></label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="email" id="email" value="${form.email}"/>
                            </div>
                            <span class="col-sm-2 alert-danger">${erreurs.email}</span>
                        </div>
                    </div>
                </div>
                <div class="col-sm-12">
                    <div class="row">
                        <div class="form-group">
                            <label for="pwd1" class="col-sm-3 control-label">Mot de passe<span class="requis"> *</span></label>
                            <div class="col-sm-4">
                                <input type="password" class="form-control" name="pwd1" id="pwd1" required="required" value="${form.pwd1}"/>
                            </div>
                            <span class="col-sm-5 alert-danger">${erreurs.pwd1}</span>
                        </div>
                    </div>
                </div>
                <div class="col-sm-12">
                    <div class="row">
                        <div class="form-group">
                            <label for="pwd2" class="col-sm-3 control-label">Confirmation  du mot de passe<span class="requis"> *</span></label>
                            <div class="col-sm-4">
                                <input type="password" class="form-control" name="pwd2" id="pwd2" required="required" value="${form.pwd2}"/>
                            </div>
                            <span class="col-sm-2 alert-danger">${erreurs.pwd2}</span>
                        </div>
                    </div>
                </div>
                <div class="col-sm-12">
                    <div class="row">
                        <div class="form-group">
                            <label for="lastName" class="col-sm-3 control-label">Nom<span class="requis"> *</span></label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="lastName" id="lastName" value="${form.lastName}"/>
                            </div>
                            <span class="col-sm-2 alert-danger">${erreurs.lastName}</span>
                        </div>
                    </div>
                </div>
                <div class="col-sm-12">
                    <div class="row">
                        <div class="form-group">
                            <label for="firstName" class="col-sm-3 control-label">Prénom</label>
                            <div class="col-sm-7">
                                <input type="text" class="form-control" name="firstName" id="firstName" value="${form.firstName}"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-12">
                    <div class="row">
                        <div class="form-group">
                            <label for="adressNumber" class="col-sm-3 control-label">N° Rue / Rue</label>
                            <div class="col-sm-2">
                                <input type="text" class="form-control" name="addressNumber" id="addressNumber" value="${form.addressNumber}"/>
                            </div>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" name="addressWay" id="addressWay" value="${form.addressWay}"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-12">
                    <div class="row">
                        <div class="form-group">
                            <label for="adressCp" class="col-sm-3 control-label">Code Postal / Ville</label>
                            <div class="col-sm-2">
                                <input type="text" class="form-control" name="addressCp" id="addressCp" value="${form.addressCp}"/>
                            </div>
                            <div class="col-sm-5">
                                <input type="text" class="form-control" name="addressCity" id="addressCity" value="${form.addressCity}"/>
                            </div>
                        </div>
                    </div>
                </div>
                
                <div class="col-sm-12">
                    <div class="row">
                        <div class="form-group">
                            <label for="phoneNumber" class="col-sm-3 control-label">Téléphone</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="phoneNumber" id="phoneNumber" value="${form.phoneNumber}"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-12">
                    <div class="row">
                        <div class="form-group">
                            <label for="sexe" class="col-sm-3 control-label">Sexe</label>
                            <div class="col-sm-2">
                                <input type="text" class="form-control" name="sexe" id="sexe" value="${form.sexe}" placeholder="H ou F"/>
                            </div>
                        </div>
                    </div>
                </div>

                 <div class="col-sm-12">
                    <div class="row">
                        <div class="form-group">
                            <label for="isSmoker" class="col-sm-3 control-label">Fumeur</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="isSmoker" id="isSmoker" value="${form.isSmoker}"/>
                            </div>
                        </div>
                    </div>
                </div>
                 <div class="col-sm-12">
                    <div class="row">
                        <div class="form-group">
                            <label for="area" class="col-sm-3 control-label">Rayon</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="area" id="area" value="${form.area}"/>
                            </div>
                        </div>
                    </div>
                </div>
                <button class="btn btn-success" type="submit" name="inscription" value="Inscription">Enregistrer</button>
                <button class="btn btn-default" type="reset" name="inscription" value="Annuler" onclick="location.href='Deconnexion'">Annuler</button>
                <br><br>
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
                <c:if test="${not empty actionMessageValidation}">
                <div class="row">
                   <div class="col-sm-6">
                        <div class="form-group">
                            <div class="alert alert-success">
                               <b>Succès : </b> <span>${actionMessageValidation}</span>
                            </div>                     
                        </div>
                    </div>
                </div>
                </c:if>
            </fieldset>
        </div>
    </form>
    <br>
    <div class="col-sm-6">
    <fieldset>
        <div>
            <p>Email : ${ newUser.email }</p>
            <p>Nom : ${ newUser.lastName }</p>
        </div>
    </fieldset>
    </div>
</body>

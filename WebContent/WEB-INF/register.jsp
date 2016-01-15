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
    <form class="form-horizontal well col-lg-12" action="Register" method="POST">
        <div id="form" style="width: 900px;" class="col-sm-6">
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
                            <label for="email" class="col-sm-4 control-label">Adresse email<span class="requis"> *</span></label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="email" id="email" value="${form.email}"/>
                            </div>
                            <span class="error">${erreurs.email}</span>
                        </div>
                    </div>
                </div>
                <div class="col-sm-12">
                    <div class="row">
                        <div class="form-group">
                            <label for="pwd1" class="col-sm-4 control-label">Mot de passe<span class="requis"> *</span></label>
                            <div class="col-sm-4">
                                <input type="password" class="form-control" name="pwd1" id="pwd1" required="required" value="${form.pwd1}"/>
                            </div>
                            <span class="error">${erreurs.pwd1}</span>
                        </div>
                    </div>
                </div>
                <div class="col-sm-12">
                    <div class="row">
                        <div class="form-group">
                            <label for="pwd2" class="col-sm-4 control-label">Confirmation  du mot de passe<span class="requis"> *</span></label>
                            <div class="col-sm-4">
                                <input type="password" class="form-control" name="pwd2" id="pwd2" required="required" value="${form.pwd2}"/>
                            </div>
                            <span class="error">${erreurs.pwd2}</span>
                        </div>
                    </div>
                </div>
                <div class="col-sm-12">
                    <div class="row">
                        <div class="form-group">
                            <label for="lastName" class="col-sm-4 control-label">Nom</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="lastName" id="lastName" value="${form.lastName}"/>
                            </div>
                            <span class="error">${erreurs.lastName}</span>
                        </div>
                    </div>
                </div>
                <div class="col-sm-12">
                    <div class="row">
                        <div class="form-group">
                            <label for="firstName" class="col-sm-4 control-label">Prénom</label>
                            <div class="col-sm-8">
                                <input type="text" class="form-control" name="firstName" id="firstName" value="${form.firstName}"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-12">
                    <div class="row">
                        <div class="form-group">
                            <label for="adressNumber" class="col-sm-4 control-label">N° Rue / Rue</label>
                            <div class="col-sm-2">
                                <input type="text" class="form-control" name="adressNumber" id="adressNumber" value="${form.adressNumber}"/>
                            </div>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" name="adressWay" id="adressWay" value="${form.adressWay}"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-12">
                    <div class="row">
                        <div class="form-group">
                            <label for="adressCp" class="col-sm-4 control-label">Code Postal / Ville</label>
                            <div class="col-sm-2">
                                <input type="text" class="form-control" name="adressCp" id="adressCp" value="${form.adressCp}"/>
                            </div>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" name="adressCity" id="adressCity" value="${form.adressCity}"/>
                            </div>
                        </div>
                    </div>
                </div>
                
                <div class="col-sm-12">
                    <div class="row">
                        <div class="form-group">
                            <label for="phoneNumber" class="col-sm-4 control-label">Téléphone</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="phoneNumber" id="phoneNumber" value="${form.phoneNumber}"/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-sm-12">
                    <div class="row">
                        <div class="form-group">
                            <label for="sexe" class="col-sm-4 control-label">Sexe</label>
                            <div class="col-sm-2">
                                <input type="text" class="form-control" name="sexe" id="sexe" value="${form.sexe}" placeholder="H ou F"/>
                            </div>
                        </div>
                    </div>
                </div>

                 <div class="col-sm-12">
                    <div class="row">
                        <div class="form-group">
                            <label for="isSmoker" class="col-sm-4 control-label">Fumeur</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="isSmoker" id="isSmoker" value="${form.isSmoker}"/>
                            </div>
                        </div>
                    </div>
                </div>
                 <div class="col-sm-12">
                    <div class="row">
                        <div class="form-group">
                            <label for="area" class="col-sm-4 control-label">Rayon</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control" name="area" id="area" value="${form.area}"/>
                            </div>
                        </div>
                    </div>
                </div>
                <button class="btn btn-primary" type="submit" name="inscription" value="Inscription">Inscription</button>
                <button class="btn btn-default" type="reset" name="inscription" value="Annuler">Annuler</button>
                <span class="info">${actionMessage}</span>
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

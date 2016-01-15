<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/bootstrap.min.css" rel="stylesheet" media="screen">

<title>Liste des conducteurs</title>
</head>
<body>

    <form class="form-horizontal well col-sm-12" method="POST">
        <div id="form" style="width: 900px;" class="col-sm-12">
            <fieldset>
            <div class="form-group">
                <legend style="color: blue; font-weight: bold;"><span class="glyphicon glyphicon-pencil"> Liste des conducteurs</legend>
            </div>
                
            <table class="table table-striped table-bordered no-userselection listTable">
                <thead>
                    <tr>
                        <th scope="col">
                            Nom
                        </th>
                        <th scope="col">
                            Prénom
                        </th>
                        <th scope="col">
                            Distance
                        </th>
                        <th scope="col">
                            Sexe
                        </th>
                        <th scope="col">
                            Fumeur
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            TEST
                        </td>
                        <td>
                            JEAN
                        </td>
                        <td>
                            0.8 kms
                        </td>
                        <td>
                            H
                        </td>
                        <td>
                            Oui
                        </td>
                    </tr> 
                    <tr>
                        <td>
                            DUPONT
                        </td>
                        <td>
                            MARTINE
                        </td>
                        <td>
                            1.5 kms
                        </td>
                        <td>
                            F
                        </td>
                        <td>
                            Non
                        </td>
                    </tr> 
                </tbody>
            </table>
            </fieldset>
        </div>
    

</form>

</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Spittr App</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container">
        <div class="jumbotron" style="text-align:center" >
            <h1>Spittr App</h1>
        </div>
        <h1>Spitter</h1>
        <div class="well">
            <form method="post">
                <div class="form-group row">
                    <label for="spitterUsername" class="col-2 col-form-label">Spitter Username</label>
                    <div class="col-10">
                        <input class="form-control" type="text" name="spitterUsername" id="spitterUsername" placeholder="Spitter Username">
                    </div>
                </div>
                <div>
                    <button type="submit" name="action" value="addSpitter" class="btn btn-success">Add Spitter</button>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
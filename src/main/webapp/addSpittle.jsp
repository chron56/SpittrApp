<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
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
        <h1>Spittle</h1>
        <div class="well">
            <form action="SpittleController" method="post">
                <div class="form-group row">
                    <label for="spitterId">Choose Spitter :</label>
                    <select class="form-control" name="spitterId" id="spitterId" for="spitterId">
                        <c:forEach items="${spitters}" var="spitter">
                            <option value="<c:out value="${spitter.id}" />"><c:out value="${spitter.username}" /></option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group row">
                    <label for="spittleText" class="col-2 col-form-label">Spittle Text</label>
                    <div class="col-10">
                        <input class="form-control" type="spittleText" name="spittleText" id="spittleText" placeholder="Spittle Text">
                    </div>
                </div>
                <div>
                    <button type="submit" name="todo" value="addSpittle" class="btn btn-success">Add Spittle</button>
                </div>
            </form>
        </div>

    </div>
</body>
</html>
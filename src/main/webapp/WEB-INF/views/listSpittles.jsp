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
        <div class="jumbotron" style="text-align:center" >
            <h1>Spittr App</h1>
        </div>
        <h1>List of Spittles</h1>
        <form method="post">
            <input type="hidden" id="action" name="action" value="selectSpitter">
            <div class="row">
                <div class="col-sm-3 col-sm-offset-6 form-group row">
                    <select class="form-control" name="spitterId" id="spitterId" onchange="this.form.submit()">
                        <option disabled selected value> -- Filter Spittles by Spitter -- </option>
                        <c:forEach items="${spitters}" var="spitter">
                            <option value="<c:out value="${spitter.id}" />"><c:out value="${spitter.username}" /></option>
                        </c:forEach>
                    </select>
                </div>
                <div class="col-sm-3">
                    <button type="submit" name="spitterId" value="0" class="btn btn-success">All Spittles</button>
                </div>
            </div>
        </form>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>Spittle ID</th>
                <th>Spittle Text</th>
                <th>Spitter of the Spittle</th>
                <th colspan="2">Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${spittles}" var="spittle">
                <tr>
                    <td><c:out value="${spittle.id}" /></td>
                    <td><c:out value="${spittle.text}" /></td>
                    <td><c:out value="${spittle.spitter.username}" /></td>
                    <td>
                        <a class="btn btn-warning" role="button" href="<c:url value='updateSpittle/${spittle.id}' />">Update</a>
                        <a class="btn btn-danger" role="button" href="<c:url value='deleteSpittle/${spittle.id}' />">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="col-sm-11 col-sm-offset-1">
            <div class="row">
                <div class="col-sm-3 col-sm-offset-4 text-center">
                    <a href="addSpittle" class="btn btn-info" role="button">Add Spittle</a>
                    <a href="addSpitter" class="btn btn-primary" role="button">Add Spitter</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
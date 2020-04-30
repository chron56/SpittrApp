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
        <h1>Spittles List</h1>
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
                        <a class="btn btn-warning" role="button" href="SpittleController?action=updateSpittle&spittleId=<c:out value="${spittle.id }"/>">Update</a>
                        <a class="btn btn-danger" role="button" href="SpittleController?action=deleteSpittle&spittleId=<c:out value="${spittle.id}"/>">Delete</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="btn-group" role="group" >
            <a href="SpittleController?action=addSpittle" class="btn btn-info" role="button">Add Spittle</a>
            <a href="SpittleController?action=addSpitter" class="btn btn-primary" role="button">Add Spitter</a>
        </div>
    </div>
</body>
</html>
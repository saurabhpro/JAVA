<%--
  Created by IntelliJ IDEA.
  User: saurabhkumar
  Date: 03/09/17
  Time: 1:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Todo Tasks for ${name}</title>
    <link href="webjars/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h1>Your TodoTasks</h1>

    <table class="table table-striped">
        <caption>Your TodoTasks are</caption>

        <thead class="thead-inverse">
        <tr>
            <th>Description</th>
            <th>Date</th>
            <th>Completed</th>
            <th></th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${todoTasks}" var="todo">
            <tr>
                <td>${todo.desc}</td>
                <td>
                    <fmt:formatDate pattern="dd/MM/yyyy" value="${todo.targetDate}"/>
                </td>
                <td>${todo.done}</td>
                <td>
                    <a class="btn btn-outline-secondary"
                       href="${pageContext.request.contextPath}/updateTodoTask?id=${todo.id}">Update</a>
                    <a class="btn btn-danger" href="${pageContext.request.contextPath}/deleteTodoTask?id=${todo.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div>
        <a class="btn btn-success" href="${pageContext.request.contextPath}/addTodoTask">Add</a>
    </div>

</div>


<script src="webjars/jquery/3.2.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: saurabhkumar
  Date: 03/09/17
  Time: 1:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Add Todo Task</title>
    <link href="webjars/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

<div class="container">
    <h1>Add a Todo</h1>
    <form:form action="${pageContext.request.contextPath}/addTodoTask" method="post"
               commandName="todoTask"> <!--command object to be used-->

        <fieldset class="form-group">
            <form:label path="desc">Description</form:label>
            <form:input name="desc" type="text" class="form-control" required="required" path="desc"/>
            <form:errors path="desc" cssClass="text-warning"></form:errors>
        </fieldset>

        <button type="submit" class="btn btn-success">Add</button>
    </form:form>
</div>


</body>


</html>

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
    <form:form method="post" commandName="todoTask"> <!--command object to be used - is set via controller
        action removed as submit will just work as href added on task buttons-->
        <form:hidden path="id"/>
        <!--
        <form:hidden path="user"/>
        for updating data
        but can be seen in post request - so not safe
        -->

        <fieldset class="form-group">
            <form:label path="desc">Description</form:label>
            <form:input name="desc" type="text" class="form-control" required="required" path="desc"/>
            <form:errors path="desc" cssClass="text-warning"></form:errors>
        </fieldset>
        <fieldset class="form-group">
            <form:label path="targetDate">Target Date</form:label>
            <form:input path="targetDate" type="text" class="form-control"
                        required="required"/>
            <form:errors path="targetDate" cssClass="text-warning"/>
        </fieldset>

        <button type="submit" class="btn btn-success">Submit</button>
    </form:form>
</div>


<script src="webjars/jquery/3.2.1/jquery.min.js"></script>
<script src="webjars/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
<script src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>

<script>
    $('#targetDate').datepicker({
        format: 'dd/mm/yyyy'
    });
</script>

</body>


</html>

<%--
  Created by IntelliJ IDEA.
  User: saurabhkumar
  Date: 05/04/17
  Time: 5:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Student Resgistration</title>
    <link rel="stylesheet" href="../../resources/css/font-awesome.min.css"/>
</head>
<body>
<form:form action="processForm" modelAttribute="student">
    <div class="input-group margin-bottom-sm">
        <span class="input-group-addon"><i class="fa fa-envelope-o fa-fw"></i></span>
        First Name: <form:input path="firstName" cssClass="form-control"/>
    </div>
    <br/>
    Last Name: <form:input path="lastName" cssClass="form-control"/>
    <br/>
    Countery :
    <form:select path="country">
        <form:option value="BRA" label="Brazil"/>
        <form:option value="GER" label="Germany"/>
        <form:option value="FRA" label="France"/>
        <form:option value="IND" label="India"/>
    </form:select>

    <form:select path="country">
        <form:options items="${student.countryOptions}"/>
    </form:select>

    <br/>
    Java<form:radiobutton path="favoriteLanguage" value="Java"/>
    C#<form:radiobutton path="favoriteLanguage" value="C#"/>
    Ruby<form:radiobutton path="favoriteLanguage" value="Ruby"/>
    Python<form:radiobutton path="favoriteLanguage" value="Python"/>

    <br/>
    Favorite Language:

    <form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}"/>

    <br><br>

    Operating Systems
    <form:checkbox path="operatingSystems" value="windows"/>Windows
    <form:checkbox path="operatingSystems" value="OSx"/>OSX
    <form:checkbox path="operatingSystems" value="Linux"/>Linux
    <br><br>

    <input class="btn btn-default" type="submit" VALUE="Submit">
</form:form>
</body>
</html>

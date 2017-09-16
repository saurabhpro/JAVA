<%--
  Created by IntelliJ IDEA.
  User: saurabhkumar
  Date: 06/04/17
  Time: 5:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Second PageSet</title>
    <style>
        .error {
            color: red
        }
    </style>
</head>
<body>

Fill out the form. Asterisk(*) means required

<!-- /processForm is different form processForm, the prior will call $root/processForm,
later will $relative/processForm -->
<form:form action="processForm" modelAttribute="customer">

    FirstName <form:input path="firstName"/>

    <br/><br/>

    LastName(*) <form:input path="lastName"/>
    <form:errors cssClass="error" path="lastName"/>

    <br/><br/>

    FreePasses(*) <form:input path="freePasses"/>
    <form:errors cssClass="error" path="freePasses"/>

    <!-- how do I handle validation if the user enters String input for the integer field GOTO Customer model-->
    <br/><br/>

    Postal <form:input path="postalCode"/>
    <form:errors cssClass="error" path="postalCode"/>

    <br/><br/>

    <input type="submit" value="Submit"/>
</form:form>

</body>
</html>

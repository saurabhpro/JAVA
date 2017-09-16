<%--
  Created by IntelliJ IDEA.
  User: saurabhkumar
  Date: 05/04/17
  Time: 5:18 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Do</title>
</head>
<body>
Student Name : ${student.firstName} ${student.lastName}
<br/>
Country : ${student.country}
<br/>
Favorite Language : ${student.favoriteLanguage}
<br/>
Operating Systems
${student.operatingSystems}
<ul>
    <c:forEach var="temp" items="${student.operatingSystems}"/>
    <li>${temp}</li>
</ul>
</body>
</html>

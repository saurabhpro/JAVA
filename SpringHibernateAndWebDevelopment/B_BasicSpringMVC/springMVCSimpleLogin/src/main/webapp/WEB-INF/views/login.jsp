<html>
<head>
    <title>Yahoo!!</title>
</head>
<body>


<p><span style="color: red; ">${errorMessage}</span></p>

<!--${pageContext.request.contextPath}- current page path - /spring-mvc/login-->
<form action="${pageContext.request.contextPath}" method="POST">
    Name : <label>
    <input name="name" type="text"/>
</label>
    Password : <label>
    <input name="password" type="password"/>
</label>
    <input type="submit"/>
</form>
</body>
</html>
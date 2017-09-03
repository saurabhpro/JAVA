<%--@elvariable id="password" type="com.in28minutes.springmvc.login.password"--%>
<%--@elvariable id="name" type="com.in28minutes.springmvc.login.name"--%>
<html>
<head>
    <title>Hey There!!</title>
    <link href="webjars/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div class="container">
    Welcome ${name}. You are now authenticated. <br/>

    <!--<a href="${pageContext.request.contextPath}/todoTasks?name=${name}"> -->
    <a class="btn btn-outline-info" href="${pageContext.request.contextPath}/todoTasks">Click here</a>

    to start maintaining your todo's.

</div>

</body>
</html>
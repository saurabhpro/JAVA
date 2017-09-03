<html>
<head>
    <title>Yay!!</title>
    <link href="webjars/bootstrap/4.0.0-beta/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container h-100">
    <div class="row h-100 justify-content-center align-items-center">

        <!--${pageContext.request.contextPath}- current page path - /spring-mvc/login-->

        <form action="${pageContext.request.contextPath}" method="POST">
            <fieldset class="form-group">
                <label for="name">Name</label>
                <input name="name" id="name" type="text" class="form-control" required="required"/>
            </fieldset>

            <fieldset class="form-group">
                <label for="password">Password</label>
                <input name="password" id="password" type="text" class="form-control" required="required"/>
            </fieldset>

            <button type="submit" class="btn btn-outline-primary">Login</button>

            <p><span style="color: red; ">${errorMessage}</span></p>

        </form>
    </div>
</div>

</body>
</html>
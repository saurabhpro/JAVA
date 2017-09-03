<%--@elvariable id="password" type="com.in28minutes.springmvc.login.password"--%>
<%--@elvariable id="name" type="com.in28minutes.springmvc.login.name"--%>
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
    Welcome ${name}. You are now authenticated. <br/>

    <!--<a href="${pageContext.request.contextPath}/todoTasks?name=${name}"> -->
    <a class="btn btn-outline-info" href="${pageContext.request.contextPath}/todoTasks">Click here</a>

    to start maintaining your todo's.

</div>

<%@ include file="common/footer.jspf" %>
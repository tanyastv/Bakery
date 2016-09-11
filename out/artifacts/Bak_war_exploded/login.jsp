<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="includes/preludes.jsp" %>
<jsp:include page="includes/header.jsp">
    <jsp:param name="lang" value="${user}"/>
    <jsp:param name="title" value="Home"/>
    <jsp:param name="user" value="${user}"/>
</jsp:include>
<title>Authorization</title>
<br>
<br>
<br>
<div class="container">
    <div class="row">
        <form method="post" class="form-signin-heading col-md-offset-4 col-md-4" role="form">
            <br><br>
            <input type="text" name="login" id="login" class="form-control" placeholder="Login">
            <input type="password" name="password" id="password" class="form-control" placeholder="Password">
            <br>
            <button type="submit" class="btn btn-lg btn-primary btn-block">Sign in</button>
        </form>
    </div>
</div>
<div class="row col-md-offset-4 col-md-4" style="color:#FF0000" align="center"><h3> ${error}</h3></div>
</body>
</html>

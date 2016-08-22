<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html>
<head>
    <title>Authorization</title>
    <style type="text/css">
        <%@ include file="css/form.css" %>
    </style>
    <div align="center"><h2>Authorization</h2></div>
    <div style="color:#FF0000" align="center"><h2>${error}</h2></div>
    <form method="post" class="form-3">
        <div class="clearfix">
            <label for="login">Login</label>
            <input type="text" name="login" id="login" placeholder="Login">
        </div>
        <div class="clearfix">
            <label for="password">Password</label>
            <input type="password" name="password" id="password" placeholder="Password">
        </div>
        <div class="clearfix">
            <input type="submit" name="submit" value="Sign in">
        </div>
    </form>
</head>
<body>

</body>
</html>

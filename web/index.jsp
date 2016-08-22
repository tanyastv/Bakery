<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  entity.User: USER
  Date: 18.07.2016
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html>
<head>
    <title>Home page</title>
    <style type="text/css">
        <%@ include file="css/common.css" %>
    </style>
</head>
<body>

<div style="background-color:#1f2124; color:#D3D3D3; width:100%; height:50px; margin-top: 0px; margin-bottom: 10px;">
    <h1 align="center"> ${user.getName_user()} </h1>
    <div align="right">
        <a href="/registr/" class="button15" align="right">Registration</a>
        <a href="/login/" class="button15" align="right">Sign in</a>
    </div>
</div>

<div ALIGN="CENTER">
    <img src="b.png" width="600" height="300" alt="index" ALIGN="CENTER"/>
    <h1 align="center">Bakery Shop</h1>
    <img src="44.png" alt="blue line" ALIGN="CENTER"/>
    <br>
    <table align="center" cellspacing='0' width="500">
        <br>
        <td align="center">
            <tr><a href="/product" class="button15"> Products </a></tr>

            <tr><a href="/provider" class="button15"> Provider </a></tr>

            <tr><a href="/orders" class="button15"> Order </a></tr>

            <tr><a href="/sale" class="button15"> Sale </a></tr>

            <tr><a href="/seller" class="button15"> Seller </a></tr>

        </td>
    </table>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>

    <div style="background-color:#1f2124; color:#D3D3D3; width:100%; height:30px; margin-top: 30px; margin-down: 0px;">
        <h4 align="center">autor - t_sarnavskaya@mail.ru</h4>
    </div>

</body>
</html>

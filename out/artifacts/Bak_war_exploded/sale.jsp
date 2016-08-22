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
    <title>Sale</title>
    <style type="text/css">
        <%@ include file="css/common.css" %>
    </style>
</head>
<body>
<div style="background-color:#1f2124; color:#D3D3D3; width:100%; height:50px; margin-top: 0px; margin-bottom: 10px;">
    <h1 align="center"> ${user.getName_user()} </h1>
    <div align="right">
        <a href="/" class="button15">Home</a>
        <a href="/exit" class="button15">Exit</a>
    </div>
</div>
<DIV ALIGN="CENTER">
    <img src="a.png" width="600" height="300" alt="sale" ALIGN="CENTER"/>
</DIV>
<br>
<table align="center" class="simple-little-table" cellspacing='0' width="500">

    <tr align="center">
        <th width="168"><b>ID</b></th>
        <th width="168"><b>Seller</b></th>
        <th width="168"><b>Product</b></th>
        <th width="168"><b>Cost</b></th>
        <th width="168"><b>Date of sale</b></th>
        <th width="168"><b>Delete</b></th>
    </tr>

    <c:forEach items="${requestScope.sale}" var="sale">

        <tr>
            <td>${sale.id_sale}</td>
            <td><c:out value="${sale.id_seller}"/></td>
            <td><c:out value="${sale.id_product}"/></td>
            <td><c:out value="${sale.cost_sale}"/></td>
            <td><c:out value="${sale.date_of_sale}"/></td>
            <td>
                <a href="deletesale?id_sale=${sale.id_sale}">
                    <img src="3.png"/>
                </a>
            </td>
        </tr>
    </c:forEach>
    <form action="/addsale" method="POST">
        <tr>
            <td></td>
            <td>
                <input name='id_seller' type="text">
            </td>
            <td>
                <input name='id_product' type="text">
            </td>
            <td>
                <input name='cost_sale' type="text">
            </td>
            <td>
                <input name='date_of_sale' type="date">
            </td>
            <td>
                <input type="submit" value="Add">

            </td>
        </tr>
    </form>
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

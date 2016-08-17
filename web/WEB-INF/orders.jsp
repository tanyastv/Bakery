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
<style>

    imple-little-table {
        font-family:Arial, Helvetica, sans-serif;
        color:#666;
        font-size:12px;
        text-shadow: 1px 1px 0px #fff;
        background:#eaebec;
        margin:20px;
        border:#ccc 1px solid;
        border-collapse:separate;

        -moz-border-radius:3px;
        -webkit-border-radius:3px;
        border-radius:3px;

        -moz-box-shadow: 0 1px 2px #d1d1d1;
        -webkit-box-shadow: 0 1px 2px #d1d1d1;
        box-shadow: 0 1px 2px #d1d1d1;
    }

    .simple-little-table th {
        font-weight:bold;
        padding:21px 25px 22px 25px;
        border-top:1px solid #fafafa;
        border-bottom:1px solid #e0e0e0;

        background: #ededed;
        background: -webkit-gradient(linear, left top, left bottom, from(#ededed), to(#ebebeb));
        background: -moz-linear-gradient(top, #ededed, #ebebeb);
    }
    .simple-little-table th:first-child{
        text-align: left;
        padding-left:20px;
    }
    .simple-little-table tr:first-child th:first-child{
        -moz-border-radius-topleft:3px;
        -webkit-border-top-left-radius:3px;
        border-top-left-radius:3px;
    }
    .simple-little-table tr:first-child th:last-child{
        -moz-border-radius-topright:3px;
        -webkit-border-top-right-radius:3px;
        border-top-right-radius:3px;
    }
    .simple-little-table tr{
        text-align: center;
        padding-left:20px;
    }
    .simple-little-table tr td:first-child{
        text-align: left;
        padding-left:20px;
        border-left: 0;
    }
    .simple-little-table tr td {
        padding:18px;
        border-top: 1px solid #ffffff;
        border-bottom:1px solid #e0e0e0;
        border-left: 1px solid #e0e0e0;

        background: #fafafa;
        background: -webkit-gradient(linear, left top, left bottom, from(#fbfbfb), to(#fafafa));
        background: -moz-linear-gradient(top, #fbfbfb, #fafafa);
    }
    .simple-little-table tr:nth-child(even) td{
        background: #f6f6f6;
        background: -webkit-gradient(linear, left top, left bottom, from(#f8f8f8), to(#f6f6f6));
        background: -moz-linear-gradient(top, #f8f8f8, #f6f6f6);
    }
    .simple-little-table tr:last-child td{
        border-bottom:0;
    }
    .simple-little-table tr:last-child td:first-child{
        -moz-border-radius-bottomleft:3px;
        -webkit-border-bottom-left-radius:3px;
        border-bottom-left-radius:3px;
    }
    .simple-little-table tr:last-child td:last-child{
        -moz-border-radius-bottomright:3px;
        -webkit-border-bottom-right-radius:3px;
        border-bottom-right-radius:3px;
    }
    .simple-little-table tr:hover td{
        background: #f2f2f2;
        background: -webkit-gradient(linear, left top, left bottom, from(#f2f2f2), to(#f0f0f0));
        background: -moz-linear-gradient(top, #f2f2f2, #f0f0f0);
    }

    .simple-little-table a:link {
        color: #666;
        font-weight: bold;
        text-decoration:none;
    }
    .simple-little-table a:visited {
        color: #000000;
        font-weight:bold;
        text-decoration:none;
    }
    .simple-little-table a:active,
    .simple-little-table a:hover {
        color: #bd5a35;
        text-decoration:underline;
    }
    input[type=text] {
        padding:5px;
        border:2px solid #ccc;
        -webkit-border-radius: 5px;
        border-radius: 5px;
    }

    input[type=text]:focus {
        border-color:#333;
    }

    input[type=submit] {
        padding:5px 15px;
        background:#ccc;
        border:0 none;
        cursor:pointer;
        -webkit-border-radius: 5px;
        border-radius: 5px;
    }
    a.button15 {
        display: inline-block;
        font-family: arial,sans-serif;
        font-size: 16px;
        font-weight: bold;
        color: rgb(68,68,68);
        text-decoration: none;
        user-select: none;
        padding: .2em 1.2em;
        outline: none;
        border: 1px solid rgba(0,0,0,.1);
        border-radius: 2px;
        background: rgb(245,245,245) linear-gradient(#f4f4f4, #f1f1f1);
        transition: all .218s ease 0s;
    }
    a.button15:hover {
        color: rgb(24,24,24);
        border: 1px solid rgb(198,198,198);
        background: #f7f7f7 linear-gradient(#f7f7f7, #f1f1f1);
        box-shadow: 0 1px 2px rgba(0,0,0,.1);
    }
    a.button15:active {
        color: rgb(51,51,51);
        border: 1px solid rgb(204,204,204);
        background: rgb(238,238,238) linear-gradient(rgb(238,238,238), rgb(224,224,224));
        box-shadow: 0 1px 2px rgba(0,0,0,.1) inset;
    }
</style>

<html>
<head>
    <title>Order</title>
</head>
<body>

<div style="background-color:#000000; color:#D3D3D3; width:100%; height:50px; margin-top: 0px; margin-bottom: 10px;">
    <h1 align="center"> ${user.getName_user()} </h1>
    <div align="right">
        <a href="/"  class="button15">Home</a>
        <a href="/vihod"  class="button15">Exit</a>
    </div>
</div>
<DIV ALIGN="CENTER">
    <img src="c.png" width="600" height="300" alt="order" ALIGN="CENTER" />
</DIV>

<table align="center" class="simple-little-table" cellspacing='0' width="500">

    <tr align="center">
        <th width="168"><b>ID</b></th>
        <th width="168"><b>Name</b></th>
        <th width="168"><b>Product</b></th>
        <th width="168"><b>Provider</b></th>
        <th width="168"><b>Nds</b></th>
        <th width="168"><b>Delete</b></th>
    </tr>

    <c:forEach items="${requestScope.orders}" var="orders">

        <tr>

            <td>${orders.id_order}</td>
            <td><c:out value="${orders.getName_order()}"/></td>
            <td><c:out value="${orders.getId_product()}"/></td>
            <td><c:out value="${orders.getId_provider()}"/></td>
            <td><c:out value="${orders.nds}"/></td>
            <td>
                <a href="deleteorders?id_order=${orders.id_order}" >
                    <img src="../image/3.png" />
                </a>
            </td>
        </tr>
    </c:forEach>
    <form action="/addorders" method="POST">
        <tr>
            <td>    </td>
            <td >
                <input name='name_order' type="text">
            </td>
            <td >
                <input name='id_product' type="text">
            </td>
            <td >
                <input name='id_provider' type="text">
            </td>
            <td >
                <input name='nds' type="text">
            </td>
            <td >
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

<div style="background-color:#000000; color:#D3D3D3; width:100%; height:30px; margin-top: 30px; margin-down: 0px;">
    <h4 align="center" >autor - t_sarnavskaya@mail.ru</h4>
</div>

</body>
</html>

<%@ include file="preludes.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<html>
<head>
<title>${param.title}</title>
    <style type="text/css">
        <%@ include file="../css/common.css" %>
    </style>
</head>
<body>
<c:choose>
<c:when test="${empty user}">
<div style="background-color:#1f2124; color:#D3D3D3; width:100%; height:50px; margin-top: 0px; margin-bottom: 10px;">
    <div align="right">
        <a href="/registration/" class="button15">Registration</a>
        <a href="/login/" class="button15">Sign in</a>
    </div>
</div>
</c:when>
<c:otherwise>
<div style="background-color:#1f2124; color:#D3D3D3; width:100%; height:50px; margin-top: 0px; margin-bottom: 10px;">
    <h1 align="center"> ${user.getName_user()} </h1>
    <div align="right">
        <a href="/" class="button15">Home</a>
        <a href="/exit" class="button15">Exit</a>
    </div>
</div>
</c:otherwise>
</c:choose>



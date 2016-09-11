<%@ include file="preludes.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<body>
<style type="text/css">
    <%@ include file="../css/bootstrap.css" %>
    <%@ include file="../css/common.css" %>
</style>
<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp">Bakery Shop</a>
        </div>
        <div class="navbar-collapse collapse">
            <c:choose>
                <c:when test="${empty user}">
                    <div class="navbar-right">
                        <div align="right">
                            <a href="/registration/" class="btn btn-success" style="margin-top: 10px;">Registration</a>
                            <a href="/login/" class="btn btn-success" style="margin-top: 10px;"> Sign in</a>
                        </div>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="navbar-right">
                        <span align="center" class="navbar-brand"> ${user.getName_user()} </span>
                        <a href="/exit" class="btn btn-success" style="margin-top: 10px;">Exit</a>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</div>


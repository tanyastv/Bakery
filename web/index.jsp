<%@ include file="includes/preludes.jsp" %>
<jsp:include page="includes/header.jsp">
    <jsp:param name="title" value="Home"/>
    <jsp:param name="user" value="${user}"/>
</jsp:include>
<title>Bakery Shop</title>
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
            <div align="CENTER">
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <h1 align="center">Bakery Shop</h1>
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
            </div>
            </table>
        </c:otherwise>
    </c:choose>
</div>
</body>

</html>
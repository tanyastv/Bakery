<%@ include file="includes/preludes.jsp" %>
<jsp:include page="includes/header.jsp">
    <jsp:param name="title" value="Home"/>
    <jsp:param name="user" value="${user}"/>
</jsp:include>

<div ALIGN="CENTER">
    <img src="/3.png" width="600" height="300" alt="index" ALIGN="CENTER"/>
    <h1 align="center">Bakery Shop</h1>
    <img src="/44.png" alt="blue line" ALIGN="CENTER"/>
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
    <br>
    <br>
<%@ include file="includes/footer.jsp" %>
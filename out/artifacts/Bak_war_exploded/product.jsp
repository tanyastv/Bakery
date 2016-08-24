<%@ include file="includes/preludes.jsp" %>
<jsp:include page="includes/header.jsp">
    <jsp:param name="title" value="Product"/>
</jsp:include>

<DIV ALIGN="CENTER">
    <img src="a.png" width="600" height="300" alt="product" ALIGN="CENTER"/></DIV>

<br>
<table align="center" class="simple-little-table" cellspacing='0' width="500">

    <tr align="center">
        <th width="168"><b>ID</b></th>
        <th width="168"><b>Name</b></th>
        <th width="168"><b>Cost</b></th>
        <th width="168"><b>Delete</b></th>
    </tr>

    <c:forEach items="${requestScope.product}" var="product">

        <tr>

            <td>${product.id_product}</td>
            <td><c:out value="${product.getName_product()}"/></td>
            <td><c:out value="${product.cost}"/></td>
            <td>
                <a href="deleteproduct?id_product=${product.id_product}">
                    <img src="3.png"/>
                </a>
            </td>
        </tr>
    </c:forEach>
    <form action="/addproduct" method="POST">
        <tr>
            <td></td>
            <td>
                <input name='name_product' type="text">
            </td>
            <td>
                <input name='cost' type="text">
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
<%@ include file="includes/footer.jsp" %>

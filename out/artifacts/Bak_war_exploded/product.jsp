<%@ include file="includes/preludes.jsp" %>
<jsp:include page="includes/header.jsp">
    <jsp:param name="title" value="Product"/>
</jsp:include>
<title>Product</title>
<br>
<br>
<br>
<br>
<div style="color:#000000; width:100%; height:50px;">
    <h2 align="center"> PRODUCT </h2>
</div>
<DIV ALIGN="CENTER"></DIV>
<table align="center" class="simple-little-table" cellspacing='0' width="500">
    </DIV>
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
                    <button type="button" class="btn btn-default btn-lg">
                        &#x2716;
                    </button>
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
</body>
</html>
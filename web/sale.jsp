<%@ include file="includes/preludes.jsp" %>
<jsp:include page="includes/header.jsp">
    <jsp:param name="title" value="Sale"/>
</jsp:include>
<title>Sale</title>
<br>
<br>
<br>
<br>
<div style="color:#000000; width:100%; height:50px;">
    <h2 align="center"> SALE </h2>
</div>
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
                    <button type="button" class="btn btn-default btn-lg">
                        &#x2716;
                    </button>
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
</body>
</html>
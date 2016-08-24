<%@ include file="includes/preludes.jsp" %>
<jsp:include page="includes/header.jsp">
    <jsp:param name="title" value="Orders"/>
</jsp:include>
<DIV ALIGN="CENTER">
    <img src="c.png" width="600" height="300" alt="order" ALIGN="CENTER"/>
</DIV>
<br>
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
                <a href="deleteorders?id_order=${orders.id_order}">
                    <img src="3.png"/>
                </a>
            </td>
        </tr>
    </c:forEach>
    <form action="/addorders" method="POST">
        <tr>
            <td></td>
            <td>
                <input name='name_order' type="text">
            </td>
            <td>
                <input name='id_product' type="text">
            </td>
            <td>
                <input name='id_provider' type="text">
            </td>
            <td>
                <input name='nds' type="text">
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

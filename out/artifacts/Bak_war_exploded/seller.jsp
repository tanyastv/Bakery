<%@ include file="includes/preludes.jsp" %>
<jsp:include page="includes/header.jsp">
    <jsp:param name="title" value="Seller"/>
</jsp:include>
<DIV ALIGN="CENTER">
    <img src="web/image/a.png" width="600" height="300" alt="seller" ALIGN="CENTER"/>
</DIV>
<br>
<table align="center" class="simple-little-table" cellspacing='0' width="500">

    <tr align="center">
        <th width="168"><b>ID</b></th>
        <th width="168"><b>Name</b></th>
        <th width="168"><b>Order</b></th>
        <th width="168"><b>Delete</b></th>
    </tr>

    <c:forEach items="${requestScope.seller}" var="seller">

        <tr>

            <td>${seller.id_seller}</td>
            <td><c:out value="${seller.getName_seller()}"/></td>

            <td><c:out value="${seller.id_order}"/></td>
            <td>
                <a href="deleteseller?id_seller=${seller.id_seller}">
                    <img src="3.png"/>
                </a>
            </td>
        </tr>
    </c:forEach>
    <form action="/addseller" method="POST">
        <tr>
            <td></td>
            <td>
                <input name='name_seller' type="text">
            </td>
            <td>
                <input name='id_order' type="text">
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

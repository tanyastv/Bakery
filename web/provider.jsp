<%@ include file="includes/preludes.jsp" %>
<jsp:include page="includes/header.jsp">
    <jsp:param name="title" value="Provider"/>
</jsp:include>

<DIV ALIGN="CENTER">
    <img src="b.png" width="600" height="300" alt="provider" ALIGN="CENTER"/>
</DIV>
<br>
<table align="center" class="simple-little-table" cellspacing='0' width="500">

    <tr align="center">
        <th width="168"><b>ID</b></th>
        <th width="168"><b>Product</b></th>
        <th width="168"><b>Date</b></th>
        <th width="168"><b>Name</b></th>
        <th width="168"><b>Delete</b></th>
    </tr>
    <c:forEach items="${requestScope.provider}" var="provider">
        <tr>

            <td>${provider.id_provider}</td>
            <td><c:out value="${provider.id_product}"/></td>
            <td><c:out value="${provider.date_of_delivery}"/></td>
            <td><c:out value="${provider.getName_provider()}"/></td>
            <td>
                <a href="deleteprovider?id_provider=${provider.id_provider}">
                    <img src="3.png"/>
                </a>
            </td>
        </tr>
    </c:forEach>
    <form action="/addprovider" method="POST">
        <tr>
            <td></td>

            <td>
                <input name='id_product' type="text">
            </td>
            <td>
                <input name='date_of_delivery' type="date">
            </td>

            <td>
                <input name='name_provider' type="text">
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
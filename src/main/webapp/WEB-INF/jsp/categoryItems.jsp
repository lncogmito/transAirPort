<%@ include file="./include/importTags.jsp"%>

<h1>${currentCategory.getName()}</h1>

<table id="productList">
    <tr class="productLine">
        <%
            int iItem = 0;
        %>
        <c:forEach var="productItem" items="${productList}">
            <td class="productItem">
                <table class="productItemTable">
                    <tr><td colspan="2">${productItem.getName()}</td></tr>
                    <tr><td colspan="2"><img class="productImage" src="<spring:url value='/images/products/${productItem.getProduct().getId()}.png'/>"/></td> </tr>
                    <tr>
                        <form:form id="productItemBasketForm"
                        method="post"
                        action="/transAirPort/categoryItems/send"
                        modelAttribute="current_basket">

                        </form:form>
                        <td></td>
                        <td></td>
                    </tr>
                </table>
            </td>

            <%
                if(iItem < 3)
                    iItem ++;
                else{
                    out.println("</tr><tr class='productLine'>");
                    iItem = 0;
                }
            %>

        </c:forEach>
    </tr>
</table>

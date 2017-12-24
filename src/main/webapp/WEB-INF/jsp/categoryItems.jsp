<%@ include file="./include/importTags.jsp"%>

<h1>${currentCategory.getName()}</h1>

<table id="productList">
    <tr class="productLine">
        <%
            int iItem = 0;
        %>
        <c:forEach var="productItem" items="${productList}">
            <td class="productItem">
                <form:form id="productItemBasketForm"
                           method="post"
                           action="/transAirPort/productDetails/send?product=${productItem.getProduct().getId()}"
                           modelAttribute="formQuantity">
                    <table class="productItemTable">
                        <tr><td colspan="2">
                                ${productItem.getName()}
                        </td></tr>
                        <tr><td colspan="2">
                            <a href="/transAirPort/productDetails?product=${productItem.getProduct().getId()}">
                                <img class="img-responsive" src="<spring:url value='/images/${productItem.getProduct().getId()}.jpg'/>"/>
                            </a>
                        </td></tr>
                        <tr>
                            <td>
                                <form:input path="quantity" type="number"/>
                            </td>
                            <td>
                                <form:button class="btn btn-secondary btn-sm"><spring:message code="buttonValidate"/></form:button>
                            </td>
                        </tr>
                    </table>
                </form:form>
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
        <c:if test="${productList.isEmpty()}">
            <spring:message code="emptyCategory"/>
        </c:if>
    </tr>
</table>

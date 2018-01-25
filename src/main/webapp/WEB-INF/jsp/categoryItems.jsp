<%@ include file="./include/importTags.jsp"%>

<h1 class="titleCat">${currentCategory.getName()}</h1>
<p><spring:message code="categoryInfoAdd"/></p>
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
                        <tr><td colspan="2" class="productItemName">
                                ${productItem.getName()}
                        </td></tr>
                        <tr><td colspan="2" class="productItemImg">
                            <a href="/transAirPort/productDetails?product=${productItem.getProduct().getId()}">
                                <img src="<spring:url value='/images/${productItem.getProduct().getId()}.jpg'/>"/>
                            </a>
                        </td></tr>
                        <tr>
                            <td class="productItemQuant">
                                <form:input path="quantity" type="number"/>
                            </td>
                            <td class="productItemBut">
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
            <p class="emptyCat"><spring:message code="emptyCategory"/></p>
        </c:if>
    </tr>
</table>

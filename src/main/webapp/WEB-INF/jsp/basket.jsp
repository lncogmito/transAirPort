<%@ include file="./include/importTags.jsp"%>
<c:choose>
    <c:when test="${!orderLines.isEmpty()}">
        <table id="basketList">
            <tr>
                <th><spring:message code="basketHeaderTableProduct"/></th>
                <th><spring:message code="basketHeaderTablePhotos"/></th>
                <th><spring:message code="basketHeaderTableQuantity"/></th>
                <th><spring:message code="basketHeaderTableUnitPrice"/></th>
            </tr>

            <%
                int iItem = 0;
            %>
            <c:forEach var="orderLine" items="${orderLines}">
                <tr class="basketProduct">
                    <td>${productList.get(iItem).getName()}</td>
                    <td><a href="/transAirPort/productDetails?product=${orderLine.getProduct().getId()}"><img src="<spring:url value='/images/${orderLine.getProduct().getId()}.jpg'/>"/></a></td>
                    <td>${orderLine.getQuantity()}</td>
                    <td><fmt:formatNumber type="number" maxFractionDigits="2" value="${orderLine.getPrice()}" /></td>
                    <td><a href="/transAirPort/delete?productId=${orderLine.getProduct().getId()}"><spring:message code="basketDelete"/></a></td>
                </tr>
                <%
                    iItem++;
                %>
            </c:forEach>


            <tr class="basketPrice">
                <td colspan="3"><spring:message code="basketTableTotalCost"/></td>
                <td colspan="2"><fmt:formatNumber type="number" maxFractionDigits="2" value="${totalCost}" /> euros</td>
            </tr>

            <c:if test="${totalCost != totalCostReduc}">
                <tr class="basketPrice">
                    <td colspan="3"><spring:message code="basketTableTotalCostReduc"/></td>
                    <td colspan="2"><fmt:formatNumber type="number" maxFractionDigits="2" value="${totalCostReduc}" /> euros</td>
                </tr>
            </c:if>
            <tr>
                <td colspan="5"><a href="/transAirPort/validateCommand"><button><spring:message code="buttonValidateCommand"/></button></a></td>
            </tr>

        </table>
    </c:when>
    <c:otherwise>
        <p class="emptyCat"><spring:message code="emptyBasket"/></p>
    </c:otherwise>
</c:choose>

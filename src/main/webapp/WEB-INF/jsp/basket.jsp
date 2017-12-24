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
                    <td>${productList.get(iItem).getName()}</td><!-- Charger une arraylist d'infos en // -->
                    <td><img class="img-responsive" src="<spring:url value='/images/${orderLine.getProduct().getId()}.jpg'/>"/></td>
                    <td>${orderLine.getQuantity()}</td>
                    <td><fmt:formatNumber type="number" maxFractionDigits="2" value="${orderLine.getPrice()}" /></td>
                    <!-- ADD bouton supprimer de la list! -->
                </tr>
                <%
                    iItem++;
                %>
            </c:forEach>
            <tr><td colspan="3"><spring:message code="basketTableTotalCost"/></td><td><fmt:formatNumber type="number" maxFractionDigits="2" value="${totalCost}" /> euros</td></tr>
            <c:if test="${totalCost != totalCostReduc}">
                <tr><td colspan="3"><spring:message code="basketTableTotalCostReduc"/></td><td><fmt:formatNumber type="number" maxFractionDigits="2" value="${totalCostReduc}" /> euros</td></tr>
            </c:if>
            <tr><td colspan="4"><a href="/transAirPort/validateCommand"><button><spring:message code="buttonValidateCommand"/></button></a></td></tr>
        </table>
    </c:when>
    <c:otherwise>
        <p><spring:message code="emptyBasket"/></p>
    </c:otherwise>
</c:choose>

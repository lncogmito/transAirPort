<%@ include file="./include/importTags.jsp"%>
<div id="productDetailsBasket">
    <table id="productDetailsBasketTable"><form:form id="productDetailsBasketForm"
                                 method="post"
                                 action="/transAirPort/productDetails/send?product=${productItem.getProduct().getId()}"
                                 modelAttribute="formQuantity"
    >
        <tr>
            <td>${productItem.getName()}</td>
            <td><fmt:formatNumber type="number" maxFractionDigits="2" value="${productItem.getProduct().getPrice()*(1+productItem.getProduct().getVat()/100)}"/> euros</td>
        </tr>
        <tr>
            <td><img class="img-responsive" src="<spring:url value='/images/${productItem.getProduct().getId()}.jpg'/>"/></td>
            <td><form:input path="quantity" type="number"/></td>
        </tr>
        <tr>
            <td>${productItem.getDescription()}</td>
            <td><form:button class="btn btn-secondary btn-sm"><spring:message code="buttonValidate"/></form:button></td>
        </tr>
    </form:form></table>
</div>
<div id="productDetailsInfo"></div>
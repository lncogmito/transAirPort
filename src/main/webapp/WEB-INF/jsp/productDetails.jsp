<%@ include file="./include/importTags.jsp"%>
<div id="productDetails">
    <table id="productDetailsTable"><form:form id="productDetailsBasketForm"
                                 method="post"
                                 action="/transAirPort/productDetails/send?product=${productItem.getProduct().getId()}"
                                 modelAttribute="formQuantity"
    >
        <tr>
            <td colspan="2" class="errorField">
                <form:errors path="quantity"/>
            </td>
        </tr>
        <tr>
            <td class="productDetailsName">${productItem.getName()}</td>
            <td class="productDetailsPrice"><fmt:formatNumber type="number" maxFractionDigits="2" value="${productItem.getProduct().getPrice()*(1+productItem.getProduct().getVat()/100)}"/> euros</td>
        </tr>
        <tr>
            <td class="productDetailsImg"><img src="<spring:url value='/images/${productItem.getProduct().getId()}.jpg'/>"/></td>
            <td  class="productDetailsQuantity"><form:input path="quantity" type="number"/></td>
        </tr>
        <tr>
            <td class="productDetailsDesc">${productItem.getDescription()}</td>
            <td class="productDetailsBut"><form:button class="btn btn-secondary btn-sm"><spring:message code="buttonValidate"/></form:button></td>
        </tr>
    </form:form></table>
</div>
<div id="productDetailsInfo"></div>
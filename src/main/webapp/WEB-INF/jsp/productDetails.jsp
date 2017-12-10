<%@ include file="./include/importTags.jsp"%>
<div id="productDetailsHeader">
    <h1>NOM PRODUIT</h1>
</div>
<div id="productDetailsPhoto">
    <img src="CHEMIN RELATIF EN BD"/>
</div>
<div id="productDetailsBasket">
    <table id="productDetailsBasketTable"><form:form id="productDetailsBasketForm"
                                 method="post"
                                 action="/transAirPort/"
                                 modelAttribute="current_basket"
    >
        <tr>
            <td></td>
            <td colspan="2"><form:input path="username"></form:input></td>
        </tr>
        <tr>
            <td colspan="2"><form:password path="password"></form:password></td>
        </tr>
        <tr>
            <td><form:button><spring:message code="buttonLogIn"/></form:button></td>
            <td><a href="/transAirPort/signIn"><button><spring:message code="buttonSignIn"/></button></a></td>
        </tr>
    </form:form></table>
</div>
<div id="productDetailsInfo"></div>
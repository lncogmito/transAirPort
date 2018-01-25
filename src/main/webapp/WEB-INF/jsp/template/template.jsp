<%@ include file="../include/importTags.jsp"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!--db204Pa$$-->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css" href="<spring:url value="/css/transAirPortStylesheet.css"/>" rel="stylesheet">
    <title>
        ${title}
    </title>

    <spring:url var="localeFr" value="">
        <c:if test="${param.type != null}">
            <spring:param name="type" value="${param.type}"/>
        </c:if>
        <c:if test="${param.product != null}">
            <spring:param name="product" value="${param.product}"/>
        </c:if>
        <spring:param name="locale" value="fr"/>
    </spring:url>
    <spring:url var="localeEn" value="">
        <c:if test="${param.type != null}">
            <spring:param name="type" value="${param.type}"/>
        </c:if>
        <c:if test="${param.product != null}">
            <spring:param name="product" value="${param.product}"/>
        </c:if>
        <spring:param name="locale" value="en"/>
    </spring:url>
</head>
<body>
    <ul id="menu">
        <li><a href="/transAirPort/home">TransAirPort</a></li>
        <li><a href="#"><spring:message code="menuCategories"/></a>
            <ul>
                <c:forEach var="category" items="${categories}">
                    <li><a href="/transAirPort/category?type=${category.getCategory().getCode()}">${category.getName()}</a></li>
                </c:forEach>
            </ul>
        </li><li><a href="/transAirPort/basket"><spring:message code="menuBasket"/> (${nbItemInBasket})</a></li>
    </ul>


    <div id="lang">
        <a href="${localeFr}"><img src="<spring:url value='/images/fr.png'/>" id="langFr"/></a>
        <a href="${localeEn}"><img src="<spring:url value='/images/en.png'/>" id="langEn"/></a>
    </div>

    <sec:authorize access="!isAuthenticated()">
        <table id="login">
            <tr>
                <td><a href="/transAirPort/logged"><button><spring:message code="buttonLogIn"/></button></td>
                <td><a href="/transAirPort/signIn"><button><spring:message code="buttonSignIn"/></button></a></td>
            </tr>
        </table>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <table id="login">
            <tr>
                <td><a href='<c:url value="/logout"/>'><button><spring:message code="buttonLogOut"/></button></a></td>
            </tr>
        </table>
    </sec:authorize>

    <p class="msg">${msg}</p>

    <div id="mainPart">
        <tiles:insertAttribute name="main-content"/>
    </div>
    <footer>
        <sec:authorize access="isAuthenticated()">
            <p>Connected as ${pageContext.request.userPrincipal.name}</p>
        </sec:authorize>
    </footer>
</body>
</html>

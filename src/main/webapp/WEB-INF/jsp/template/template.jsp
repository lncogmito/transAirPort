<%@ include file="../include/importTags.jsp"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!--db204Pa$$-->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link type="text/css" href="<spring:url value='/css/bootstrap.min.css'/>" rel="stylesheet">
    <link type="text/css" href="<spring:url value="/css/transAirPortStylesheet.css"/>" rel="stylesheet">

    <spring:url var="localeFr" value="">
        <spring:param name="locale" value="fr"/>
    </spring:url>
    <spring:url var="localeEn" value="">
        <spring:param name="locale" value="en"/>
    </spring:url>
</head>
<body>
    <ul id="menu">
        <li><a href="/transAirPort/home">TransAirPort</a></li>
        <li><a href="#">Menu</a>
            <ul>
                <li><a href="/transAirPort/normal">Normal page</a></li>
                <li><a href="/transAirPort/admin">Admin page</a></li>
                <li><a href="#">lien sous menu 3</a></li>
                <li><a href="#">lien sous menu 3</a></li>
            </ul>
        </li><li><a href="#">Lien menu 4</a>
            <ul>
                <li><a href="#">Lien sous menu 4</a></li>
                <li><a href="#">Lien sous menu 4</a></li>
                <li><a href="#">Lien sous menu 4</a></li>
                <li><a href="#">Lien sous menu 4</a></li>
            </ul>
        </li>
    </ul>


    <div id="lang">
        <a href="${localeFr}"><img src="<spring:url value='/images/fr.png'/>" id="langFr"/></a>
        <a href="${localeEn}"><img src="<spring:url value='/images/en.png'/>" id="langEn"/></a>
    </div>

    <sec:authorize access="!isAuthenticated()">
        <table id="login">
            <tr>
                <!-- $ {requestScope['javax.servlet.forward.request_uri']}-->
                <td><a href="/transAirPort/normal"><button><spring:message code="buttonLogIn"/></button></td>
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


    <div id="mainPart">
        <tiles:insertAttribute name="main-content"/>
    </div>
    <footer>
        <sec:authorize access="isAuthenticated()">
            <p>Connected as ${pageContext.request.userPrincipal.name}</p>
        </sec:authorize>
        <p>Footer</p>
    </footer>
</body>
</html>

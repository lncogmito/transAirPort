<%@ include file="./include/importTags.jsp"%>

<p>Bienvenue Tout ca tout ca</p>
<sec:authorize access="!isAuthenticated()">
<p>not authenticated</p>
</sec:authorize>
<sec:authorize access="isAuthenticated()">
<p>authenticated</p>
</sec:authorize>

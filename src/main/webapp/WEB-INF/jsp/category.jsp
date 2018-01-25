<%@ include file="./include/importTags.jsp"%>

<h1 class="titleCat">${currentCategory.getName()}</h1>

<ul id="subCatList">
    <c:forEach var="category" items="${childCategories}">
        <li><a href="/transAirPort/category?type=${category.getCategory().getCode()}">${category.getName()}</a></li>
    </c:forEach>
</ul>
<%@ include file="./include/importTags.jsp"%>
<form:form id="signInForm"
           method="post"
           action="/transAirPort/signIn/send"
           modelAttribute="newUser">
    <table>
        <tr>
            <td>
                <form:label path="username"><spring:message code="signInLabelUsername"/></form:label>
                <form:input path="username"/>
            </td>
            <td>
                <form:errors path="username"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="email"><spring:message code="signInLabelEmail"/></form:label>
                <form:input path="email"/>
            </td>
            <td>
                <form:errors path="email"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="emailConfirm"><spring:message code="signInLabelEmailConfirm"/></form:label>
                <form:input path="emailConfirm"/>
            </td>
            <td>
                <form:errors path="emailConfirm"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="password"><spring:message code="signInLabelPassword"/></form:label>
                <form:input path="password" type="password"/>
            </td>
            <td>
                <form:errors path="password"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="passwordConfirm"><spring:message code="signInLabelPasswordConfirm"/></form:label>
                <form:input path="passwordConfirm" type="password"/>
            </td>
            <td>
                <form:errors path="passwordConfirm"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="street"><spring:message code="signInLabelAddressStreet"/></form:label>
                <form:input path="street"/>
            </td>
            <td>
                <form:errors path="street"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="houseNumber"><spring:message code="signInLabelAddressHouseNumber"/></form:label>
                <form:input path="houseNumber"/>
            </td>
            <td>
                <form:errors path="houseNumber"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="boxNumber"><spring:message code="signInLabelAddressBoxNumber"/></form:label>
                <form:input path="boxNumber"/>
            </td>
            <td>
                <form:errors path="boxNumber"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="localityName"><spring:message code="signInLabelAddressLocality"/></form:label>
                <form:input path="localityName"/>
            </td>
            <td>
                <form:errors path="localityName"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="postalCode"><spring:message code="signInLabelAddressPostalCode"/></form:label>
                <form:input path="postalCode" type="number"/>
            </td>
            <td>
                <form:errors path="postalCode"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="country"><spring:message code="signInLabelAddressCountry"/></form:label>
                <form:input path="country"/>
            </td>
            <td>
                <form:errors path="country"/>
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <form:button class="btn btn-secondary btn-sm"><spring:message code="buttonValidate"/></form:button>
            </td>
        </tr>
    </table>
</form:form>
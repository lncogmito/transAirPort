
<form:form id="addCategoryStep1"
           method="post"
           action="/transAirPort/addCategory/step1"
           modelAttribute="category">
    <table class="addCategory">
        <form:button class="btn btn-secondary btn-sm"><spring:message code="buttonValidate"/></form:button>
    </table>
</form:form>

<form:form id="addCategoryStep2"
           method="post"
           action="/transAirPort/addCategory/step2"
           modelAttribute="category">
    <table class="addCategory">
        <form:button class="btn btn-secondary btn-sm"><spring:message code="buttonValidate"/></form:button>
    </table>
</form:form>

<form:form id="addCategoryStep3"
           method="post"
           action="/transAirPort/addCategory/step3"
           modelAttribute="category">
    <table class="addCategory">
        <form:button class="btn btn-secondary btn-sm"><spring:message code="buttonValidate"/></form:button>
    </table>
</form:form>

//Prevoir un premier formulaire pour dire à quel élément on attache cette nouvelle catégorie
//Un second pour demander le contenu de catégoryInfo
//une troisième partie pour valider la création

//La page ne doit n'en affiché qu'un à la fois.
//Dans le controller 2 POST avec a chaque fois un integrated de cette meme page car on est toujours renvoyé vers cette page-ci

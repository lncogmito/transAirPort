//Etape 1 du formulaire: connaitre la catégorie mère à laquelle on l'accroche
<c:if test="${step} == 1">
    <form:form id="addCategoryStep1"
               method="post"
               action="/transAirPort/addCategory/step2"
               modelAttribute="category">
        <table class="addCategory">

            <form:button class="btn btn-secondary btn-sm"><spring:message code="buttonValidate"/></form:button>
        </table>
    </form:form>
</c:if>
//Etape 2 du formulaire: Obtenir le nom français
<c:if test="${step} == 2">
    <form:form id="addCategoryStep2"
               method="post"
               action="/transAirPort/addCategory/step3"
               modelAttribute="categoryFrenchName">
        <table class="addCategory">
            <form:button class="btn btn-secondary btn-sm"><spring:message code="buttonValidate"/></form:button>
        </table>
    </form:form>
</c:if>
//Etape 3 du formulaire: Obetnir le nom anglais
<c:if test="${step} == 3">
    <form:form id="addCategoryStep3"
               method="post"
               action="/transAirPort/addCategory/step4"
               modelAttribute="categoryEnglishName">
        <table class="addCategory">
            <form:button class="btn btn-secondary btn-sm"><spring:message code="buttonValidate"/></form:button>
        </table>
    </form:form>
</c:if>
<c:if test="${step} == 4">
//Etape 4 du formulaire: valider le tout
    //VALIDER TOUT CA TOUT CA

</c:if>


//Prevoir un premier formulaire pour dire à quel élément on attache cette nouvelle catégorie
//Un second pour demander le contenu de catégoryInfo
//une troisième partie pour valider la création

//La page ne doit n'en affiché qu'un à la fois.
//Dans le controller 2 POST avec a chaque fois un integrated de cette meme page car on est toujours renvoyé vers cette page-ci

<#include "functions.ftl"/>

<#macro css>
    <#compress>

        <#assign themeStyles>
            <@spring.theme "path.css"/>
        </#assign>

        ${getThemeStyleOrScrypt(themeStyles)}

    </#compress>
</#macro>

<#macro js>
    <#compress>

        <#assign themeScripts>
            <@spring.theme "path.js"/>
        </#assign>

    ${getThemeStyleOrScrypt(themeScripts, "js")}

    </#compress>
</#macro>

<#macro title titleName>
    <@spring.message titleName />
</#macro>

<#macro header inside>
${inside}
</#macro>

<#macro content inside>
${inside}
</#macro>

<#macro footer inside>
${inside}
</#macro>
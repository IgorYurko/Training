<#include "jspTagLibs.ftl"/>
<#function getThemeStyleOrScrypt themeData tagName="link">

    <#assign stylesOrScripts = themeData?matches("[a-z_0-9/.-]+", "i")>

    <#assign result>
        <#compress>
            <#list stylesOrScripts as styleOrScript>
                <#if tagName == "link">
                <link rel="stylesheet" href="<@spring.url value="/resources/css"/>${styleOrScript?ensure_starts_with("/")
                }"/>
                <#else>
                <script src="<@spring.url value="/resources/js"/>${styleOrScript?ensure_starts_with("/")}"></script>
                </#if>
            </#list>
        </#compress>
    </#assign>

    <#return result>

</#function>
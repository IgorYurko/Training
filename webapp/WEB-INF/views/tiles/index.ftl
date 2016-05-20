<#include "jspTagLibs.ftl"/>

<#--<h2><a href="<@spring.url value="/some1"/>" id="some1">GO1</a></h2>-->
<#--<h2><a href="<@spring.url value="/some2"/>" id="some2">GO2</a></h2>-->
<#--<h2><a href="<@spring.url value="/some3"/>" id="some3">GO3</a></h2>-->
<@spring.message code="layout.content.h2.text"/>
<#list all as a>
	<h2>${a.firstName}</h2>
</#list>
<#--<#if request??>-->
    <#--<#assign headers = request.getHeaderNames()/>-->
    <#--<#assign parameters = request.getParameterNames()/>-->
    <#--<#list 1..100 as x>-->
        <#--<#if !headers.hasMoreElements()>-->
            <#--<#break/>-->
        <#--</#if>-->
        <#--<#if headers.hasMoreElements()>-->
            <#--<#assign name = headers.nextElement()/>-->
            <#--<p style="color: black">${name} : ${request.getHeader(name)}</p>-->
        <#--</#if>-->
    <#--</#list>-->
<#--<#else>-->
<h2>No</h2>
<#--</#if>-->
<#--<h2>${request.getRequestURI()?remove_ending("/")?keep_after_last("/")}</h2>-->


<#--<#if Request.keys()??>-->
    <#--<#list Request.keys() as keys>-->
        <#--<p>keys</p>-->
    <#--</#list>-->
<#--<#else>-->
    <#--<p>No</p>-->
<#--</#if>-->

<#--<h2>${request.getHeader("referer")!"Null"}</h2>-->
<#--<h2>${request.getHeader("origin")!"Null"}</h2>-->
<#--Enumeration headerNames = request.getHeaderNames();-->
<#--while(headerNames.hasMoreElements()) {-->
<#--String paramName = (String)headerNames.nextElement();-->
<#--out.print("<tr><td>" + paramName + "</td>\n");-->
<#--String paramValue = request.getHeader(paramName);-->
<#--out.println("<td> " + paramValue + "</td></tr>\n");-->
<#--}-->
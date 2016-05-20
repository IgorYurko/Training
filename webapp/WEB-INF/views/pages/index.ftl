<#import "../layouts/_layout.ftl" as layout/>
<#import "../ftl/index.ftl" as ftl/>
<#assign security=JspTaglibs["http://www.springframework.org/security/tags"] />

<@security.authorize access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
    <@layout._layout "index.title.text", ftl.inside_content/>
</@security.authorize>
<@security.authentication property="principal.username"/>
<@security.authentication property="credentials.password"/>
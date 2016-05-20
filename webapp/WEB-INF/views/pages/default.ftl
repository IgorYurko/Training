<#--<#include "_layout.ftl" />-->

<#macro patern <#--title_name--> inside_header inside_content inside_footer <#--theme_name-->>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title><#--<@title title_name />--></title>
    <#--<@css theme_name />-->
</head>
<body>
<main class="main">
    <header>
        ${inside_header}<#--<@header inside_header />-->
    </header>
    <div class="content">
        ${inside_content}<#--<@content inside_content />-->
    </div>
    <footer>
        ${inside_footer}<#--<@footer inside_footer />-->
    </footer>
    <#--<@js theme_name />-->
</main>
</body>
</html>
</#macro>
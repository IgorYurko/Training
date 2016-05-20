<#include "../tiles/macros.ftl" />
<#include "static-pages.ftl"/>
<#import "/spring.ftl" as spring />

<#macro _layout insideTitle="layout.title.text" insideContent=_content insideHeader=_header insideFooter=_footer>
    <#compress>
        <!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <title><@title insideTitle/></title>
            <link rel="stylesheet" href="<@spring.url "/webjars/jquery-ui/1.11.4/jquery-ui.min.css"/>"/>
            <link rel="stylesheet" href="<@spring.url "/webjars/bootstrap/3.3.6/css/bootstrap.min.css"/>"/>
            <link rel="stylesheet" href="<@spring.url "/webjars/bootstrap/3.3.6/css/bootstrap-theme.min.css"/>"/>
            <@css/>
            <script src="<@spring.url "/webjars/jquery/2.2.0/jquery.min.js"/>"></script>
            <script src="<@spring.url "/webjars/jquery-ui/1.11.4/jquery-ui.min.js"/>"></script>
            <script src="<@spring.url "/webjars/bootstrap/3.3.6/js/bootstrap.min.js"/>"></script>
            <@js/>
        </head>
        <body>
        <main class="main">
            <header>
                <@header insideHeader/>
            </header>
            <div class="content">
                <@content insideContent/>
            </div>
            <footer>
                <@footer insideFooter/>
            </footer>
        </main>
        </body>
        </html>
    </#compress>
</#macro>
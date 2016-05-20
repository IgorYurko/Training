<#include "jspTagLibs.ftl"/>
<#include "macros.ftl"/>
<@tilesx.useAttribute id="titleName" name="title" classname="java.lang.String"/>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><@title titleName/></title>
    <link rel="stylesheet" href="<@spring.url value="/webjars/jquery-ui/1.11.4/jquery-ui.min.css"/>"/>
    <link rel="stylesheet" href="<@spring.url value="/webjars/bootstrap/3.3.6/css/bootstrap.min.css"/>"/>
    <link rel="stylesheet" href="<@spring.url value="/webjars/bootstrap/3.3.6/css/bootstrap-theme.min.css"/>"/>
    <@css/>
    <script src="<@spring.url value="/webjars/jquery/2.2.0/jquery.min.js"/>"></script>
    <script src="<@spring.url value="/webjars/jquery-ui/1.11.4/jquery-ui.min.js"/>"></script>
    <script src="<@spring.url value="/webjars/bootstrap/3.3.6/js/bootstrap.min.js"/>"></script>
    <@js/>
</head>
<body>
<main class="main">
    <header>
        <@tiles.insertAttribute name="header"/>
    </header>
    <div class="content">
        <@tiles.insertAttribute name="content"/>
    </div>
    <footer>
        <@tiles.insertAttribute name="footer"/>
    </footer>
</main>
</body>
</html>
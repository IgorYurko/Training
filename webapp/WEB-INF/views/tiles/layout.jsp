<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="te" uri="http://tiles.apache.org/tags-tiles-extras" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<te:useAttribute name="title" classname="java.lang.String"/>
<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title><s:message code="${title}"/></title>
</head>
<body>
<div class="content">
    <t:insertAttribute name="content"/>
</div>
</body>
</html>
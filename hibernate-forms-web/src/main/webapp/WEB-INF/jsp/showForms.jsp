<%-- 
    Document   : showForms
    Created on : 2014-05-21, 14:16:47
    Author     : Adrian Lapierre <adrian@softproject.com.pl>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
    <ul>
        <c:forEach items="${forms}" var="form">
            <li><a href="<c:url value="/displayForm.htm?id=${form.id}" />">${form.title}</a></li>
        </c:forEach>
    <ul> 
        
    </body>
</html>

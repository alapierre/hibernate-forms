<%-- 
    Document   : displayForm
    Created on : 2014-05-21, 14:59:12
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
        <h1>${form.title}</h1>
        
        <c:forEach items="${form.fields}" var="field">
            ${field.description}
        </c:forEach>
    </body>
</html>

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
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>JSP Page</title>
        <%@include file="../jspf/bootstrap.jspf" %>
    </head>
    <body>

        <%@include file="../jspf/menu.jspf" %>
        

        <div class="container">

            <div class="starter-template">
                <br><br>
                <h1>Hello World!</h1>
                
                <ul>
                    <c:forEach items="${forms}" var="form">
                        <li><a href="<c:url value="/displayForm.htm?id=${form.id}" />">${form.title}</a></li>
                        </c:forEach>
                </ul>
                
            </div>

        </div><!-- /.container -->





    </body>
</html>

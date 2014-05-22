<%-- 
    Document   : addForm
    Created on : 2014-05-22, 09:58:19
    Author     : Adrian Lapierre <adrian@softproject.com.pl>
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
        <br/><br/>
        <h1>Dodawanie nowej Ankiety</h1>
        
        <c:url value="/admin/saveForm.htm" var="url" />
        
        <form:form commandName="form" action="${url}" method="POST">
            <form:input required="true" path="title"/><form:errors path="title"/>
            
            <form:button>Zapisz</form:button>
        </form:form>
        
    </body>
</html>

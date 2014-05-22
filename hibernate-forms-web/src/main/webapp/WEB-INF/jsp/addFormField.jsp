<%-- 
    Document   : addFormField
    Created on : 2014-05-22, 11:03:04
    Author     : Adrian Lapierre <adrian@softproject.com.pl>
--%>

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
        <title>Dodawanie pola do ankiety</title>
        <%@include file="../jspf/bootstrap.jspf" %>
    </head>
    <body>
        <%@include file="../jspf/menu.jspf" %>
        <br/><br/>
        <h1>Dodaj pole do ankiety!</h1>
        
        <h2>${form.title}</h2>
        
        <ul>
            <c:forEach items="${form.fields}" var="field">
                <li>${field.lp} : ${field.formField.question}</li>
            </c:forEach>
        </ul>
            
        <form:form commandName="formFormFieldAssociacion" method="POST" action="saveFormField.htm">
            
            <c:choose>
                <c:when test="${empty form.id}">
                    <label for="form.id">Ankieta</label>
                    <form:select path="form.id" items="${forms}" itemLabel="title" itemValue="id"></form:select>
                    <br/>
                </c:when>
                <c:otherwise>
                    <form:hidden path="form.id" />
                </c:otherwise>
            </c:choose>
            
            <label for="formField.id">Pytanie</label>
            <form:select path="formField.id" items="${formFields}" itemLabel="question" itemValue="id"/>
            <br/>
            <label for="description">Opis pytania</label>
            <form:input path="description"/>   
            <br/>
            <form:button>Dodaj</form:button>
        </form:form>
            
    </body>
</html>

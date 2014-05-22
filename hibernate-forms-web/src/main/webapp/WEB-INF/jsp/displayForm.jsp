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
        
        <c:url value="/saveFormDate.htm" var="saveURL" />
        
        <form method="POST" action="${saveURL}">
        
            <input type="hidden" name="form_id" value="${form.id}"/>
                
            
            <label for="person.name">Imię i nazwisko</label>
            <input type="text" name="person.name" id="person.name"/>
            <br/>
            <label for="person.address.street">Ulica</label>
            <input type="text" name="person.address.street" id="person.address.street"/>
            <br/>
            <label for="person.address.citi">Miasto</label>
            <input type="text" name="person.address.citi" id="person.address.citi"/>
            <br/>
            <label for="person.address.postcode">Kod pocztowy</label>
            <input type="text" name="person.address.postcode" id="person.address.postcode"/>
            <br/>
            
            <c:forEach items="${form.fields}" var="field">
                <label for="field_${field.formField.id}">${field.lp}. ${field.formField.question}</label>
                <input type="text" id="field_${field.formField.id}" name="field_${field.formField.id}">
                 <br/>${field.description} 
                 <br/>
            </c:forEach>
                 <input type="submit" value="Zapisz" name="submit">
        </form>
    </body>
</html>

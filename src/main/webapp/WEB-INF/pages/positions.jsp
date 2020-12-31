<%-- 
    Document   : positions
    Created on : Dec 29, 2020, 8:05:37 PM
    Author     : Silvan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:pageTemplate pageTitle="Positions">
    <h1>Available positions: </h1>
    <br>
    <c:forEach var="position" items="${positions}">
        <br>
        <div class="card text-center">
		  <div class="card-body">
		    <h4 class="card-title">${position.name}</h4>
		    <p class="card-text">${position.description}</p>
		    <c:if test="${position.isOpen}">
		    	<a href="Applications/Add" class="btn btn-primary">Apply</a>
		    </c:if>
		  </div>
		</div>
    </c:forEach>
</t:pageTemplate>

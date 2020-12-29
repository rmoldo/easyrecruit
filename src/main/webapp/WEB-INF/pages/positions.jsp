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

    <c:forEach var="position" items="${positions}">
        <br>
    	<div class="row">
    		<div class="col-md-4">
                    <h5>${position.name}</h5>
    		</div>
    		<div class="col-md-4">
                    ${position.description}
    		</div>
                <c:if test="${position.isOpen}">
                    <div class="col-md-4">
                        <button class="btn btn-primary btn-lg btn-block" onclick="location.href='Applications/Add'" type="button">Apply</button>
                    </div>
                </c:if>
    	</div>
    </c:forEach>
</t:pageTemplate>

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
		    <c:choose>
				<c:when test="${position.isOpen}">
					<!--c:if test="${pageContext.request.isUserInRole('ClientRole')}">-->
						<a href="Applications/Add" class="btn btn-primary">Apply</a>
					<!--/c:if>-->
				</c:when>
				<c:otherwise>
					<!--c:if test="${pageContext.request.isUserInRole('AdminRole')}">-->
						<a href="Positions/Add" class="btn btn-primary">Approve position</a>
				    <!--/c:if>-->
				</c:otherwise>
			</c:choose>
			<!--c:if test="${pageContext.request.isUserInRole('AdminRole')}">-->
				<a href="Applications/Add" class="btn btn-primary">Edit position</a>
			<!--/c:if>-->
			<!--c:if test="${pageContext.request.isUserInRole('AdminRole')}">-->
				<a href="Applications/Add" class="btn btn-danger">Delete position</a>
			<!--/c:if>-->
		  </div>
		  <div class="card-footer text-muted">
		    Created by ${position.creatorUserName}
		  </div>
		</div>
    </c:forEach>
    <!--c:if test="${pageContext.request.isUserInRole('AdminRole')}">-->
    <br><br>
    <div class="row justify-content-center">
		<a href="Positions/Add" class="btn btn-primary">Add position</a>
	</div>
    <!--/c:if>-->
</t:pageTemplate>

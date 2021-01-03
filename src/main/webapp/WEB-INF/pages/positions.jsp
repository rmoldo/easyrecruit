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
				<!--c:if test="${pageContext.request.isUserInRole('ClientRole')}">-->
					<a href="Applications/Add?positionId=${position.id}" class="btn btn-success">Apply for this position</a>
				<!--/c:if>-->
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
				<br>
				<br>
				<div class="card text-white bg-info mb-3">
					<h5 class="card-header">Comments</h5>
					<div class="card-body">
						<c:forEach var="comment" items="${position.comments}">
							<b>${comment.creatorUser}: </b>
							<p>${comment.text}</p>
						</c:forEach>
						<c:if test="${pageContext.request.getRemoteUser() != null}">
							<form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/Positions/AddComment">
								<input type="hidden" class="form-control" id="creatorUser" name="creatorUser" value="${pageContext.request.remoteUser}" required>
						        <div class="invalid-feedback" role="alert">
						            Please login to add a comment!
						        </div>
						        <div class="row justify-content-center">
						            <div class="col-md-6 mb-3">
						                <input type="text" class="form-control" id="text" name="text" placeholder="Add a comment" value="" required>
						                <div class="invalid-feedback">
						                    Comment body is required.
						                </div>
						            </div>
						        </div>
						        <button class="btn btn-secondary" type="submit">Add comment</button>
							</form>
							<script>
						        // Example starter JavaScript for disabling form submissions if there are invalid fields
						        (function () {
						            'use strict'

						            window.addEventListener('load', function () {
						                // Fetch all the forms we want to apply custom Bootstrap validation styles to
						                var forms = document.getElementsByClassName('needs-validation')

						                // Loop over them and prevent submission
						                Array.prototype.filter.call(forms, function (form) {
						                    form.addEventListener('submit', function (event) {
						                        if (form.checkValidity() === false) {
						                            event.preventDefault()
						                            event.stopPropagation()
						                        }

						                        form.classList.add('was-validated')
						                    }, false)
						                })
						            }, false)
						        })()
						    </script>
						</c:if>
					</div>
				</div>
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

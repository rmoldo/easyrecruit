<%--
    Document   : positions
    Created on : Dec 29, 2020, 8:05:37 PM
    Author     : Silvan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:pageTemplate pageTitle="Positions">
    <c:if test="${visibility_error != null}">
        <div class="alert alert-warning" role="alert">
            ${visibility_error}
        </div>
    </c:if>
    <c:if test="${visibility_status != null}">
        <div class="alert alert-info" role="alert">
            ${visibility_status}
          </div>
    </c:if>
    <h1>Available positions: </h1>
    <br>
    <c:if test="${pageContext.request.isUserInRole('ManagePositionsRole')}">
    <div class="row justify-content-center">
        <a href="Positions/Add" class="btn btn-primary btn-lg">Add position</a>
    </div>
    <br>
    </c:if>
    <c:forEach var="position" items="${positions}">
        <c:if test="${position.isOpen || pageContext.request.isUserInRole('ManagePositionsRole')}">
            <br>
            <div class="card text-center">
                <div class="card-body">
                    <h4 class="card-title">${position.name}</h4>
                    <p class="card-text"><b>Department:</b> ${position.department}<br>
                        <b>Project:</b> ${position.project}<br>
                        <b>Requirements:</b> ${position.requirements}<br>
                        <b>Responsibilities:</b> ${position.responsibilities}<br>
                    </p>
                    <c:choose>
                        <c:when test="${position.isOpen}">
                            <c:if test="${pageContext.request.isUserInRole('ClientRole')}">
                                <a href="Application?positionId=${position.id}" class="btn btn-primary">
                                    Apply for this position
                                </a>
                            </c:if>
                            <c:if test="${pageContext.request.isUserInRole('CeoRole')}">
                                <a href="Positions/Visibility?positionId=${position.id}&action=close" class="btn btn-primary">Close</a>
                            </c:if>
                        </c:when>
                        <c:otherwise>
                            <c:if test="${pageContext.request.isUserInRole('CeoRole')}">
                                <a href="Positions/Visibility?positionId=${position.id}&action=open" class="btn btn-primary">Approve/Reopen</a>
                            </c:if>
                        </c:otherwise>
                    </c:choose>
                    <c:if test="${pageContext.request.isUserInRole('ManagePositionsRole')}">
                        <a href="Positions/Edit?positionId=${position.id}" class="btn btn-primary">Edit</a>
                    </c:if>
                    <c:if test="${pageContext.request.isUserInRole('CeoRole')}">
                        <a href="Positions/Delete?positionId=${position.id}" class="btn btn-danger">Delete</a>
                    </c:if>
                    <br>
                    <br>
                    <div class="card text-white bg-info mb-3">
                        <h5 class="card-header">Comments</h5>
                        <div class="card-body">
                            <c:forEach var="comment" items="${position.comments}">
                                <div class="border border-dark rounded justify-content-center">
                                    <b>${comment.creatorUser}: </b>
                                    <p>${comment.text}</p>
                                    <c:if test="${pageContext.request.getRemoteUser() == comment.creatorUser}">
                                        <a href="Positions/EditComment?positionId=${position.id}&commentId=${comment.id}" class="card-link">Edit</a>
                                        <a href="Positions/DeleteComment?positionId=${position.id}&commentId=${comment.id}" class="card-link">Delete</a>
                                    </c:if>
                                </div>
                                <br>
                            </c:forEach>
                            <c:if test="${position.isOpen && pageContext.request.isUserInRole('ManageCommentsRole')}">
                                <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/Positions/AddComment">
                                    <input type="hidden" class="form-control" id="creatorUser" name="creatorUser" value="${pageContext.request.remoteUser}" required>
                                    <input type="hidden" class="form-control" id="positionId" name="positionId" value="${position.id}" required>
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
                            </c:if>
                        </div>
                    </div>
                </div>
                <div class="card-footer text-muted">
                    Created by ${position.creatorUserName}
                </div>
            </div>
        </c:if>
    </c:forEach>
    <br>
</t:pageTemplate>

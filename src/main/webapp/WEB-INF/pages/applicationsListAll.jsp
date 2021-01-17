<%-- 
    Document   : applicationsAll
    Created on : Jan 14, 2021, 6:16:44 PM
    Author     : Dragos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:pageTemplate pageTitle="Applications">
    <link href="css/applicationsListAllstyle.css" rel="stylesheet" type="text/css">
    <h1>All Applications:</h1>
    <br>
    <table class="table table-layout-fixed">
        <thead>
            <tr>
                <th></th>                             
                <th>Candidate</th>
                <th>Department</th>
                <th>Project</th>
                <th>Position</th> 
                <th>Submitted CV</th>
                <th>Interview</th>
                <c:if test="${pageContext.request.isUserInRole('StatusViewerRole')}">
                    <th>Status</th>
                </c:if>
                <c:if test="${pageContext.request.isUserInRole('DepartmentDirectorRole')}">
                    <th>Actions</th>
                </c:if>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="app" items="${applicationsAll}">
                <tr>
                    <td>
                        <a href="Application?positionId=${app.position.id}&candidateId=${app.candidate.id}">👁‍ Open</a>
                    </td>
                    <td>${app.candidate.firstName} ${app.candidate.lastName}</td>
                    <td>${app.position.department}</td>
                    <td>${app.position.project}</td>
                    <td>${app.position.name}</td>
                    <td class="text-truncate">
                        <a href="${app.cvLink}">${app.cvLink}</a>
                    </td> 
                    <td class="text-truncate">
                        <a href="${pageContext.request.contextPath}/Interview?positionId=${app.position.id}&candidateId=${app.candidate.id}" class="interview"> Set Interview</a>
                    </td>
                    <c:if test="${pageContext.request.isUserInRole('StatusViewerRole')}">
                        <td class="text-truncate">${app.status}</td>
                    </c:if>
                    <c:if test="${pageContext.request.isUserInRole('DepartmentDirectorRole') and app.status eq 'OPEN'}">
                        <td class="text-nowrap">
                            <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/Applications">
                                <input type="hidden" class="form-control" id="positionId" name="positionId" value="${app.position.id}" required>
                                <input type="hidden" class="form-control" id="username" name="username" value="${app.candidate.username}" required>
                                <input type="hidden" class="form-control" id="action" name="action" value="approve" required>
                                <button class="btn btn-success btn-sm" type="submit">Approve</button>
                            </form>
                            <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/Applications">
                                <input type="hidden" class="form-control" id="positionId" name="positionId" value="${app.position.id}" required>
                                <input type="hidden" class="form-control" id="username" name="username" value="${app.candidate.username}" required>
                                <input type="hidden" class="form-control" id="action" name="action" value="reject" required>
                                <button class="btn btn-danger btn-sm" type="submit">Reject</button>
                            </form>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</t:pageTemplate>

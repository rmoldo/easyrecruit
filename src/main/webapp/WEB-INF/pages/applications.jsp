<%-- 
    Document   : applications
    Created on : Jan 9, 2021, 1:15:11 PM
    Author     : andrei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:pageTemplate pageTitle="My Applications">
    <h1>My Applications:</h1>
    <br>
    <table class="table table-layout-fixed">
        <thead>
            <tr>
                <th></th>
                <th>Position</th>
                <th>Department</th>
                <th>Project</th>
                <th>Submitted CV</th>
                <c:if test="${pageContext.request.isUserInRole('StatusViewerRole')}">
                    <th>Status</th>
                </c:if>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="app" items="${applications}">
                <tr>
                    <td>
                        <a href="Application?positionId=${app.position.id}">👁‍ Open</a>
                    </td>
                    <td>${app.position.name}</td>
                    <td>${app.position.department}</td>
                    <td>${app.position.project}</td>
                    <td class="text-truncate">
                        <a href="${app.cvLink}">${app.cvLink}</a>
                    </td>
                    <c:if test="${pageContext.request.isUserInRole('StatusViewerRole')}">
                        <td class="text-truncate">${app.status}</td>
                    </c:if>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</t:pageTemplate>

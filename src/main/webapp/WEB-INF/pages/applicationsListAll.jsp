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
            </tr>
        </thead>
        <tbody>
            <c:forEach var="app" items="${applicationsAll}">
                <tr>
                    <td>
                        <a href="ApplicationsListAll?positionId=${app.position.id}">👁‍ Open</a>
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
                </tr>
            </c:forEach>
        </tbody>
    </table>
</t:pageTemplate>

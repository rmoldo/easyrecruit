<%-- 
    Document   : applicationsAll
    Created on : Jan 14, 2021, 6:16:44 PM
    Author     : Dragos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:pageTemplate pageTitle="Applications">
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
                <th>Interview status</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="app" items="${applicationsAll}">
                <tr>
                    <td>
                        <a href="ApplicationsListAll?positionId=${app.position.id}">👁‍ Open</a>
                    </td>
                    <td>${app.position.name}</td>
                    <td>${app.position.department}</td>
                    <td>${app.position.project}</td>
                    <td class="text-truncate">
                        <a href="${app.cvLink}">${app.cvLink}</a>
                    </td>                                                      
                </tr>
            </c:forEach>
        </tbody>
    </table>
</t:pageTemplate>

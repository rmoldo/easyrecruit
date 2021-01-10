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
    <table class="table">
        <thead>
            <tr>
                <th>Position Name</th>
                <th>Position Department</th>
                <th>Position Project</th>
                <th>Submitted CV</th>   
            </tr>
        </thead>
        <tbody>
            <c:forEach var="app" items="${applications}">
                <tr>
                    <td>${app.position.name}</td>
                    <td>${app.position.department}</td>
                    <td>${app.position.project}</td>
                    <td>${app.cvLink}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</t:pageTemplate>

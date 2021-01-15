<%-- 
    Document   : users
    Created on : Dec 21, 2020, 1:34:02 PM
    Author     : M Radu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:pageTemplate pageTitle="Users">
    <h1> Users </h1>
    <table class="table no-wrap user-table mb-0">
        <tbody>
            <tr>
                <th scope="col" class="border-0 text-uppercase font-medium pl-4">#</th>
                <th scope="col" class="border-0 text-uppercase font-medium">First Name</th>
                <th scope="col" class="border-0 text-uppercase font-medium">Last Name</th>
                <th scope="col" class="border-0 text-uppercase font-medium">Username</th>
                <th scope="col" class="border-0 text-uppercase font-medium">Email</th>
                <th scope="col" class="border-0 text-uppercase font-medium">Role</th>
            </tr>
        </tbody>
        <c:set var="count" value="0" scope="page" />
        <c:forEach var="user" items="${users}" varStatus="status">
            <tbody>
                <tr>
                    <td class="pl-4">
                        <c:set var="count" value="${count + 1}" scope="page"/>
                        <c:out value="${count}" />
                        <%--${user.id}--%>
                    </td>
                    <td>
                        ${user.firstName}
                    </td>
                    <td>
                        ${user.lastName}
                    </td>
                    <td>
                        ${user.username}
                    </td>
                    <td>
                        ${user.email}
                    </td>
                    <td>
                        ${user.position}
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</t:pageTemplate> 
<%-- 
    Document   : editListUser
    Created on : Jan 2, 2021, 2:55:31 PM
    Author     : M Radu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:pageTemplate pageTitle="Edit User">
    <h1>Edit Users </h1>
    <form method="POST" action="${pageContext.request.contextPath}/Users" id="form_1"  ></form>
    <table class="table no-wrap user-table mb-0">
        <tbody>
            <tr>
                <th scope="col" class="border-0 text-uppercase font-medium pl-4">#</th>
                <th scope="col" class="border-0 text-uppercase font-medium">First Name</th>
                <th scope="col" class="border-0 text-uppercase font-medium">Last Name</th>
                <th scope="col" class="border-0 text-uppercase font-medium">Username</th>
                <th scope="col" class="border-0 text-uppercase font-medium">Role</th>
            </tr>
        </tbody>
        <input form="form_1" type="hidden">
        <c:set var="count" value="0" scope="page" />
        <c:forEach var="user" items="${listUsers}" varStatus="status">
            <tbody>
                <tr>
                    <td class="pl-4">
                        <c:set var="count" value="${count + 1}" scope="page"/>
                        <c:out value="${count}" />
                        <%--${user.id}--%>
                    </td>
                    <td>
                        ${user.lastName}
                    </td>
                    <td>
                        ${user.firstName}
                    </td>
                    <td>
                        ${user.username}
                    </td>
                    <td>
                        ${user.position}
                    </td>
                    <td>
                        <a class="btn btn-secondary" href="${pageContext.request.contextPath}/Users/Edit?id=${user.id}" role="button"> Edit User </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</t:pageTemplate>
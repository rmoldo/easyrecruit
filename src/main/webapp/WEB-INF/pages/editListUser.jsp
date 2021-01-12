<%-- 
    Document   : editListUser
    Created on : Jan 2, 2021, 2:55:31 PM
    Author     : M Radu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:pageTemplate pageTitle="Edit User">
    <body>
        <div class ="container">
            <div class="card-body">
                <h5 class="card-title text-uppercase mb-0">Edit Users</h5>
            </div>

            <table class="table no-wrap user-table mb-0">
                <tr>
                    <th scope="col" class="border-0 text-uppercase font-medium pl-4">#</th>
                    <th scope="col" class="border-0 text-uppercase font-medium">First Name</th>
                    <th scope="col" class="border-0 text-uppercase font-medium">Last Name</th>
                    <th scope="col" class="border-0 text-uppercase font-medium">Username</th>
                    <th scope="col" class="border-0 text-uppercase font-medium">Role</th>
                </tr>
                <form method="POST" action="${pageContext.request.contextPath}/Users">
                    <c:set var="count" value="0" scope="page" />
                    <c:forEach var="user" items="${listUsers}" varStatus="status">
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
                    <div></form></div>
    </table>
</div>
</body>
</t:pageTemplate>
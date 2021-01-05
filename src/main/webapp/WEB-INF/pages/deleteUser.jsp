<%-- 
    Document   : deleteUser
    Created on : Jan 2, 2021, 5:27:47 PM
    Author     : M Radu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:pageTemplate pageTitle="Delete User">
    <form method="POST" action="${pageContext.request.contextPath}/Users/Delete">
        <button class="btn btn-danger" type="submit">Delete Users</button>
        <c:forEach var="user" items="${listDeleteUsers}" varStatus="status">
            <div class="row">
                <div class="col-md">
                    <input type="checkbox" name="user_ids" value="${user.id}"/>
                </div>
                <div class="col-md">
                    ${user.lastName}
                </div>
                <div class="col-md">
                    ${user.firstName}
                </div>
                <div class="cold-md">
                    ${user.username}
                </div>
                <div class="col-md">
                    ${user.position}
                </div>
            </div>
        </c:forEach>
    </form>
</t:pageTemplate>

<%-- 
    Document   : editListUser
    Created on : Jan 2, 2021, 2:55:31 PM
    Author     : M Radu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:pageTemplate pageTitle="Edit User">
    <form method="POST" action="${pageContext.request.contextPath}/Users">
        <c:forEach var="user" items="${listUsers}" varStatus="status">
            <div class="row">
                <div class="col-md-2">
                    ${user.lastName}
                </div>
                <div class="col-md-2">
                    ${user.firstName}
                </div>
                <div class="cold-md-2">
                    ${user.username}
                </div>
                <div class="col-md-2">
                    ${user.position}
                </div>
                <div class="col-md-2">
                    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/Users/Edit?id=${user.id}" role="button"> Edit User </a>
                </div>
            </div>
        </c:forEach>
    </form>
</t:pageTemplate>
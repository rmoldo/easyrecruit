<%-- 
    Document   : deleteUser
    Created on : Jan 2, 2021, 5:27:47 PM
    Author     : M Radu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:pageTemplate pageTitle="Delete User">
    <c:if test="${delete_error != null}">
        <div class="alert alert-warning" role="alert">
            ${delete_error}
        </div>
    </c:if>
    <div class ="container">
        <div class="card-body">
            <h5 class="card-title text-uppercase mb-0">Delete User</h5>
        </div>
    </div>
    <div class="card-body">
        <h5 class="card-title text-uppercase mb-0">Delete User</h5>
    </div>
    <form method="POST" action="${pageContext.request.contextPath}/Users/Delete" id="form_2">
        <table class="table no-wrap user-table mb-0">
            <tbody>
                <tr>
                    <th scope="col" class="border-0 text-uppercase font-medium pl-4"></th>
                    <th scope="col" class="border-0 text-uppercase font-medium">Last Name</th>
                    <th scope="col" class="border-0 text-uppercase font-medium">First Name</th>
                    <th scope="col" class="border-0 text-uppercase font-medium">Username</th>
                    <th scope="col" class="border-0 text-uppercase font-medium">Role</th>
                </tr>
            </tbody>
            <input form="form_2" type="hidden">
            <button class="btn btn-danger" type="submit" form="form_2">Delete Users</button>
            <c:forEach var="user" items="${listDeleteUsers}" varStatus="status">
                <tbody>
                    <tr>
                        <td class="pl-4">
                            <div class="col-md">
                                <input type="checkbox" name="user_ids" value="${user.id}"/>
                            </div>
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
                    </tr>
                </tbody>
            </c:forEach>
        </table>
    </form>
</t:pageTemplate>

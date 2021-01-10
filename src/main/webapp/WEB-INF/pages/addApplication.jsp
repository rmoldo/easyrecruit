<%-- 
    Document   : addApplication
    Created on : Jan 3, 2021, 12:39:21 PM
    Author     : andrei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:pageTemplate pageTitle="Create application">
    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/Applications/Add">
        <input type="hidden" class="form-control" id="creatorUserName" name="creatorUserName" value="${pageContext.request.remoteUser}">
        <div class="invalid-feedback" role="alert">
            Please login to add a position!
        </div>
        ${position.name}
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="positionName">Position name</label>
                <input type="text" class="form-control" id="positionName" name="positionName" placeholder="Position name" value="" required>
                <div class="invalid-feedback">
                    Position name is required.
                </div>
            </div>
        </div>
        <hr class="mb-4">
        <button class="btn btn-primary btn-lg btn-block" type="submit">Add position</button>
    </form>
</t:pageTemplate>
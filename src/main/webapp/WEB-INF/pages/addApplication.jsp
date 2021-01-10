<%-- 
    Document   : addApplication
    Created on : Jan 3, 2021, 12:39:21 PM
    Author     : andrei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:pageTemplate pageTitle="Submit application">
    <h1>Submit application for ${position.name}:</h1>
    <br />
    <h4>Position details:</h4>
    Name: ${position.name}<br />
    Department: ${position.department}<br />
    Project: ${position.project}<br />
    Requirements: ${position.requirements}<br />
    Responsibilities: ${position.responsibilities}<br />
    <br />
    <h4>Application details:</h4><br />
    Please include all the necessary details in your CV, upload it to any accessible
    file hosting website and add the link to it below:
    <br /><br />

    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/Applications/Add">
        <input type="hidden" name="positionId" value="${position.id}">
        <div class="row">
            <div class="col">
                <label for="positionName">Link to curriculum vitae:</label>
                <input type="text" class="form-control" name="cvLink" value="" required>
                <div class="invalid-feedback">
                    Link to curriculum vitae is required.
                </div>
            </div>
        </div>
        <hr class="mb-4">
        <button class="btn btn-primary btn-lg btn-block" type="submit">Submit application</button>
    </form>
</t:pageTemplate>
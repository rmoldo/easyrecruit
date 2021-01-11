<%--
    Document   : addApplication
    Created on : Jan 3, 2021, 12:39:21 PM
    Author     : andrei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:pageTemplate pageTitle="Submit application">
    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/Applications/Add">
        <h3>Application for ${application.position.name}:</h3>
        <br />
        <h4>Position details:</h4>
        <table class="table table-sm table-borderless text-nowrap">
            <tbody>
                <tr>
                    <td style="width: 1px">Name:</td>
                    <td>${application.position.name}</td>
                </tr>
                <tr>
                    <td>Department:</td>
                    <td>${application.position.department}</td>
                </tr>
                <tr>
                    <td>Project:</td>
                    <td>${application.position.project}</td>
                </tr>
                <tr>
                    <td>Requirements:</td>
                    <td>${application.position.requirements}</td>
                </tr>
                <tr>
                    <td>Responsibilities:</td>
                    <td>${application.position.responsibilities}</td>
                </tr>
            </tbody>
        </table>

        <h4>Candidate details:</h4><br />
        Please include all the necessary details in your CV, upload it to any accessible
        file hosting website and add the link to it below.
        <br /><br />

        <input type="hidden" name="positionId" value="${application.position.id}">
        <table class="table table-sm table-borderless text-nowrap">
            <tbody>
                <tr>
                    <td style="width: 1px">First name:</td>
                    <td>${application.candidate.firstName}</td>
                </tr>
                <tr>
                    <td style="width: 1px">Last name:</td>
                    <td>${application.candidate.lastName}</td>
                </tr>
                <tr>
                    <td style="width: 1px">Phone number:</td>
                    <td>${application.candidate.phoneNumber}</td>
                </tr>
                <tr>
                    <td style="width: 1px">Email:</td>
                    <td>${application.candidate.email}</td>
                </tr>
            </tbody>
        </table>
        <div class="form-group">
            <label for="positionName">Link to curriculum vitae:</label>
            <input type="text" class="form-control" name="cvLink" value="" required>
            <div class="invalid-feedback">
                Link to curriculum vitae is required.
            </div>
        </div>
        <hr class="mb-4">
        <button class="btn btn-primary btn-lg btn-block" type="submit">Submit application</button>
    </form>
</t:pageTemplate>
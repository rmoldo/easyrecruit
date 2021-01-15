<%--
    Document   : application
    Created on : Jan 3, 2021, 12:39:21 PM
    Author     : andrei
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:pageTemplate pageTitle="Submit application">
    <form id="applicationForm" class="needs-validation" novalidate method="POST">
        <h3>Application for ${application.position.name}:</h3>
        <br />
        <h4>Position details:</h4>
        <table class="table table-sm table-borderless text-nowrap">
            <tbody>
                <tr>
                    <td class="column-fit">Name:</td>
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

        <c:if test="${edit}">
            Please include all the necessary details in your CV, upload it to any accessible
            file hosting website and add the link to it below.
            <br />
        </c:if>
        <br />

        <table class="table table-sm table-borderless text-nowrap">
            <tbody>
                <tr>
                    <td class="column-fit">First name:</td>
                    <td>${application.candidate.firstName}</td>
                    <td class="column-fit">Last name:</td>
                    <td>${application.candidate.lastName}</td>
                </tr>
                <tr>
                    <td>Phone number:</td>
                    <td>${application.candidate.phoneNumber}</td>
                    <td>Email:</td>
                    <td>${application.candidate.email}</td>
                </tr>
            </tbody>
        </table>
        <div class="form-group">
            <label for="positionName">Link to curriculum vitae:</label>
            <input type="url" class="form-control" name="cvLink" value="${application.cvLink}" required ${edit ? "" : "readonly"}>
            <div class="invalid-feedback">
                A valid link to curriculum vitae is required.
            </div>
        </div>
    </form>

    <hr class="mb-4">

    <c:if test="${edit}">
        <div class="row">
            <div class="col d-flex justify-content-around">
                <button class="btn btn-primary btn-lg" type="submit" form="applicationForm">Submit</button>
                <form method="POST">
                    <input type="hidden" name="delete" value="true" />
                    <button class="btn btn-danger btn-lg" type="submit">Delete</button>
                </form>
            </div>
        </div>
    </c:if>


    <c:if test="${comments}">
        <h4>Comments:</h4>
        
        <t:commentSection />
    </c:if>
</t:pageTemplate>
<%--
    Document   : editPosition
    Created on : Jan 8, 2021, 11:37:40 AM
    Author     : Silvan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:pageTemplate pageTitle="Edit position">
    <c:if test="${position_error_message != null}">
        <div class="alert alert-warning" role="alert">
            ${position_error_message}
        </div>
    </c:if>
    <c:if test="${position_status_message != null}">
        <div class="alert alert-info" role="alert">
            ${position_status_message}
          </div>
    </c:if>
    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/Positions/Edit">
        <input type="hidden" class="form-control" id="positionId" name="positionId" value="${position.id}" required>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="positionName">Position name</label>
                <input type="text" class="form-control" id="positionName" name="positionName" placeholder="Position name" value="${position.name}" required>
                <div class="invalid-feedback">
                    Position name is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="neededNumber">Number of needed candidates</label>
                <input type="number" class="form-control" id="neededNumber" name="neededNumber" placeholder="Number of needed candidates" value=${position.nbOfCandidatesNeeded} required>
                <div class="invalid-feedback">
                    Number of needed candidates is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="department">Department</label>
                <input type="text" class="form-control" id="department" name="department" placeholder="Department" value="${position.department}" required>
                <div class="invalid-feedback">
                    Department is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="project">Project</label>
                <input type="text" class="form-control" id="project" name="project" placeholder="Project" value="${position.project}">
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="requirements">Requirements</label>
                <input type="text" class="form-control" id="requirements" name="requirements" placeholder="Requirements" value="${position.requirements}" required>
                <div class="invalid-feedback">
                    Requirements is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="responsibilities">Responsibilities</label>
                <input type="text" class="form-control" id="responsibilities" name="responsibilities" placeholder="Responsibilities" value="${position.responsibilities}" required>
                <div class="invalid-feedback">
                    Responsibilities is required.
                </div>
            </div>
        </div>
        <hr class="mb-4">
        <button class="btn btn-primary btn-lg btn-block" type="submit">Apply</button>
    </form>
</t:pageTemplate>

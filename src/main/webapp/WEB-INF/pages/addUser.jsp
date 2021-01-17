<%-- 
    Document   : addUser
    Created on : Jan 2, 2021, 2:07:32 PM
    Author     : M Radu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:pageTemplate pageTitle="Add User">
    <c:if test="${add_user_error_message != null}">
        <div class="alert alert-warning" role="alert">
            ${add_user_error_message}
        </div>
    </c:if>
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-body">
                        <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/Users/Add"
                              oninput='edit_rpassword.setCustomValidity(edit_rpassword.value != edit_password.value ? "Passwords do not match." : "")'>
                            <div class="form-group">
                                <div class="cols-sm-10">
                                    <label for="username">Username</label>
                                    <input type="text" class="form-control" id="addUsername" name="addUsername" placeholder="" value="" required>
                                    <div class="invalid-feedback">
                                        Username is required
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="cols-sm-10">
                                    <label for="first_name">First name</label>
                                    <input type="text" class="form-control" id="addFirstName" name="addFirstName" placeholder="" value="" required>
                                    <div class="invalid-feedback">
                                        First name is required
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="cols-sm-10">
                                    <label for="last_name">Last name</label>
                                    <input type="text" class="form-control" id="addLastName" name="addLastName" placeholder="" value="" required>
                                    <div class="invalid-feedback">
                                        Last name is required
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="cols-sm-10">
                                    <label for="email">Email</label>
                                    <input type="email" class="form-control" id="addEmail" name="addEmail" placeholder="" value="" required>
                                    <div class="invalid-feedback">
                                        Email is required.
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="cols-sm-10">
                                    <label for="phone_number">Phone number</label>
                                    <input type="text" pattern="^\+(?:[0-9] ?){6,14}[0-9]$" class="form-control" id="addPhoneNumber" name="addPhoneNumber" placeholder="" value="" required>
                                    <div class="invalid-feedback">
                                        Phone number is required
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="cols-sm-10">
                                    <label for="password">Password</label>
                                    <input type="password" class="form-control" id="addPassword" name="addPassword" placeholder="" value="" required>
                                    <div class="invalid-feedback">
                                        Password is required
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="cols-sm-10">
                                    <label for="password">Retype Password</label>
                                    <input type="password" class="form-control" id="addRetypePassword" name="addRetypePassword" placeholder="" value="" required>
                                    <div class="invalid-feedback">
                                        Retype password is required
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="cols-sm-10">
                                    <label for="position"> Role </label>
                                    <select class="custom-select d-block w-100" id="addPosition" name="addPosition" required>
                                        <option value="CLIENT">Client</option>
                                        <option value="ADMINISTRATOR">Administrator</option>
                                        <option value="CEO">Chief executive officer</option>
                                        <option value="DEPARTMENTDIRECTOR">Department director</option>
                                        <option value="RECRUITER">Recruiter</option>
                                    </select>
                                    <div class="invalid-feedback">
                                        Please select a position
                                    </div>
                                </div>
                            </div>       
                            <hr class="mb-4">
                            <button class="btn btn-primary btn-lg btn-block" type="submit">Add User</button>
                        </form> 
                    </div>
                </div>
            </div>
        </div>
    </div>
</t:pageTemplate>
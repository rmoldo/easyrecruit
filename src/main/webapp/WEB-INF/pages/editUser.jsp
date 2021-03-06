<%-- 
    Document   : editUser
    Created on : Jan 2, 2021, 4:21:48 PM
    Author     : M Radu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<t:pageTemplate pageTitle="Edit User">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-body">
                        <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/Users/Edit"
                              oninput='edit_rpassword.setCustomValidity(edit_rpassword.value != edit_password.value ? "Passwords do not match." : "")'>
                            <div class="form-group">
                                <div class="cols-sm-10">
                                    <label for="first_name">First name</label>
                                    <input type="text" class="form-control" id="edit_first_name" name="edit_first_name" placeholder="" value="${editUser.firstName}" required>
                                    <div class="invalid-feedback">
                                        First name is required
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="cols-sm-10">
                                    <label for="last_name">Last name</label>
                                    <input type="text" class="form-control" id="edit_last_name" name="edit_last_name" placeholder="" value="${editUser.lastName}" required>
                                    <div class="invalid-feedback">
                                        Last name is required
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="cols-sm-10">
                                    <label for="email">Email</label>
                                    <input type="email" class="form-control" id="edit_email" name="edit_email" placeholder="" value="${editUser.email}" required>
                                    <div class="invalid-feedback">
                                        Email is required.
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="cols-sm-10">
                                    <label for="phone_number">Phone number</label>
                                    <input type="text" pattern="^\+(?:[0-9] ?){6,14}[0-9]$" class="form-control" id="edit_phone_number" name="edit_phone_number" placeholder="" value="${editUser.phoneNumber}" required>
                                    <div class="invalid-feedback">
                                        Phone number is required
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="cols-sm-10">
                                    <label for="password">Password</label>
                                    <input type="password" class="form-control" id="edit_password" name="edit_password" placeholder="" value="">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="cols-sm-10">
                                    <label for="password">Retype Password</label>
                                    <input type="password" class="form-control" id="edit_rpassword" name="edit_rpassword" placeholder="" value="">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="cols-sm-10">
                                    <label for="position"> Role </label>
                                    <select class="custom-select d-block w-100" id="edit_position" name="edit_position" required>
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
                            <input type="hidden" name="edit_user_id" value="${editUser.id}"/>
                            <button class="btn btn-primary btn-lg btn-block" type="submit">Save</button>
                        </form> 
                    </div>
                </div>
            </div>
        </div>
    </div>
</t:pageTemplate>
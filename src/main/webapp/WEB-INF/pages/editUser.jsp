<%-- 
    Document   : editUser
    Created on : Jan 2, 2021, 4:21:48 PM
    Author     : M Radu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<t:pageTemplate pageTitle="Edit User">
    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/Users/Edit"
          oninput='edit_rpassword.setCustomValidity(edit_rpassword.value != edit_password.value ? "Passwords do not match." : "")'>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="first_name">First name</label>
                <input type="text" class="form-control" id="edit_first_name" name="edit_first_name" placeholder="" value="${editUser.firstName}" required>
                <div class="invalid-feedback">
                    First name is required
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="last_name">Last name</label>
                <input type="text" class="form-control" id="edit_last_name" name="edit_last_name" placeholder="" value="${editUser.lastName}" required>
                <div class="invalid-feedback">
                    Last name is required
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="email">Email</label>
                <input type="email" class="form-control" id="edit_email" name="edit_email" placeholder="" value="${editUser.email}" required>
                <div class="invalid-feedback">
                    Email is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="phone_number">Phone number</label>
                <input type="text" pattern="^\+(?:[0-9] ?){6,14}[0-9]$" class="form-control" id="edit_phone_number" name="edit_phone_number" placeholder="" value="${editUser.phoneNumber}" required>
                <div class="invalid-feedback">
                    Phone number is required
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="password">Password</label>
                <input type="password" class="form-control" id="edit_password" name="edit_password" placeholder="" value="">
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="password">Retype Password</label>
                <input type="password" class="form-control" id="edit_rpassword" name="edit_rpassword" placeholder="" value="">
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="position"> Role </label>
                <select class="custom-select d-block w-100" id="edit_position" name="edit_position" required>
                    <option value="CEO">CEO</option>
                    <option value="ADMINISTRATOR">Administrator</option>
                    <option value="CLIENT">Client</option>
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
    <script>
        // Example starter JavaScript for disabling form submissions if there are invalid fields
        (function () {
            'use strict'

            window.addEventListener('load', function () {
                // Fetch all the forms we want to apply custom Bootstrap validation styles to
                var forms = document.getElementsByClassName('needs-validation')

                // Loop over them and prevent submission
                Array.prototype.filter.call(forms, function (form) {
                    form.addEventListener('submit', function (event) {
                        if (form.checkValidity() === false) {
                            event.preventDefault()
                            event.stopPropagation()
                        }

                        form.classList.add('was-validated')
                    }, false)
                })
            }, false)
        })()
    </script>
</t:pageTemplate>
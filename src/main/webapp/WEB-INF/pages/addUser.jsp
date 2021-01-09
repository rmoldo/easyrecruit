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
    <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/Users/Add"
          oninput='retypepassword.setCustomValidity(retypepassword.value != password.value ? "Passwords do not match." : "")'>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="username">Username</label>
                <input type="text" class="form-control" id="addUsername" name="addUsername" placeholder="" value="" required>
                <div class="invalid-feedback">
                    Username is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="firstName">First name</label>
                <input type="text" class="form-control" id="addFirstName" name="addFirstName" placeholder="" value="" required>
                <div class="invalid-feedback">
                    First name is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="lastName">Last name</label>
                <input type="text" class="form-control" id="addLastName" name="addLastName" placeholder="" value="" required>
                <div class="invalid-feedback">
                    Last name is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="phoneNumber">Phone number</label>
                <input type="text" pattern="^\+(?:[0-9] ?){6,14}[0-9]$" class="form-control" id="addPhoneNumber" name="addPhoneNumber" placeholder="" value="" required>
                <div class="invalid-feedback">
                    Phone number is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="email">Email</label>
                <input type="email" class="form-control" id="addEmail" name="addEmail" placeholder="" value="" required>
                <div class="invalid-feedback">
                    Email is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="password">Password</label>
                <input type="password" class="form-control" id="addPassword" name="addPassword" placeholder="" value="" required>
                <div class="invalid-feedback">
                    Password is required.
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="password">Confirm password</label>
                <input type="password" class="form-control" id="addRetypePassword" name="addRetypePassword" placeholder="" value="" required>
                <div class="invalid-feedback">
                    Please confirm the password
                </div>
            </div>
        </div>
        <!-- TODO: Add the rest of the roles -->
        <div class="row">
            <div class="col-md-6 mb-3">
                <label for="position"> Role </label>
                <select class="custom-select d-block w-100" id="addPosition" name="addPosition" required>
                    <option value="ADMINISTRATOR">Administrator</option>
                    <option value="CLIENT">Client</option>
                </select>
                <div class="invalid-feedback">
                     Please select a position
                </div>
            </div>
        </div>
        <hr class="mb-4">
        <button class="btn btn-primary btn-lg btn-block" type="submit">Add User</button>
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
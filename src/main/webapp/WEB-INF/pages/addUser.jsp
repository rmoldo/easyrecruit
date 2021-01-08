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
                <h5 class="card-title text-uppercase mb-0">Add Users</h5>
            </div>
                    <div class="card-body">

                        <form class="form-horizontal" class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/Users/Add"
                              oninput='retypepassword.setCustomValidity(retypepassword.value != password.value ? "Passwords do not match." : "")'>

                            <div class="form-group">
                                <label for="username" class="cols-sm-2 control-label">Username</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">

                                        <input type="text" class="form-control" name="addUsername" id="addUsername" placeholder="Enter a Username" required/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="firstName" class="cols-sm-2 control-label">First Name</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">

                                        <input type="text" class="form-control" name="addFirstName" id="addFirstName" placeholder="Enter your First Name" required/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="lastName" class="cols-sm-2 control-label">Last Name</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">

                                        <input type="text" class="form-control" name="addLastName" id="addLastName" placeholder="Enter your Last Name" required/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="phoneNumber" class="cols-sm-2 control-label">Phone Number</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">

                                        <input type="text" class="form-control" name="addPhoneNumber" id="addPhoneNumber" placeholder="Enter your Phone Number" required />
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="email" class="cols-sm-2 control-label">Email</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">

                                        <input type="text" class="form-control" name="addEmail" id="addEmail" placeholder="Enter your Email" required />
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="password" class="cols-sm-2 control-label">Password</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">

                                        <input type="password" class="form-control" name="addPassword" id="addPassword" placeholder="Enter your Password" required />
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="password" class="cols-sm-2 control-label">Confirm Password</label>
                                <div class="cols-sm-10">
                                    <div class="input-group">

                                        <input type="password" class="form-control" name="addRetypePassword" id="addRetypePassword" placeholder="Confirm your Password" required />
                                    </div>
                                </div>
                            </div>
                            <!-- TODO: Add the rest of the roles -->
                            <div class="form-group">
                                <label for="position" class="cols-sm-2 control-label"> Role </label>
                                <div class="col-md-10" style="padding: 0;width: 100%;">
                                    <div class="input-group">
                                        <select class="form-control form-control-md" id="addPosition" name="addPosition" required>
                                            <option value="ADMINISTRATOR">Administrator</option>
                                            <option value="CLIENT">Client</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group ">
                                <button type="submit" class="btn btn-primary btn-lg btn-block login-button">Add User</button>
                            </div>
                        </form>
                    </div>

                </div>
            </div>
        </div>
    </div>

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
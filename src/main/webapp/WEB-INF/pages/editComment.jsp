<%-- 
    Document   : editComment
    Created on : Jan 9, 2021, 3:44:43 PM
    Author     : Silvan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:pageTemplate pageTitle="Edit comment">
    <div class="row justify-content-center">
        <form class="needs-validation" novalidate method="POST" action="${pageContext.request.contextPath}/Positions/EditComment">
            <input type="hidden" class="form-control" id="positionId" name="positionId" value="${positionId}" required>
            <input type="hidden" class="form-control" id="commentId" name="commentId" value="${commentId}" required>
            <div class="invalid-feedback" role="alert">
                Please login to add a comment!
            </div>
            <div class="row justify-content-center">
                <input type="text" class="form-control" id="text" name="text" placeholder="Add a comment" value="${commentText}" required>
                <div class="invalid-feedback">
                    Comment body is required.
                </div>
            </div>
            <br>
            <div class="row justify-content-center">
                <button class="btn btn-secondary" type="submit">Save changes</button>
            </div>
        </form>
    </div>
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


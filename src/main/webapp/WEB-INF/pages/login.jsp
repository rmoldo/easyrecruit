<%-- 
    Document   : login
    Created on : Dec 25, 2020, 11:08:29 AM
    Author     : M Radu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<t:pageTemplate pageTitle="Login">
    <html>
        <head>
            <c:if test="${login_error_message != null}">
            <div class="alert alert-warning" role="alert">
                ${login_error_message}
            </div>
        </c:if>
        <meta charset="utf-8">
        <link rel="stylesheet" href="css/loginstyle.css">
        </head>
        <body>
            <div class="wrapper">
                <div class="title"> Login </div>
                <form action="j_security_check" method="POST">
                    <div class="field">
                        <input type="text" id="username" name="j_username" required>
                        <label>Username</label>
                    </div>
                    <div class="field">
                        <input type="password" id="password" name="j_password" required>
                        <label>Password</label>
                    </div>
                    <div class="field">
                        <input type="submit" value="Login">
                    </div>
<!--                    <div class="signup-link"> 
                        Not a member? <a href="login.jsp">Sign up now</a> <%-- To do for later (if time allows) --%>
                    </div>-->
                </form>
            </div>
        </body>
    </html>
</t:pageTemplate>





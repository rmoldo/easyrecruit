<%-- 
    Document   : login
    Created on : Nov 11, 2020, 7:26:05 PM
    Author     : Claudiu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="header.jsp"/>
<jsp:include page="index.jsp"/>   
<jsp:include page="navbar.jsp"/> 
<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        <main class="main">
            <div class="content">
                <form action="login" method="POST">
                    <label>Username:</label><input type="text" name="username"><br />
                    <label>Password:</label><input type="password" name="password"><br />
                    <input type="submit" value="Log In">
                </form>
            </div>
        </main>
    </body>
</html>
<jsp:include page="footer.jsp"/>
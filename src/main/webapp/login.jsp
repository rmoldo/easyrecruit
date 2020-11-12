<%-- 
    Document   : login
    Created on : Nov 11, 2020, 7:26:05 PM
    Author     : Claudiu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<link rel="stylesheet" type="text/css" href="login_style.css" />
<link rel="stylesheet" type="text/css" href="assets/bootstrap/css/bootstrap.min.css" />
<jsp:include page="index.jsp"/>  
<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        <main class="main">
            <div class="content">
                <form method="POST" action="login">
                    <h2>Please sign in</h2>
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-addon"><span class="text-primary glyphicon glyphicon-envelope"></span></div>
                            <input type="email" name="email" placeholder="Email address" required class="form-control" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="input-group">
                            <div class="input-group-addon"><span class="text-primary glyphicon glyphicon-lock"></span></div>
                            <input type="password" name="password" placeholder="Password" required class="form-control" />
                        </div>
                    </div>
                    <button type="submit" value="login" class="btn btn-block btn-success">Sign in</button>
                    <a href="#" class="btn btn-block btn-default">Forgot password</a>
                    <a href="#" class="btn btn-block btn-default">Create an account</a>
                </form>
            </div>
        </main>
    </body>
</html>
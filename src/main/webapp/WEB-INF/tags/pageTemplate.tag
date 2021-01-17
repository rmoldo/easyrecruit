<%-- 
    Document   : pageTemplate
    Created on : Nov 8, 2020, 10:41:16 AM
    Author     : andrei
--%>

<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@attribute name="pageTitle"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <title>${pageTitle}</title>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" >
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    </head>
    <body>
        <jsp:include page="/WEB-INF/pages/navbar.jsp" />

        <main role="main" class="container mt-3">
            <jsp:doBody />
        </main>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
        <script src="${pageContext.request.contextPath}/js/validation.js"></script>
        <script src="${pageContext.request.contextPath}/js/comments.js"></script>

    </body>

</html>

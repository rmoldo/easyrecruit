<%-- 
    Document   : navbar
    Created on : Nov 8, 2020, 11:49:12 AM
    Author     : andrei
--%>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="${pageContext.request.contextPath}">
        EasyRecruit
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item ${pageContext.request.requestURI eq '/easyrecruit/index.jsp' ? ' active' : ''}">
                <a class="nav-link" href="${pageContext.request.contextPath}/index.jsp">Home</a>
            </li>
            <li class="nav-item ${pageContext.request.requestURI eq '/easyrecruit/about.jsp' ? ' active' : ''}">
                <a class="nav-link" href="${pageContext.request.contextPath}/about.jsp">About</a>
            </li>
        </ul>
            
        <ul class="navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/login.jsp">Login</a>
            </li>
        </ul>
    </div>
</nav>
